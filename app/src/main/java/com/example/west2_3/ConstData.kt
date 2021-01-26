package com.example.west2_3

import java.util.*

object ConstData {
    val main_list_items_data = LinkedList<Data_ChatItem>()

    private fun init_list_items(){
        main_list_items_data.addAll(listOf(
            Data_ChatItem(R.drawable.chat_img1, "2019第三轮测试图片1", "2019第三轮测试1"),
            Data_ChatItem(R.drawable.chat_img2, "2019第三轮测试图片2", "2019第三轮测试2"),
            Data_ChatItem(R.drawable.chat_img3, "2019第三轮测试图片3", "2019第三轮测试3"),
            Data_ChatItem(R.drawable.chat_img4, "2019第三轮测试图片4", "2019第三轮测试4")
        ))
    }

    init {
        init_list_items()
    }
}