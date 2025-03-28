package com.example.daberdevporto;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebViewClient;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WebView#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WebView extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public WebView() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WebView.
     */
    // TODO: Rename and change types and number of parameters
    public static WebView newInstance(String param1, String param2) {
        WebView fragment = new WebView();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        android.webkit.WebView webview = view.findViewById(R.id.webview);
        MaterialButton search_btn = view.findViewById(R.id.search);
        TextInputEditText search_bar = view.findViewById(R.id.search_bar);

        search_btn.setOnClickListener(v ->{
            String url = Objects.requireNonNull(search_bar.getText()).toString();
            if(!url.contains("https://") && !url.contains("http://") ||
                    (url.indexOf("https://") != 0 && url.indexOf("http://") != 0)){
                new AlertDialog.Builder(getContext())
                    .setTitle("URL INVALID")
                    .setMessage("URL tidak dimulai dengan https:// atau http://")
                    .setPositiveButton("Oke",null)
                    .show();
            }else{
                webview.setWebViewClient(new WebViewClient());
                webview.loadUrl(url);
                webview.getSettings().setJavaScriptEnabled(true);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_web_view, container, false);
    }
}