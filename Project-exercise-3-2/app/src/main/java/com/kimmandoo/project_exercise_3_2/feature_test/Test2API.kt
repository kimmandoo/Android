package com.kimmandoo.project_exercise_3_2.feature_test

import com.google.gson.JsonArray
import retrofit2.Call
import retrofit2.http.GET

interface Test2API {
    @GET("/show/show_temptable.php")
    fun getResult(

    ): Call<JsonArray>
}