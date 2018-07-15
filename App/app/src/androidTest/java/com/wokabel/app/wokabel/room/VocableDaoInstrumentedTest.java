package com.wokabel.app.wokabel.room;

import android.arch.persistence.room.Room;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.wokabel.app.wokabel.LiveDataTestUtil;
import com.wokabel.app.wokabel.models.Vocable;
import com.wokabel.app.wokabel.services.room.VocableDao;
import com.wokabel.app.wokabel.services.room.WokabelDatabase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static com.wokabel.app.wokabel.room.TestData.SUBGROUPS;
import static com.wokabel.app.wokabel.room.TestData.SUPERGROUPS;
import static com.wokabel.app.wokabel.room.TestData.VOCABLES;
import static com.wokabel.app.wokabel.room.TestData.VOCABLE_ENTITY;
import static junit.framework.Assert.assertTrue;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class VocableDaoInstrumentedTest {

    private WokabelDatabase mDatabase;
    private VocableDao mVocableDao;

    @Before
    public void initDb() throws Exception
    {
        // using an in-memory database because the information stored here disappears when the
        // process is killed
        mDatabase = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(),
                WokabelDatabase.class)
                // allowing main thread queries, just for testing
                .allowMainThreadQueries()
                .build();

        mVocableDao = mDatabase.getVocableDao();
    }

    @After
    public void closeDb() throws Exception {
        mDatabase.close();
    }

    @Test
    public void getVocablesWhenNoVocablesInserted() throws InterruptedException {
        List<Vocable> vocables = LiveDataTestUtil.getValue(mVocableDao.getAllVocables());

        assertTrue(vocables.isEmpty());
    }

    @Test
    public void getVocablesAfterInserted() throws InterruptedException {
        mDatabase.getSupergroupDao().insertAll(SUPERGROUPS);
        mDatabase.getSubgroupDao().insertAll(SUBGROUPS);

        mVocableDao.insertAll(VOCABLES);

        List<Vocable> vocables = LiveDataTestUtil.getValue(mVocableDao.getAllVocables());

        assertThat(vocables.size(), is(VOCABLES.size()));
    }

    @Test
    public void getVocableById() throws InterruptedException {
        mDatabase.getSupergroupDao().insertAll(SUPERGROUPS);
        mDatabase.getSubgroupDao().insertAll(SUBGROUPS);

        mVocableDao.insertAll(VOCABLES);

        Vocable vocable = LiveDataTestUtil.getValue(mVocableDao.getVocableById
                (VOCABLE_ENTITY.getId()));

        assertThat(vocable.getId(), is(VOCABLE_ENTITY.getId()));
        assertThat(vocable.getKey(), is(VOCABLE_ENTITY.getKey()));
        assertThat(vocable.getValuesList(), is(VOCABLE_ENTITY.getValuesList()));
        assertThat(vocable.getValues(), is(VOCABLE_ENTITY.getValues()));
        assertThat(vocable.getHelper(), is(VOCABLE_ENTITY.getHelper()));
        assertThat(vocable.getLevel(), is(VOCABLE_ENTITY.getLevel()));
        assertThat(vocable.getSubgroupid(), is(VOCABLE_ENTITY.getSubgroupid()));
    }
}
