package com.example.iddirapp.ui.screens.admin

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import android.util.Log
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.iddirapp.data.model.Announcement
import com.example.iddirapp.viewmodel.AnnouncementViewModel


@Preview(showBackground = true)
@Composable
fun AnnouncementDetailsPreview() {
    AnnouncementDetailsScreen(
        selectedItem = "Announcements",
        onNavItemClick = {}
    )
}

@Composable
fun AnnouncementDetailsScreen(
//    viewModel: AnnouncementViewModel,
    onBackClick: () -> Unit = {},
    onSubmitClick: (String, String, String, String) -> Unit = { _, _, _, _ -> },
    selectedItem: String = "Announcements",
    onNavItemClick: (String) -> Unit = {}
) {

    val viewModel: AnnouncementViewModel = viewModel()

    var title by remember { mutableStateOf(value = "") }
    var date by remember { mutableStateOf(value = "") }
    var location by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    Scaffold{ innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(innerPadding)
        ) {
            // Back Button
            IconButton(onClick = onBackClick) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Announcement Details",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Title Input
            Text("Title:")
            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                placeholder = { Text("Placeholder") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Date Input
            Text("Date:")
            OutlinedTextField(
                value = date,
                onValueChange = { date = it },
                placeholder = { Text("Placeholder") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Location Input
            Text("Location:")
            OutlinedTextField(
                value = location,
                onValueChange = { location = it },
                placeholder = { Text("Placeholder") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Description Input
            Text("Description:")
            OutlinedTextField(
                value = description,
                onValueChange = { description = it; Log.d("Input","Title updated to: $it") },
                placeholder = { Text("Placeholder") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                maxLines = 5
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Buttons
            Button(onClick = {
                val announcement = Announcement(
                    title =title,
                    date = date,
                    location = location,
                    description = description
                )

                viewModel.submitAnnouncement(
                    announcement,
                    onSuccess = {
                        Log.d("Submit", "Announcement submitted successfully")
                    },
                    onError = { error ->
                        Log.e("SubmitError", error)
                    }
                )
//                onSubmitClick(title, date, location, description)
            }) {
                Text("Submit")
            }
        }
    }
}

//fun onSubmitClick(title: String, date: String, location: String, description: String) {
//    // Handle submission logic here
//}