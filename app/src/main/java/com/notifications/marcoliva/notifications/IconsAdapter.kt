package com.notifications.marcoliva.notifications

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView

/**
 * Created by ThinkSoft on 14/11/2017.
 */
class IconsAdapter(context: Context) : BaseAdapter() {
    var mContext = context
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var imageView: ImageView
        if (convertView == null) {
            imageView = ImageView(mContext)
            imageView.layoutParams = ViewGroup.LayoutParams(240,480)
            imageView.scaleType = ImageView.ScaleType.CENTER_CROP
            imageView.setPadding(8, 8, 8, 8)
        } else {
            imageView = convertView as ImageView
        }
        imageView.setImageResource(mIcons.get(position))
        return imageView

    }

    override fun getItem(p0: Int): Any? {
        return null
    }

    override fun getItemId(p0: Int): Long {
       return 0;
    }

    override fun getItemViewType(position: Int): Int {
        return mIcons[position]
    }

    override fun getCount(): Int {
        return mIcons.count()
    }

    var mIcons: IntArray = intArrayOf(
            R.drawable.alert_notify, R.drawable.chat_notify,
            R.drawable.facebook_notify, R.drawable.like_notify,
            R.drawable.new_friend_notify, R.drawable.new_message_notify)
}