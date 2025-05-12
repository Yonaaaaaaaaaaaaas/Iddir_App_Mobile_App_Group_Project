// File: data/repository/AnnouncementRepository.kt
package com.example.iddirapp.data.repository

import com.example.iddirapp.data.api.RetrofitInstance
import com.example.iddirapp.data.model.Announcement
import retrofit2.Call

class AnnouncementRepository {
    fun postAnnouncement(announcement: Announcement): Call<Announcement> {
        return RetrofitInstance.api.postAnnouncement(announcement)
    }
}
