package com.notifications.marcoliva.notifications

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Notifications {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        notification_normal_button.setOnClickListener({
            showNotification(this,"Kotlin Notification","Prueba kotlin",android.R.drawable.ic_dialog_alert)
        })
        notification_personalized_button.setOnClickListener({
           var intent = Intent(this, NotificationPersonalizedActivity::class.java)
            startActivity(intent)
        })

    }
}
