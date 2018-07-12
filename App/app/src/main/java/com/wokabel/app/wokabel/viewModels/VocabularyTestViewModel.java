package com.wokabel.app.wokabel.viewModels;

import java.util.ArrayList;
import com.wokabel.app.wokabel.models.Vocable;
import com.wokabel.app.wokabel.services.vocabularyTest.VocabularyTest;

public class VocabularyTestViewModel {

    private VocabularyTest algorithm;

    public VocabularyTestViewModel(ArrayList<Vocable> input, VocabularyTest.Modes mode)
    {
        algorithm = new VocabularyTest(input, mode);
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
}