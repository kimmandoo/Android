package com.kimmandoo.project_exercise_3_2.feature2

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.*

interface IngredientListAPI {
    @GET("/show_test2.php")
    fun getResult(
//        @Query("serviceKey") serviceKey: String,
//        @Query("query") userName: String
    ): Call<JsonArray>
}