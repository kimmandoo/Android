package com.kimmandoo.project_exercise_3_2.feature_test

import com.google.gson.JsonArray
import retrofit2.Call
import retrofit2.http.GET

interface recipeapi {
    @GET("/show/show_temptable.php")
    fun getRefrigeTable(
//        @Query("query") userName: String
    ): Call<JsonArray>

//    @GET("/update/update_ingredient.php?Uingredient=onion&")
//    fun minusOne(
////        @Query("Uingredient") Uingredient: String,
//        @Query("Ucnt") Ucnt: String,
//    ): Call<JsonArray>

    @GET("/json.php")
    fun getResult(

    ): Call<JsonArray>
}
