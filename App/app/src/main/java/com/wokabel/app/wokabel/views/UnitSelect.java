package com.wokabel.app.wokabel.views;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.wokabel.app.wokabel.R;
import com.wokabel.app.wokabel.viewModels.UnitSelectViewModel;

public class UnitSelect extends AppCompatActivity {

    UnitSelectViewModel model;
    public UnitSelect(){
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_select);

        model = ViewModelProviders.of(this).get(UnitSelectViewModel.class);
        setTitle("Test");
        //start();
        //setTitle(model.getSelectedSupergroup());
    }
    public void start(){

        setTitle(model.getSelectedSupergroup());
        model.setSelectedSupergroup(getIntent().getStringExtra(RecyclerViewAdapter.EXTRA_MESSAGE));
    }
}
