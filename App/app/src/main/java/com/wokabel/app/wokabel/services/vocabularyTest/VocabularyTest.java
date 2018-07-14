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

    public enum Difficulty {
        NOTIME,
        EASY,
        NORMAL,
        HARD
    }

    // Der Abfrage Modus
    private Modes mode;
    private ArrayList<Vocable> randomsorted;
    private Vocable currentVoc;
    private long starttime = System.currentTimeMillis();
    private int timecount;
    private Difficulty dif;
    boolean keyvalue;

    /**
     * Konstruktor
     *
     * @param input    Die Vokabeln die abgefragt werden sollen
     * @param testMode Der Modus der Abfrage
     * @param testTime Dauer der Ausfrage in Sekunden
     */
    public VocabularyTest(ArrayList<Vocable> input, Modes testMode, Difficulty testTime) {
        mode = testMode;
        dif = testTime;
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

        for (int i = 0; i < randomsorted.size(); i++) {
            switch (dif) {
                case NOTIME:
                    timecount = 0;
                    i = randomsorted.size();
                    break;
                case EASY:
                    timecount += 20;
                    break;
                case NORMAL:
                    timecount += 15;
                    break;
                case HARD:
                    timecount += 10;
                    break;

            }

        }
    }

    /**
     * getQuestion
     *
     * @return Frage der Vokabel
     * @throws Exception
     */
    public String getQuestion() throws Exception {
        currentVoc = randomsorted.get(0);
        Modes currentMode = mode;
        while (true) {
            switch (currentMode) {
                case KEY_VALUE:
                    keyvalue = true;
                    return currentVoc.getKey();
                case VALUE_KEY:
                    ArrayList<String> temp = currentVoc.getValuesList();
                    String ValueString = "";

                    for (String s : temp) {
                        ValueString += s;
                        ValueString += ", ";
                    }
                    keyvalue = false;
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
     * @return Helfer (falls man nicht mehr weiter weiß)
     */
    public String getHelper() {
        return currentVoc.getHelper();
    }

    /**
     * @param answer Antwort des Nutzers
     * @return ob Antwort richtig oder falsch ist
     * @throws Exception
     */
    public boolean handleAnswer(String answer) throws Exception {
        Modes currentMode = mode;
        while (true) {
            switch (currentMode) {
                case KEY_VALUE:
                    answer = answer.replace(",", "");
                    answer = answer.replace(" ", "");

                    ArrayList<String> temp = currentVoc.getValuesList();

                    for (String s : temp) {
                        s = s.replace(",", "");
                        s = s.replace(" ", "");
                        if (s.equals(answer)) {
                            return true;
                        }
                    }
                    return false;
                case VALUE_KEY:
                    return answer.equals(currentVoc.getKey()); //answer is right
                case RANDOM:
                    if (keyvalue) {
                        currentMode = Modes.KEY_VALUE;
                    }else{
                        currentMode = Modes.VALUE_KEY;
                    }
                default:
                    throw new Exception("Der Abfrage Modus '" + mode.toString() + "' wurde noch nicht in handleAnswer() implementiert!");
            }
        }


    }

    /**
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
            case RANDOM:
                if (keyvalue) {
                    ArrayList<String> temp2 = currentVoc.getValuesList();

                    for (String s : temp2) {
                        answer += s;
                        answer += ", ";
                    }
                    break;
                }else{
                    answer = currentVoc.getKey();
                    break;
                }
        }

        if (!answer.equals("")) {
            if (randomsorted.size() != 0) {
                randomsorted.remove(0);
            }
            return answer;
        }

        throw new Exception("Der Abfrage Modus '" + mode.toString() + "' wurde noch nicht in getAnswer() implementiert!");
    }

    public boolean isFinish() {
        if (timecount == 0) {
            return randomsorted.size() == 0;
        } else {
            if (System.currentTimeMillis() - starttime >= timecount || randomsorted.size() == 0) {
                return true;
            } else {
                return false;
            }
        }
    }

    public ArrayList<Vocable> getRandomSorted() {
        return randomsorted;
    }
}