package com.example.west2_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import kotlinx.android.synthetic.main.activity_add.*
import java.lang.Exception

class AddActivity : AppCompatActivity() {

    private val add_chat_imgs = ArrayList<Int>()
    private val IMGCNTS = 4
    var imgcnt = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        initImgs()
        add_left_tab_img.setOnClickListener {
            if (imgcnt == 0)
                imgcnt = IMGCNTS - 1
            else
                imgcnt -= 1
            add_chat_img.setImageResource(add_chat_imgs.get(imgcnt))
        }
        add_right_tab_img.setOnClickListener {
            imgcnt = (imgcnt+1)%IMGCNTS
            add_chat_img.setImageResource(add_chat_imgs.get(imgcnt))
        }
        add_chat_button.setOnClickListener {
            val title = add_chat_title_edit.text.toString()
            val author = add_chat_author_edit.text.toString()
            if (title == "" || author == "") {
                Toast.makeText(this,"请输入标题以及创建者",Toast.LENGTH_SHORT).show()
            }
            else {
                try {
                    val add_intent_to_main = Intent(this,MainActivity::class.java)
                    add_intent_to_main.putExtra("chat_img",add_chat_imgs.get(imgcnt))
                    add_intent_to_main.putExtra("chat_title",title)
                    add_intent_to_main.putExtra("chat_author",author)
                    startActivity(add_intent_to_main)
                    Toast.makeText(this,"创建成功",Toast.LENGTH_SHORT).show()
                    finish()
                } catch (e: Exception) {
                    Toast.makeText(this,"创建失败",Toast.LENGTH_SHORT).show()
                }
            }
        }
        add_button_quit.setOnClickListener {
            finish()
        }
    }

    private fun initImgs() {
        add_chat_imgs.add(R.drawable.chat_img1)
        add_chat_imgs.add(R.drawable.chat_img2)
        add_chat_imgs.add(R.drawable.chat_img3)
        add_chat_imgs.add(R.drawable.chat_img4)
    }
}