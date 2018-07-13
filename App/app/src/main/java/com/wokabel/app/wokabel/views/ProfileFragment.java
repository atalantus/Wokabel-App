package com.wokabel.app.wokabel.views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wokabel.app.wokabel.R;
import com.wokabel.app.wokabel.WokabelApplication;
import com.wokabel.app.wokabel.services.preferences.Settings;


public class ProfileFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        Settings settings = WokabelApplication.sharedPreferences;
        TextView username = view.findViewById(R.id.display_username);
        TextView user_xp = view.findViewById(R.id.display_xp);
        username.setText(settings.getString("username"));
        String xp = Integer.toString(settings.getInt("user_xp"));
        user_xp.setText(xp);
        return view;
    }

    public static ProfileFragment newInstance(){
        //setzen von desplayUsername und displayXP auf Werte gespeichert in den Settings fehlt noch
        return new ProfileFragment();
    }

    public void update(){

    }
    
}
