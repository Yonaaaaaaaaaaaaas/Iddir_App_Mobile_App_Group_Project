package com.example.iddirapp.ui.screens.Welcome


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.iddirapp.ui.theme.IddirAppTheme
import com.example.iddirapp.R
import com.example.iddirapp.ui.theme.TealMain
import com.example.iddirapp.ui.theme.DarkText
import androidx.compose.foundation.BorderStroke

@Composable
fun WelcomeScreen(navController: NavController) {
    Scaffold(
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.iddir_logo),
                contentDescription = "Logo"
            )

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = { navController.navigate("signup") },
                colors = ButtonDefaults.buttonColors(containerColor = TealMain),
                modifier = Modifier.fillMaxWidth().height(48.dp)
            ) {
                Text("Create an account", color = DarkText)
            }

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedButton(
                onClick = { navController.navigate("signin") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = DarkText),
                border = BorderStroke(1.dp, TealMain)
            ) {
                Text("Sign In")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    IddirAppTheme {
        WelcomeScreen(navController = rememberNavController())
    }
}