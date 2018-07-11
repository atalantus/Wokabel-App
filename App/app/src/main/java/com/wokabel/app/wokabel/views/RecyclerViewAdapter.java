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
import android.widget.TextView;

import com.wokabel.app.wokabel.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";
    public static final String EXTRA_MESSAGE = "com.wokabel.app.wokabel.MESSAGE";

    private ArrayList<String> mImagesNames;
    //private ArrayList<String> mImages;
    private ArrayList<String> mIDs = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(ArrayList<String> imagesNames, ArrayList<String> images, Context context, ArrayList<String> ids)
    {
        mImagesNames = imagesNames;
        //mImages = images;
        mContext = context;
        mIDs = ids;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_subject, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        Log.d(TAG, "onBindViewHolder: called.");

        //Glide.with(mContext).asBitmap().load(mImages.get(position)).into(holder.icon);

        holder.name.setText(mImagesNames.get(position));

        //WAS beim klicken passiert WICHTIG!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on: " + mImagesNames.get(position));

                String ID = mIDs.get(position);
                //Action: Neue Activitie Aufrufen
                Intent intent = new Intent(view.getContext(), UnitSelect.class);
                intent.putExtra(EXTRA_MESSAGE, ID);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mImagesNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        CircleImageView icon;
        TextView name;
        ImageButton editBtn;
        ConstraintLayout parentLayout;

        public ViewHolder(View itemView)
        {
            super(itemView);
            icon = itemView.findViewById(R.id.subject_icon);
            name = itemView.findViewById(R.id.subject_name);
            editBtn = itemView.findViewById(R.id.subject_editBtn);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }

}
