package com.example.deadnote2.domain;

import java.util.List;

public interface ColorsRepo {
    List<ColorEntity> getColors();

    void deleteItem(String id);
}
