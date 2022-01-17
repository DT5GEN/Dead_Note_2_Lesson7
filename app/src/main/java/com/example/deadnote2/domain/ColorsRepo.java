package com.example.deadnote2.domain;

import java.util.ArrayList;
import java.util.List;

public interface ColorsRepo {
    List<ColorEntity> getColors();

    void deleteItem(String id);

    void  onCreateNewCard(ArrayList<ColorEntity> dataNewCard);

    List<ColorEntity> regenerateAddColors(int size1);
}
