package com.example.deadnote2.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.deadnote2.R;
import com.example.deadnote2.data.SimpleColorsRepoImpl;
import com.example.deadnote2.domain.ColorsRepo;

public class MainActivity extends AppCompatActivity {
    private ColorsRepo colorsRepo = new SimpleColorsRepoImpl();

    private ColorsAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initRecycler();

    }

    private void initRecycler() {
        recyclerView = findViewById(R.id.activity_main__recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ColorsAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setData(colorsRepo.getColors());
    }
}