package com.example.iddirapp.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.Campaign
import androidx.compose.material.icons.filled.Checklist
import androidx.compose.material.icons.filled.Group
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import com.example.iddirapp.ui.components.BottomNavBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun BottomNavBar(
    selectedItem: String,
    onItemSelected: (String) -> Unit
) {
    NavigationBar(containerColor = Color(0xFF00BFA5)) {
        NavigationBarItem(
            selected = selectedItem == "Members",
            onClick = { onItemSelected("Members") },
            icon = { Icon(Icons.Default.Group, contentDescription = "Members") },
            label = { Text("Members") }
        )
        NavigationBarItem(
            selected = selectedItem == "Approvals",
            onClick = { onItemSelected("Approvals") },
            icon = { Icon(Icons.Default.Checklist, contentDescription = "Approvals") },
            label = { Text("Approvals") }
        )
        NavigationBarItem(
            selected = selectedItem == "Finance",
            onClick = { onItemSelected("Finance") },
            icon = { Icon(Icons.Default.AttachMoney, contentDescription = "Finance") },
            label = { Text("Finance") }
        )
        NavigationBarItem(
            selected = selectedItem == "Announcements",
            onClick = { onItemSelected("Announcements") },
            icon = { Icon(Icons.Default.Campaign, contentDescription = "Announcements") },
            label = { Text("Announcements") }
        )
    }
}