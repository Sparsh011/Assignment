package com.example.myapplication.notificationUtil;

import static com.example.myapplication.application.Application.CHANNEL_1;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.example.myapplication.R;

public class NotificationService {
    private Context context;
    private String message;

    public NotificationService(Context context, String message){
        this.context = context;
        this.message = message;
    }

    public void showNotification(){
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        PendingIntent dismissIntent = PendingIntent.getBroadcast(context,
                2,
                new Intent(context, NotificationReceiver.class),
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.M? PendingIntent.FLAG_IMMUTABLE: 0
        );

        NotificationCompat.Builder notification = new NotificationCompat.Builder(context, CHANNEL_1);
        notification.setPriority(NotificationCompat.PRIORITY_MAX)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Dismiss Notification")
                .setContentText(message)
                .setOngoing(true)
                .addAction(R.drawable.ic_baseline_cancel_24, "Dismiss", dismissIntent);

        notificationManager.notify(1, notification.build());
    }
}
