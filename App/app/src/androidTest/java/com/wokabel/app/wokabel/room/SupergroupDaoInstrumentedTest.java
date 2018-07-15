package com.wokabel.app.wokabel.room;

import android.arch.persistence.room.Room;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.wokabel.app.wokabel.LiveDataTestUtil;
import com.wokabel.app.wokabel.models.Supergroup;
import com.wokabel.app.wokabel.services.room.SupergroupDao;
import com.wokabel.app.wokabel.services.room.WokabelDatabase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static com.wokabel.app.wokabel.room.TestData.SUPERGROUPS;
import static com.wokabel.app.wokabel.room.TestData.SUPERGROUP_ENTITY;
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
public class SupergroupDaoInstrumentedTest {

    private WokabelDatabase mDatabase;
    private SupergroupDao mSupergroupDao;

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

        mSupergroupDao = mDatabase.getSupergroupDao();
    }

    @After
    public void closeDb() throws Exception {
        mDatabase.close();
    }

    @Test
    public void getSupergroupsWhenNoSupergroupsInserted() throws InterruptedException {
        List<Supergroup> supergroups = LiveDataTestUtil.getValue(mSupergroupDao.getAllSupergroups());

        assertTrue(supergroups.isEmpty());
    }

    @Test
    public void getSupergroupsAfterInserted() throws InterruptedException {
        mDatabase.getSupergroupDao().insertAll(SUPERGROUPS);

        mSupergroupDao.insertAll(SUPERGROUPS);

        List<Supergroup> supergroups = LiveDataTestUtil.getValue(mSupergroupDao.getAllSupergroups());

        assertThat(supergroups.size(), is(SUPERGROUPS.size()));
    }

    @Test
    public void getSupergroupById() throws InterruptedException {
        mDatabase.getSupergroupDao().insertAll(SUPERGROUPS);

        mSupergroupDao.insertAll(SUPERGROUPS);

        Supergroup supergroup = LiveDataTestUtil.getValue(mSupergroupDao.getSupergroupById
                (SUPERGROUP_ENTITY.getId()));

        assertThat(supergroup.getId(), is(SUPERGROUP_ENTITY.getId()));
        assertThat(supergroup.getName(), is(SUPERGROUP_ENTITY.getName()));
        assertThat(supergroup.getIcon(), is(SUPERGROUP_ENTITY.getIcon()));
    }
}
