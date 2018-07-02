package com.wokabel.app.wokabel.views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wokabel.app.wokabel.R;


public class SubjectSelectFragment extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_subject_select, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    public static SubjectSelectFragment newInstance(){
        SubjectSelectFragment fragment = new SubjectSelectFragment();
        return fragment;
    }

}
