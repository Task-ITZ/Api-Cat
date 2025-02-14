package com.example.apiCat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.CatViewHolder> {
    private Context context;
    private List<CatImage> catImageList;

    public CatAdapter(Context context, List<CatImage> catImageList) {
        this.context = context;
        this.catImageList = catImageList;
    }

    @NonNull
    @Override
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_image_cat, parent, false);
        return  new CatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatAdapter.CatViewHolder holder, int position) {
        Glide.with(context)
                .load(catImageList.get(position).getUrl())
                .into(holder.imgCat);
    }

    @Override
    public int getItemCount() {
        return catImageList.size();
    }
    public static class CatViewHolder extends RecyclerView.ViewHolder{
        ImageView imgCat;

        public CatViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCat = itemView.findViewById(R.id.img_cat);
        }
    }
}
