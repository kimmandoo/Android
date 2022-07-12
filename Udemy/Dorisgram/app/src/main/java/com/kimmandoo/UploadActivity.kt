package com.kimmandoo

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.ktx.storage
import com.kimmandoo.databinding.ActivityMainBinding
import com.kimmandoo.databinding.ActivityUploadBinding
import java.text.SimpleDateFormat
import java.util.*
import java.util.jar.Manifest
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class UploadActivity : AppCompatActivity() {
    private val PICK_STORAGE = 1001
    private val PICK_CAMERA = 1000
    private val PERMISSIONS_REQUEST = 100
    private var imageUri: Uri? = null
    private lateinit var binding: ActivityUploadBinding
    private var fireBaseStorage: FirebaseStorage? = null
    private lateinit var database: DatabaseReference


    private val Permissions = arrayOf(
        android.Manifest.permission.CAMERA,
        android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
        android.Manifest.permission.READ_EXTERNAL_STORAGE
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUploadBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fireBaseStorage = Firebase.storage
        pickImage()
        checkPermission(Permissions)

        binding.uploadIvImage.setOnClickListener {
            Log.d("Upload", "camera_open")
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            takePictureIntent.resolveActivity(packageManager)?.also {
                startActivityForResult(takePictureIntent, PICK_CAMERA)
            }
        }

        binding.uploadBtnBack.setOnClickListener {
            onBackPressed()
        }

        val db = Firebase.database
        database = db.getReference("FeedList")

        binding.uploadBtnCheck.setOnClickListener {
            uploadImage()
            //firebase storage에 이미지 업로드하기
        }
    }

    private fun uploadImage() {
        //현재시각을 포맷대로 가져옴
        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val imageFileName = "$timeStamp.jpeg"
        val storageReference =
            fireBaseStorage?.reference?.child(imageFileName) // child전에 chlie함수 하나 더 써서 폴더이름을 넣으면 그 폴더로 들어감
//        storageReference?.putFile(imageUri!!)?.continueWithTask { task ->
//            if (!task.isSuccessful) {
//                task.exception?.let {
//                    throw it
//                }
//            }
//            storageReference.downloadUrl
//        }?.addOnCompleteListener { task ->
//            if (task.isSuccessful) {
//                val downloadUri = task.result
//                database.get().addOnCompleteListener { it ->
//                    var values = it.value as ArrayList<HashMap<String, Any>>
//                    database.child((values?.size ?: 0 + 1).toString()).setValue(
//                        Feed(
//                            "dorydory",
//                            downloadUri.toString(),
//                            downloadUri.toString(),
//                            0,
//                            false,
//                            false
//                        )
//                    )
//                }
//                finish()
//            } else {
//                // Handle failures
//                // ...
//            }
//        }
    }


    private fun pickImage() {
        var intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/* video/*"

        startActivityForResult(intent, PICK_STORAGE)
        //이거 쓰려면 onActivityResult 사용해야됨
    }

    private fun checkPermission(permissions: Array<String>): Boolean {
        val permissionsList: MutableList<String> = mutableListOf()
        for (permission in permissions) {
            val result = ContextCompat.checkSelfPermission(this, permission)
            if (result != PackageManager.PERMISSION_GRANTED) {
                permissionsList.add(permission)
            }
        }
        if (permissionsList.isNotEmpty()) {
            ActivityCompat.requestPermissions(
                this, permissionsList.toTypedArray(), PERMISSIONS_REQUEST
            )
            return false
        }
        return true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            if (requestCode == PICK_STORAGE) {
                val pickedImage: Uri? = data?.data
                if (pickedImage != null) {
                    imageUri = pickedImage
                }
                Glide.with(this).load(imageUri).into(binding.uploadIvImage)
            }
            if (requestCode == PICK_CAMERA) {
                val imageBitmap = data?.extras?.get("data") as Bitmap
                val pickedImage: Uri? = data.data
                if (pickedImage != null) {
                    imageUri = pickedImage
                }
                binding.uploadIvImage.setImageBitmap(imageBitmap)
            }
        }
    }
}