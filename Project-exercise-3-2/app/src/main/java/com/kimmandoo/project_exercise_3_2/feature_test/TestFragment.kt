package com.kimmandoo.project_exercise_3_2.feature_test

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonArray
import com.kimmandoo.project_exercise_3_2.R
import com.kimmandoo.project_exercise_3_2.feature2.IngredientExp
import com.kimmandoo.project_exercise_3_2.feature2.IngredientExpAPI
import org.json.JSONArray
import org.json.JSONObject
import org.json.JSONTokener
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TestFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_test, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var gson = GsonBuilder().setLenient().create()
        val retrofit = Retrofit.Builder()
            .baseUrl("http://jaeryurp.duckdns.org:40131/")
//            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson)) //있으나마나한 코드...
            .build()
        val api = retrofit.create(recipeapi::class.java)
        //원래는 getResult에 query 넣어야됨
        /*이슈가 있음.
        * 원래 json파일이 response body로 와야되는데 웹 태그(<pre></pre>)가 붙어서 나옴. substring으로 jsonString으로 강제로 만들어서 바꿈
        * */
        val callResult = api.getResult()
        val refrigeResult = api.getRefrigeTable()
        var resultJsonArray : JsonArray?
        var resultRefrigeJSON : JsonArray?
        val items = mutableListOf<recipe>()

        callResult.enqueue(object : Callback<JsonArray> {
            override fun onResponse(
                call: Call<JsonArray>,
                response: Response<JsonArray>
            ) {
//                Log.d("FeatTwo", "성공 : ${response.body()}")
                resultJsonArray = response.body()
//                Log.d("FeatTwo", "json : ${resultJsonArray.toString()}")

                val jsonArray = JSONTokener(resultJsonArray.toString()).nextValue() as JSONArray
                val convertArray = MutableList<JSONObject>(jsonArray.length()) { i -> jsonArray.getJSONObject(i)}. map {  Gson().fromJson<HashMap<String, String>>(it.toString(), HashMap::class.java) }
                val filterMainIngredient = convertArray.filter { it?.get("mainIngredient") == "tomato" }
//                val mainItems = filterMainIngredient.filter { it?.get("chief") == "A" }
//                val subItems = filterMainIngredient.filter { it?.get("chief") != "A" }
                for (i in 0 until jsonArray.length()) {
                    val name = jsonArray.getJSONObject(i).getString("name")
                    val chief = jsonArray.getJSONObject(i).getString("chief")
                    val step1 = jsonArray.getJSONObject(i).getString("step1")
                    val step2 = jsonArray.getJSONObject(i).getString("step2")
                    val step3 = jsonArray.getJSONObject(i).getString("step3")
                    val step4 = jsonArray.getJSONObject(i).getString("step4")
                    val step5 = jsonArray.getJSONObject(i).getString("step5")
                    val step6 = jsonArray.getJSONObject(i).getString("step6")
                    val step7 = jsonArray.getJSONObject(i).getString("step7")
                    val step8 = jsonArray.getJSONObject(i).getString("step8")
                    val Ingredient = jsonArray.getJSONObject(i).getString("ingredient")
                    val url = jsonArray.getJSONObject(i).getString("link")
                    val match = 0
                    val list = Ingredient.substring(1,Ingredient.length-1).split(", ").toList()
                    items.add(recipe(name, list, chief, step1, step2, step3, step4, step5, step6, step7, step8, url, match))
                }
//                val mainItems = items.filter { it.chief == "A" }
//                val subItems = items.filter { it.chief != "A" }
                Log.d("List","$items")

                for( i in items.indices){
                    val matchCounter = (items[i].Ingredient).count() - (items[i].Ingredient).minus(listOf<String>("onion","rice","kimchi")).count()
                    items[i].matchCount = matchCounter
                    Log.d("count","$matchCounter")

                }
                items.sortBy { it.matchCount }
                items.reverse()

                Log.d("match","$items")

            }

            override fun onFailure(call: Call<JsonArray>, t: Throwable) {
                Log.d("FeatTwo", "실패 : $t")
            }


        })

        refrigeResult.enqueue(object : Callback<JsonArray>{
            override fun onResponse(call: Call<JsonArray>, response: Response<JsonArray>) {
                resultRefrigeJSON = response.body()
                val refrigelist = mutableListOf<refrige>()

                val jsonArray = JSONTokener(resultRefrigeJSON.toString()).nextValue() as JSONArray
                for (i in 0 until jsonArray.length()) {
                    val name = jsonArray.getJSONObject(i).getString("temp")
                    refrigelist.add(refrige(name))
                }
                Log.d("List","$refrigelist")
            }

            override fun onFailure(call: Call<JsonArray>, t: Throwable) {
                Log.d("FeatTwo", "실패 : $t")
            }

        })


//        var gson = GsonBuilder().setLenient().create()
//
//        val retrofit = Retrofit.Builder()
//            .baseUrl("http://jaeryurp.duckdns.org:40131/")
//            .addConverterFactory(GsonConverterFactory.create(gson))
//            .build()
//        val api = retrofit.create(Test2API::class.java)
//        val callResult = api.getResult()
//
//        var resultJsonArray : JsonArray?
//        val testList = mutableListOf<Test2DC>()
//
//        callResult.enqueue(object : Callback<JsonArray> {
//            override fun onResponse(
//                call: Call<JsonArray>,
//                response: Response<JsonArray>
//            ) {
//                Log.d("Test2", "${response.body()}")
//                resultJsonArray = response.body()
//
//                val jsonArray = JSONTokener(resultJsonArray.toString()).nextValue() as JSONArray
//
//                for (i in 0 until jsonArray.length()) {
//                    val name = jsonArray.getJSONObject(i).getString("temp")
//                    testList.add(Test2DC(name))
//                }
//                Log.d("Test2-2", "${testList}")
//
//            }
//
//            override fun onFailure(call: Call<JsonArray>, t: Throwable) {
//                Log.d("FeatTwo", "실패 : $t")
//            }
//        })
    }

}