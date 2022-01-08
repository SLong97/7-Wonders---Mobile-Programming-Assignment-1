package com.example.thesevenwonders;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class WondersAdapter extends RecyclerView.Adapter<WondersAdapter.ViewHolder>{

    ArrayList<Wonder> wonderNames = new ArrayList<>();
    Context context;

    public WondersAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.wonders_list, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.tvwonder.setText(wonderNames.get(position).getWonderName());
        holder.tvlocation.setText(wonderNames.get(position).getWonderLocation());
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,wonderNames.get(position).getWonderName() + " Selected", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, WonderActivity.class);
                intent.putExtra("wonderName", wonderNames.get(position).getWonderName());
                intent.putExtra("wonderLocation", wonderNames.get(position).getWonderLocation());
                intent.putExtra("wonderImage", wonderNames.get(position).getWonderImageURL());
                intent.putExtra("wonderInfo", wonderNames.get(position).getWonderInformation());
                intent.putExtra("wonderCode",wonderNames.get(position).getMapCode());
                context.startActivity(intent);

            }
        });

        Glide.with(context)
                .asBitmap()
                .load(wonderNames.get(position).getWonderImageURL())
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return wonderNames.size();
    }

    public void setWonderNames(ArrayList<Wonder> wonderNames) {
        this.wonderNames = wonderNames;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvwonder, tvlocation;
        CardView parent;
        ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvwonder = itemView.findViewById(R.id.tvwonder);
            parent = itemView.findViewById(R.id.parent);
            tvlocation = itemView.findViewById(R.id.tvlocation);
            image = itemView.findViewById(R.id.image);
        }
    }


}
