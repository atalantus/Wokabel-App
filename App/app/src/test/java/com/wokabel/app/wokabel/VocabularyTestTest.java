package com.wokabel.app.wokabel;

import com.wokabel.app.wokabel.services.vocabularyTest.VocabularyTest;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class VocabularyTestTest {
    
    private ArrayList<Vocable> testVocables;

    @Before
    public void setUp()
    {
        testVocables = new ArrayList<Vocable>(Arrays.asList(
            new Vocable("tree", new ArrayList<String>(Arrays.asList("Baum")), "Fängt mit B an und existiert im Wald.", "0"),
            new Vocable("car", new ArrayList<String>(Arrays.asList("Auto")), "Brum brum", "0"),
            new Vocable("flower", new ArrayList<String>(Arrays.asList("Blume")), "Gibts auf Wiese und im Laden", "0"),
            new Vocable("to pay", new ArrayList<String>(Arrays.asList("bezahlen")), "Nach dem Kauf ....... man", "0"),
            new Vocable("house", new ArrayList<String>(Arrays.asList("Haus")), "Da wohnst du drinnen", "0"),
            new Vocable("cellphone", new ArrayList<String>(Arrays.asList("Handy")), "Nutzt du jeden Tag", "0"),
            new Vocable("table", new ArrayList<String>(Arrays.asList("Tisch")), "Kann man was draufstellen", "0"),
            new Vocable("bike", new ArrayList<String>(Arrays.asList("Fahrrad")), "2 Räder, selber treten", "0"),
            new Vocable("to jump", new ArrayList<String>(Arrays.asList("springen")), "Gegeneil von fallen", "0"),
            new Vocable("to fall", new ArrayList<String>(Arrays.asList("fallen")), "Gegenteil von springen", "0"),
            new Vocable("forest", new ArrayList<String>(Arrays.asList("Wald")), "Den ...... vor lauter Bäumen nicht mehr sehen", "0")
            ));
    }

    @Test
    public void mode_keyValue() {
        // TODO: Key -> Value tests
        VocabularyTest testing = new VocabularyTestTest(testVocables, KEY_VALUE, EASY);
        

    }

    @Test
    public void mode_valueKey() {
        // TODO: Value -> Key tests
        VocabularyTest testing = new VocabularyTestTest(testVocables, VALUE_KEY, HARD);
    }

    @Test
    public void mode_random() {
        // TODO: Random tests
        VocabularyTest testing = new VocabularyTestTest(testVocables, RANDOM, NOTIME2);
    }
}
