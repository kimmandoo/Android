package com.kimmandoo.project_exercise_3_2.feature_room_exp

import com.google.gson.JsonArray
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GetIngredientAPI {
    @GET("/show/show_test2.php?")
    fun getList(
        @Query("Sname") Sname: String,
    ): Call<JsonArray>

    @GET("show/show_table2.php?")
    fun getExp(
        @Query("Sname") Sname: String,
    ): Call<JsonArray>
}