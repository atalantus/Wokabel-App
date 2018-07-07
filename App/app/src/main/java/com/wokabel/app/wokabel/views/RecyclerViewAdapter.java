package com.wokabel.app.wokabel.views;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wokabel.app.wokabel.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> mImagesNames = new ArrayList<>();
    private ArrayList<String> mImages = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(ArrayList<String> imagesNames, ArrayList<String> images, Context context)
    {
        mImagesNames = imagesNames;
        mImages = images;
        mContext = context;
        
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        Log.d(TAG, "onBindViewHolder: called.");

        Glide.with(mContext).asBitmap().load(mImages.get(position)).into(holder.image);

        holder.imageName.setText(mImagesNames.get(position));

        //WAS beim klicken passiert WICHTIG!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on: " + mImagesNames.get(position));


                //Action: Neue Activitie Aufrufen
            }
        });
    }

    @Override
    public int getItemCount() {
        return mImagesNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        CircleImageView image;
        TextView imageName;
        RelativeLayout parentLayout;
        public ViewHolder(View itemView)
        {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            imageName = itemView.findViewById(R.id.image_name);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }

}
