package com.kimmandoo.project_exercise_3_2.feature2

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface IngredientExpAPI {
    @GET("/show_table2.php")
    fun getResult(
//        @Query("serviceKey") serviceKey: String,
//        @Query("query") userName: String
    ): Call<JsonArray>

    @GET("/update_ingredient.php?Uingredient=onion&Ucnt=1")
    fun minusOne(

    ): Call<JsonArray>
}