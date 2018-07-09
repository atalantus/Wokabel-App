package com.wokabel.app.wokabel.services.vocabularyTest;

import android.view.Display;

import java.util.Random;
import java.util.ArrayList;
import java.util.Timer;

import com.wokabel.app.wokabel.models.Vocable;

public class VocabularyTest {

    // Die verschiedenen Abfrage Modi
    public enum Modes {
        KEY_VALUE,
        VALUE_KEY,
        RANDOM
    }

    // Der Abfrage Modus
    private Modes mode;
    private ArrayList<Vocable> randomsorted;
    private Vocable currentVoc;
    private long starttime = System.currentTimeMillis();
    private int timecount;
    /**
     * Konstruktor
     *
     * @param input    Die Vokabeln die abgefragt werden sollen
     * @param testMode Der Modus der Abfrage
     */
    public VocabularyTest(ArrayList<Vocable> input, Modes testMode, int seconds) {
        timecount = seconds;
        mode = testMode;
        Random rand = new Random();
        randomsorted = new ArrayList<>();
        ArrayList<Vocable> a = new ArrayList<>();
        currentVoc = null;

        for (int i = 0; i < input.size(); i++) {
            for (int l = 5; l > input.get(i).getLevel() - 1; l--) {
                a.add(input.get(i));
            }
        }
        while (a.size() > 0) {
            int randnum = rand.nextInt(a.size());
            randomsorted.add(a.get(randnum));
            a.remove(randnum);
        }
    }

    /**
     * getQuestion
     * @return Frage der Vokabel
     * @throws Exception
     */
    public String getQuestion() throws Exception {
        currentVoc = randomsorted.get(0);
        Modes currentMode = mode;
        while (true) {
            switch (currentMode) {
                case KEY_VALUE:
                    return currentVoc.getKey();
                case VALUE_KEY:
                    ArrayList<String> temp = currentVoc.getValuesList();
                    String ValueString = "";

                    for (String s : temp) {
                        ValueString += s;
                        ValueString += ", ";
                    }
                    return ValueString;
                case RANDOM:
                    Random rand = new Random();
                    int randnum = rand.nextInt(2);
                    if (randnum == 0) {
                        currentMode = Modes.KEY_VALUE;
                    } else {
                        currentMode = Modes.VALUE_KEY;
                    }
                    break;
                default:
                    throw new Exception("Der Abfrage Modus '" + mode.toString() + "' wurde noch nicht in getQuestion() implementiert!");
            }
        }
    }

    /**
     *
     * @return Helfer (falls man nicht mehr weiter weiß)
     */
    public String getHelper() {
        return currentVoc.getHelper();
    }

    /**
     *
     * @param answer Antwort des Nutzers
     * @return ob Frage richtig oder falsch ist
     * @throws Exception
     */
    public boolean handleAnswer(String answer) throws Exception {
        switch (mode) {
            case KEY_VALUE:
                ArrayList<String> temp = currentVoc.getValuesList();

                for (String s : temp) {
                    if (s.equals(answer)) {
                        return true;
                    }
                }
                return false;
            case VALUE_KEY:
                return answer.equals(currentVoc.getKey()); //answer is right
        }

        throw new Exception("Der Abfrage Modus '" + mode.toString() + "' wurde noch nicht in handleAnswer() implementiert!");
    }

    /**
     *
     * @return die Antwort (ohne zu checken ob richtig oder falschs
     * @throws Exception
     */
    public String getAnswer() throws Exception {
        String answer = "";

        switch (mode) {
            case KEY_VALUE:
                ArrayList<String> temp = currentVoc.getValuesList();

                for (String s : temp) {
                    answer += s;
                    answer += ", ";
                }
                break;
            case VALUE_KEY:
                answer = currentVoc.getKey();
                break;
        }

        if (!answer.equals("")) {
            randomsorted.remove(0);
            return answer;
        }

        throw new Exception("Der Abfrage Modus '" + mode.toString() + "' wurde noch nicht in getAnswer() implementiert!");
    }
    public boolean isFinish(){
        if(timecount == 0){
            return randomsorted.size() == 0;
        }else{
            if(System.currentTimeMillis() - starttime >= timecount || randomsorted.size() == 0){
                return true;
            }else{
                return false;
            }
        }

    }
}