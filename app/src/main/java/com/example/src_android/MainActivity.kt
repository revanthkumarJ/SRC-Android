package com.example.src_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.src_android.ui.theme.SRCAndroidTheme
import com.example.src_android.utils.BottomNavigation
import com.example.src_android.features.navigationDrawer.presentation.NavigationDrawer
import com.example.src_android.utils.BottomSheet
import com.example.src_android.utils.OtherTopBar
import com.example.src_android.utils.ProfileTopBar
import com.example.src_android.utils.SharedPreference
import com.example.src_android.utils.TopHomeBar
import com.example.src_android.utils.edtProfileTopBar
import kotlinx.coroutines.launch

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

                    }, gesturesEnabled = route == "home"
                ) {

                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        containerColor = MaterialTheme.colorScheme.primaryContainer
                        ,
                        topBar = {
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
                            "edt_profile" -> edtProfileTopBar(onClick = {
                                    route = "profile"
                                    navHostController.navigate("profile")
                                })


                                else -> OtherTopBar {
                                    route = "home"
                                    navHostController.navigate("home")
                                }
                            }
                        },
                        bottomBar = {

                            BottomNavigation(
                                navHostController =
                                navHostController
                            ) {
                                route = it
                                navHostController.navigate(it)
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

                    }
                }
            }
        }
    }
}

