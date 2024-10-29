package com.example.yesable

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ChatFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_chat, container, false)

        // RecyclerView 설정
        val chatListRecyclerView: RecyclerView = view.findViewById(R.id.chatListRecyclerView)
        chatListRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        // 샘플 데이터
        val chatItems = listOf(
            ChatItem("1", "예서블 봇", "오늘 하루는 어때?"),
            ChatItem("2", "김순득", "하이"),
            ChatItem("3", "신영덕", "와썹")
        )

        // 어댑터 설정 및 클릭 리스너 추가
        chatListRecyclerView.adapter = ChatListAdapter(chatItems) { chatItem ->
            val intent = Intent(requireContext(), ChatDetailActivity::class.java)
            intent.putExtra("chatItemId", chatItem.id)
            startActivity(intent)
        }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ChatFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}