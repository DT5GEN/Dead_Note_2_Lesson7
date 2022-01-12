package com.example.deadnote2.ui;

import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.deadnote2.domain.ColorEntity;

import java.util.ArrayList;
import java.util.List;

public class ColorsAdapter extends RecyclerView.Adapter<ColorViewHolder> {

    private int holdersCounters = 0;
    private ColorViewHolder.OnItemsClickListener onItemClickListener = null;

    // hranit kopiyu dannih
    private final List<ColorEntity> data = new ArrayList<>();

    @NonNull
    @Override
    public ColorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // sozdayutsa view holdery
        return new ColorViewHolder(parent, holdersCounters++, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ColorViewHolder holder, int position) {
        // privyazyvaet znacheniya
        ColorEntity colorEntity = getItem(position);
        holder.bind(colorEntity);
    }

    private ColorEntity getItem(int position) {
        // vichislenie konkretnoi pozicii
        return data.get(position);
    }

    @Override
    public int getItemCount() {
        // skolko vsego dannih
        return data.size();
    }

    public void setData(List<ColorEntity> colors) {
        // ustanovka dannih i refresh
        data.clear();
        data.addAll(colors);
        notifyDataSetChanged();
    }

    public void deleteItem(String itemId){

        for (int i = 0; i < data.size(); i++) {
             if (data.get(i).getId().equals(itemId)){
                data.remove(i);
                notifyItemRemoved(i);
                return;
            }
        }
    }

    public void setOnItemClickListener(ColorViewHolder.OnItemsClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


}
