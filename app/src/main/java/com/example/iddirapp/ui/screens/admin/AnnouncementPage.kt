package com.example.iddirapp.ui.screens.admin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.draw.clip
//import com.example.iddirapp.ui.components.BottomNavBar // <-- import shared BottomNavBar

@Composable
fun AnnouncementCard(
    title: String,
    datePosted: String,
    eventDate: String,
    location: String,
    onViewDetails: () -> Unit,
    onEdit: () -> Unit,
    onDelete: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .wrapContentHeight(),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = datePosted, fontSize = 12.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = title, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(12.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null,
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .background(Color(0xFFE0E0E0)),
                    tint = Color(0xFF4E342E)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(text = "Date: $eventDate", fontSize = 14.sp, fontWeight = FontWeight.Medium)
                    Text(text = "Location: $location", fontSize = 14.sp)
                }
            }

            Spacer(modifier = Modifier.height(12.dp))
            Button(
                onClick = onViewDetails,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                elevation = ButtonDefaults.buttonElevation(2.dp)
            ) {
                Text("View Details", color = Color.Black)
            }

            Spacer(modifier = Modifier.height(8.dp))
            Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()) {
                IconButton(onClick = onEdit) {
                    Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit")
                }
                IconButton(onClick = onDelete) {
                    Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete")
                }
            }
        }
    }
}

@Composable
fun AnnouncementPage(
    selectedItem: String = "Announcements", // Pass to BottomNavBar
    onNavItemClick: (String) -> Unit = {}   // Nav click callback
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* Add new announcement */ },
                containerColor = Color(0xFF00BFA5)
            ) {
                Icon(Icons.Default.Add, contentDescription = "Announce")
            }
        },
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(Color(0xFFF4F7F8))
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "Announcements",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            AnnouncementCard(
                title = "FUNERAL SERVICE",
                datePosted = "December 16, 9:10 PM",
                eventDate = "Dec 17th, 2025",
                location = "Arada Giyorgis",
                onViewDetails = { /* TODO */ },
                onEdit = { /* TODO */ },
                onDelete = { /* TODO */ }
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AnnouncementPagePreview() {
    AnnouncementPage()
}
