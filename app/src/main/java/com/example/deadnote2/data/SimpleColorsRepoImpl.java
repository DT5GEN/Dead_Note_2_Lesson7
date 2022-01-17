package com.example.deadnote2.data;

import androidx.core.graphics.ColorUtils;

import com.example.deadnote2.domain.ColorEntity;
import com.example.deadnote2.domain.ColorsRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class SimpleColorsRepoImpl implements ColorsRepo {
    private static final int COLORS_LIST_SIZE = 3;
    private static final int COLORS_1_SIZE = 1;

    private List<ColorEntity> data = new ArrayList<>();

    public SimpleColorsRepoImpl(){
        regenerateColors(COLORS_LIST_SIZE);
    }
    public void SimpleColorsRepoImpl2(){regenerateAddColors(COLORS_1_SIZE);}

    public  static ColorsRepo repo;
    public static ColorsRepo getInstance()
    {
        if (repo == null)
        {
            repo = new SimpleColorsRepoImpl();
        }
        return repo;
    }


    @Override
    public List<ColorEntity> getColors() {
        return new ArrayList<>(data);

    }

    @Override
    public void deleteItem(String id) {
        for (int i = 0; i < data.size(); i++) {
            ColorEntity item = data.get(i);
            if (data.get(i).getId().equals(id)){
                data.remove(i);
                return;
            }
        }
    }

    @Override
    public void onCreateNewCard(ArrayList<ColorEntity> dataNewCard) {

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
    public List<ColorEntity> regenerateAddColors(int size1) {

            ColorEntity colorEntity = new ColorEntity(
                    UUID.randomUUID().toString(),
                    ColorUtils.setAlphaComponent(new Random().nextInt(), 255) );

            data.add(colorEntity);


        return data;
    }

    }



