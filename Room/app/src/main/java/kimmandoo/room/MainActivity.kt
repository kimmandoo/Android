package kimmandoo.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import kimmandoo.room.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    //viewBinding을 위한 코드
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    lateinit var helper : RoomHelper
    lateinit var memoAdapter: RvAdapter
    val memoList = mutableListOf<RoomMemo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
//        helper = Room.databaseBuilder(this, RoomHelper::class.java,"roomDB")
//            .allowMainThreadQueries() // 중요. 공부할 때만 사용하는 것. 룸은 원래 메인스레드에서 돌지 않음 -> 접근 시간을 특정할수 없어서 main에서 못돌림.
//            .build()
        //build가 호출되는 순간 RoomHelper를 이용해서 사용할 수 있게끔 작동
        helper = Room.databaseBuilder(this, RoomHelper::class.java,"roomDB")
            .build()

//        memoList.addAll(helper.roomMemoDao().getAll()) // 갱신을 위함

        memoAdapter = RvAdapter(memoList)

        refreshAdapter()

        with(binding){
            recyclerMemo.adapter = memoAdapter
            recyclerMemo.layoutManager = LinearLayoutManager(this@MainActivity) // 그냥 this 하면 binding으로 잡힘
            //목록을 뿌림

            btnSave.setOnClickListener {
                val content = editMemo.text.toString()
                if(content.isNotEmpty()){
                    val datetime = System.currentTimeMillis()
                    val memo = RoomMemo(content, datetime)
//                    helper.roomMemoDao().insert(memo)
//                    refreshAdapter()
                    editMemo.setText("") //입력창을 지워주는 것 (DB에 추가가 됐다면)
                    insertMemo(memo)

                    //data가 많을때는 중복제거를 넣어줌
//                    memoList.clear()
//                    memoList.addAll(helper.roomMemoDao().getAll())
//                    memoAdapter.notifyDataSetChanged()
//                    memoList.add(0, memo) // 맨위에 삽입
//                    refreshAdapter()
                }
            }
        }
    }
    fun insertMemo(memo: RoomMemo){
        CoroutineScope(Dispatchers.IO).launch {
            helper.roomMemoDao().insert(memo)
//            withContext(Dispatchers.Main){
//                //MainThread에서 할일
//            }
            refreshAdapter()
        }
    }

    fun refreshAdapter(){
        //MainThread에서 안돌리려면 코루틴 안에 넣어야됨
        CoroutineScope(Dispatchers.IO).launch {
            memoList.clear()
            memoList.addAll(helper.roomMemoDao().getAll())
            withContext(Dispatchers.Main){
                memoAdapter.notifyDataSetChanged()
            }
        }
//        memoList.clear()
//        memoList.addAll(helper.roomMemoDao().getAll())
//        memoAdapter.notifyDataSetChanged() //바뀌었다고 데이터 갱신요청
    }
}