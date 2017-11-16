package com.notifications.marcoliva.notifications

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.support.v4.app.NotificationCompat
import java.util.*

/**
 * Created by ThinkSoft on 14/11/2017.
 */
interface Notifications {

    fun showNotificationWithBitmap(context: Context, title: String, description: String, bitmap: Bitmap) {
        //an array of longs of times for which to turn the vibrator on or off
        var mLong: LongArray = longArrayOf(100, 250, 100, 500)
        // create a intent to display tha activity
        var intent = Intent(context, DisplayNotificacionActivity::class.java)
        //create a PendingIntent reference
        var pendingIntent = PendingIntent.getActivity(context, 0, intent, 0)

        var notificationManager: NotificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        var mBuilder: NotificationCompat.Builder = NotificationCompat.Builder(context, "Notification")
        mBuilder.setContentIntent(pendingIntent)// set pendingIntent
        mBuilder.setLargeIcon(bitmap)
        mBuilder.setContentTitle(title)
        mBuilder.setContentText(description)
        mBuilder.setVibrate(mLong)
        mBuilder.setAutoCancel(false)//Make this notification automatically dismissed when the user touches it

        randomNotification(notificationManager, mBuilder)
    }

    fun showNotificationWithIcon(context: Context, title: String, description: String, idIcon: Int) {
        //an array of longs of times for which to turn the vibrator on or off
        var mLong: LongArray = longArrayOf(100, 250, 100, 500)
        // create a intent to display tha activity
        var intent = Intent(context, DisplayNotificacionActivity::class.java)
        //create a PendingIntent reference
        var pendingIntent = PendingIntent.getActivity(context, 0, intent, 0)

        var notificationManager: NotificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        var mBuilder: NotificationCompat.Builder = NotificationCompat.Builder(context, "Notification")
        mBuilder.setContentIntent(pendingIntent)// set pendingIntent
        mBuilder.setSmallIcon(idIcon)
        mBuilder.setContentTitle(title)
        mBuilder.setContentText(description)
        mBuilder.setVibrate(mLong)
        mBuilder.setAutoCancel(false)//Make this notification automatically dismissed when the user touches it

        randomNotification(notificationManager, mBuilder)
    }

    private fun randomNotification(notificationManager: NotificationManager, mBuilder: NotificationCompat.Builder) {
        //Specify a different id for each notification
        var random = Random()
        var id: Int = random.nextInt(1000 + 1)

        notificationManager.notify(id, mBuilder.build())
    }


}