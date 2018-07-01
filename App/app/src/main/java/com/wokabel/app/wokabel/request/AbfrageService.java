package com.wokabel.app.wokabel.request;

import java.util.Random;
import java.util.ArrayList;
import com.wokabel.app.wokabel.Models.Vocable;

public class AbfrageService{

    ArrayList<Vocable> randomsorted;
    Vocable currentVoc;
    public AbfrageService(ArrayList<Vocable> input){
        Random rand = new Random();
        randomsorted = new ArrayList<Vocable>();
        ArrayList<Vocable> a = new ArrayList<Vocable>();
        currentVoc = null;
        for(int i = 0; i < input.size(); i++){
            for(int l = 5; l > input.get(i).getLevel()-1; l--){
                a.add(input.get(i));
            }
        }

        while (a.size() > 0){
            int randnum = rand.nextInt(a.size());
            randomsorted.add(a.get(randnum));
            a.remove(randnum);
        }

    }




    public String getQuestion(int input){
        currentVoc = randomsorted.get(0);
        if(input == 0) { // 0 equals key - value
            return currentVoc.getKey();
        }else{ // 1 equals value - key   (else if(input == 1) later)
            ArrayList<String> temp = currentVoc.getValues();
            String ValueString = "";

            for (String s:temp) {
                ValueString += s;
                ValueString += ", ";
            }

            return ValueString;
        }
    }

    public String getHelper(){
        return currentVoc.getHelper();
    }

    public boolean handleAnswer(String answer, int input){
        if(input == 0){ // 0 euqals (question)key - (answer)value
            ArrayList<String> temp = currentVoc.getValues();

            for (String s:temp) {
                if(s.equals(answer)){
                    return true;
                }
            }
            return false;
        }else{ // 1 euqals (question) value - (answer)key
            return answer.equals(currentVoc.getKey()); //answer is right
        }
    }
    public String getAnswer(int input){
        String answer = "";
        if(input == 0){ // 0 equals key - value
            ArrayList<String> temp = currentVoc.getValues();

            for (String s:temp) {
                answer += s;
                answer += ", ";
            }
        }else{ //
            answer = currentVoc.getKey();
        }
        randomsorted.remove(0);
        return answer;
    }
}