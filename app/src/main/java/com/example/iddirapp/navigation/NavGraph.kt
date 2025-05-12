package com.example.iddirapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.iddirapp.ui.screens.*
import com.example.iddirapp.ui.screens.Admin.AdminDashboardScreen
import com.example.iddirapp.ui.screens.Admin.FinancialDashboardScreen
import com.example.iddirapp.ui.screens.Admin.InitiateScreen
import com.example.iddirapp.ui.screens.Admin.MemberManagementScreen
import com.example.iddirapp.ui.screens.Welcome.*
import com.example.iddirapp.ui.screens.members.MainScreen
import com.example.iddirapp.ui.screens.members.UserProfileScreen


@Composable
fun AppNavGraph(
    navController: NavHostController,
    startDestination: String = "welcome" // Can be changed to "admin_dashboard" for testing
) {
    NavHost(navController = navController, startDestination = startDestination) {
        // Welcome flow screens
        composable("welcome") {
            WelcomeScreen(navController = navController)
        }
        composable("signin") {
            SignInScreen(navController = navController)
        }
        composable("signup") {
            SignUpScreen(navController = navController)
        }
        composable("verification") {
            VerificationScreen(navController = navController)
        }

        // Main app screens with bottom navigation
        composable("members") {
            MemberManagementScreen(
                selectedItem = "Members",
                onNavItemClick = { navController.navigate(it) }
            )
        }
        composable("finance") {
            FinancialDashboardScreen(
                selectedItem = "Finance",
                onNavItemClick = { navController.navigate(it) }
            )
        }
        composable("initiate") {
            InitiateScreen()
        }

        composable("mainscreen") {
            MainScreen()
        }

    }
}
