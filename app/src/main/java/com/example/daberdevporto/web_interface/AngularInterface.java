package com.example.daberdevporto.web_interface;

import static android.content.ContentValues.TAG;
import static androidx.core.content.ContextCompat.startActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.daberdevporto.R;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AngularInterface {

    Context m_ctx;
    Activity m_activity;

    public AngularInterface(Context ctx, Activity act){
        this.m_ctx = ctx;
        this.m_activity = act;
    }

    @JavascriptInterface
    public void showNotification(String title, String message){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("dabdev","deb", NotificationManager.IMPORTANCE_DEFAULT);
            Notification noti = new Notification.Builder(this.m_ctx,"dabdev")
            .setContentTitle(title)
            .setContentText(message)
            .setSmallIcon(R.mipmap.ic_launcher)
            .build();

                NotificationManager manager = (NotificationManager) this.m_activity.getSystemService(Context.NOTIFICATION_SERVICE);
                manager.createNotificationChannel(channel);
                manager.notify(1,noti);
        }
    }

    @JavascriptInterface
    public void showCall(){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        this.m_activity.startActivity(intent);
    }

    public boolean isPackageExisted(String targetPackage){
        List<ApplicationInfo> packages;
        PackageManager pm;

        pm = this.m_ctx.getPackageManager();
        packages = pm.getInstalledApplications(0);
        for (ApplicationInfo packageInfo : packages) {
            if(packageInfo.packageName.equals(targetPackage))
                return true;
        }
        return false;
    }

    @JavascriptInterface
    public void showWhatsApp(){
        String url = "https://wa.me/+6282154733569?text=hallo%20Ari";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        this.m_ctx.startActivity(i);

    }


    @JavascriptInterface
    public void showCamera(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        this.m_ctx.startActivity(intent);

    }

}
