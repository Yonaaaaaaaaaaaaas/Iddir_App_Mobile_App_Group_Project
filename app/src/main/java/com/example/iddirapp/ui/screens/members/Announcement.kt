package com.example.iddirapp.ui.screens.members

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.iddirapp.R
import com.example.iddirapp.ui.components.BottomNavBar

@Composable
fun AnnouncementsScreen() {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF5F8F8))
                .padding(innerPadding)
        ) {
            // Top Bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Announcements",
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF00332A)
                )
            }
            // Announcements list
            LazyColumn (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 56.dp)
            ) {
                item {
                    AnnouncementCardFuneral()
                }
                item {
                    AnnouncementCardTextOnly(
                        title = "MONTHLY GATHERING",
                        content = "We gather to discuss about annual payment. All members are requested to pay their respects and participate in the service."
                    )
                }
                item {
                    AnnouncementCardNotice(
                        content = "We ask you kindly to pay 200 birr for your monthly fee in a week, if you pass the due date 50 additional fee is required"
                    )
                }
            }
        }
    }
}

@Composable
fun AnnouncementCardFuneral() {
    Card  (
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(6.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF0F0F0))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("DECEMBER 16, 9:10 PM", fontSize = 12.sp, color = Color.DarkGray)
            Spacer(Modifier.height(4.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Funeral Service",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF00332A),
                    modifier = Modifier.weight(1f)
                )
                Box(
                    modifier = Modifier
                        .size(12.dp)
                        .background(Color.Red, shape = CircleShape)
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_1),
                    contentDescription = "avatar",
                    modifier = Modifier
                        .size(64.dp)
                        .clip(CircleShape)
                )
                Spacer(Modifier.width(12.dp))
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .background(Color.White, shape = RoundedCornerShape(12.dp))
                        .padding(12.dp)
                ) {
                    Text("Adanech Belay", fontWeight = FontWeight.Medium)
                    Text("10 Jan 2023", fontWeight = FontWeight.Medium)
                    Text("Shiromeda church", fontWeight = FontWeight.Medium)
                }
            }
        }
    }
}

@Composable
fun AnnouncementCardTextOnly(title: String, content: String) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(6.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF0F0F0))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("DECEMBER 16, 9:10 PM", fontSize = 12.sp, color = Color.DarkGray)
            Spacer(Modifier.height(4.dp))
            Text(
                text = title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF00332A)
            )
            Spacer(Modifier.height(8.dp))
            Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFFFF)),
                shape = RoundedCornerShape(12.dp),
                elevation = CardDefaults.cardElevation(0.dp)
            ) {
                Text(
                    text = content,
                    modifier = Modifier.padding(12.dp),
                    fontSize = 14.sp
                )
            }
        }
    }
}

@Composable
fun AnnouncementCardNotice(content: String) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(6.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF0F0F0))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "Notice",
                    tint = Color(0xFF00332A),
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Notice",
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF00332A),
                    fontSize = 18.sp
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = content,
                fontSize = 14.sp,
                color = Color.DarkGray
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AnnouncementsScreenPreview() {
    AnnouncementsScreen()
}
