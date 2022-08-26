package com.kimmandoo.project_exercise_3_2.feature1_1

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ToolAPI {
//    @GET("/show/show_table2.php?")
    @GET("show/show_cookware.php?")
    fun getResult(
//        @Query("query") userName: String
    ): Call<JsonArray>
}