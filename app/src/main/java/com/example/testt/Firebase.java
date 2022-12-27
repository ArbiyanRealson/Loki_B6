package com.example.testt;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class Firebase extends FirebaseMessagingService {
    private static final String CHANNEL_ID = "test_channel" ;
    private static final String TAG = "Service-Debug";
    private NotificationManagerCompat notificationManager;

    @Override
    public void onNewToken(@NonNull String token) {
        Log.d(TAG, "Refreshed token: " + token);
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        String tipe = remoteMessage.getData().get("tipe");
        if (tipe.equals("1"))
            displayNotification(remoteMessage.getNotification()); // Notifikasi ada intent
        else
            displayNotification2(remoteMessage.getNotification()); // Notifikasi tidak ada intent
    }

    // A. TIPE NOTIFIKASI 1 (ada intent)
    private void displayNotification(RemoteMessage.Notification notification) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Channel Contoh", NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("Ini hanya channel untuk contoh notifikasi");
            NotificationManagerCompat.from(this).createNotificationChannel(channel);
        }
        NotificationCompat.Builder builder = null;

        Intent resultIntent = new Intent(this, DetailSeminar.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addNextIntentWithParentStack(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(0,
                        PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

        builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_baseline_person_24)
                .setContentTitle(notification.getTitle())
                .setContentText(notification.getBody())
                .setContentIntent(resultPendingIntent)
//                .addAction(R.drawable.ic_baseline_warning_24, "PERGI", resultPendingIntent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        // Tampilkan notifikasi
        NotificationManagerCompat.from(this).notify(101, builder.build());
    }

    // B. TIPE NOTIFIKASI 2 (tidak ada intent)
    private void displayNotification2(RemoteMessage.Notification notification) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Channel Contoh", NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("Ini hanya channel untuk contoh notifikasi");
            NotificationManagerCompat.from(this).createNotificationChannel(channel);
        }
        NotificationCompat.Builder builder = null;

        builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_baseline_person_24)
                .setContentTitle(notification.getTitle())
                .setContentText(notification.getBody())
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        // Tampilkan notifikasi
        NotificationManagerCompat.from(this).notify(101, builder.build());
    }
}