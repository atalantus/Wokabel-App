package com.wokabel.app.wokabel;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.wokabel.app.wokabel.models.Vocable;

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
public class VocableInstrumentedTest {

    private Vocable test;

    @Before
    public void setUp()
    {
        test =  new Vocable("test", "Prüfung, Test, Probe, Versuch, Untersuchung", "Etwas worauf Schüler nie Lust haben.", "01", 3, "99");
    }

    @Test
    public void valuesTest() {
        assertEquals("Prüfung, Test, Probe, Versuch, Untersuchung", test.getValues());
        ArrayList<String> valuesList = new ArrayList<>(Arrays.asList("Prüfung","Test","Probe","Versuch","Untersuchung"));
        ArrayList<String> vocabValuesList = test.getValuesList();
        assertEquals(valuesList, vocabValuesList);
    }
}
