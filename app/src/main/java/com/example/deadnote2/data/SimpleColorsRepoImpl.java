package com.example.deadnote2.data;

import androidx.core.graphics.ColorUtils;

import com.example.deadnote2.domain.ColorEntity;
import com.example.deadnote2.domain.ColorsRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class SimpleColorsRepoImpl implements ColorsRepo {
    private static final int COLORS_LIST_SIZE = 100;

    private List<ColorEntity> data = new ArrayList<>();

    public SimpleColorsRepoImpl(){
        regenerateColors(COLORS_LIST_SIZE);
    }


    @Override
    public List<ColorEntity> getColors() {
        return new ArrayList<>(data);

    }

    public void regenerateColors(int size) {
        for (int i = 0; i < size; i++) {
            ColorEntity colorEntity = new ColorEntity(
                    UUID.randomUUID().toString(),
                    ColorUtils.setAlphaComponent(new Random().nextInt(), 255)
            );
            data.add(colorEntity);

        }
    }


}
