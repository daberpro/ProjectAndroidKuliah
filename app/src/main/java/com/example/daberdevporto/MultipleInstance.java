package com.example.daberdevporto;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.button.MaterialButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MultipleInstance#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MultipleInstance extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MultipleInstance() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MultipleInstance.
     */
    // TODO: Rename and change types and number of parameters
    public static MultipleInstance newInstance(String param1, String param2) {
        MultipleInstance fragment = new MultipleInstance();
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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MaterialButton open_phone = view.findViewById(R.id.open_phone);
        MaterialButton open_sms = view.findViewById(R.id.sms);
        MaterialButton open_calendar = view.findViewById(R.id.calendar);
        MaterialButton open_browser = view.findViewById(R.id.browser);
        MaterialButton open_calculator = view.findViewById(R.id.calculator);
        MaterialButton open_contact = view.findViewById(R.id.contact);
        MaterialButton open_galeri = view.findViewById(R.id.galeri);
        MaterialButton open_wifi = view.findViewById(R.id.wifi);
        MaterialButton open_sound = view.findViewById(R.id.sound);
        MaterialButton open_airplane = view.findViewById(R.id.airplane);
        MaterialButton open_settings = view.findViewById(R.id.apps);
        MaterialButton open_bluetooth = view.findViewById(R.id.bluetooth);
        open_phone.setOnClickListener(v ->{
            this.OpenPhone();
        });
        open_sms.setOnClickListener(v ->{
            this.OpenSMS();
        });
        open_calendar.setOnClickListener(v ->{
            this.OpenCalendar();
        });
        open_browser.setOnClickListener(v ->{
            this.OpenBrowser();
        });
        open_calculator.setOnClickListener(v ->{
            this.OpenCalculator();
        });
        open_contact.setOnClickListener(v ->{
            this.OpenContact();
        });
        open_galeri.setOnClickListener(v ->{
            this.OpenGallery();
        });
        open_wifi.setOnClickListener(v ->{
            this.OpenWifi();
        });
        open_sound.setOnClickListener(v ->{
            this.OpenSound();
        });
        open_airplane.setOnClickListener(v ->{
            this.OpenAirPlaneMode();
        });
        open_settings.setOnClickListener(v ->{
            this.OpenAppSettings();
        });
        open_bluetooth.setOnClickListener(v ->{
            this.OpenBluetooth();
        });
    }

    public void OpenPhone(){
        Intent phone = new Intent(Intent.ACTION_DIAL);
        startActivity(phone);
    }

    public void OpenSMS(){
        Intent sms = new Intent(Intent.ACTION_MAIN);
        sms.addCategory(Intent.CATEGORY_APP_MESSAGING);
        startActivity(sms);
    }

    public void OpenCalendar(){
        Intent calendar = new Intent(Intent.ACTION_MAIN);
        calendar.addCategory(Intent.CATEGORY_APP_CALENDAR);
        startActivity(calendar);
    }

    public void OpenBrowser(){
        Intent browser = new Intent(Intent.ACTION_MAIN);
        browser.addCategory(Intent.CATEGORY_APP_BROWSER);
        startActivity(browser);
    }

    public void OpenCalculator(){
        Intent calculator = new Intent(Intent.ACTION_MAIN);
        calculator.addCategory(Intent.CATEGORY_APP_CALCULATOR);
        startActivity(calculator);
    }

    public void OpenContact(){
        Intent contact = new Intent(Intent.ACTION_MAIN);
        contact.addCategory(Intent.CATEGORY_APP_CONTACTS);
        startActivity(contact);
    }

    public void OpenGallery(){
        Intent gallery = new Intent(Intent.ACTION_MAIN);
        gallery.addCategory(Intent.CATEGORY_APP_GALLERY);
        startActivity(gallery);
    }

    public void OpenWifi(){
        Intent wifi = new Intent(Settings.ACTION_WIFI_SETTINGS);
        startActivity(wifi);
    }

    public void OpenSound(){
        Intent sound = new Intent(Settings.ACTION_SOUND_SETTINGS);
        startActivity(sound);
    }

    public void OpenAirPlaneMode(){
        Intent airplane = new Intent(Settings.ACTION_AIRPLANE_MODE_SETTINGS);
        startActivity(airplane);
    }

    public void OpenAppSettings(){
        Intent settings = new Intent(Settings.ACTION_APPLICATION_SETTINGS);
        startActivity(settings);
    }

    public void OpenBluetooth(){
        Intent bluetooth = new Intent(Settings.ACTION_BLUETOOTH_SETTINGS);
        startActivity(bluetooth);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_multiple_instance, container, false);
    }
}