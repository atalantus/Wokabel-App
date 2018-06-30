package com.wokabel.app.wokabel.models;

import android.arch.persistence.room.TypeConverter;

import java.util.ArrayList;
import java.util.Arrays;

public class Typeconverter {

    @TypeConverter
    public static String toString(ArrayList<String> list){
        return String.join(", ", list);
    }

    public static ArrayList<String> fromString(String string){
        return new ArrayList<String>(Arrays.asList(string.split(",")));
    }

}
