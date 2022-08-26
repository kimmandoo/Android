package com.kimmandoo.project_exercise_3_2.feature3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.kimmandoo.project_exercise_3_2.databinding.FragmentRoomBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RoomFragment : Fragment() {
    private var _binding: FragmentRoomBinding? = null
    private val binding get() = _binding!!

    lateinit var helper: RoomHelper
    lateinit var dbAdapter: DbAdapter
    val dbList = mutableListOf<IngredientDb>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRoomBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        helper = Room.databaseBuilder(requireContext(), RoomHelper::class.java, "innerDb")
            .build()
        dbAdapter = DbAdapter(dbList)
        refreshAdapter()

        with(binding){
            dbRv.adapter = dbAdapter
            dbRv.layoutManager = LinearLayoutManager(context) // 그냥 this 하면 binding으로 잡힘
            //목록을 뿌림

            btnSave.setOnClickListener {
                val name = editMemo.text.toString()
                if(name.isNotEmpty()){
                    val data = IngredientDb(name,"","")
//                    helper.ingredientDao().insert(data)
//                    refreshAdapter()
                    editMemo.setText("") //입력창을 지워주는 것 (DB에 추가가 됐다면)
                    insertData(data)

                    //data가 많을때는 중복제거를 넣어줌
//                    dbList.clear()
//                    dbList.addAll(helper.ingredientDao().getAll())
//                    dbAdapter.notifyDataSetChanged()
//                    dbList.add(0, data) // 맨위에 삽입
//                    refreshAdapter()
                }
            }
        }


    }

    fun insertData(data: IngredientDb){
        CoroutineScope(Dispatchers.IO).launch {
            helper.ingredientDao().insert(data)
//            withContext(Dispatchers.Main){
//                //MainThread에서 할일
//            }
            refreshAdapter()
        }
    }

    fun refreshAdapter(){
        //MainThread에서 안돌리려면 코루틴 안에 넣어야됨
        CoroutineScope(Dispatchers.IO).launch {
            dbList.clear()
            dbList.addAll(helper.ingredientDao().getAll())
            withContext(Dispatchers.Main){
                dbAdapter.notifyDataSetChanged()
            }
        }
//        memoList.clear()
//        memoList.addAll(helper.roomMemoDao().getAll())
//        memoAdapter.notifyDataSetChanged() //바뀌었다고 데이터 갱신요청
    }
}