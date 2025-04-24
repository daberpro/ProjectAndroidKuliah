package com.example.daberdevporto.adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.daberdevporto.MyGithub;
import com.example.daberdevporto.MyYoutube;
import com.example.daberdevporto.STMIKPontianak;

public class TabLayoutAdapter extends FragmentStateAdapter {

    private MyGithub MyGithubFragment = new MyGithub();
    private MyYoutube MyYoutubeFragment = new MyYoutube();
    private STMIKPontianak STMIKPontianakFragment = new STMIKPontianak();
    private int TabCount = 0;

    public TabLayoutAdapter(@NonNull Fragment fragment, int tabCount) {
        super(fragment);
        this.TabCount = tabCount;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        Log.d("Position tab", "Position : " + position);
        switch(position){
            case 0:
                return this.MyGithubFragment;
            case 1:
                return this.MyYoutubeFragment;
            case 2:
                return this.STMIKPontianakFragment;
            default:
                return this.MyGithubFragment;
        }
    }

    @Override
    public int getItemCount() {
        return this.TabCount;
    }


}
