package com.example.src_android.Admin.SubPages.HomeUI

import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.example.src_android.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarouselInput(modifier: Modifier = Modifier) {
    var name by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var selectedDomain by remember { mutableStateOf("") }
    var imageUri by remember { mutableStateOf<Uri?>(null) }

    val domains = listOf("Tech", "Design", "Science", "Art", "Business")

    val containerColor = if (MaterialTheme.colorScheme.primaryContainer == Color.Black) {
        Color(0xFFFAF9F6)
    } else {
        Color(0xFF1A1A1A)
    }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        imageUri = uri
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Add New Event", fontSize = 28.sp)
        Spacer(modifier = Modifier.height(16.dp))
        // Name TextField
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent, // Use containerColor for background in Material3
                focusedIndicatorColor = containerColor, // Remove underline on focus

            )
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Description TextField (5 lines)
        TextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Description") },
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            maxLines = 5,
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent, // Use containerColor for background in Material3
                focusedIndicatorColor = containerColor, // Remove underline on focus

            )
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Dropdown for selecting domain
        DomainDropdown(
            domains = domains,
            selectedDomain = selectedDomain,
            onDomainSelected = { selectedDomain = it }
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Display the selected image or a default image
        val imageModifier = Modifier
            .size(200.dp, 150.dp)
            .clip(RoundedCornerShape(10.dp))
            .border(1.dp, Color.Gray, RoundedCornerShape(10.dp))

        if (imageUri != null) {
            Image(
                painter = rememberAsyncImagePainter(model = imageUri),
                contentDescription = "Selected Image",
                modifier = imageModifier,
                contentScale = ContentScale.Crop
            )
        } else {
            Image(
                painter = painterResource(id = R.drawable.krishna), // replace with your default image resource
                contentDescription = "Default Image",
                modifier = imageModifier,
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Image Picker Button
        OutlinedButton(
            onClick = { launcher.launch("image/*") }
        ) {
            Text("Choose Image")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Add Carousel Button
        OutlinedButton(
            onClick = {
                logCarouselData(name, description, selectedDomain, imageUri)
            }
        ) {
            Text("Add Carousel", fontSize = 18.sp, color = Color.White)
        }
    }
}

// Sample Dropdown for selecting domain
@Composable
fun DomainDropdown(domains: List<String>, selectedDomain: String, onDomainSelected: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }

    Box {
        OutlinedButton(onClick = { expanded = true }) {
            Text(
                text = selectedDomain.ifEmpty { "Select Domain" },
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onSurface
            )
        }

        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            domains.forEach { domain ->
                DropdownMenuItem(onClick = {
                    onDomainSelected(domain)
                    expanded = false
                }, text = {Text(text = domain)})
            }
        }
    }
}

// Log carousel data
fun logCarouselData(name: String, description: String, domain: String, imageUri: Uri?) {
    Log.i("Relevant","$name $description $imageUri")
}


@Composable
fun Carousel(modifier: Modifier)
{
    var array= listOf(CarouselUIData(name = "Revanth", description = "This is the description of Domain and Details", image = "", domain = "App"),CarouselUIData(name = "Revanth", description = "Random", image = "", domain = "App"),CarouselUIData(name = "Revanth", description = "Random", image = "", domain = "App"),CarouselUIData(name = "Revanth", description = "Random", image = "", domain = "App"))

    Column(modifier=modifier) {
        LazyRow(

        ) {
            itemsIndexed(array)
            {
                    index, item ->
                CarouselUI(
                    name = item.name,
                    description = item.description,
                    domain =item.domain ,
                    image = item.image,
                    onEditClick = { /*TODO*/ },
                    onDeleteClick = { /*TODO*/ },
                    defaultImageRes = item.defaultImageRes
                )
            }
        }
    }

}

@Composable
fun CarouselUI(
    name: String,
    description: String,
    domain: String,
    image: String,
    onEditClick: () -> Unit,
    onDeleteClick: () -> Unit,
    defaultImageRes: Int // Resource ID of the default image
) {
    val lightBlack = Color(0xFF1A1A1A)
    val lightBlack1 = Color(0xFFFAF9F6)
    ElevatedCard(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.elevatedCardElevation(8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.elevatedCardColors(
            containerColor = if (MaterialTheme.colorScheme.primaryContainer == Color
                    .Black
            ) lightBlack else lightBlack1
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Image at the top with placeholder or fallback on error
            val painter = // If error occurs, show default image
                rememberAsyncImagePainter( // Animation for a smooth transition
                    ImageRequest.Builder(LocalContext.current).data(data = image).apply(block = fun ImageRequest.Builder.() {
                        placeholder(defaultImageRes)
                        error(defaultImageRes) // If error occurs, show default image
                        crossfade(true) // Animation for a smooth transition
                    }).build()
                )

            Image(
                painter = painter,
                contentDescription = "Image",
                modifier = Modifier
                    .size(300.dp,200.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Name
            Text(
                text = "Title: $name",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))
            // Domain
            Text(
                text = "Domain: $domain",
                style = MaterialTheme.typography.bodyLarge,
            )

            Spacer(modifier = Modifier.height(16.dp))
            // Description
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium,
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Buttons: Edit and Delete
            Row(
                modifier = Modifier.width(300.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Edit Button with Icon on the right
                Button(
                    onClick = onEditClick,
                    modifier = Modifier.weight(1f)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = "Edit")
                        Spacer(modifier = Modifier.width(8.dp)) // Space between text and icon
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = "Edit"
                        )
                    }
                }

                Spacer(modifier = Modifier.width(16.dp))

                // Delete Button with Icon on the right
                Button(
                    onClick = onDeleteClick,
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = "Delete")
                        Spacer(modifier = Modifier.width(8.dp)) // Space between text and icon
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = "Delete"
                        )
                    }
                }
            }

        }
    }
}


data class CarouselUIData(
    val name: String,
    val description: String,
    val domain: String,
    val image: String,
    val defaultImageRes: Int=R.drawable.krishna
)