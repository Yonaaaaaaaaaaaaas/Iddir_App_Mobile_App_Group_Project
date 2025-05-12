package com.example.iddirapp.data.local

import com.example.iddirapp.data.model.Announcement
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("api/announcements")
    suspend fun getAnnouncements(): List<Announcement>

    @POST("api/announcements")
    suspend fun createAnnouncement(@Body announcement: Announcement): Response<Announcement>
}
