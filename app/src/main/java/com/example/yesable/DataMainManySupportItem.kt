package com.example.yesable

data class DataMainManySupportItem(
    val type: String,     // 기업 구분
    val name: String,     // 기업명
    val title: String,    // 공고 제목
    var isHeartClicked: Boolean = false // 찜 여부 상태
)