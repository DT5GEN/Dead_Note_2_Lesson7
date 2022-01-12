package com.example.deadnote2.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.ColorUtils;
import androidx.recyclerview.widget.RecyclerView;

import com.example.deadnote2.R;
import com.example.deadnote2.domain.ColorEntity;

public class ColorViewHolder extends RecyclerView.ViewHolder {

    private final TextView nameTextView = itemView.findViewById(R.id.color_name_text_view);
    private final CardView rootCardView = itemView.findViewById(R.id.root_card_view);
    private final TextView numberTextView = itemView.findViewById(R.id.color_number_text_view);
    private final AppCompatImageView refreshImageView = itemView.findViewById(R.id.item_color__refresh_image_view);
    private final AppCompatImageView deleteImageView = itemView.findViewById(R.id.item_color__delete_image_view);

    @NonNull
    private ColorEntity colorEntity;

    public ColorViewHolder(@NonNull ViewGroup parent,
                           int holderNumber,
                           OnItemsClickListener onItemsClickListener
    ) {
        // запоминает созданные вьюшки, razduvayet i  napolnyaet i hranit na sebya ssilki
        super(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_color, parent, false));
        numberTextView.setText("№ " + holderNumber);
//        View view = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.item_color, parent, false);
//        super(view);
        deleteImageView.setOnClickListener(v -> {
            onItemsClickListener.onDeleteItem(colorEntity);
        });
        refreshImageView.setOnClickListener(v -> {
            onItemsClickListener.onRefreshItem(colorEntity);
        });
        rootCardView.setOnClickListener(v -> {
            onItemsClickListener.onClickItem(colorEntity);
        });
        rootCardView.setOnLongClickListener(v -> {
            onItemsClickListener.onDeleteItem(colorEntity);
            return true;
        });
    }

    public void bind(ColorEntity item) {
        //  наполняем вьюшку значениями
        // getContext(). mojno polu4at' context
        nameTextView.setText("#" + item.getHexString());
        rootCardView.setCardBackgroundColor(item.getColor());

        colorEntity = item; // когда происходит бинд у нас что-то создаётся
    }


    private Context getContext() {
        return itemView.getContext();
    }


    public interface OnItemsClickListener {
        void onDeleteItem(ColorEntity item);

        void onRefreshItem(ColorEntity item);

        void onClickItem(ColorEntity item);


    }
}
