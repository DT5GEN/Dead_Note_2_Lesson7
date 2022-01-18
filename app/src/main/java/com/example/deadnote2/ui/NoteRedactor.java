package com.example.deadnote2.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.deadnote2.R;
import com.example.deadnote2.domain.NoteEntity;
import com.example.deadnote2.domain.NotesRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class NoteRedactor extends AppCompatActivity implements NotesRepo {

    private EditText editHeading;
    private EditText editTextBody;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_redactor);

        initView();

        NoteEntity newNote = getIntent().getExtras().getParcelable(YOUR_NOTE);

        AppCompatImageView saveNote = findViewById(R.id.activity_note_redactor__save_note_image_view);
    saveNote.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

          populateView(newNote);



//            Intent intentResult = new Intent();
//            intentResult.putExtra(YOUR_NOTE, createNotes());
//            setResult(RESULT_OK, intentResult);
            // Метод finish() завершает активити
            finish();
        }
    });
    }

    private void initView() {
        editHeading = findViewById(R.id.activity_note_redactor__heading_edit_text);
        editTextBody = findViewById(R.id.activity_note_redactor__body_text_edit_text);

    }


    private void populateView(NoteEntity setNote) {
        editHeading.setText(" Такой то заголовок");
        editTextBody.setText("Body notes");

    }

    private NoteEntity createNotes(){
        NoteEntity newNote = new NoteEntity(
                editHeading.getText().toString(),
                editTextBody.getText().toString());

        return newNote;
    }


    @Override
    public List<NoteEntity> getNotes() {
        return null;
    }

    @Override
    public void deleteItem(String id) {

    }

    @Override
    public void onCreateNewCard(ArrayList<NoteEntity> dataNewCard) {

    }

    @Override
    public List<NoteEntity> regenerateAddNotes(int size1) {
        return null;
    }
}