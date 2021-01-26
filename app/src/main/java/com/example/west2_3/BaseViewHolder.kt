package com.example.west2_3

import android.view.View
import androidx.collection.SparseArrayCompat
import androidx.recyclerview.widget.RecyclerView

class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val mViews = SparseArrayCompat<View>()

    fun <V : View> getView(id: Int): V {
        var view = mViews[id]
        if (view == null) {
            view = itemView.findViewById(id)
            mViews.put(id, view)
        }
        return view as V
    }
}