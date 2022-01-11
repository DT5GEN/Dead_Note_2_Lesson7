package com.example.deadnote2.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.ColorUtils;
import androidx.recyclerview.widget.RecyclerView;

import com.example.deadnote2.R;
import com.example.deadnote2.domain.ColorEntity;

public class ColorViewHolder extends RecyclerView.ViewHolder {

    private final TextView nameTextView = itemView.findViewById(R.id.color_name_text_view);
    private final CardView rootCardView = itemView.findViewById(R.id.root_card_view);

    public ColorViewHolder(@NonNull ViewGroup parent) {
        // запоминает созданные вьюшки, razduvayet i  napolnyaet i hranit na sebya ssilki
        super(LayoutInflater.from(parent.getContext())
               .inflate(R.layout.item_color, parent, false));
//        View view = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.item_color, parent, false);
//        super(view);
    }

    public void bind(ColorEntity item) {
        //  наполняем вьюшку значениями
        // getContext(). mojno polu4at' context
        nameTextView.setText("#" + item.getHexString());
        rootCardView.setCardBackgroundColor(item.getColor());
           }

    private Context getContext(){
        return itemView.getContext();
    }
}
