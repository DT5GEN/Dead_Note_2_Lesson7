package com.example.deadnote2.ui;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.deadnote2.domain.NoteEntity;

import java.util.ArrayList;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NoteViewHolder> {

    private int holdersCounters = 0;
    private NoteViewHolder.OnItemsClickListener onItemClickListener = null;

    // hranit kopiyu dannih
    private final List<NoteEntity> data = new ArrayList<>();

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // sozdayutsa view holdery
        return new NoteViewHolder(parent, holdersCounters++, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        // privyazyvaet znacheniya
        NoteEntity noteEntity = getItem(position);
        holder.bind(noteEntity);
    }

    private NoteEntity getItem(int position) {
        // vichislenie konkretnoi pozicii
        return data.get(position);
    }

    @Override
    public int getItemCount() {
        // skolko vsego dannih
        return data.size();
    }

    public void setData(List<NoteEntity> colors) {
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

    public void setOnItemClickListener(NoteViewHolder.OnItemsClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


}
