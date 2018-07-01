package com.wokabel.app.wokabel.services.room;

import android.arch.persistence.room.TypeConverter;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.Arrays;

public class Typeconverter {

    @TypeConverter
    public static String toString(ArrayList<String> list){
        return TextUtils.join(", ", list);
    }

    public static ArrayList<String> fromString(String string){
        return new ArrayList<>(Arrays.asList(string.split(",")));
    }

}
