package com.notifications.marcoliva.notifications

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_notification_personalized.*

/**
 * Created by ThinkSoft on 14/11/2017.
 */
class NotificationPersonalizedActivity: AppCompatActivity() , Notifications {

    private var mIcons: IntArray = intArrayOf(
            R.drawable.alert_notify, R.drawable.chat_notify,
            R.drawable.facebook_notify, R.drawable.like_notify,
            R.drawable.new_friend_notify, R.drawable.new_message_notify)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification_personalized)
        val mNameIcons = arrayOf(
                getString(R.string.alert_notify),getString(R.string.chat_notify),
                getString(R.string.facebook_notify),getString(R.string.like_notify),
                getString(R.string.new_friend_notify),getString(R.string.new_message_notify))
        var gridView = icons_grid_view
        var showNotificationButton = show_notification_button
        var idImage  = R.drawable.alert_notify
        gridView.adapter = IconsAdapter(this)
        gridView.setOnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(this,"Selected "+mNameIcons[i]+" Notification Icon",Toast.LENGTH_SHORT).show()
            idImage = mIcons[i]
        }
        showNotificationButton.setOnClickListener {
            showNotification(this,title_edit_text.text.toString(),content_edit_text.text.toString(),idImage )
        }
    }
}