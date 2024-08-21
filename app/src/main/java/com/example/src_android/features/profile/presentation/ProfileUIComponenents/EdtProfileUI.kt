package com.example.src_android.features.profile.presentation.ProfileUIComponenents

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.src_android.R


@Composable
fun EdtTextFields() {
    var name by remember {
        mutableStateOf("")
    }
    var gfg by remember {
        mutableStateOf("")
    }
    var linkdein by remember {
        mutableStateOf("")
    }
    var github by remember {
        mutableStateOf("")
    }
    var leetcode by remember {
        mutableStateOf("")
    }

    Column (modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally){
        TextField(value = name, onValueChange = { name = it }, label = {
            Text(text = "Name")
        },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_profile_filled),
                    contentDescription = "Profile Icon",
                    modifier = Modifier.size(26.dp)
                )
            }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = linkdein,
            onValueChange = { linkdein = it },
            label = { Text(text = "LinkedIn") },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.linkdein_white),
                    contentDescription = "LinkedIn Icon",
                    modifier = Modifier.size(30.dp)
                )
            }
        )
        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = github,
            onValueChange = { github = it },
            label = { Text(text = "GitHub") },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.github_white),
                    contentDescription = "GitHub Icon",
                    modifier = Modifier.size(30.dp)
                )
            }
        )
        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = gfg,
            onValueChange = { gfg = it },
            label = { Text(text = "GFG") },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.gfg_icon_white),
                    contentDescription = "GFG Icon",
                    modifier = Modifier.size(27.dp)
                )
            }
        )
        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = leetcode,
            onValueChange = { leetcode = it },
            label = { Text(text = "LeetCode") },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.leetcode_white),
                    contentDescription = "LeetCode Icon",
                    modifier = Modifier.size(25.dp)
                )
            }
        )
    }
}


@Composable
fun ProfileImage(
    selectedImageUri: Uri?,
    onImageClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .size(130.dp) // Size of the image
            .clip(CircleShape) // Makes the image rounded
            .background(Color.Gray) // Placeholder background color
            .clickable { onImageClick() }, // Handle image click
        contentAlignment = Alignment.Center
    ) {
        if (selectedImageUri != null) {
            Image(
                painter = rememberAsyncImagePainter(model = selectedImageUri),
                contentDescription = "Profile Image",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop // Crop to fit the circle
            )
        } else {
            Icon(
                painter = painterResource(id = R.drawable.ic_profile_filled), // Default profile icon
                contentDescription = "Default Profile Icon",
                tint = Color.White
            )
        }
    }
}

@Composable
fun ProfileScreen() {
    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri: Uri? ->
            selectedImageUri = uri
        }
    )

    ProfileImage(
        selectedImageUri = selectedImageUri,
        onImageClick = {
            launcher.launch("image/*")
        }
    )
}

