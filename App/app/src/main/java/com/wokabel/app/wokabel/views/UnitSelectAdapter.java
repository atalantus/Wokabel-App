package com.wokabel.app.wokabel.views;

import android.content.Intent;
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
    public static final String SELECTED_SUBGROUP_ID = "com.wokable.com.wokabel.SELECTED_SUBGROUP_ID";
    public static final String SELECTED_SUBGROUP_NAME = "com.wokable.com.wokabel.SELECTED_SUBGROUP_NAME";
    public static final String SELECTED_SUBGROUP_EDIT = "com.wokable.com.wokable.SEÖECTED_SUBGROUP_EDIT";
    public static final String SELECTED_SUPERGROUP_ID = "com.wokable.com.wokable.SELECTED_SUPERGROUP_ID";


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
        holder.name.setText(subgroups.get(position).getName());
        holder.editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ID = subgroups.get(position).getId();
                String name = subgroups.get(position).getName();
                Intent intent = new Intent(view.getContext(), EditUnit.class);
                intent.putExtra(SELECTED_SUBGROUP_NAME, name);
                intent.putExtra(SELECTED_SUBGROUP_ID, ID);
                intent.putExtra(SELECTED_SUBGROUP_EDIT, "true");
                view.getContext().startActivity(intent);
            }
        });
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on: " + subgroups.get(position).getName());
                //Action: Neue Activitie Aufrufen
                String ID = subgroups.get(position).getId();
                //Action: Neue Activitie Aufrufen
                Intent intent = new Intent(view.getContext(), UnitDisplay.class);
                intent.putExtra(SELECTED_SUBGROUP_ID, ID);
                intent.putExtra(SELECTED_SUBGROUP_NAME, subgroups.get(position).getName());
                view.getContext().startActivity(intent);
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
