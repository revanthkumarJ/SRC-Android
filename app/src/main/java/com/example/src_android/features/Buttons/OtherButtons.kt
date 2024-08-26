package com.example.src_android.features.Buttons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
// Edit Button with Icon on the right
fun EditButton(onEditClick:()->Unit)
{
    Button(
        onClick = onEditClick
    ) {
        Row(verticalAlignment = Alignment.CenterVertically,modifier = Modifier.padding(horizontal = 10.dp)) {
            Text(text = "Edit")
            Spacer(modifier = Modifier.width(8.dp)) // Space between text and icon
            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = "Edit"
            )
        }
    }
}

@Composable
fun DeleteButton(onDeleteClick:()->Unit)
{
    Button(
        onClick = onDeleteClick,
        colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically,modifier = Modifier.padding(horizontal = 8.dp)) {
            Text(text = "Delete")
            Spacer(modifier = Modifier.width(8.dp)) // Space between text and icon
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Delete"
            )
        }
    }
}

@Composable
fun EditAndDeleteButtons(onEditClick:()->Unit,onDeleteClick:()->Unit){
    Row(
        modifier = Modifier.width(300.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        EditButton(onEditClick=onEditClick)

        Spacer(modifier = Modifier.width(16.dp))

        // Delete Button with Icon on the right
        DeleteButton(onDeleteClick=onDeleteClick)

    }
}