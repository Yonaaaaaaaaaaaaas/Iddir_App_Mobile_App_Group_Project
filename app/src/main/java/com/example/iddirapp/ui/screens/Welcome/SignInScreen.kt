package com.example.iddirapp.ui.screens.Welcome

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.iddirapp.ui.theme.IddirAppTheme

@Composable
fun SignInScreen(navController: NavController) {
    // Predefined valid user lists
    val list1 = listOf("Alice" to "0911223344", "Bob" to "0900112233")
    val list2 = listOf("Charlie" to "0922334455", "Diana" to "0933445566")

    // Input state
    var name by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }

    // Error message state
    var errorMessage by remember { mutableStateOf<String?>(null) }

    // Track entered users
    val userList = remember { mutableStateListOf<Pair<String, String>>() }

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Sign In", style = MaterialTheme.typography.headlineSmall)

            Spacer(modifier = Modifier.height(24.dp))

            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Name") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = phone,
                onValueChange = { phone = it },
                label = { Text("Phone Number") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            errorMessage?.let {
                Text(text = it, color = MaterialTheme.colorScheme.error)
                Spacer(modifier = Modifier.height(8.dp))
            }

            Button(
                onClick = {
                    val currentUser = name to phone
                    userList.clear()
                    userList.add(currentUser)

                    when {
                        list1.contains(currentUser) -> {
                            errorMessage = null
                            navController.navigate("initiate")
                        }
                        list2.contains(currentUser) -> {
                            errorMessage = null
                            navController.navigate("mainscreen")
                        }
                        else -> {
                            errorMessage = "Incorrect name or phone number"
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Login")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignInScreenPreview() {
    IddirAppTheme {
        SignInScreen(navController = rememberNavController())
    }
}
