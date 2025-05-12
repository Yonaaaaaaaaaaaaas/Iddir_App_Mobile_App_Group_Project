package com.example.iddirapp.navigation

import EventRequestScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.iddirapp.ui.screens.*
import com.example.iddirapp.ui.screens.Welcome.*
import com.example.iddirapp.ui.screens.profile.EditProfileScreen


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
        composable("admin_dashboard") {
            AdminDashboardScreen(
                selectedItem = "Members",
                onNavItemClick = { navController.navigate(it) }
            )
        }
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
        composable("approvals") {
            EventRequestScreen(
                selectedItem = "Approvals",
                onNavItemClick = { navController.navigate(it) }
            )
        }
        composable("announcements") {
            AnnouncementPage(
                selectedItem = "Announcements",
                onNavItemClick = { navController.navigate(it) }
            )
        }
        composable("profile") {
            EditProfileScreen(
                selectedItem = "Members",
                onNavItemClick = { navController.navigate(it) },
                onBackClick = { navController.popBackStack() },
                onSubmitClick = { /* Handle profile update */ }
            )
        }
    }
}