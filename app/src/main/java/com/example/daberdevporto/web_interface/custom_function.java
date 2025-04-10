package com.example.daberdevporto.web_interface;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

import com.example.daberdevporto.WebViewLanjutan;

public class custom_function {

    private Context m_context;
    private Activity m_activity;
    private WebViewLanjutan main_ctx;

    public custom_function(Context m_context, Activity m_acitivity, WebViewLanjutan ctx){
        this.m_context = m_context;
        this.m_activity = m_acitivity;
        this.main_ctx = ctx;
    }

    @JavascriptInterface
    public void showToast(String text){
        Toast.makeText(this.m_context,text,Toast.LENGTH_LONG).show();
    }

    @JavascriptInterface
    public void showSms(){
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_APP_MESSAGING);
        this.m_context.startActivity(intent);
    }

    @JavascriptInterface
    public void showWhatsApp(String noHp,String pesan){

        if(this.main_ctx.isPackageExisted("com.whatsapp")){
            String url = "https://wa.me/"+noHp+"?text="+pesan;
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            this.m_context.startActivity(i);
        }else{
            Toast.makeText(this.m_context,"Whatsapp not installed", Toast.LENGTH_LONG).show();
        }
    }

}
