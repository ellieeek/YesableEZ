package com.example.yesable

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ChatDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_detail)

        val chatRecyclerView: RecyclerView = findViewById(R.id.chatRecyclerView)
        val sendButton: Button = findViewById(R.id.sendButton)
        val messageEditText: EditText = findViewById(R.id.messageEditText)

        chatRecyclerView.layoutManager = LinearLayoutManager(this)
        chatRecyclerView.adapter = ChatAdapter()

        sendButton.setOnClickListener {
            val message = messageEditText.text.toString()
            // 메시지를 추가하고 RecyclerView에 업데이트
            (chatRecyclerView.adapter as ChatAdapter).addMessage(message)
            messageEditText.text.clear()
        }
    }
}