package com.example.west2_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        detail_button_quit.setOnClickListener {
            finish()
        }

        detail_title_text.text = intent.getStringExtra("detail_title")?:"群组标题"
        detail_author_text.text = intent.getStringExtra("detail_author")?:"群组创建者"
        detail_chat_img.setImageResource(intent.getIntExtra("detail_img",0))
    }
}