package com.wokabel.app.wokabel.room;

import android.arch.persistence.room.Room;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.wokabel.app.wokabel.LiveDataTestUtil;
import com.wokabel.app.wokabel.models.Subgroup;
import com.wokabel.app.wokabel.services.room.SubgroupDao;
import com.wokabel.app.wokabel.services.room.WokabelDatabase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static com.wokabel.app.wokabel.room.TestData.SUBGROUPS;
import static com.wokabel.app.wokabel.room.TestData.SUBGROUP_ENTITY;
import static com.wokabel.app.wokabel.room.TestData.SUPERGROUPS;
import static junit.framework.Assert.assertTrue;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class SubgroupDaoInstrumentedTest {

    private WokabelDatabase mDatabase;
    private SubgroupDao mSubgroupDao;

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

        mSubgroupDao = mDatabase.getSubgroupDao();
    }

    @After
    public void closeDb() throws Exception {
        mDatabase.close();
    }

    @Test
    public void getSubgroupsWhenNoSubgroupsInserted() throws InterruptedException {
        List<Subgroup> subgroups = LiveDataTestUtil.getValue(mSubgroupDao.getAllSubgroups());

        assertTrue(subgroups.isEmpty());
    }

    @Test
    public void getSubgroupsAfterInserted() throws InterruptedException {
        mDatabase.getSupergroupDao().insertAll(SUPERGROUPS);

        mDatabase.getSubgroupDao().insertAll(SUBGROUPS);

        List<Subgroup> subgroups = LiveDataTestUtil.getValue(mSubgroupDao.getAllSubgroups());

        assertThat(subgroups.size(), is(SUBGROUPS.size()));
    }

    @Test
    public void getSubgroupById() throws InterruptedException {
        mDatabase.getSupergroupDao().insertAll(SUPERGROUPS);

        mDatabase.getSubgroupDao().insertAll(SUBGROUPS);

        Subgroup subgroup = LiveDataTestUtil.getValue(mSubgroupDao.getSubgroupById
                (SUBGROUP_ENTITY.getId()));

        assertThat(subgroup.getId(), is(SUBGROUP_ENTITY.getId()));
        assertThat(subgroup.getName(), is(SUBGROUP_ENTITY.getName()));
        assertThat(subgroup.getSupergroupid(), is(SUBGROUP_ENTITY.getSupergroupid()));
    }
}
