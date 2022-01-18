package com.example.deadnote2.data;

import androidx.core.graphics.ColorUtils;

import com.example.deadnote2.domain.NoteEntity;
import com.example.deadnote2.domain.NotesRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class SimpleNotesRepoImpl implements NotesRepo {
    private static final int NOTES_LIST_SIZE = 2;
    private static final int NOTES_1_SIZE = 1;

    private List<NoteEntity> data = new ArrayList<>();

    public SimpleNotesRepoImpl(){
        regenerateNotes(NOTES_LIST_SIZE);
    }
    public void SimpleColorsRepoImpl2(){
        regenerateAddNotes(NOTES_1_SIZE);}

    public  static NotesRepo repo;
    public static NotesRepo getInstance()
    {
        if (repo == null)
        {
            repo = new SimpleNotesRepoImpl();
        }
        return repo;
    }


    @Override
    public List<NoteEntity> getNotes() {
        return new ArrayList<>(data);

    }

    @Override
    public void deleteItem(String id) {
        for (int i = 0; i < data.size(); i++) {
            NoteEntity item = data.get(i);
            if (data.get(i).getId().equals(id)){
                data.remove(i);
                return;
            }
        }
    }

    @Override
    public void onCreateNewCard(ArrayList<NoteEntity> dataNewCard) {

    }

    public void regenerateNotes(int size) {
        for (int i = 0; i < size; i++) {
            NoteEntity noteEntity = new NoteEntity(
                    UUID.randomUUID().toString(),
                    ColorUtils.setAlphaComponent(16774381, 255)
            );
            data.add(noteEntity);

        }
    }
    public List<NoteEntity> regenerateAddNotes(int size1) {

   //     NoteEntity noteEntity = new NoteEntity("1arg","2arg");

            NoteEntity noteEntity = new NoteEntity(
                    UUID.randomUUID().toString(),
                    ColorUtils.setAlphaComponent(16774381, 255) );

            data.add(noteEntity);


        return data;
    }

    }



