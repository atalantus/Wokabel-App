package com.wokabel.app.wokabel.views;

import android.content.Context;
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
import com.wokabel.app.wokabel.models.Supergroup;

import java.util.ArrayList;
import java.util.List;

public class SubjectSelectAdapter extends RecyclerView.Adapter<SubjectSelectAdapter.ViewHolder>{

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
    public static final String SELECTED_SUPERGROUP_ID = "com.wokabel.app.wokabel.SELECTED_SUPERGROUP_ID";
    public static final String SELECTED_SUPERGROUP_NAME = "com.wokabel.app.wokabel.SELECTED_SUPERGROUP_NAME";
    public static final String SELECTED_SUPERGROUP_EDIT = "com.wokabel.app.wokabel.SELECTED_SUPERGROUP_EDIT";

    private List<Supergroup> mSupergroups;
    //private ArrayList<String> mImages;
    private Context context;
    private final LayoutInflater inflater;

    public SubjectSelectAdapter(Context iContext)
    {
        inflater = LayoutInflater.from(iContext);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item_subject, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        Log.d(TAG, "onBindViewHolder: called.");
        Log.d(TAG,"Supergroups loaded");
        Supergroup current = mSupergroups.get(position);
        holder.name.setText(current.getName());
        holder.editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ID = mSupergroups.get(position).getId();
                String name = mSupergroups.get(position).getName();
                Intent intent = new Intent(view.getContext(), EditSubject.class);
                intent.putExtra(SELECTED_SUPERGROUP_NAME, name);
                intent.putExtra(SELECTED_SUPERGROUP_ID, ID);
                intent.putExtra(SELECTED_SUPERGROUP_EDIT, "true");
                view.getContext().startActivity(intent);
            }
        });
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on: " + mSupergroups.get(position).getId());
                String ID = mSupergroups.get(position).getId();
                //Action: Neue Activitie Aufrufen
                Intent intent = new Intent(view.getContext(), UnitSelect.class);
                intent.putExtra(SELECTED_SUPERGROUP_ID, ID);
                intent.putExtra(SELECTED_SUPERGROUP_NAME, mSupergroups.get(position).getName());
                view.getContext().startActivity(intent);
            }
        });
    }

    public void setmSupergroups(ArrayList<Supergroup> supergroups){
        mSupergroups = supergroups;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mSupergroups != null){
            return mSupergroups.size();
        } else return 0;
    }
}
