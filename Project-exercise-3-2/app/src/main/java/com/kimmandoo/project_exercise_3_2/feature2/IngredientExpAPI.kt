package com.kimmandoo.project_exercise_3_2.feature2

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface IngredientExpAPI {
//    @GET("/show/show_table2.php?")
    @GET("/update/update_ingredient.php?")
    fun getResult(
//        @Query("Sname") Sname: String,
        @Query("Uingredient") Uingredient: String,
        @Query("Ucnt") Ucnt: String,
        @Query("Udate") Udate: String
//        @Query("query") userName: String
    ): Call<JsonArray>

    @GET("/update/update_ingredient.php?")
    fun minusOne(
        @Query("Uingredient") Uingredient: String,
        @Query("Ucnt") Ucnt: String,
        @Query("Udate") Udate: String
    ): Call<JsonArray>
}