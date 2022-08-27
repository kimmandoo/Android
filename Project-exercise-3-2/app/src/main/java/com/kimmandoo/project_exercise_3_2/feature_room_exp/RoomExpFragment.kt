package com.kimmandoo.project_exercise_3_2.feature_room_exp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.google.gson.GsonBuilder
import com.google.gson.JsonArray
import com.kimmandoo.project_exercise_3_2.databinding.FragmentRoomExpBinding
import com.kimmandoo.project_exercise_3_2.feature2.IngredientExp
import com.kimmandoo.project_exercise_3_2.feature2.IngredientList
import com.kimmandoo.project_exercise_3_2.feature3.DbAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONTokener
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RoomExpFragment : Fragment() {
    private var _binding: FragmentRoomExpBinding? = null
    private val binding get() = _binding!!
    lateinit var helper: RoomHelper
    lateinit var dbAdapter : ExpDBAdapter

    val dbList = mutableListOf<RoomExpDB>()
    val nameList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRoomExpBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        helper = Room.databaseBuilder(requireContext(), RoomHelper::class.java, "roomexpDb")
            .build()
        dbAdapter = ExpDBAdapter(dbList)
        dbList.clear()
        refreshAdapter()

        binding.featExpRv.adapter = dbAdapter
        binding.featExpRv.layoutManager = LinearLayoutManager(context)
        //list를 먼저 받고, exp를 받아서 list에 exp가 있으면 name-count-exp순으로 앱 내부 db에 저장한다.
        //list받기
        var gson = GsonBuilder().setLenient().create()

        val retrofit = Retrofit.Builder()
            .baseUrl("http://jaeryurp.duckdns.org:40131/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        val api = retrofit.create(GetIngredientAPI::class.java)
        val callList = api.getList()

        var resultJsonArray : JsonArray?

        callList.enqueue(object : Callback<JsonArray> {
            override fun onResponse(
                call: Call<JsonArray>,
                responseList: Response<JsonArray>
            ) {
                Log.d("List", "${responseList.body()}")
                resultJsonArray = responseList.body()

                val jsonArray = JSONTokener(resultJsonArray.toString()).nextValue() as JSONArray
                for (i in 0 until jsonArray.length()) {
                    val Sname = jsonArray.getJSONObject(i).getString("Tables_in_test")
                    nameList.add(Sname)
                }
                for (i in nameList){
                    if(i == "temp_ingre" || i == "cookware") continue //filter
                    val callExp = api.getExp(i)
                    callExp.enqueue(object : Callback<JsonArray>{
                        override fun onResponse(
                            call: Call<JsonArray>,
                            responseExp: Response<JsonArray>
                        ) {
                            if (responseExp.body()!!.size()>0){
                                Log.d("EXP","${responseExp.body()}")

                                val expArray = JSONTokener(responseExp.body().toString()).nextValue() as JSONArray
                                val count = expArray.getJSONObject(expArray.length()-1).getString("count")
                                val exp = expArray.getJSONObject(expArray.length()-1).getString("expiration")
                                Log.d("DB","${i},${count},${exp}")
                                insertData(RoomExpDB(i,count,exp))// 추가하는 것 까지 완성
                                refreshAdapter()

                                // 이미 있으면 replace나 add 하지 않는 방법으로 적용할 예정
                            }else{
//                                Log.d("EXP Null","${responseExp.body()}")
                            }
                        }
                        override fun onFailure(call: Call<JsonArray>, t: Throwable) {

                        }
                    })
                }

//                listAdapter.notifyDataSetChanged()
            }
            override fun onFailure(call: Call<JsonArray>, t: Throwable) {
                Log.d("List", "실패 : $t")
            }
        })

        //list에 exp가 있다면
//        val data = RoomExpDB("name","1","2022-08-26")
//        insertData(data)
    }

    fun insertData(data: RoomExpDB){
        CoroutineScope(Dispatchers.IO).launch {
            helper.roomExpDao().insert(data)
//            withContext(Dispatchers.Main){
//                //MainThread에서 할일
//            }
            refreshAdapter()
        }
    }
    fun refreshAdapter() {
        //MainThread에서 안돌리려면 코루틴 안에 넣어야됨
        CoroutineScope(Dispatchers.IO).launch {
            dbList.clear()
            dbList.addAll(helper.roomExpDao().getAll())
            withContext(Dispatchers.Main) {
                dbAdapter.notifyDataSetChanged()
            }
        }
    }
}