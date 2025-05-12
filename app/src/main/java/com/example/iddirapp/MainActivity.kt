package com.example.iddirapp

import AdminProfileDetailsPreview
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.iddirapp.navigation.AppNavGraph
import com.example.iddirapp.ui.screens.Admin.AdminDashboardScreen
import com.example.iddirapp.ui.screens.Admin.InitiateScreen
import com.example.iddirapp.ui.screens.Welcome.WelcomeScreen
import com.example.iddirapp.ui.theme.IddirAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IddirAppTheme {
                WelcomeScreen(navController= rememberNavController())
                AppNavGraph(navController = rememberNavController())
            }
        }
    }
}

// This is a simple greeting function that can be used for previews
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

// This preview function is separate from the main app navigation
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IddirAppTheme {
        Greeting("Android")
    }
}