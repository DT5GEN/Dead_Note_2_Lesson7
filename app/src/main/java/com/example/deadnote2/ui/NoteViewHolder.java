package com.example.deadnote2.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.deadnote2.R;
import com.example.deadnote2.domain.NoteEntity;

public class NoteViewHolder extends RecyclerView.ViewHolder {

    private final TextView nameTextView = itemView.findViewById(R.id.preview_edit_text);
    private final CardView rootCardView = itemView.findViewById(R.id.root_card_view);
    private final TextView numberTextView = itemView.findViewById(R.id.heading_edit_text);
    private final AppCompatImageView refreshImageView = itemView.findViewById(R.id.item_color__refresh_image_view);
    private final AppCompatImageView deleteImageView = itemView.findViewById(R.id.item_color__delete_image_view);

    @NonNull
    private NoteEntity noteEntity;

    public NoteViewHolder(@NonNull ViewGroup parent,
                          int holderNumber,
                          OnItemsClickListener onItemsClickListener
    ) {
        // запоминает созданные вьюшки, razduvayet i  napolnyaet i hranit na sebya ssilki
        super(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_color, parent, false));
        numberTextView.setText(" " + holderNumber);
//        View view = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.item_color, parent, false);
//        super(view);
        deleteImageView.setOnClickListener(v -> {
            onItemsClickListener.onDeleteItem(noteEntity);
        });
        refreshImageView.setOnClickListener(v -> {
            onItemsClickListener.onRefreshItem(noteEntity);
        });
        rootCardView.setOnClickListener(v -> {
            onItemsClickListener.onClickItem(noteEntity);
        });
        rootCardView.setOnLongClickListener(v -> {
            onItemsClickListener.onDeleteItem(noteEntity);
            return true;
        });
    }

    public void bind(NoteEntity item) {
        //  наполняем вьюшку значениями
        // getContext(). mojno polu4at' context
        nameTextView.setText("#" + item.getHexString());
        rootCardView.setCardBackgroundColor(item.getColor());

        noteEntity = item; // когда происходит бинд у нас что-то создаётся
    }


    private Context getContext() {
        return itemView.getContext();
    }


    public interface OnItemsClickListener {
        void onDeleteItem(NoteEntity item);

        void onRefreshItem(NoteEntity item);

        void onClickItem(NoteEntity item);

        void onCreateItem(NoteEntity item);


    }
}
