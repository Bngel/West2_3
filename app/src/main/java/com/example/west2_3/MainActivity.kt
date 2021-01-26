package com.example.west2_3

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.PopupWindow
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.west2_3.ConstData.main_list_items_data
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_main_button_add_item.*


class MainActivity : AppCompatActivity() {

    /*
    * author : 061900209
    * 实现了 附加 1 , 2
     */

    private val INTENT_ADD = 1

    @SuppressLint("ClickableViewAccessibility", "InflateParams")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        add_list_item()
        val main_list_adapter = ChatAdapter(main_list_items_data)
        main_list_items.adapter = main_list_adapter
        val main_list_layoutManager = LinearLayoutManager(this)
        main_list_items.layoutManager = main_list_layoutManager

        main_button_add.setOnClickListener {
            val popupWindow_view = layoutInflater.inflate(R.layout.layout_main_button_add_item,
                null,false)
            val popupWindow = PopupWindow(popupWindow_view, ActionBar.LayoutParams.WRAP_CONTENT,
                ActionBar.LayoutParams.WRAP_CONTENT, true)
            popupWindow.showAsDropDown(main_button_add,0,35)

            val popbtn_add = popupWindow_view.findViewById<Button>(R.id.main_popbutton_add)
            val popbtn_empty = popupWindow_view.findViewById<Button>(R.id.main_popbutton_empty)
            val popbtn_quit = popupWindow_view.findViewById<Button>(R.id.main_popbutton_quit)

            popbtn_add.setOnClickListener {
                popupWindow.dismiss()
                val main_intent_to_add = Intent(this,AddActivity::class.java)
                startActivity(main_intent_to_add)
                finish()
            }
            popbtn_empty.setOnClickListener {
                popupWindow.dismiss()
                main_list_items_data.clear()
                main_list_items.adapter = ChatAdapter(main_list_items_data)
            }
            popbtn_quit.setOnClickListener {
                popupWindow.dismiss()
                finish()
            }
        }
    }

    private fun add_list_item(){
        val chat_img = intent.getIntExtra("chat_img",0)
        val chat_title = intent.getStringExtra("chat_title")?:""
        val chat_author = intent.getStringExtra("chat_author")?:""
        if (!(chat_img == 0 || chat_title == "" || chat_author == "")){
            main_list_items_data.addFirst(
                Data_ChatItem(chat_img,chat_title,chat_author)
            )
        }
    }
}