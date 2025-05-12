package com.example.iddirapp.ui.screens.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import com.example.iddirapp.ui.components.BottomNavBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


@Preview(showBackground = true)
@Composable
fun EditProfileScreen(
    onBackClick: () -> Unit = {},
    onSubmitClick: (ProfileData) -> Unit = {},
    selectedItem: String = "Members",
    onNavItemClick: (String) -> Unit = {}
) {
    var fullName by remember { mutableStateOf("") }
    var dateOfBirth by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Scaffold(
        bottomBar = {
            BottomNavBar(
                selectedItem = selectedItem,
                onItemSelected = onNavItemClick
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(24.dp)
                .verticalScroll(rememberScrollState())
        ) {
        // Back button
        IconButton(onClick = onBackClick) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Edit Profile",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Input Fields
        OutlinedTextField(
            value = fullName,
            onValueChange = {
                val it = null
                fullName = it.toString()
            },
            label = { Text("Full Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = dateOfBirth,
            onValueChange = {
                val it = null
                dateOfBirth = it.toString()
            },
            label = { Text("Date of birth") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = address,
            onValueChange = {
                val it = null
                address = it.toString()
            },
            label = { Text("Address") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = phoneNumber,
            onValueChange = {
                val it = null
                phoneNumber = it.toString()
            },
            label = { Text("Phone Number") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Phone),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = {
                val it = null
                password = it.toString()
            },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedButton(
                onClick = onBackClick,
                modifier = Modifier.weight(1f)
            ) {
                Text("Back")
            }

            Spacer(modifier = Modifier.width(16.dp))

            Button(
                onClick = {
                    val profileData = ProfileData(
                        fullName, dateOfBirth, address, phoneNumber, password
                    )
                    onSubmitClick(profileData)
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Submit")
            }
        }
    }
    }
}

// Data class to hold profile info
data class ProfileData(
    val fullName: String,
    val dateOfBirth: String,
    val address: String,
    val phoneNumber: String,
    val password: String
)
