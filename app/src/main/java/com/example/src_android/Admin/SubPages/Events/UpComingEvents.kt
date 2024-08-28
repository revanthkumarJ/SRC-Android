package com.example.src_android.Admin.SubPages.Events

import android.net.Uri
import android.widget.DatePicker
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.src_android.R
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpComingEventUI(modifier: Modifier){
    val containerColor = if (MaterialTheme.colorScheme.primaryContainer == Color.Black) {
        Color(0xFFFAF9F6)
    } else {
        Color(0xFF1A1A1A)
    }
    var imageUri by remember { mutableStateOf<Uri?>(null) }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        imageUri = uri
    }

    Column(modifier = modifier
        .fillMaxWidth()
        .padding(16.dp)
        .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Text(text = "Add Event", fontSize = 28.sp)
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            value = "",
            onValueChange = {  },
            label = {
                Text(text = "Event name")
            },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent, // Use containerColor for background in Material3
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            value = "",
            onValueChange = {  },
            label = {
                Text(text = "Description About Event")
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent, // Use containerColor for background in Material3
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
            ),
            maxLines = 5
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            value = "",
            onValueChange = {  },
            label = {
                Text(text = "Location")
            },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent, // Use containerColor for background in Material3
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Date:")
        Spacer(modifier = Modifier.height(7.dp))
        DatePickerWithIcon("From")
        DatePickerWithIcon("To")
        Spacer(modifier = Modifier.height(10.dp))
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            TextField(
                value = "",
                onValueChange = {  },
                label = {
                    Text(text = "Enter Coordinator Mail")
                },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent, // Use containerColor for background in Material3
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedButton(
                onClick = {
                }
            ) {
                Text("Add Coordinator", fontSize = 18.sp, color = MaterialTheme.colorScheme.primary)
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
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
        Spacer(modifier = Modifier.height(10.dp))
        // Image Picker Button
        OutlinedButton(
            onClick = { launcher.launch("image/*") }
        ) {
            Text("Choose Image")
        }
        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = "",
            onValueChange = {  },
            label = {
                Text(text = "1st prize Details")
            },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent, // Use containerColor for background in Material3
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
            )
        )
        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = "",
            onValueChange = {  },
            label = {
                Text(text = "2nd prize Details")
            },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent, // Use containerColor for background in Material3
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
            )
        )
        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = "",
            onValueChange = {  },
            label = {
                Text(text = "3rd prize Details")
            },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent, // Use containerColor for background in Material3
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
            )
        )
        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = "",
            onValueChange = {  },
            label = {
                Text(text = "Registration Link")
            },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent, // Use containerColor for background in Material3
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedButton(
            onClick = {  }
        ) {
            Text("Add Event")
        }
        Spacer(modifier = Modifier.height(10.dp))
        
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerWithIcon(text:String) {
    var selectedDate by remember { mutableStateOf("00-00-0000") }
    val context = LocalContext.current

    // Function to show the DatePickerDialog
    val calendar = Calendar.getInstance()
    val datePickerDialog = android.app.DatePickerDialog(
        context,
        { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            // Update the selected date when user picks a date
            val sdf = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
            calendar.set(year, month, dayOfMonth)
            selectedDate = sdf.format(calendar.time)
        },
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH)
    )

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        // TextField to display the selected date
        TextField(
            value = selectedDate,
            onValueChange = {},
            readOnly = true, // Make the field read-only
            modifier = Modifier.weight(1f), // Take up remaining space
            label = { Text(text) },
            trailingIcon = {
                IconButton(onClick = { datePickerDialog.show() }) {
                    Icon(imageVector = Icons.Default.DateRange, contentDescription = "Select Date")
                }
            }
        )
    }
}