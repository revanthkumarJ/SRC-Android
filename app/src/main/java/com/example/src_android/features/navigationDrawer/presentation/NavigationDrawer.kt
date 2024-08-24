package com.example.src_android.features.navigationDrawer.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.src_android.R
import com.example.src_android.utils.SharedPreference

@Composable
fun NavigationDrawer(
    isDarkTheme: Boolean,
    onClick: () -> Unit,
    navigate: (route: String) -> Unit,
    toggleTheme: () -> Unit,
    showBottomSheet: () -> Unit
) {
    val context = LocalContext.current
    val sharedPreference = remember {
        SharedPreference(context)
    }
    val loginStatus by remember {
        mutableStateOf(sharedPreference.getLoginStatus().isLogged)
    }
    val username by remember {
        mutableStateOf(sharedPreference.getUsername().username)
    }
    val email by remember {
        mutableStateOf(sharedPreference.getEmail().email)
    }

    ModalDrawerSheet(drawerContainerColor = MaterialTheme.colorScheme.primaryContainer) {

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(25.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
            ) {

                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "profile " + "Image",
                    modifier = Modifier
                        .size(55.dp)
                        .padding(bottom = 5.dp)
                )

                Text(
                    text = "email@gmail.com",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(top = 1.dp)
                )
                Text(
                    text = "Username",
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(top = 1.dp)
                )
            }
//            if (loginStatus) {
            IconButton(onClick = { showBottomSheet() }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_user_options),
                    contentDescription = "User Options",
                    modifier = Modifier.size(25.dp)
                )
            }
//            }
        }
        HorizontalDivider(modifier = Modifier.padding(top = 5.dp, bottom = 5.dp))
        NavigationDrawerItem(colors = NavigationDrawerItemDefaults.colors(
            selectedContainerColor = MaterialTheme.colorScheme.primaryContainer,
            unselectedIconColor = MaterialTheme.colorScheme.primaryContainer
        ), modifier = Modifier.padding(
            start = 25.dp, top = 9.dp
        ), label = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement =
                Arrangement.spacedBy(15.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Home,
                    tint = MaterialTheme.colorScheme.primary,
                    contentDescription = "Person"
                )
                Text(
                    "Home",
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold,
                    fontSize = 21.sp
                )
            }
        }, selected = true, onClick = {
            onClick()
            navigate("home")
        })

        NavigationDrawerItem(
            colors = NavigationDrawerItemDefaults.colors(
                selectedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                unselectedContainerColor = MaterialTheme.colorScheme.primaryContainer,
            ),
            modifier = Modifier.padding(start = 25.dp, top = 9.dp),
            label = {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement =
                    Arrangement.spacedBy(15.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        tint = MaterialTheme.colorScheme.primary,
                        contentDescription = "Person"
                    )
                    Text(
                        "Profile",
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold,
                        fontSize = 21.sp
                    )
                }
            },
            selected = true,
            onClick = {
                onClick()
                navigate("profile")
            }
        )

        NavigationDrawerItem(
            colors = NavigationDrawerItemDefaults.colors(
                selectedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                unselectedContainerColor = MaterialTheme.colorScheme.primaryContainer,
            ),
            modifier = Modifier.padding(start = 25.dp, top = 9.dp),
            label = {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement =
                    Arrangement.spacedBy(15.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Info,
                        tint = MaterialTheme.colorScheme.primary,
                        contentDescription = "Person"
                    )
                    Text(
                        "Know More",
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold,
                        fontSize = 21.sp
                    )
                }
            },
            selected = true,
            onClick = {
                onClick()
                navigate("about")
            }
        )

        NavigationDrawerItem(
            colors = NavigationDrawerItemDefaults.colors(
                selectedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                unselectedContainerColor = MaterialTheme.colorScheme.primaryContainer,
            ),
            modifier = Modifier.padding(start = 25.dp, top = 9.dp),
            label = {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement =
                    Arrangement.spacedBy(15.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Info,
                        tint = MaterialTheme.colorScheme.primary,
                        contentDescription = "Person"
                    )
                    Text(
                        "Admin",
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold,
                        fontSize = 21.sp
                    )
                }
            },
            selected = true,
            onClick = {
                onClick()
                navigate("admin")
            }
        )


        Box(
            modifier = Modifier
                .padding(start = 50.dp, bottom = 25.dp)
                .fillMaxSize(),
            contentAlignment = Alignment.BottomStart
        ) {
            IconButton(onClick = {
                toggleTheme()
            }) {
                Icon(
                    painter = painterResource(
                        id = if (isDarkTheme) R.drawable.ic_light_mode else R.drawable.ic_dark_mode
                    ), contentDescription = "dark mode", modifier = Modifier.size(21.dp)
                )
            }
        }
    }
}