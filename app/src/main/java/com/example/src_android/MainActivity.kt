package com.example.src_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
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
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
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
import com.example.src_android.utils.EdtProfileTopBar
import com.example.src_android.utils.OtherTopBar
import com.example.src_android.utils.ProfileTopBar
import com.example.src_android.utils.SharedPreference
import com.example.src_android.utils.TopHomeBar
import kotlinx.coroutines.launch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.example.src_android.core.AdminOptions
import com.example.src_android.features.about.presentation.OfficialViewModel
import com.example.src_android.features.about.presentation.OfficialViewModelFactory
import com.example.src_android.core.presentation.buttons.FloatingPointButton
import com.example.src_android.features.home.presentaion.HomeViewModel
import com.example.src_android.features.home.presentaion.HomeViewModelFactory
import com.example.src_android.utils.AdminBottomSheet
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var officialViewModelFactory: OfficialViewModelFactory
    @Inject
    lateinit var homeViewModelFactory: HomeViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        init()

        setContent {
            val officialViewModel: OfficialViewModel = remember {
                ViewModelProvider(this, officialViewModelFactory)[OfficialViewModel::class.java]
            }
            val homeViewModel: HomeViewModel = remember {
                ViewModelProvider(this, homeViewModelFactory)[HomeViewModel::class.java]
            }
            MainContent(officialViewModel = officialViewModel,homeViewModel = homeViewModel)
        }
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainContent(officialViewModel: OfficialViewModel,homeViewModel: HomeViewModel) {
    val context = LocalContext.current
    val sharedPreference = remember { SharedPreference(context) }
    var isDarkTheme by remember { mutableStateOf(sharedPreference.getThemePreference().mode) }
    var isMenuOpen by remember { mutableStateOf(false) }
    val backgroundColor by animateColorAsState(
        targetValue = if (isMenuOpen) Color.Black.copy(alpha = 1f) else Color.Transparent,
        animationSpec = tween(durationMillis = 0)
    )
    var route by remember { mutableStateOf("home") }
    var option by remember { mutableStateOf("home") }

    LaunchedEffect(isDarkTheme) {
        sharedPreference.setThemePreference(isDarkTheme)
    }

    SRCAndroidTheme(darkTheme = isDarkTheme) {
        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
        val scope = rememberCoroutineScope()
        val navHostController: NavHostController = rememberNavController()
        val sheetState = rememberModalBottomSheetState()
        var showBottomSheet by remember { mutableStateOf(false) }
        val adminBottomSheetState = rememberModalBottomSheetState()
        var adminBottomSheet by remember { mutableStateOf(false) }

        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                NavigationDrawer(
                    onClick = { if (drawerState.isOpen) scope.launch { drawerState.close() } },
                    toggleTheme = { isDarkTheme = !isDarkTheme },
                    isDarkTheme = isDarkTheme,
                    navigate = { navigateTo(navHostController, it); route = it },
                    showBottomSheet = { showBottomSheet = !showBottomSheet }
                )
            },
            gesturesEnabled = route == "home" && !isMenuOpen
        ) {
            Scaffold(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                topBar = { TopAppBar(route, isMenuOpen, navHostController, scope, drawerState) },
                bottomBar = {
                    BottomBar(route, navHostController, isMenuOpen) {
                        route = it;
                        navigateTo(navHostController = navHostController, it)
                    }
                },
                floatingActionButton = {
                    if (route == "home") {
                        FabMenu(isMenuOpen) { isMenuOpen = !isMenuOpen }
                    } else if (route == "official") {
                        FloatingPointButton {
                            navigateTo(navHostController = navHostController, "official input")
                        }
                    } else if (route == "testimonial") {
                        FloatingPointButton {
                            navigateTo(navHostController = navHostController, "testimonial input")
                        }
                    } else if (route == "carousel") {
                        FloatingPointButton {
                            navigateTo(navHostController = navHostController, "carousel input")
                        }
                    } else if (route == "domain") {
                        FloatingPointButton {
                            navigateTo(navHostController = navHostController, "domain input")
                        }
                    } else if (route == "news") {
                        FloatingPointButton {
                            navigateTo(navHostController = navHostController, "news input")
                        }
                    }
                }
            ) { innerPadding ->
                Navigation(
                    modifier = Modifier.padding(innerPadding),
                    navHostController,
                    officialViewModel,
                    homeViewModel
                ) {
                    route = it
                }
                if (showBottomSheet) {
                    BottomSheet(scope = scope, sheetState = sheetState) {
                        showBottomSheet = !showBottomSheet
                    }
                }
                if (adminBottomSheet) {
                    AdminBottomSheet(
                        scope = scope,
                        sheetState = adminBottomSheetState,
                        adminOptionList = getAdminList(option),
                        onClick = {
                            isMenuOpen = !isMenuOpen; route = it; navigateTo(navHostController, it)
                        },
                        showAdminBottomSheet = { adminBottomSheet = !adminBottomSheet }
                    )
                }
                if (isMenuOpen) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(backgroundColor)
                            .clickable { isMenuOpen = false }
                    )
                }
                FabMenuItems(isMenuOpen) {
                    option = it; adminBottomSheet =
                    !adminBottomSheet
                }

            }
        }
    }
}


@Composable
fun TopAppBar(
    route: String,
    isMenuOpen: Boolean,
    navHostController: NavHostController,
    scope: CoroutineScope,
    drawerState: DrawerState
) {
    if (!isMenuOpen) {
        when (route) {
            "home" -> TopHomeBar {
                scope.launch { if (drawerState.isClosed) drawerState.open() else drawerState.close() }
            }

            "profile" -> ProfileTopBar(onClick = { navigateTo(navHostController, "home") }) {
                navigateTo(navHostController, "edt_profile")
            }

            "edt_profile" -> EdtProfileTopBar(onClick = {
                navigateTo(
                    navHostController,
                    "profile"
                )
            })

            "carousel input" -> OtherTopBar(onClick = { navigateTo(navHostController, "carousel") })
            "domain input" -> OtherTopBar(onClick = { navigateTo(navHostController, "domain") })
            "news input" -> OtherTopBar(onClick = { navigateTo(navHostController, "news") })
            "official input" -> OtherTopBar(onClick = { navigateTo(navHostController, "official") })
            "testimonial input" -> OtherTopBar(onClick = {
                navigateTo(
                    navHostController,
                    "testimonial"
                )
            })

            else -> OtherTopBar(onClick = { navigateTo(navHostController, "home") })
        }
    }
}

@Composable
fun BottomBar(
    route: String, navHostController: NavHostController, isMenuOpen:
    Boolean, onChange: (changedRoute: String) -> Unit
) {
    if (!isMenuOpen && route == "home") {
        BottomNavigation(navHostController = navHostController) { onChange(it) }
    }
}

@Composable
fun FabMenu(isMenuOpen: Boolean, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = if (isMenuOpen) 81.dp else 0.dp),
        contentAlignment = Alignment.BottomEnd
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(11.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (isMenuOpen) {
                Text(
                    text = "Admin",
                    color = Color.White,
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            FloatingActionButton(
                onClick = onClick,
                containerColor = Color.LightGray,
                shape = RoundedCornerShape(50.dp),
                elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 15.dp),
                modifier = Modifier.size(61.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Edit",
                    tint = Color.White,
                    modifier = Modifier.size(35.dp)
                )
            }
        }
    }
}

@Composable
fun FabMenuItems(isMenuOpen: Boolean, onClick: (String) -> Unit) {
    if (isMenuOpen) {
        Box(
            modifier = Modifier
                .padding(end = 5.dp, bottom = 210.dp)
                .fillMaxSize(),
            contentAlignment = Alignment.BottomEnd
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                listOf(
                    "Home" to Icons.Default.Home,
                    "About" to Icons.Default.Info,
                    "Events" to Icons.Default.DateRange,
                    "Others" to Icons.Default.Star
                ).forEach {
                    Spacer(modifier = Modifier.height(8.dp))
                    FabMenuItem(text = it.first, icon = it.second, onClick = onClick)
                }
            }
        }
    }
}

@Composable
fun FabMenuItem(text: String, icon: ImageVector, onClick: (String) -> Unit) {
    Button(
        onClick = { onClick(text) },
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
    ) {
        Row(
            modifier = Modifier
                .background(Color.Transparent, CircleShape)
                .padding(vertical = 5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(imageVector = icon, contentDescription = text, tint = Color.White)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text, color = Color.White, fontSize = 19.sp)
        }
    }
}

fun navigateTo(navHostController: NavHostController, route: String) {
    navHostController.navigate(route) {
        popUpTo(navHostController.graph.startDestinationId) { saveState = true }
        launchSingleTop = true
        restoreState = true
    }
}

fun getAdminList(option: String): List<AdminOptions> = when (option) {
    "Home" -> listOf(
        AdminOptions("Carousel", "carousel"),
        AdminOptions("Domain", "domain"),
        AdminOptions("News", "news")
    )

    "About" -> listOf(
        AdminOptions("Official", "official"),
        AdminOptions("Coordinator", "coordinator"),
        AdminOptions("Testimonial", "testimonial"),
        AdminOptions("Make CR", "make-CR")
    )

    "Events" -> listOf(
        AdminOptions("Upcoming Events", "upcoming events"),
        AdminOptions("Completed Events", "comEvents")
    )

    "Others" -> listOf(
        AdminOptions("projects", "projects"),
        AdminOptions("Resources", "resources"),
        AdminOptions("Contact-Form", "contact-form"),
        AdminOptions("Feedback", "feedback")
    )

    else -> emptyList()
}
