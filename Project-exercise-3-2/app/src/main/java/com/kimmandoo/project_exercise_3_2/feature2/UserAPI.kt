package com.kimmandoo.project_exercise_3_2.feature2

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface UserAPI {
    @GET("/json.php")
    fun getResult(
//        @Query("serviceKey") serviceKey: String,
//        @Query("query") userName: String
    ): Call<String>
}