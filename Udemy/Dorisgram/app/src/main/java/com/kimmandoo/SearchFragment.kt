package com.kimmandoo

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.kimmandoo.databinding.FragmentMainBinding
import com.kimmandoo.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    private val imageList:ArrayList<String> = arrayListOf(
        "https://mblogthumb-phinf.pstatic.net/MjAyMDA3MjhfMzcg/MDAxNTk1OTE5OTQ3ODA2.ecxiJRgcYqOwDAodSPyzGb_RluVzfnf7AIF6o97m2XQg.4_8LadIMzCW1yj_ZpavPYxb635t-3aJevVhcIkQXtGQg.JPEG.hyousang/1.jpg?type=w800",
        "https://mblogthumb-phinf.pstatic.net/MjAyMDA3MjhfMzcg/MDAxNTk1OTE5OTQ3ODA2.ecxiJRgcYqOwDAodSPyzGb_RluVzfnf7AIF6o97m2XQg.4_8LadIMzCW1yj_ZpavPYxb635t-3aJevVhcIkQXtGQg.JPEG.hyousang/1.jpg?type=w800",
        "https://mblogthumb-phinf.pstatic.net/MjAyMDA3MjhfMzcg/MDAxNTk1OTE5OTQ3ODA2.ecxiJRgcYqOwDAodSPyzGb_RluVzfnf7AIF6o97m2XQg.4_8LadIMzCW1yj_ZpavPYxb635t-3aJevVhcIkQXtGQg.JPEG.hyousang/1.jpg?type=w800",
        "https://mblogthumb-phinf.pstatic.net/MjAyMDA3MjhfMzcg/MDAxNTk1OTE5OTQ3ODA2.ecxiJRgcYqOwDAodSPyzGb_RluVzfnf7AIF6o97m2XQg.4_8LadIMzCW1yj_ZpavPYxb635t-3aJevVhcIkQXtGQg.JPEG.hyousang/1.jpg?type=w800",
        "https://mblogthumb-phinf.pstatic.net/MjAyMDA3MjhfMzcg/MDAxNTk1OTE5OTQ3ODA2.ecxiJRgcYqOwDAodSPyzGb_RluVzfnf7AIF6o97m2XQg.4_8LadIMzCW1yj_ZpavPYxb635t-3aJevVhcIkQXtGQg.JPEG.hyousang/1.jpg?type=w800",
        "https://mblogthumb-phinf.pstatic.net/MjAyMDA3MjhfMzcg/MDAxNTk1OTE5OTQ3ODA2.ecxiJRgcYqOwDAodSPyzGb_RluVzfnf7AIF6o97m2XQg.4_8LadIMzCW1yj_ZpavPYxb635t-3aJevVhcIkQXtGQg.JPEG.hyousang/1.jpg?type=w800",
        "https://mblogthumb-phinf.pstatic.net/MjAyMDA3MjhfMzcg/MDAxNTk1OTE5OTQ3ODA2.ecxiJRgcYqOwDAodSPyzGb_RluVzfnf7AIF6o97m2XQg.4_8LadIMzCW1yj_ZpavPYxb635t-3aJevVhcIkQXtGQg.JPEG.hyousang/1.jpg?type=w800",
        "https://mblogthumb-phinf.pstatic.net/MjAyMDA3MjhfMzcg/MDAxNTk1OTE5OTQ3ODA2.ecxiJRgcYqOwDAodSPyzGb_RluVzfnf7AIF6o97m2XQg.4_8LadIMzCW1yj_ZpavPYxb635t-3aJevVhcIkQXtGQg.JPEG.hyousang/1.jpg?type=w800",
        "https://mblogthumb-phinf.pstatic.net/MjAyMDA3MjhfMzcg/MDAxNTk1OTE5OTQ3ODA2.ecxiJRgcYqOwDAodSPyzGb_RluVzfnf7AIF6o97m2XQg.4_8LadIMzCW1yj_ZpavPYxb635t-3aJevVhcIkQXtGQg.JPEG.hyousang/1.jpg?type=w800",

    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.searchRvRecommend.layoutManager = GridLayoutManager(activity, 3)
        binding.searchRvRecommend.adapter = RecommendAdapter(activity as MainActivity, imageList)

        binding.searchLl.setOnClickListener {
            Intent(context, SearchActivity::class.java).apply {

            }. run {
                context?.startActivity(this)
            }
        }
    }
}