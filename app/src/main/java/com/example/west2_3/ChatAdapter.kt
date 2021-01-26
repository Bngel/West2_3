package com.example.west2_3

import android.content.Context
import android.content.Intent
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class ChatAdapter(val chatitems: List<Data_ChatItem>): BaseAdapter<Data_ChatItem>(chatitems) {

    override fun convert(holder: BaseViewHolder, position: Int) {
        val chatitem = chatitems[position]
        val chatImg = holder.getView<ImageView>(R.id.main_item_img)
        chatImg.setImageResource(chatitem.ChatImg)
        chatImg.setTag(chatitem.ChatImg)
        val chatTitle = holder.getView<TextView>(R.id.main_item_title)
        chatTitle.text = chatitem.ChatTitle
        val chatAuthor =  holder.getView<TextView>(R.id.main_item_author)
        chatAuthor.text = chatitem.ChatAuthor
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val holder = super.onCreateViewHolder(parent, viewType)
        holderSetting(parent.context,holder)
        return holder
    }

    private fun holderSetting(context: Context, holder: BaseViewHolder) {
        val img = holder.getView<ImageView>(R.id.main_item_img)
        val title = holder.getView<TextView>(R.id.main_item_title)
        val author = holder.getView<TextView>(R.id.main_item_author)
        holder.itemView.setOnClickListener {
            intentSetting(context,title.text.toString(),author.text.toString(),img.getTag() as Int)
        }
    }

    private fun intentSetting(context: Context, title: String, author: String, img: Int) {
        val main_intent_to_detail = Intent(context,DetailActivity::class.java)
        main_intent_to_detail.putExtra("detail_title",title)
        main_intent_to_detail.putExtra("detail_author",author)
        main_intent_to_detail.putExtra("detail_img", img)
        context.startActivity(main_intent_to_detail)
    }
}
