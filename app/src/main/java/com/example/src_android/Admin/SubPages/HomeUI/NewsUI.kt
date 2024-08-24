package com.example.src_android.Admin.SubPages.HomeUI

import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.src_android.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsUI(modifier: Modifier) {

    var name by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var link by remember { mutableStateOf("") }
    val containerColor = if (MaterialTheme.colorScheme.primaryContainer == Color.Black) {
        Color(0xFFFAF9F6)
    } else {
        Color(0xFF1A1A1A)
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Add Latest News", fontSize = 28.sp)
        Spacer(modifier = Modifier.height(16.dp))
        // Name TextField
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("News Name") },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent, // Use containerColor for background in Material3
                focusedIndicatorColor = containerColor, // Remove underline on focus

            )
        )
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = link,
            onValueChange = { link = it },
            label = { Text("Link") },
            modifier = Modifier
                .fillMaxWidth()
                ,
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent, // Use containerColor for background in Material3
                focusedIndicatorColor = containerColor, // Remove underline on focus

            )
        )
        Spacer(modifier = Modifier.height(12.dp))
        // Description TextField (5 lines)
        TextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("News Description") },
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            maxLines = 10,
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent, // Use containerColor for background in Material3
                focusedIndicatorColor = containerColor, // Remove underline on focus

            )
        )
        Spacer(modifier = Modifier.height(12.dp))

        // Add Carousel Button
        OutlinedButton(
            onClick = {
                logCarouselData(name, description, link = link)
            }
        ) {
            Text("Add News", fontSize = 18.sp, color = Color.White)
        }
    }
}
// Log carousel data
fun logCarouselData(name: String, description: String,link:String) {
    Log.i("Relevant","$name $description $link")
}

