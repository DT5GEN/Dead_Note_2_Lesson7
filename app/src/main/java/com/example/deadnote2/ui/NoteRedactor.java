package com.example.deadnote2.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.deadnote2.R;
import com.example.deadnote2.domain.NoteEntity;
import com.example.deadnote2.domain.NotesRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class NoteRedactor extends AppCompatActivity implements NotesRepo {

    EditText editHeading;
    EditText editTextBody;
    ImageView saveNoteNoteRedactor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_redactor);

//        editHeading = findViewById(R.id.activity_note_redactor__heading_edit_text);  // перенесли в initView()
//        editTextBody = findViewById(R.id.activity_note_redactor__body_text_edit_text);
        saveNoteNoteRedactor = findViewById(R.id.activity_note_redactor__save_note_image_view);

        //достанем интент
        Intent intentNoteRedactorGetText = getIntent();
        Bundle extrasMainActivity = intentNoteRedactorGetText.getExtras();

        initView();


        NoteEntity newNote = getIntent().getExtras().getParcelable(YOUR_NOTE);

        ImageView saveNote = findViewById(R.id.activity_note_redactor__save_note_image_view);
    saveNote.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent sendTextHeading = new Intent(NoteRedactor.this, MainActivity.class);
            String textHeadingNotesRedactor = editHeading.getText().toString();
            // запихиваем сообщение в Bundle
            sendTextHeading.putExtra(MainActivity.KEY_MESSAGE, textHeadingNotesRedactor);
            setResult(RESULT_OK, sendTextHeading);
        // временно отключаю  populateView(newNote);



//            Intent intentResult = new Intent();
//            intentResult.putExtra(YOUR_NOTE, createNotes());
//            setResult(RESULT_OK, intentResult);
            // Метод finish() завершает активити
            finish();
        }
    });

    if (extrasMainActivity != null) // если бандл не пустой
    {
        String messageExtras = extrasMainActivity.getString(MainActivity.KEY_MESSAGE);
        editHeading.setText(messageExtras);

    }


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