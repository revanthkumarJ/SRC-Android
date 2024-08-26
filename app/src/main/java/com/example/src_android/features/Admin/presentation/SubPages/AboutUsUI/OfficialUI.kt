package com.example.src_android.features.Admin.presentation.SubPages.AboutUsUI

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.CardDefaults
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
import coil.request.ImageRequest
import com.example.src_android.features.Admin.presentation.SubPages.HomeUI.DomainDropdown
import com.example.src_android.R
import com.example.src_android.features.Buttons.DeleteButton
import com.example.src_android.features.Buttons.EditAndDeleteButtons
import com.example.src_android.features.Buttons.EditButton


@Composable
fun Official(modifier: Modifier) {
    var array = listOf(
        OfficialUIData(name = "RatnaKumari", designation = "HOD", phoneNumber = "0000000000", email = "jrevanth101@gmail.com", department = "CSE", linkdeIn = "", bio = "Bio snjjsbjs sjnjss bsbsn", qualifications = "hss MTech, PHD", image = ""),
        OfficialUIData(name = "RatnaKumari", designation = "HOD", phoneNumber = "0000000000", email = "jrevanth101@gmail.com", department = "CSE", linkdeIn = "", bio = "Bio snjjsbjs sjnjss bsbsn", qualifications = "hss MTech, PHD", image = ""),
        OfficialUIData(name = "RatnaKumari", designation = "HOD", phoneNumber = "0000000000", email = "jrevanth101@gmail.com", department = "CSE", linkdeIn = "", bio = "Bio snjjsbjs sjnjss bsbsn", qualifications = "hss MTech, PHD", image = "")

    )
    Column(modifier = modifier) {
        LazyRow(

        ) {
            itemsIndexed(array)
            { index, item ->
                OfficialUI(
                    name = item.name,
                    email = item.email,
                    designation = item.designation ,
                    phoneNumber = item.phoneNumber ,
                    department = item.department,
                    bio = item.bio,
                    qualifications =item.qualifications ,
                    linkdeIn = item.linkdeIn,
                    image = item.image,
                    onEditClick = { /*TODO*/ }) {

                }
            }
        }
    }
}

@Composable
fun OfficialUI(
    name: String,
    email: String,
    designation: String,
    phoneNumber: String,
    department: String,
    bio: String,
    qualifications: String,
    linkdeIn: String,
    image: String,
    onEditClick: () -> Unit,
    onDeleteClick: () -> Unit,
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
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Image at the top with placeholder or fallback on error
            val painter = // If error occurs, show default image
                rememberAsyncImagePainter( // Animation for a smooth transition
                    ImageRequest.Builder(LocalContext.current).data(data = image)
                        .apply(block = fun ImageRequest.Builder.() {
                            placeholder(R.drawable.krishna)
                            error(R.drawable.krishna) // If error occurs, show default image
                            crossfade(true) // Animation for a smooth transition
                        }).build()
                )

            Image(
                painter = painter,
                contentDescription = "Image",
                modifier = Modifier
                    .size(300.dp, 200.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Name
            Text(
                text = name,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )


            Spacer(modifier = Modifier.height(16.dp))
            // Email
            Text(
                text = email,
                style = MaterialTheme.typography.bodyMedium,
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = phoneNumber,
                style = MaterialTheme.typography.bodyMedium,
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "$department Department",
                style = MaterialTheme.typography.bodyMedium,
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Designation :$designation",
                style = MaterialTheme.typography.bodyMedium,
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Bio: $bio",
                style = MaterialTheme.typography.bodyMedium,
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Qualifications: $qualifications",
                style = MaterialTheme.typography.bodyMedium,
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "LinkdeIn: $linkdeIn",
                style = MaterialTheme.typography.bodyMedium,
            )

            Spacer(modifier = Modifier.height(16.dp))

            EditAndDeleteButtons(onEditClick = onEditClick,onDeleteClick=onDeleteClick)


        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OfficialInputUI(modifier: Modifier) {
    var name by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var designation by remember {
        mutableStateOf("")
    }
    var phone by remember {
        mutableStateOf("")
    }
    var dept by remember {
        mutableStateOf("")
    }
    var bio by remember {
        mutableStateOf("")
    }
    var qualifications by remember {
        mutableStateOf("")
    }
    var linkdein by remember {
        mutableStateOf("")
    }
    var imageUri by remember { mutableStateOf<Uri?>(null) }

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
        Text(text = "Add Official", fontSize = 28.sp)
        Spacer(modifier = Modifier.height(16.dp))
        // Name TextField
        TextField(
            value = "",
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
            )
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Description TextField (5 lines)
        TextField(
            value = "",
            onValueChange = { },
            label = { Text("Email") },
            modifier = Modifier
                .fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
            )
        )
        Spacer(modifier = Modifier.height(16.dp))


        TextField(
            value = "",
            onValueChange = { },
            label = { Text("Designation") },
            modifier = Modifier
                .fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
            )
        )
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = "",
            onValueChange = { },
            label = { Text("Phone Number") },
            modifier = Modifier
                .fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
            )
        )
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = "",
            onValueChange = { },
            label = { Text("Department") },
            modifier = Modifier
                .fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
            )
        )
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = "",
            onValueChange = { },
            label = { Text("Bio") },
            modifier = Modifier
                .fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
            )
        )
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = "",
            onValueChange = { },
            label = { Text("Qualifications") },
            modifier = Modifier
                .fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
            )
        )
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = "",
            onValueChange = { },
            label = { Text("LinkdeIn") },
            modifier = Modifier
                .fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
            )
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
            }
        ) {
            Text("Add Official", fontSize = 18.sp, color = Color.White)
        }
    }

}


data class OfficialUIData(
    val name: String,
    val email: String,
    val designation: String,
    val phoneNumber: String,
    val department: String,
    val bio: String,
    val qualifications: String,
    val linkdeIn: String,
    val image: String
)