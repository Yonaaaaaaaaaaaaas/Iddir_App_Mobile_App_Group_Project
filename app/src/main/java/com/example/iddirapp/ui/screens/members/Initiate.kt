package com.example.iddirapp.ui.screens.members


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.example.iddirapp.ui.screens.members.AnnouncementsScreen
import com.example.iddirapp.ui.screens.members.ServiceRequestScreen
import com.example.iddirapp.ui.screens.members.UserProfileScreen

@Composable
fun MainScreen() {
    val selectedItem = remember { mutableStateOf(0) }
    val items = listOf("Announcements", "Request", "Profile")
    val icons = listOf(Icons.Default.Notifications, Icons.Default.Add, Icons.Default.Person)

    Scaffold (
        bottomBar = {
            NavigationBar (containerColor = Color(0xFF00BDBD)) {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        icon = { Icon(imageVector = icons[index], contentDescription = item) },
                        label = { Text(item) },
                        selected = selectedItem.value == index,
                        onClick = { selectedItem.value = index }
                    )
                }
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            when (selectedItem.value) {
                0 -> AnnouncementsScreen()
                1 -> ServiceRequestScreen()
                2 -> UserProfileScreen(navController = rememberNavController())
            }
        }
    }
}
