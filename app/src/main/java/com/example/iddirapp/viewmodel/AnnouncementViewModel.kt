package com.example.iddirapp.viewmodel


import androidx.lifecycle.ViewModel
import com.example.iddirapp.data.repository.AnnouncementRepository
import com.example.iddirapp.data.model.Announcement
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AnnouncementViewModel : ViewModel() {
    private val repository = AnnouncementRepository()

    fun submitAnnouncement(announcement: Announcement, onSuccess: () -> Unit, onError: (String) -> Unit) {
        repository.postAnnouncement(announcement).enqueue(object : Callback<Announcement> {
            override fun onResponse(call: Call<Announcement>, response: Response<Announcement>) {
                if (response.isSuccessful) {
                    onSuccess()
                } else {
                    onError("Error: ${response.errorBody()?.string()}")
                }
            }

            override fun onFailure(call: Call<Announcement>, t: Throwable) {
                onError("Failure: ${t.message}")
            }
        })
    }
}

