package com.example.bennettangieslistapp.data.api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val CLIENT_ID = "be10dde89a99596"

const val BASE_URL = "https://api.imgur.com/3/"

const val IMAGE_URL = "https://api.imgur.com/3/gallery/r/{{subreddit}}/{{subredditImageId}}"

//needs to be sent with requests -> Authorization: Client-ID <YOUR_CLIENT_ID>

object TheImageDBClient {

    fun getClient(): ImageDBInterface {
        val requestInterceptor = Interceptor { chain ->

            val url = chain.request()
                .url()
                .newBuilder()
                .addQueryParameter("client_id", CLIENT_ID)
                .build()

            val request = chain.request()
                .newBuilder()
                .url(url)
                .build()

            return@Interceptor chain.proceed(request)
        }

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(requestInterceptor)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ImageDBInterface::class.java)

    }
}