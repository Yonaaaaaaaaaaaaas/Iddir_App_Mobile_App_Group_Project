package com.example.iddirapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.iddirapp.R
import com.example.iddirapp.ui.components.BottomNavBar

data class Member(val name: String, val phone: String, val status: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MemberManagementScreen(
    selectedItem: String = "Members",
    onNavItemClick: (String) -> Unit = {},
    members: List<Member> = listOf(
        Member("Abel Taye", "0911234567", "Paid"),
        Member("Nahom Abebe", "0987424532", "Overdue"),
        Member("Hanan Mulugeta", "0958746321", "Paid"),
        Member("Million Abate", "0987543255", "Pending")
    )
) {
    var searchQuery by remember { mutableStateOf("") }

    // Filter members based on search query
    val filteredMembers = members.filter { member ->
        member.name.contains(searchQuery, ignoreCase = true)
    }

    Scaffold() { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(20.dp)
                .background(Color.White)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = "Member Management",
                fontSize = 42.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF003B2D) // Dark green color
            )

            Spacer(modifier = Modifier.height(60.dp))

            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                label = { Text("Search Members") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            filteredMembers.forEach { member ->
                MemberItem(member, onNavItemClick)
                Spacer(modifier = Modifier.height(4.dp)) // Space between items
            }
        }
    }
}

@Composable
fun MemberItem(member: Member, onNavItemClick: (String) -> Unit = {}) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = member.name,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = member.phone,
                        fontSize = 20.sp
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    StatusIndicator(member.status)
                }
                Box {
                    IconButton(onClick = { expanded = true }) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline),
                            contentDescription = "More options"
                        )
                    }
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        DropdownMenuItem(
                            text = { Text("View") },
                            onClick = {
                                expanded = false
                                onNavItemClick("adminProfileDetails")
                            }
                        )

                        DropdownMenuItem(
                            text = { Text("Remove") },
                            onClick = {
                                expanded = false
                                // Handle remove action
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun StatusIndicator(status: String) {
    val (color, label) = when (status) {
        "Paid" -> Color.Green to "Paid"
        "Overdue" -> Color.Red to "Overdue"
        "Pending" -> Color.Yellow to "Pending"
        else -> Color.Gray to "Unknown"
    }

    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .size(24.dp)
                .background(color, shape = RoundedCornerShape(12.dp))
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = label, fontSize = 18.sp, color = color)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMemberManagement() {
    MemberManagementScreen()
}
