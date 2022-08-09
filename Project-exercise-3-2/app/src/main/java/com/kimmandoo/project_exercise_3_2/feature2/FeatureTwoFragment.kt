package com.kimmandoo.project_exercise_3_2.feature2

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.gson.GsonBuilder
import com.kimmandoo.project_exercise_3_2.databinding.FragmentFeatureTwoBinding
import org.json.JSONArray
import org.json.JSONObject
import org.json.JSONTokener
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory


class FeatureTwoFragment : Fragment() {
    private val serviceKey = "Cname"
    private var _binding: FragmentFeatureTwoBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFeatureTwoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var gson = GsonBuilder().setLenient().create()
        val retrofit = Retrofit.Builder()
            .baseUrl("http://jaeryurp.duckdns.org:40131/")
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        val api = retrofit.create(UserAPI::class.java)
        //원래는 getResult에 query 넣어야됨
        val callResult = api.getResult()
        lateinit var jsonString : String
        callResult.enqueue(object : Callback<String> {
            override fun onResponse(
                call: Call<String>,
                response: Response<String>
            ) {
                Log.d("FeatTwo", "성공 : ${response.body()}")
                jsonString = response.body()!!.substring(5, response.body()!!.length-7)
                Log.d("FeatTwo", "json : ${jsonString}")

                val items = mutableListOf<Test>()
                val jsonArray = JSONTokener(jsonString).nextValue() as JSONArray
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

                    items.add(Test(name, chief, step1, step2, step3, step4, step5, step6, step7, step8))
                }
                Log.d("List","$items")

            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.d("FeatTwo", "실패 : $t")
            }
        })

    }
}