package com.wokabel.app.wokabel.views;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.wokabel.app.wokabel.R;
import com.wokabel.app.wokabel.models.Subgroup;

import java.util.ArrayList;


public class UnitSelectAdapter extends RecyclerView.Adapter<UnitSelectAdapter.ViewHolder>{

    class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView icon;
        private TextView name;
        private ImageButton editBtn;
        private ConstraintLayout parentLayout;

        private ViewHolder(View itemView)
        {
            super(itemView);
            icon = itemView.findViewById(R.id.subject_icon);
            name = itemView.findViewById(R.id.subject_name);
            editBtn = itemView.findViewById(R.id.subject_editBtn);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }

    private static final String TAG = "SubjectSelectAdapter";

    private ArrayList<Subgroup> subgroups;
    public UnitSelectAdapter() {
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_unit, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");
        holder.name.setText(subgroups.get(position).getName());
        //WAS beim klicken passiert WICHTIG!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on: " + subgroups.get(position).getName());
                //Action: Neue Activitie Aufrufen

            }
        });
    }

    @Override
    public int getItemCount() {
        if (subgroups != null){
        return subgroups.size();}
        return 0;
    }

    public ArrayList<Subgroup> getSubgroups() {
        return subgroups;
    }

    public void setSubgroups(ArrayList<Subgroup> subgroups) {
        this.subgroups = subgroups;
        notifyDataSetChanged();
    }

}
