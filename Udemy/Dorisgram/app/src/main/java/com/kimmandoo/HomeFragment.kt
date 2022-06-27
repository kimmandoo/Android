package com.kimmandoo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.kimmandoo.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private var feedList:ArrayList<Feed> = arrayListOf(
        Feed("dory","https://mblogthumb-phinf.pstatic.net/MjAyMDA3MjhfMzcg/MDAxNTk1OTE5OTQ3ODA2.ecxiJRgcYqOwDAodSPyzGb_RluVzfnf7AIF6o97m2XQg.4_8LadIMzCW1yj_ZpavPYxb635t-3aJevVhcIkQXtGQg.JPEG.hyousang/1.jpg?type=w800","https://mblogthumb-phinf.pstatic.net/MjAyMDA3MjhfMzcg/MDAxNTk1OTE5OTQ3ODA2.ecxiJRgcYqOwDAodSPyzGb_RluVzfnf7AIF6o97m2XQg.4_8LadIMzCW1yj_ZpavPYxb635t-3aJevVhcIkQXtGQg.JPEG.hyousang/1.jpg?type=w800",2,false, false),
        Feed("dory","https://mblogthumb-phinf.pstatic.net/MjAyMDA3MjhfMzcg/MDAxNTk1OTE5OTQ3ODA2.ecxiJRgcYqOwDAodSPyzGb_RluVzfnf7AIF6o97m2XQg.4_8LadIMzCW1yj_ZpavPYxb635t-3aJevVhcIkQXtGQg.JPEG.hyousang/1.jpg?type=w800","https://mblogthumb-phinf.pstatic.net/MjAyMDA3MjhfMzcg/MDAxNTk1OTE5OTQ3ODA2.ecxiJRgcYqOwDAodSPyzGb_RluVzfnf7AIF6o97m2XQg.4_8LadIMzCW1yj_ZpavPYxb635t-3aJevVhcIkQXtGQg.JPEG.hyousang/1.jpg?type=w800",2,false, false),
        Feed("dory","https://mblogthumb-phinf.pstatic.net/MjAyMDA3MjhfMzcg/MDAxNTk1OTE5OTQ3ODA2.ecxiJRgcYqOwDAodSPyzGb_RluVzfnf7AIF6o97m2XQg.4_8LadIMzCW1yj_ZpavPYxb635t-3aJevVhcIkQXtGQg.JPEG.hyousang/1.jpg?type=w800","https://mblogthumb-phinf.pstatic.net/MjAyMDA3MjhfMzcg/MDAxNTk1OTE5OTQ3ODA2.ecxiJRgcYqOwDAodSPyzGb_RluVzfnf7AIF6o97m2XQg.4_8LadIMzCW1yj_ZpavPYxb635t-3aJevVhcIkQXtGQg.JPEG.hyousang/1.jpg?type=w800",2,false, false),
        Feed("dory","https://mblogthumb-phinf.pstatic.net/MjAyMDA3MjhfMzcg/MDAxNTk1OTE5OTQ3ODA2.ecxiJRgcYqOwDAodSPyzGb_RluVzfnf7AIF6o97m2XQg.4_8LadIMzCW1yj_ZpavPYxb635t-3aJevVhcIkQXtGQg.JPEG.hyousang/1.jpg?type=w800","https://mblogthumb-phinf.pstatic.net/MjAyMDA3MjhfMzcg/MDAxNTk1OTE5OTQ3ODA2.ecxiJRgcYqOwDAodSPyzGb_RluVzfnf7AIF6o97m2XQg.4_8LadIMzCW1yj_ZpavPYxb635t-3aJevVhcIkQXtGQg.JPEG.hyousang/1.jpg?type=w800",2,false, false),
        Feed("dory","https://mblogthumb-phinf.pstatic.net/MjAyMDA3MjhfMzcg/MDAxNTk1OTE5OTQ3ODA2.ecxiJRgcYqOwDAodSPyzGb_RluVzfnf7AIF6o97m2XQg.4_8LadIMzCW1yj_ZpavPYxb635t-3aJevVhcIkQXtGQg.JPEG.hyousang/1.jpg?type=w800","https://mblogthumb-phinf.pstatic.net/MjAyMDA3MjhfMzcg/MDAxNTk1OTE5OTQ3ODA2.ecxiJRgcYqOwDAodSPyzGb_RluVzfnf7AIF6o97m2XQg.4_8LadIMzCW1yj_ZpavPYxb635t-3aJevVhcIkQXtGQg.JPEG.hyousang/1.jpg?type=w800",2,false, false),
        Feed("dory","https://mblogthumb-phinf.pstatic.net/MjAyMDA3MjhfMzcg/MDAxNTk1OTE5OTQ3ODA2.ecxiJRgcYqOwDAodSPyzGb_RluVzfnf7AIF6o97m2XQg.4_8LadIMzCW1yj_ZpavPYxb635t-3aJevVhcIkQXtGQg.JPEG.hyousang/1.jpg?type=w800","https://mblogthumb-phinf.pstatic.net/MjAyMDA3MjhfMzcg/MDAxNTk1OTE5OTQ3ODA2.ecxiJRgcYqOwDAodSPyzGb_RluVzfnf7AIF6o97m2XQg.4_8LadIMzCW1yj_ZpavPYxb635t-3aJevVhcIkQXtGQg.JPEG.hyousang/1.jpg?type=w800",2,false, false),
        Feed("dory","https://mblogthumb-phinf.pstatic.net/MjAyMDA3MjhfMzcg/MDAxNTk1OTE5OTQ3ODA2.ecxiJRgcYqOwDAodSPyzGb_RluVzfnf7AIF6o97m2XQg.4_8LadIMzCW1yj_ZpavPYxb635t-3aJevVhcIkQXtGQg.JPEG.hyousang/1.jpg?type=w800","https://mblogthumb-phinf.pstatic.net/MjAyMDA3MjhfMzcg/MDAxNTk1OTE5OTQ3ODA2.ecxiJRgcYqOwDAodSPyzGb_RluVzfnf7AIF6o97m2XQg.4_8LadIMzCW1yj_ZpavPYxb635t-3aJevVhcIkQXtGQg.JPEG.hyousang/1.jpg?type=w800",2,false, false),
        Feed("dory","https://mblogthumb-phinf.pstatic.net/MjAyMDA3MjhfMzcg/MDAxNTk1OTE5OTQ3ODA2.ecxiJRgcYqOwDAodSPyzGb_RluVzfnf7AIF6o97m2XQg.4_8LadIMzCW1yj_ZpavPYxb635t-3aJevVhcIkQXtGQg.JPEG.hyousang/1.jpg?type=w800","https://mblogthumb-phinf.pstatic.net/MjAyMDA3MjhfMzcg/MDAxNTk1OTE5OTQ3ODA2.ecxiJRgcYqOwDAodSPyzGb_RluVzfnf7AIF6o97m2XQg.4_8LadIMzCW1yj_ZpavPYxb635t-3aJevVhcIkQXtGQg.JPEG.hyousang/1.jpg?type=w800",2,false, false),
        Feed("dory","https://mblogthumb-phinf.pstatic.net/MjAyMDA3MjhfMzcg/MDAxNTk1OTE5OTQ3ODA2.ecxiJRgcYqOwDAodSPyzGb_RluVzfnf7AIF6o97m2XQg.4_8LadIMzCW1yj_ZpavPYxb635t-3aJevVhcIkQXtGQg.JPEG.hyousang/1.jpg?type=w800","https://mblogthumb-phinf.pstatic.net/MjAyMDA3MjhfMzcg/MDAxNTk1OTE5OTQ3ODA2.ecxiJRgcYqOwDAodSPyzGb_RluVzfnf7AIF6o97m2XQg.4_8LadIMzCW1yj_ZpavPYxb635t-3aJevVhcIkQXtGQg.JPEG.hyousang/1.jpg?type=w800",2,false, false),
        Feed("dory","https://mblogthumb-phinf.pstatic.net/MjAyMDA3MjhfMzcg/MDAxNTk1OTE5OTQ3ODA2.ecxiJRgcYqOwDAodSPyzGb_RluVzfnf7AIF6o97m2XQg.4_8LadIMzCW1yj_ZpavPYxb635t-3aJevVhcIkQXtGQg.JPEG.hyousang/1.jpg?type=w800","https://mblogthumb-phinf.pstatic.net/MjAyMDA3MjhfMzcg/MDAxNTk1OTE5OTQ3ODA2.ecxiJRgcYqOwDAodSPyzGb_RluVzfnf7AIF6o97m2XQg.4_8LadIMzCW1yj_ZpavPYxb635t-3aJevVhcIkQXtGQg.JPEG.hyousang/1.jpg?type=w800",2,false, false),
        Feed("dory","https://mblogthumb-phinf.pstatic.net/MjAyMDA3MjhfMzcg/MDAxNTk1OTE5OTQ3ODA2.ecxiJRgcYqOwDAodSPyzGb_RluVzfnf7AIF6o97m2XQg.4_8LadIMzCW1yj_ZpavPYxb635t-3aJevVhcIkQXtGQg.JPEG.hyousang/1.jpg?type=w800","https://mblogthumb-phinf.pstatic.net/MjAyMDA3MjhfMzcg/MDAxNTk1OTE5OTQ3ODA2.ecxiJRgcYqOwDAodSPyzGb_RluVzfnf7AIF6o97m2XQg.4_8LadIMzCW1yj_ZpavPYxb635t-3aJevVhcIkQXtGQg.JPEG.hyousang/1.jpg?type=w800",2,false, false),
        Feed("dory","https://mblogthumb-phinf.pstatic.net/MjAyMDA3MjhfMzcg/MDAxNTk1OTE5OTQ3ODA2.ecxiJRgcYqOwDAodSPyzGb_RluVzfnf7AIF6o97m2XQg.4_8LadIMzCW1yj_ZpavPYxb635t-3aJevVhcIkQXtGQg.JPEG.hyousang/1.jpg?type=w800","https://mblogthumb-phinf.pstatic.net/MjAyMDA3MjhfMzcg/MDAxNTk1OTE5OTQ3ODA2.ecxiJRgcYqOwDAodSPyzGb_RluVzfnf7AIF6o97m2XQg.4_8LadIMzCW1yj_ZpavPYxb635t-3aJevVhcIkQXtGQg.JPEG.hyousang/1.jpg?type=w800",2,false, false),
    )

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

        binding.homeRvFeed.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        binding.homeRvFeed.adapter = FeedAdapter(activity as MainActivity, feedList)

        binding.homeRvFeed.isNestedScrollingEnabled = false

        binding.homeRvStory.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        binding.homeRvStory.adapter = StoryAdapter(activity as MainActivity, storyList)
    }
}