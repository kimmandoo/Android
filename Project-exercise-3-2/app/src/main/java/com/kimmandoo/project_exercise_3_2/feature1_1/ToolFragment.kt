package com.kimmandoo.project_exercise_3_2.feature1_1

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import com.google.gson.JsonArray
import com.kimmandoo.project_exercise_3_2.R
import com.kimmandoo.project_exercise_3_2.databinding.FragmentAlertBinding
import com.kimmandoo.project_exercise_3_2.databinding.FragmentToolBinding
import com.kimmandoo.project_exercise_3_2.feature2.IngredientExp
import com.kimmandoo.project_exercise_3_2.feature2.IngredientExpAPI
import org.json.JSONArray
import org.json.JSONTokener
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ToolFragment : Fragment() {
    private var _binding: FragmentToolBinding? = null
    private val binding get() = _binding!!
    var refresh = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentToolBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        var gson = GsonBuilder().setLenient().create()

        val retrofit = Retrofit.Builder()
            .baseUrl("http://jaeryurp.duckdns.org:40131/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        val api = retrofit.create(ToolAPI::class.java)
        val callResult = api.getResult()

        var resultJsonArray : JsonArray?
        val toolList = mutableListOf<Tool>()
        val toolAdapter = TwoAdapter(toolList)
        binding.toolRv.adapter = toolAdapter
        binding.toolRv.layoutManager = LinearLayoutManager(context)

        callResult.enqueue(object : Callback<JsonArray> {
            override fun onResponse(
                call: Call<JsonArray>,
                response: Response<JsonArray>
            ) {
                Log.d("Tool", "${response.body()}")
                resultJsonArray = response.body()

                val jsonArray = JSONTokener(resultJsonArray.toString()).nextValue() as JSONArray
                for (i in 0 until jsonArray.length()) {
                    val name = jsonArray.getJSONObject(i).getString("name")
                    val exist = jsonArray.getJSONObject(i).getString("exist")
                    toolList.add(Tool(name, exist))
                    if(!refresh){

                    }else{

                    }
                }
                toolAdapter.notifyDataSetChanged()
                refresh = true
            }

            override fun onFailure(call: Call<JsonArray>, t: Throwable) {
                Log.d("FeatTwo", "실패 : $t")
            }
        })
    }
}