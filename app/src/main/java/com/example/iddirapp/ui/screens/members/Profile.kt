package com.example.iddirapp.ui.screens.members

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.iddirapp.R

@Composable
fun UserProfileScreen(navController: NavController) {
    var showSignOutDialog by remember { mutableStateOf(false) }

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(innerPadding)
        ) {
            // Header with profile image
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .background(Color(0xFFE8ECEC))
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Box {
                        Image(
                            painter = painterResource(id = R.drawable.img_1),
                            contentDescription = "Profile Image",
                            modifier = Modifier
                                .size(96.dp)
                                .clip(CircleShape)
                                .background(Color.LightGray)
                        )
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = "Edit Icon",
                            tint = Color.Black,
                            modifier = Modifier
                                .align(Alignment.BottomEnd)
                                .offset(x = 8.dp, y = 8.dp)
                                .size(24.dp)
                                .background(Color.White, shape = CircleShape)
                        )
                    }
                    Text("Puerto Rico", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    Text("+01 234 567 89", fontSize = 14.sp)
                }
            }

            // Profile options
            Column(modifier = Modifier.padding(16.dp)) {
                ProfileOption(Icons.Default.Person, "Edit profile information")
                ProfileOption(Icons.Default.Notifications, "Notifications", trailingText = "ON")
                ProfileOption(Icons.Default.Menu, "Events")
                Spacer(modifier = Modifier.height(8.dp))
                ProfileOption(Icons.Default.CheckCircle, "Payment")
                ProfileOption(Icons.Default.Person, "Response from admin", trailingIcon = {
                    Box(
                        modifier = Modifier
                            .size(10.dp)
                            .background(Color.Green, shape = CircleShape)
                    )
                })
                Spacer(modifier = Modifier.height(8.dp))
                ProfileOption(Icons.Default.Face, "Members")
                ProfileOption(Icons.Default.Add, "Uploaded files and photos")
            }

            Spacer(modifier = Modifier.weight(1f)) // Push Sign Out to the bottom

            // Sign Out Button
            Button(
                onClick = { showSignOutDialog = true },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text("Sign Out")
            }

            // Confirmation Dialog
            if (showSignOutDialog) {
                AlertDialog(
                    onDismissRequest = { showSignOutDialog = false },
                    title = { Text("Confirm Sign Out") },
                    text = { Text("Do you want to sign out?") },
                    confirmButton = {
                        TextButton(
                            onClick = {
                                showSignOutDialog = false
                                navController.navigate("welcome")
                            }
                        ) {
                            Text("Yes")
                        }
                    },
                    dismissButton = {
                        TextButton(onClick = { showSignOutDialog = false }) {
                            Text("Cancel")
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun ProfileOption(
    icon: ImageVector,
    text: String,
    trailingText: String? = null,
    trailingIcon: @Composable (() -> Unit)? = null
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(icon, contentDescription = null, modifier = Modifier.size(24.dp))
        Spacer(modifier = Modifier.width(16.dp))
        Text(text, modifier = Modifier.weight(1f))
        trailingText?.let {
            Text(it, color = Color.Blue)
        }
        trailingIcon?.invoke()
    }
}
