package com.example.deadnote2.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.deadnote2.App;
import com.example.deadnote2.R;
import com.example.deadnote2.data.SimpleColorsRepoImpl;
import com.example.deadnote2.domain.ColorEntity;
import com.example.deadnote2.domain.ColorsRepo;

public class MainActivity extends AppCompatActivity {


    private ColorsAdapter adapter;
    private RecyclerView recyclerView;
    private LinearLayout rootLinearLayout;
    private Button scrollButton;

    private ColorsRepo colorsRepo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colorsRepo = App.get().colorsRepo;

        scrollButton = findViewById(R.id.activity_main__scroll_button);
            scrollButton.setOnClickListener(v -> {
                recyclerView.smoothScrollToPosition(adapter.getItemCount());
            });

        rootLinearLayout = findViewById(R.id.root_linear_layout);
        initRecycler();

    }

    private void initRecycler() {
        recyclerView = findViewById(R.id.activity_main__recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ColorsAdapter();
        recyclerView.setAdapter(adapter);
      //  App.get().colorsRepo.getColors(); заменяем в аргумент сет дата
        adapter.setData(colorsRepo.getColors());
        adapter.setOnItemClickListener(new ColorViewHolder.OnItemsClickListener() {

            @Override
            public void onDeleteItem(ColorEntity item) {
                Toast.makeText(MainActivity.this, "DELete " + item.getHexString(), Toast.LENGTH_SHORT).show();
                colorsRepo.deleteItem(item.getId());
                adapter.deleteItem(item.getId()); // заменяем setData, что бы поштучно вносить изменения
              //  adapter.setData(colorsRepo.getColors());
            }

            @Override
            public void onRefreshItem(ColorEntity item) {
                Toast.makeText(MainActivity.this, "Fresh " + item.getHexString(), Toast.LENGTH_SHORT).show();

            }
            // получаеm сообщение с + данные из ColorEntity
            @Override
            public void onClickItem(ColorEntity item) {
                rootLinearLayout.setBackgroundColor(item.getColor());
            }
        });
    }

    private void onDeleteItem(ColorEntity colorEntity){
        Toast.makeText(this, "DELete " + colorEntity.getHexString(), Toast.LENGTH_SHORT).show();
    }
    private void onRefreshItem(ColorEntity colorEntity){
        Toast.makeText(this, "Fresh " + colorEntity.getHexString(), Toast.LENGTH_SHORT).show();
    }
    // получаеm сообщение с + данные из ColorEntity
    private void onClickItem(ColorEntity colorEntity){
        Toast.makeText(this, "Root " + colorEntity.getHexString(), Toast.LENGTH_SHORT).show();
    }
}