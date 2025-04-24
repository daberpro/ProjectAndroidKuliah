package com.example.daberdevporto.model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.daberdevporto.R;

import java.util.List;

public class CustomSpinnerModel extends BaseAdapter {

    List<String> m_negara;
    Context m_ctx;

    public CustomSpinnerModel(Context ctx, List<String> negara){
        super();
        this.m_ctx = ctx;
        this.m_negara = negara;
    }

    @Override
    public int getCount() {
        if(this.m_negara == null){
            return 0;
        }
        return this.m_negara.size();
    }

    @Override
    public Object getItem(int position) {
        return this.m_negara.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        @SuppressLint("ViewHolder") View view = LayoutInflater.from(this.m_ctx).inflate(R.layout.custom_spinner,null);
        ImageView country_flag = view.findViewById(R.id.county_flags);
        TextView country_name = view.findViewById(R.id.country_name);

        String data = this.m_negara.get(position);
        country_name.setText(data);

        switch (data.toLowerCase()){
            case "hungary":
                country_flag.setImageResource(R.drawable.hungary);
                break;
            case "belgia":
                country_flag.setImageResource(R.drawable.belgia);
                break;
            case "albania":
                country_flag.setImageResource(R.drawable.albania);
                break;
            case "iran":
                country_flag.setImageResource(R.drawable.iran);
                break;
            case "slovenia":
                country_flag.setImageResource(R.drawable.slovenia);
                break;
            default:
                country_flag.setImageResource(R.drawable.flag_24px);
        }

        return view;
    }
}
