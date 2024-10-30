package com.example.yesable

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.yesable.ui.theme.YesableTheme

class Recruitment_Detail_Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recruitment_detail)

        // 전달된 데이터 가져오기
        val recruitId = intent.getIntExtra("recruitId", -1)

        // recruitId를 사용해 데이터 표시
        if (recruitId != -1) {
            // DB나 리스트에서 해당 ID에 맞는 데이터를 가져와 표시
        }

        val backbutton = findViewById<TextView>(R.id.back_button)
        backbutton.setOnClickListener {
            finish()
        }



        val sign_button = findViewById<Button>(R.id.sign_button)
        sign_button.setOnClickListener {
            val intent = Intent(this, Apply_List_Activity::class.java)
            startActivity(intent)
        }

    }
}

