package com.example.deadnote2.domain;

import java.util.ArrayList;
import java.util.List;

public interface NotesRepo {
    List<NoteEntity> getNotes();

    void deleteItem(String id);

    void  onCreateNewCard(ArrayList<NoteEntity> dataNewCard);

    List<NoteEntity> regenerateAddNotes(int size1);

    String YOUR_NOTE = "YOUR_NOTE";
}
