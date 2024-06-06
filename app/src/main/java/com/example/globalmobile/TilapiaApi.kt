package com.example.globalmobile

import retrofit2.Call
import retrofit2.http.GET

interface TilapiaApi {
    @GET("/tilapiaMobile")
    fun getTilapias(): Call<List<Tilapia>>
}