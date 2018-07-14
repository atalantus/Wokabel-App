package com.wokabel.app.wokabel;

import com.wokabel.app.wokabel.models.Vocable;
import com.wokabel.app.wokabel.services.vocabularyTest.VocabularyTest;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static com.wokabel.app.wokabel.services.vocabularyTest.VocabularyTest.Difficulty.EASY;
import static com.wokabel.app.wokabel.services.vocabularyTest.VocabularyTest.Difficulty.HARD;
import static com.wokabel.app.wokabel.services.vocabularyTest.VocabularyTest.Difficulty.NOTIME;
import static com.wokabel.app.wokabel.services.vocabularyTest.VocabularyTest.Modes.KEY_VALUE;
import static com.wokabel.app.wokabel.services.vocabularyTest.VocabularyTest.Modes.RANDOM;
import static com.wokabel.app.wokabel.services.vocabularyTest.VocabularyTest.Modes.VALUE_KEY;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class VocabularyTestTest {

    private ArrayList<Vocable> testVocables;
    private Vocable tree = new Vocable("tree", "Baum", "Fängt mit B an und existiert im Wald.", "0", 1, "99");
    private Vocable car = new Vocable("car", "Auto, Fahrzeug", "Brum brum", "1", 1, "99");
    private Vocable flower = new Vocable("flower", "Blume", "Gibts auf Wiese und im Laden", "2", 3, "99");
    private Vocable toPay = new Vocable("to pay", "bezahlen, zahlen, entrichten, vergüten, entlohnen, rentieren, sich lohnen für, sich auszahlen für", "Nach dem Kauf ....... man", "3", 5, "99");
    private Vocable house = new Vocable("house", "Haus, Haushalt", "Da wohnst du drinnen", "4", 4, "99");
    private Vocable cellphone = new Vocable("cellphone", "Handy", "Nutzt du jeden Tag", "5", 4, "99");
    private Vocable table = new Vocable("table", "Tisch", "Kann man was draufstellen", "6", 2, "99");
    private Vocable bike = new Vocable("bike", "Fahrrad", "2 Räder, selber treten", "7", 1, "99");
    private Vocable toJump = new Vocable("to jump", "springen", "Gegeneil von fallen", "8", 2, "99");
    private Vocable toFall = new Vocable("to fall", "fallen", "Gegenteil von springen", "9", 1, "99");
    private Vocable forest = new Vocable("forest", "Wald", "Den ... vor lauter Bäumen nicht mehr sehen", "10", 5, "99");

    @Before
    public void setUp() {
        testVocables = new ArrayList<>(Arrays.asList(tree, car, flower, toPay, house, cellphone, table, bike, toJump, toFall, forest));

    }

    @Test
    public void mode_keyValue() {
        // TODO: Key -> Value tests
        VocabularyTest testing = new VocabularyTest(testVocables, VocabularyTest.Modes.KEY_VALUE, VocabularyTest.Difficulty.EASY);
        while(testing.isFinish() == false){
            try{
                System.out.println("Question: " +testing.getQuestion());
                System.out.println("Answer: " + testing.getAnswer());
                System.out.println("handleAnser: " + testing.handleAnswer(testing.getAnswer()));
            }catch (Exception e){
                System.out.println(e);
                break;
            }
        }
    }

    @Test
    public void mode_valueKey() {
        // TODO: Value -> Key tests
        VocabularyTest testing = new VocabularyTest(testVocables, VocabularyTest.Modes.VALUE_KEY, VocabularyTest.Difficulty.HARD);
        while(testing.isFinish() == false){
            try{
                System.out.println("Value Question: " +testing.getQuestion());
                System.out.println("Value Answer: " + testing.getAnswer());
                System.out.println("Value handleAnser: " + testing.handleAnswer(testing.getAnswer()));
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
    }
}
