package com.example.src_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.FloatingActionButtonElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.src_android.ui.theme.SRCAndroidTheme
import com.example.src_android.utils.BottomNavigation
import com.example.src_android.features.navigationDrawer.presentation.NavigationDrawer
import com.example.src_android.utils.BottomSheet
import com.example.src_android.utils.EdtProfileTopBar
import com.example.src_android.utils.NewsBottomSheet
import com.example.src_android.utils.OtherTopBar
import com.example.src_android.utils.ProfileTopBar
import com.example.src_android.utils.SharedPreference
import com.example.src_android.utils.TopHomeBar
import kotlinx.coroutines.launch
import androidx.compose.material3.Text

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val context = LocalContext.current
            val sharedPreference = remember { SharedPreference(context) }
            var isDarkTheme by remember {
                mutableStateOf(
                    sharedPreference.getThemePreference()
                        .mode
                )
            }
            var isMenuOpen by remember {
                mutableStateOf(false)
            }
            val backgroundColor by animateColorAsState(
                targetValue = if (isMenuOpen) Color.Black.copy(alpha = 1f) else Color.Transparent,
                animationSpec = tween(durationMillis = 0)
            )
            LaunchedEffect(isDarkTheme) {
                sharedPreference.setThemePreference(isDarkTheme)
            }
            SRCAndroidTheme(darkTheme = isDarkTheme) {

                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                val scope = rememberCoroutineScope()
                val navHostController: NavHostController = rememberNavController()
                var route by remember {
                    mutableStateOf("home")
                }
                val sheetState = rememberModalBottomSheetState()
                var showBottomSheet by remember { mutableStateOf(false) }
                ModalNavigationDrawer(
                    drawerState = drawerState,
                    drawerContent = {
                        NavigationDrawer(
                            onClick = {
                                if (drawerState.isOpen) scope.launch { drawerState.close() }
                            },
                            toggleTheme = {
                                isDarkTheme = !isDarkTheme
                            },
                            isDarkTheme = isDarkTheme,
                            navigate = {
                                route = it
                                navHostController.navigate(it) {
                                    popUpTo(navHostController.graph.startDestinationId) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }

                            },
                            showBottomSheet = {
                                showBottomSheet = !showBottomSheet
                            }
                        )

                    }, gesturesEnabled = route == "home" && !isMenuOpen
                ) {

                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        containerColor = MaterialTheme.colorScheme.primaryContainer,

                        topBar = {
                            if (!isMenuOpen) {
                                when (route) {
                                    "home" ->
                                        TopHomeBar {
                                            scope.launch {
                                                if (drawerState.isClosed) {
                                                    drawerState.open()
                                                } else {
                                                    drawerState.close()
                                                }
                                            }
                                        }

                                    "profile" -> ProfileTopBar(onClick = {
                                        route = "home"
                                        navHostController.navigate("home")
                                    },
                                        toEditProfile = {
                                            route = "edt_profile"
                                            navHostController.navigate("edt_profile")
                                        }
                                    )

                                    "edt_profile" -> EdtProfileTopBar(onClick = {
                                        route = "profile"
                                        navHostController.navigate("profile")
                                    })

                                    else -> OtherTopBar {
                                        route = "home"
                                        navHostController.navigate("home")
                                    }
                                }
                            }
                        },
                        bottomBar = {
                            if (!isMenuOpen) {
                                if (route == "home") {
                                    BottomNavigation(
                                        navHostController =
                                        navHostController
                                    ) {
                                        route = it
                                        navHostController.navigate(it)
                                    }
                                }
                            }
                        },
                        floatingActionButton = {
                            if (route == "home") {
                                Box(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(bottom = if (isMenuOpen) 81.dp else 0.dp),
                                    contentAlignment = Alignment.BottomEnd
                                ) {
                                    FloatingActionButton(
                                        onClick = { isMenuOpen = !isMenuOpen }, containerColor =
                                        Color.LightGray, shape = RoundedCornerShape(50.dp),
                                        elevation = FloatingActionButtonDefaults.elevation(
                                            defaultElevation = 15.dp
                                        ),
                                        modifier = Modifier.size(61.dp)
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Add,
                                            contentDescription =
                                            "Admin",
                                            tint = Color.White,
                                            modifier = Modifier.size(35.dp)
                                        )
                                    }
                                }
                            }
                        }
                    ) { innerPadding ->

                        Navigation(modifier = Modifier.padding(innerPadding), navHostController) {
                            route = it
                        }
                        if (showBottomSheet) {

                            BottomSheet(scope = scope, sheetState = sheetState) {
                                showBottomSheet = !showBottomSheet
                            }
                        }
                        if (isMenuOpen) {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(backgroundColor)
                                    .clickable {
                                        isMenuOpen = false
                                    }
                            )
                        }
                        if (isMenuOpen) {
                            Box(
                                modifier = Modifier
                                    .padding(end = 16.dp), // Adjust for FAB
                                // position
                                contentAlignment = Alignment.BottomEnd
                            ) {
                                Column(
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {

                                    FabMenuItem(
                                        "Go Live",
                                        Icons.Default.Person
                                    ) { /* Handle Go Live */ }
                                    Spacer(modifier = Modifier.height(8.dp))
                                    FabMenuItem(
                                        "Spaces",
                                        Icons.Default.Person
                                    ) { /* Handle Spaces */ }
                                    Spacer(modifier = Modifier.height(8.dp))
                                    FabMenuItem(
                                        "Photos",
                                        Icons.Default.Phone
                                    ) { /* Handle Photos */ }
                                    Spacer(modifier = Modifier.height(8.dp))
                                    FabMenuItem("Post", Icons.Default.Edit) { /* Handle Post */ }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun FabMenuItem(text: String, icon: ImageVector, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.surface, CircleShape)
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(imageVector = icon, contentDescription = text)
        Spacer(modifier = Modifier.width(8.dp))
        Text(text)
    }
}

