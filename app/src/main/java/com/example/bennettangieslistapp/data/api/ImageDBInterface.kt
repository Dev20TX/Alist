package com.example.bennettangieslistapp.data.api

import com.example.bennettangieslistapp.data.vo.ImageDetails
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query


interface ImageDBInterface {

    //https://api.imgur.com/3/gallery/r/{{subreddit}}/{{subredditImageId}}
    //--header 'Authorization: Client-ID {{clientId}}'
    //base url https://api.imgur.com/3/

    @GET("gallery/{subredditImageId)")
    fun getImageDetails(@Query("subredditImageId") id: Int): Single<ImageDetails>

}