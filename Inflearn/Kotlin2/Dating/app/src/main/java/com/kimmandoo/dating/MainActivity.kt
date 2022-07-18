package com.kimmandoo.dating

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.kimmandoo.dating.auth.IntroActivity
import com.kimmandoo.dating.databinding.ActivityMainBinding
import com.kimmandoo.dating.slider.CardStackAdapter
import com.yuyakaido.android.cardstackview.CardStackLayoutManager
import com.yuyakaido.android.cardstackview.CardStackListener
import com.yuyakaido.android.cardstackview.Direction

class MainActivity : AppCompatActivity() {

    lateinit var cardStackAdapter: CardStackAdapter
    lateinit var manager: CardStackLayoutManager // RecyclerView에서 LayoutManager와 같은 역할
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.settingIcon.setOnClickListener {
            val auth = Firebase.auth
            auth.signOut()

            val intent = Intent(this, IntroActivity::class.java)
            startActivity(intent)
            finish()
        }

        manager = CardStackLayoutManager(baseContext, object : CardStackListener {
            override fun onCardDragging(direction: Direction?, ratio: Float) {

            }

            override fun onCardSwiped(direction: Direction?) {

            }

            override fun onCardRewound() {

            }

            override fun onCardCanceled() {

            }

            override fun onCardAppeared(view: View?, position: Int) {

            }

            override fun onCardDisappeared(view: View?, position: Int) {

            }

        })
        val items = mutableListOf<String>()
        items.add("this")
        items.add("is")
        items.add("card")
        items.add("view")

        cardStackAdapter = CardStackAdapter(baseContext, items)
        binding.mainCardStackView.apply {
            layoutManager = manager
            adapter = cardStackAdapter
        }

    }
}