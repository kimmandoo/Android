package com.kimmandoo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.app
import com.kimmandoo.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var database: DatabaseReference




    private var storyList: ArrayList<Story> = arrayListOf(
        Story("zzaang", ""),
        Story("zzaang", ""),
        Story("zzaang", ""),
        Story("zzaang", ""),
        Story("zzaang", ""),
        Story("zzaang", ""),
        Story("zzaang", ""),
        Story("zzaang", "")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val db = Firebase.database
        database = db.getReference("FeedList")

        binding.homeRvStory.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        binding.homeRvStory.adapter = StoryAdapter(activity as MainActivity, storyList)
    }

    override fun onStart() {
        super.onStart()
        binding.homeRvFeed.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

        binding.homeRvFeed.isNestedScrollingEnabled = false
        var feedList = ArrayList<Feed>()
        binding.homeRvFeed.adapter = FeedAdapter(activity as MainActivity, feedList)

        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val values = snapshot.value as ArrayList<HashMap<String, Any>>?
                // size가 null 값이면 0을 넣는 엘비스 연산자
                for (i: Int in 1 until (values?.size ?: 0)) {
                    val data = values?.get(i)
                    feedList.add(
                        Feed(
                            data?.get("userId").toString(),
                            data?.get("imageUrl").toString(),
                            data?.get("profileImageUrl").toString(),
                            data?.get("likeCount") as Long,
                            data.get("isLIke") as? Boolean ?: false,
                            data.get("isBookmark") as? Boolean ?: false
                        )
                    )
                }
                binding.homeRvFeed.adapter?.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }
}