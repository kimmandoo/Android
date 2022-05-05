package com.tistory.gyudev.lec6_2

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.util.*

class MainActivity : AppCompatActivity() {

    val dataModelList = mutableListOf<DataModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //realtime db에서 값 가져오는것
        val database = Firebase.database
        val myRef = database.getReference("message")

        val listView = findViewById<ListView>(R.id.mainLv)

        val adapter_list = ListViewAdapter(dataModelList)

        listView.adapter = adapter_list
        //현재유저에대한 정보 받아오기
        myRef.child(Firebase.auth.currentUser!!.uid).addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                dataModelList.clear() // 중첩되어 생기는거 없애는 방식
                for(dataModel in snapshot.children){
                    //이때 dataModel은 key/value 형태로 값이 들어옴
                    dataModelList.add(dataModel.getValue(DataModel::class.java)!!)
                }

                adapter_list.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })


        //Dialog 실습
        val btnWrite = findViewById<ImageView>(R.id.btnWrite)
        btnWrite.setOnClickListener {
            //custom dialog
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.custom_dialog, null)
            val mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)
                .setTitle("운동메모 다이얼로그")

            val mAlertDialog = mBuilder.show()
            val btn = mAlertDialog.findViewById<Button>(R.id.btnDateSelect)

            var dateStr: String? = null

            mAlertDialog.findViewById<Button>(R.id.btnDateSelect)?.setOnClickListener {

                val today = GregorianCalendar()
                val year: Int = today.get(Calendar.YEAR)
                val month: Int = today.get(Calendar.MONTH)
                val date: Int = today.get(Calendar.DATE)

                val dlg = DatePickerDialog(this, object :DatePickerDialog.OnDateSetListener{
                    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
                        //p0 : view, p1: year, p2: month, p3: dayOfMonth
                        //선택한 후 이벤트
                        btn?.setText("${year}. ${month+1}. ${date}")
                        dateStr = "${year}. ${month+1}. ${date}"+""
                    }
                },year,month,date)

                dlg.show()

            }
            val editText = mAlertDialog.findViewById<EditText>(R.id.editText)
            val btnSave = mAlertDialog.findViewById<Button>(R.id.btnSave)
            btnSave?.setOnClickListener {
                //db저장
                val database = Firebase.database
                //고유 uid기반으로 데이터가 들어감
                val myRef = database.getReference("message").child(Firebase.auth.currentUser!!.uid)
                val model = DataModel(dateStr.toString(), editText?.text.toString())
                myRef
                    .push()
                    .setValue(model)
                
                //저장하기 누르면 닫힘
                mAlertDialog.dismiss()
            }
        }
    }
}