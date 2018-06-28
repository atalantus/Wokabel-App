package com.wokabel.app.wokabel.Models;
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;


@SuppressLint("ValidFragment")
public class SaveLoadPreferences extends Fragment {
    private SharedPreferences Pref = getActivity().getPreferences(Context.MODE_PRIVATE);
    private SharedPreferences.Editor editor = Pref.edit();
    private com.wokabel.app.wokabel.models.User user;

    @SuppressLint("ValidFragment")
    public SaveLoadPreferences(com.wokabel.app.wokabel.models.User user){
        this.user=user;
    }

    public void save(){
        editor.putInt(user.getName(), user.getXp());
        editor.apply();
    }

    public void load(){
        user.setXp(Pref.getInt(user.getName(), 100));
    }
}
