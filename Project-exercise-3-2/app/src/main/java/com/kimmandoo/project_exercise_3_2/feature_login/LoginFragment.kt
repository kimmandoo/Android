package com.kimmandoo.project_exercise_3_2.feature_login

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonArray
import com.kimmandoo.project_exercise_3_2.R
import com.kimmandoo.project_exercise_3_2.databinding.FragmentAlertBinding
import com.kimmandoo.project_exercise_3_2.databinding.FragmentLoginBinding
import com.kimmandoo.project_exercise_3_2.feature_test.recipe
import com.kimmandoo.project_exercise_3_2.feature_test.recipeapi
import org.json.JSONArray
import org.json.JSONObject
import org.json.JSONTokener
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginFragment : Fragment() {
    private lateinit var auth: FirebaseAuth

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    lateinit var email: String
    lateinit var password: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
//        Log.d("AUTH", auth.currentUser!!.uid + " ")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signin.setOnClickListener {
            email = binding.loginEt.text.toString()
            password = binding.loginPw.text.toString()
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(requireActivity()) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d("TAG", "signInWithEmail:success")
                        val user = auth.currentUser
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w("TAG", "signInWithEmail:failure", task.exception)
                        Toast.makeText(
                            context, "Authentication failed.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

        }

        binding.signup.setOnClickListener {
            email = binding.loginEt.text.toString()
            password = binding.loginPw.text.toString()

            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(requireActivity()) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d("TAG", "createUserWithEmail:success")
                        val user = auth.currentUser

                        var gson = GsonBuilder().setLenient().create()
                        val retrofit = Retrofit.Builder()
                            .baseUrl("http://jaeryurp.duckdns.org:40131/")
//            .addConverterFactory(ScalarsConverterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create(gson)) //있으나마나한 코드...
                            .build()
                        val api = retrofit.create(createAPI::class.java)
                        val callResult = api.createUser(user!!.uid)

                        callResult.enqueue(object : Callback<JsonArray> {
                            override fun onResponse(
                                call: Call<JsonArray>,
                                response: Response<JsonArray>
                            ) {
                                Log.d("SignIn", "성공 : ${response.body()}")
                            }

                            override fun onFailure(call: Call<JsonArray>, t: Throwable) {
                                Log.d("SignIn", "실패 : $t")
                            }
                        })

                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w("TAG", "createUserWithEmail:failure", task.exception)
                        Toast.makeText(
                            context, "Authentication failed.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }


        }

    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if (currentUser != null) {
            reload();
        }
    }

    private fun reload() {

    }
}

