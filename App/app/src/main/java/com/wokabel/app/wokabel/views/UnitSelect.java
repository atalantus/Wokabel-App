package com.wokabel.app.wokabel.views;

import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.wokabel.app.wokabel.R;

import java.util.ArrayList;

public class UnitSelect extends AppCompatActivity {

    private static final String TAG = "UnitSelect";

    private RecyclerView recyclerView;

    private ArrayList<String> mNames = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_select);
        Log.d(TAG, "onCreate: started.");

    }


    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        recyclerView = this.findViewById(R.id.recycler_view);
        initBitmap();
    }

    private void initBitmap(){

        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        //TODO: mNames.add(model.getSupergroups().getName());
        mNames.add("Unit1"); //noch mit strings.xml verknüpfen
        mNames.add("Unit2"); //noch mit strings.xml verknüpfen

        initRecyclerView();

    }

    private void initRecyclerView() {

        Log.d(TAG, "initRecyclerView: inti recyclerView.");

        UnitSelectAdapter adapter = new UnitSelectAdapter(mNames, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void createSubject(View view) {
        Snackbar.make(view, "Hier sollte jetzt ne neue Activity zum Erstellen eines Subjects sein!", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

}
