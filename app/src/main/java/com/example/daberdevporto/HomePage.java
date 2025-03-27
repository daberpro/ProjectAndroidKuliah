package com.example.daberdevporto;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomePage#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomePage extends Fragment {



    public HomePage() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomePage.
     */
    // TODO: Rename and change types and number of parameters
    public static HomePage newInstance(String param1, String param2) {
        HomePage fragment = new HomePage();
        Bundle args = new Bundle();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button FiveColor = (Button) view.findViewById(R.id.five_color);
        Button EditText = (Button) view.findViewById(R.id.edit_text);
        Button EmailForm = (Button) view.findViewById(R.id.email_form);
        Button MultiLang = (Button) view.findViewById(R.id.multi_language);
        Button MultiIntent = (Button) view.findViewById(R.id.multi_intent);

        FiveColor.setOnClickListener(v ->{
            Navigation.findNavController(view).navigate(R.id.action_fiveColor);
        });

        EditText.setOnClickListener(v ->{
            Navigation.findNavController(view).navigate(R.id.action_editText);
        });

        EmailForm.setOnClickListener(v ->{
            Navigation.findNavController(view).navigate(R.id.action_EmailForm);
        });

        MultiLang.setOnClickListener(v ->{
            Navigation.findNavController(view).navigate(R.id.action_MultiLang);
        });

        MultiIntent.setOnClickListener(v ->{
            Navigation.findNavController(view).navigate(R.id.action_MultiInstance);
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_page, container, false);
    }
}