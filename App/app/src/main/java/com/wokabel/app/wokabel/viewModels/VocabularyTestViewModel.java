package com.wokabel.app.wokabel.viewModels;

import android.arch.lifecycle.ViewModel;

import com.wokabel.app.wokabel.models.Vocable;
import com.wokabel.app.wokabel.services.vocabularyTest.VocabularyTest;

import java.util.ArrayList;

public class VocabularyTestViewModel extends ViewModel {

    private VocabularyTest algorithm;

    public VocabularyTestViewModel(ArrayList<Vocable> input, VocabularyTest.Modes mode, VocabularyTest.Difficulty difficulty)
    {
        algorithm = new VocabularyTest(input, mode, difficulty);
    }

    public String getQuestion() {
        try {
            return algorithm.getQuestion();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "EXCEPTION!";
        }
    }

    public String getHelper() {
        return algorithm.getHelper();
    }

    public String getAnswer() {
        try {
            return algorithm.getAnswer();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "EXCEPTION!";
        }
    }

    public boolean handleAnswer(String answer) {
        try {
            return algorithm.handleAnswer(answer);
        }  catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    public boolean isEmpty(){
        return algorithm.isFinish();
    }
}