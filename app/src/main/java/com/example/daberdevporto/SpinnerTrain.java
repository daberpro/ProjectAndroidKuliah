package com.example.daberdevporto;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.daberdevporto.model.CustomSpinnerModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SpinnerTrain#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SpinnerTrain extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SpinnerTrain() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SpinnerTrain.
     */
    // TODO: Rename and change types and number of parameters
    public static SpinnerTrain newInstance(String param1, String param2) {
        SpinnerTrain fragment = new SpinnerTrain();
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

        Spinner spinner = view.findViewById(R.id.default_spinner);
        Spinner custom_spinner = view.findViewById(R.id.custom_spinner);

        List<String> NamaBuah = new ArrayList<>();
        NamaBuah.add("Apel");
        NamaBuah.add("Anggur");
        NamaBuah.add("Pisang");
        NamaBuah.add("Kelapa");
        NamaBuah.add("Alpukat");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1,NamaBuah);
        spinner.setAdapter(dataAdapter);

        List<String> Negara = new ArrayList<>();
        Negara.add("Albania");
        Negara.add("Belgia");
        Negara.add("Hungary");
        Negara.add("Iran");
        Negara.add("slovenia");

        CustomSpinnerModel customModel = new CustomSpinnerModel(getContext(),Negara);
        custom_spinner.setAdapter(customModel);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_spinner_train, container, false);
    }
}