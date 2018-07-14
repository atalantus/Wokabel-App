package com.wokabel.app.wokabel;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.wokabel.app.wokabel.models.Vocable;
import com.wokabel.app.wokabel.services.vocabularyTest.VocabularyTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class VocabularyTestInstrumentedTest {

    private ArrayList<Vocable> testVocables;
    private Vocable tree, car, flower, toPay, house, cellphone, table, bike, toJump, toFall, forest;

    @Before
    public void setUp() {
        tree = new Vocable("tree", "Baum", "Fängt mit B an und existiert im Wald.", "0", 1, "99");
        car = new Vocable("car", "Auto, Fahrzeug", "Brum brum", "1", 1, "99");
        flower = new Vocable("flower", "Blume", "Gibts auf Wiese und im Laden", "2", 3, "99");
        toPay = new Vocable("to pay", "bezahlen, zahlen, entrichten, vergüten, entlohnen, rentieren, sich lohnen für, sich auszahlen für", "Nach dem Kauf ....... man", "3", 5, "99");
        house = new Vocable("house", "Haus, Haushalt", "Da wohnst du drinnen", "4", 4, "99");
        cellphone = new Vocable("cellphone", "Handy", "Nutzt du jeden Tag", "5", 4, "99");
        table = new Vocable("table", "Tisch", "Kann man was draufstellen", "6", 2, "99");
        bike = new Vocable("bike", "Fahrrad", "2 Räder, selber treten", "7", 1, "99");
        toJump = new Vocable("to jump", "springen", "Gegeneil von fallen", "8", 2, "99");
        toFall = new Vocable("to fall", "fallen", "Gegenteil von springen", "9", 1, "99");
        forest = new Vocable("forest", "Wald", "Den ... vor lauter Bäumen nicht mehr sehen", "10", 5, "99");

        testVocables = new ArrayList<>(Arrays.asList(tree, car, flower, toPay, house, cellphone, table, bike, toJump, toFall, forest));
    }

    @Test
    public void mode_keyValue() {
        // TODO: Key -> Value tests
        VocabularyTest testing = new VocabularyTest(testVocables, VocabularyTest.Modes.KEY_VALUE, VocabularyTest.Difficulty.EASY);
        while(!testing.isFinish()) {
            try {
                String question = testing.getQuestion();
                String answer = null;
                if(question.equals("car")){ answer = "Auto";}
                else if (question.equals("to pay")){answer = "zahlen";}
                else if (question.equals("house")){answer = "Haus";}
                if (answer == null){
                    assertEquals(true, testing.handleAnswer(testing.getAnswer()));
                }else{
                    assertEquals(true,testing.handleAnswer(answer));
                }
            } catch (Exception e) {
                System.out.println(e);
                break;
            }
        }
    }

    @Test
    public void mode_valueKey() {
        // TODO: Value -> Key tests
        VocabularyTest testing = new VocabularyTest(testVocables, VocabularyTest.Modes.VALUE_KEY, VocabularyTest.Difficulty.HARD);
        while(!testing.isFinish()){
            try{
                testing.getQuestion();
                assertEquals(true,testing.handleAnswer(testing.getAnswer()));

            }catch (Exception e){
                System.out.println(e);
                break;
            }
        }
    }

    @Test
    public void mode_random() {
        // TODO: Random tests
        VocabularyTest testing = new VocabularyTest(testVocables, VocabularyTest.Modes.RANDOM, VocabularyTest.Difficulty.NOTIME);
        try{
            String question = testing.getQuestion();
            String answer = null;
            if(question.equals("car")){ answer = "Auto";}
            else if (question.equals("to pay")){answer = "zahlen";}
            else if (question.equals("house")){answer = "Haus";}
            if (answer == null){
                assertEquals(true, testing.handleAnswer(testing.getAnswer()));
            }else{
                assertEquals(true,testing.handleAnswer(answer));
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
