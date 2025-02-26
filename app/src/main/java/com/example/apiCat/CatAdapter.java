package com.example.apiCat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.CatViewHolder> {
    private List<CatImage> catImageList = new ArrayList<>();

    public void setCatAdapter(List<CatImage> cats) {
        this.catImageList = cats;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image_cat, parent, false);
        return  new CatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatViewHolder holder, int position) {
        Glide.with(holder.imgCat.getContext())
                .load(catImageList.get(position).getUrl())
                .fitCenter()
                .into(holder.imgCat);
    }

    @Override
    public int getItemCount() {
        return catImageList.size();
    }
    static class CatViewHolder extends RecyclerView.ViewHolder{
        ImageView imgCat;

        public CatViewHolder(View itemView) {
            super(itemView);
            imgCat = itemView.findViewById(R.id.img_cat);
        }
    }
}
