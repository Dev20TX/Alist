package com.example.bennettangieslistapp.data.vo


import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("account_id")
    val accountId: Any,
    val id: String,
    @SerializedName("in_gallery")
    val inGallery: Boolean,
    val nsfw: Boolean,
    val title: String

)