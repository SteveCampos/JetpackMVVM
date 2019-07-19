package com.stevecampos.jetpackmvvm

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

//ApiFactory to create TMDB Api


object ApiFactory {

    const val TEST_URL = "https://jsonplaceholder.typicode.com/"


    fun retrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(TEST_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()


    val testApi: TestService = retrofit().create(TestService::class.java)


    interface TestService {

        @GET("users")
        suspend fun getUsers(): List<User>
    }
}