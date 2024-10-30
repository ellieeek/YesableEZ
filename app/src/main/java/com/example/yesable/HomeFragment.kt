package com.example.yesable

import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.yesable.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!! // 안전하게 접근하기 위한 getter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Fragment의 View Binding 설정
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 어댑터 설정 및 아이템 클릭 리스너 전달
        val adapter = MainRecommendAdapter(MainRecommendList.recruitList) { recruitItem ->
            // 클릭 시 Recruitment_Detail_Activity로 이동
            val intent = Intent(activity, Recruitment_Detail_Activity::class.java).apply {
                putExtra("recruitId", recruitItem.id) // 필요한 데이터 전달
            }
            startActivity(intent)
        }

        binding.recyclerViewMainRecommend.adapter = adapter

        // 검색 버튼 클릭 리스너 설정
        val searchBtn = view.findViewById<ImageView>(R.id.search)
        searchBtn?.setOnClickListener {
            val intent = Intent(activity, SearchActivity::class.java)
            startActivity(intent)
        }

        // GridLayoutManager를 사용하여 한 행에 2개의 아이템 배치
        binding.recyclerView5.layoutManager = GridLayoutManager(context, 2)
        binding.recyclerView5.adapter = MainManySupportAdapter(getSampleData())

        // 카드 간의 간격 설정
        binding.recyclerView5.addItemDecoration(SpacingItemDecoration(16)) // 16dp 간격

        val sampleData2 = listOf(
            DataMainMyHeart("한국장애인고용공단", "2024 장애인 인턴 모집", "D-5"),
            DataMainMyHeart("SK 이노베이션", "사무지원직 채용", "D-3")
        )

        // 어댑터 연결
        val adapterMyHeart = MainMyHeartAdapter(sampleData2)
        binding.recyclerView6.isNestedScrollingEnabled = false
        binding.recyclerView6.layoutManager = LinearLayoutManager(context)
        binding.recyclerView6.adapter = adapterMyHeart


        val sampleData3 = listOf(
            DataMainMyApply("한국장애인고용공단", "2024 장애인 인턴 모집"),
            DataMainMyApply("SK 이노베이션", "사무지원직 채용")
        )

        // 어댑터 연결
        val adapterMyApply = MainMyApplyAdapter(sampleData3)
        binding.recyclerView7.isNestedScrollingEnabled = false
        binding.recyclerView7.layoutManager = LinearLayoutManager(context)
        binding.recyclerView7.adapter = adapterMyApply

    }

    private fun getSampleData(): List<DataMainManySupportItem> {
        return listOf(
            DataMainManySupportItem("공공기관", "CJ", "2024 장애인 채용 지원 인턴 모집"),
            DataMainManySupportItem("대기업", "SK", "장애인 친화 사무지원직 채용", true)
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // 메모리 누수를 방지하기 위해 뷰를 해제
    }

    // 카드 간격을 설정하는 ItemDecoration 클래스
    class SpacingItemDecoration(private val space: Int) : RecyclerView.ItemDecoration() {
        override fun getItemOffsets(
            outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State
        ) {
            outRect.left = space
            outRect.right = space
            outRect.top = space
            outRect.bottom = space
        }
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    // 매개변수 처리
                }
            }
    }
}
