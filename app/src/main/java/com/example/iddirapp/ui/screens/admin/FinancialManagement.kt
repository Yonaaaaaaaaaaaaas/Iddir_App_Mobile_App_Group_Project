package com.example.iddirapp.ui.screens.admin


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.AccountBalance
import androidx.compose.material.icons.outlined.EventNote
import androidx.compose.material.icons.outlined.Storage
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.BorderStroke
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun FinancialDashboardScreen(
    selectedItem: String = "Finance",
    onNavItemClick: (String) -> Unit = {}
) {
    Scaffold{ innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color(0xFFE8ECEC))
                .padding(16.dp)
        ) {
            // Back Button
            IconButton(onClick = { /* TODO: handle back */ }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
            }

            // Title
            Text(
                text = "Financial Management",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF004D40),
                modifier = Modifier.padding(vertical = 8.dp)
            )

            // Summary Cards
            FinancialCard(
                icon = Icons.Outlined.AccountBalance,
                label = "In the bank:",
                amount = "ETB 120,000"
            )
            FinancialCard(
                icon = Icons.Outlined.EventNote,
                label = "Overdue:",
                amount = "ETB 60,000"
            )
            FinancialCard(
                icon = Icons.Outlined.Storage,
                label = "Pending:",
                amount = "ETB 50,000"
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Overdue Payments Header
            Text(
                text = "Overdue Payments",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Sample Overdue Payment
            Card(
                shape = RoundedCornerShape(12.dp),
                border = BorderStroke(1.dp, Color.Black),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Aisha Kedir", fontWeight = FontWeight.Medium)
                    Text(text = "ETB 10,000", fontWeight = FontWeight.SemiBold)
                }
            }
            Spacer(modifier = Modifier.height(16.dp))

            // Overdue Payments Header
            Text(
                text = "Pending Payments",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Card(
                shape = RoundedCornerShape(12.dp),
                border = BorderStroke(1.dp, Color.Black),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Selam Alelgn", fontWeight = FontWeight.Medium)
                    Text(text = "ETB 20,000", fontWeight = FontWeight.SemiBold)
                }
            }

        }
    }
}

@Composable
fun FinancialCard(icon: ImageVector, label: String, amount: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        border = BorderStroke(1.dp, Color.LightGray),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = label, style = MaterialTheme.typography.titleMedium)
                Text(text = amount, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FinancialDashboardScreenPreview() {
    FinancialDashboardScreen()
}
