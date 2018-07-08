package com.wokabel.app.wokabel.views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wokabel.app.wokabel.R;


public class ProfileFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    public static ProfileFragment newInstance(){
        ProfileFragment fragment = new ProfileFragment();
        //setzen von desplayUsername und displayXP auf Werte gespeichert in den Settings fehlt noch
        return fragment;
    }


    
}
