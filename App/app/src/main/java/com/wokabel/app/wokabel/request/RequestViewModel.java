package com.wokabel.app.wokabel.request;

import java.util.Random;
import java.util.ArrayList;
import com.wokabel.app.wokabel.Models.Vocable;

public class RequestViewModel {

    private RequestService algorithm;
    private int mode;

    public RequestViewModel(ArrayList<Vocable> input, int i)
    {
        algorithm = new AbfrageService(input);
        mode = i; //mode zeigt an welcher Abfragemodus ausgewählt ist; 0 = key --> value, 1 = value --> key; erweiterbar nach belieben deswegen Int
    }
    public String getQuestion(){
        return algorithm.getQuestion(mode);
    }

    public String getHelper(){
        return algorithm.getHelper();
    }

    public String getAnswer(){
        return algorithm.getAnswer(mode);
    }

    public boolean handleAnswer(String answer){
        return algorithm.handleAnswer(answer, mode);
    }
}