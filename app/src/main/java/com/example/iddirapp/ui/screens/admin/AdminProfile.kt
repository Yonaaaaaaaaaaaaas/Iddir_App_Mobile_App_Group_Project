package com.example.iddirapp.ui.screens.admin

// Compose core
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ContentCopy
//import com.example.iddirapp.ui.components.BottomNavBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun AdminProfileDetailsPreview() {
    AdminProfileDetailsScreen(
        selectedItem = "Members",
        onNavItemClick = {}
    )
}

@Composable
fun ProfileInfoRow(label: String, value: String, isPhone: Boolean = false) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            fontWeight = FontWeight.Bold,
            fontSize = 27.sp
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = value,
            fontSize = 20.sp,
            modifier = Modifier.weight(1f)
        )
        if (isPhone) {
            Icon(
                imageVector = Icons.Filled.ContentCopy,
                contentDescription = "Copy Phone",
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

@Composable
fun AdminProfileDetailsScreen(
    name: String = "Alexander Raji",
    phone: String = "+251963524185",
    address: String = "Semmit Fyél Bet",
    familyCount: Int = 12,
    onBackClick: () -> Unit = {},
    selectedItem: String = "Members",
    onNavItemClick: (String) -> Unit = {}
) {
    Scaffold{ innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(24.dp)
        ) {
            IconButton(onClick = onBackClick) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Icon(
                imageVector = Icons.Filled.AccountCircle,
                contentDescription = "Profile Image",
                modifier = Modifier
                    .size(160.dp)
                    .align(Alignment.CenterHorizontally),
                tint = Color.Black
            )

            Spacer(modifier = Modifier.height(50.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                border = BorderStroke(1.dp, Color.Black),
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    ProfileInfoRow(label = "Name:", value = name)
                    ProfileInfoRow(label = "Phone:", value = phone, isPhone = true)
                    ProfileInfoRow(label = "Address:", value = address)
                    ProfileInfoRow(label = "Family Members:", value = familyCount.toString())
                }
            }
        }
    }
}
