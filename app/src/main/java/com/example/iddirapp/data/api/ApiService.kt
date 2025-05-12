package com.example.iddirapp.data.api



import com.example.iddirapp.data.model.Announcement
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("api/announcements")
    fun postAnnouncement(@Body announcement: Announcement): Call<Announcement>
}
