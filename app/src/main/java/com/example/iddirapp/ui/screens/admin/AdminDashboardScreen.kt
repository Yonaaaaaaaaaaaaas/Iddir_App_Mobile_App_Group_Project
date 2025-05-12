package com.example.iddirapp.ui.screens.admin

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.Campaign
import androidx.compose.material.icons.filled.Checklist
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.AccountCircle // Import for Profile icon
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material.icons.filled.ArrowForward
//import com.example.iddirapp.ui.components.BottomNavBar



@Composable
fun DashboardButton(
    label: String,
    icon: ImageVector,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .height(60.dp)
            .background(Color.White, shape = MaterialTheme.shapes.medium)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(icon, contentDescription = null, tint = Color.Black)
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = label,
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.weight(1f)
            )
            Icon(imageVector = Icons.Filled.ArrowForward,
                contentDescription = null, tint = Color.Black)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AdminDashboardScreen(
    selectedItem: String = "Members",
    onNavItemClick: (String) -> Unit = {}
) {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "Admin Dashboard",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            DashboardButton(label = "Members", icon = Icons.Default.Group, onClick = { onNavItemClick("members") })
            DashboardButton(label = "Requests", icon = Icons.Default.Checklist, onClick = { onNavItemClick("approvals") })
            DashboardButton(label = "Finances", icon = Icons.Default.AttachMoney, onClick = { onNavItemClick("finance") })
            DashboardButton(label = "Announcements", icon = Icons.Default.Campaign, onClick = { onNavItemClick("announcements") })
            DashboardButton(label = "Profile", icon = Icons.Default.AccountCircle, onClick = { onNavItemClick("profile") }) // Added Profile button
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AdminDashboardScreenPreview() {
    AdminDashboardScreen()
}
