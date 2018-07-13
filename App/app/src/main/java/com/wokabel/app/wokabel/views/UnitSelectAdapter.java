package com.wokabel.app.wokabel.views;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.wokabel.app.wokabel.R;

import java.util.ArrayList;

public class UnitSelectAdapter extends RecyclerView.Adapter<UnitSelectAdapter.ViewHolder>{

    private static final String TAG = "SubjectSelectAdapter";

    private ArrayList<String> mNames = new ArrayList<>();
    private Context mContext;

    public UnitSelectAdapter(ArrayList<String> Names, Context context)
    {
        mNames = Names;
        mContext = context;
        
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_unit, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        Log.d(TAG, "onBindViewHolder: called.");

        //Glide.with(mContext).asBitmap().load(mImages.get(position)).into(holder.icon);

        holder.name.setText(mNames.get(position));

        //WAS beim klicken passiert WICHTIG!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on: " + mNames.get(position));


                //Action: Neue Activitie Aufrufen
            }
        });
    }

    @Override
    public int getItemCount() {
        return mNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        ImageButton editBtn;
        ConstraintLayout parentLayout;

        public ViewHolder(View itemView)
        {
            super(itemView);

            name = itemView.findViewById(R.id.subject_name);
            editBtn = itemView.findViewById(R.id.subject_editBtn);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }

}
