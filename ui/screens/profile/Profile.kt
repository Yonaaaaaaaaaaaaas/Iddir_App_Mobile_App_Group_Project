package com.example.iddirapp.ui.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.iddirapp.R


import com.example.iddirapp.ui.components.BottomNavBar
import com.example.iddirapp.ui.theme.IddirAppTheme


@Composable
fun UserProfileScreen() {
    Scaffold(
        bottomBar = {
            BottomNavBar(selectedItem = "Profile", onItemSelected = { /* handle nav */ })
        }
    ) { innerPadding ->
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
                            painter = painterResource(id = R.drawable.img),
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
    Row (
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


@Preview(showBackground = true)
@Composable
fun UserProfileScreenPreview() {
    IddirAppTheme {
        UserProfileScreen()
    }
}

