package com.example.iddirapp.ui.screens.Welcome


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*  // Correct import for Material3 components
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.iddirapp.ui.theme.IddirAppTheme
import com.example.iddirapp.ui.components.BottomNavBar
import java.util.Locale

@Composable
fun VerificationScreen(navController: NavController) {
    Scaffold(
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(24.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Text component from Material3
            Text("Verification", style = MaterialTheme.typography.headlineSmall)

            Spacer(modifier = Modifier.height(24.dp))

            Text("Enter the code admin sent you through: +251900000000")

            Spacer(modifier = Modifier.height(16.dp))

            var verificationCode by remember { mutableStateOf(List(6) { "" }) }

            Row {
                verificationCode.forEachIndexed { index, code ->
                    OutlinedTextField(
                        value = code,
                        onValueChange = { newValue ->
                            if (newValue.length <= 1) {
                                verificationCode = verificationCode.toMutableList().also { it[index] = newValue }
                            }
                        },
                        modifier = Modifier.width(40.dp),
                        singleLine = true
                    )
                    if (index < 5) Spacer(modifier = Modifier.width(4.dp))
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            TextButton(onClick = { /* handle resend */ }) {
                Text("Resend the code?")
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = { navController.navigate("signin") },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Submit")
            }
        }
    }
}
// ... existing code ...

@Preview(showBackground = true)
@Composable
fun VerificationScreenPreview() {
    IddirAppTheme {
        VerificationScreen(navController = rememberNavController())
    }
}