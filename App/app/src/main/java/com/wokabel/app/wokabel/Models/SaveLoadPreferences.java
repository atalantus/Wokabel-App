package com.wokabel.app.wokabel.Models;
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;


@SuppressLint("ValidFragment")
public class SaveLoadPreferences extends Fragment {
    SharedPreferences Pref = getActivity().getPreferences(Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = Pref.edit();
    com.wokabel.app.wokabel.models.User user;

    @SuppressLint("ValidFragment")
    public SaveLoadPreferences(com.wokabel.app.wokabel.models.User user){
        this.user=user;
    }

    public void Save(){
        editor.putInt(user.getName(), user.getXp());
        editor.apply();
    }

    public void Load(String User){
        user.setXp(Pref.getInt(User, 100));
    }
}
