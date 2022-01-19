package com.example.deadnote2.ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.deadnote2.App;
import com.example.deadnote2.R;
import com.example.deadnote2.data.SimpleNotesRepoImpl;
import com.example.deadnote2.domain.NoteEntity;
import com.example.deadnote2.domain.NotesRepo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NotesRepo {

    public static final String KEY_MESSAGE = "messageKey_1";
    public static final int REQUEST_CODE = 1;
    TextView headingTextMainActivity;
    TextView bodyTextMainActivity;

    private static final int REQUEST_CODE_SETTING_ACTIVITY = 99;
    private NotesAdapter adapter;
    private RecyclerView recyclerView;
    private LinearLayout rootLinearLayout;
    private Button scrollButton;

    private Button onCreateButton;

    private NotesRepo notesRepo;
    private NotesRepo addNotesRepo = SimpleNotesRepoImpl.getInstance();

    private NoteEntity newNoteMainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        headingTextMainActivity = findViewById(R.id.heading_edit_text);

        notesRepo = App.get().notesRepo;

        newNoteMainActivity = new NoteEntity();

        scrollButton = findViewById(R.id.activity_main__scroll_button);
        scrollButton.setOnClickListener(v -> {
            recyclerView.smoothScrollToPosition(adapter.getItemCount());
        });

        rootLinearLayout = findViewById(R.id.root_linear_layout);

        onCreateButton = findViewById(R.id.activity_main__create_button);
        onCreateButton.setOnClickListener(v -> {
            //onCreateButton();
            adapter.setData(notesRepo.regenerateAddNotes(1));
            Toast.makeText(this, "СоздаваYся! ", Toast.LENGTH_SHORT).show();
        });
        initRecycler();

        // Добавим обмен информацией
         Intent intentGetSavedNotesNotesRedactor = getIntent();
         Bundle extractText = intentGetSavedNotesNotesRedactor.getExtras();
         if (extractText != null) {
             String savedHeading = extractText.getString(KEY_MESSAGE);
             headingTextMainActivity.setText(savedHeading);
         }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK)
            if (requestCode == REQUEST_CODE) {
                String answerMessageAOR = data.getExtras().getString(KEY_MESSAGE);
                headingTextMainActivity.setText("onActivityResult WorK " + answerMessageAOR);
            }



    }

    private void initRecycler() {
        recyclerView = findViewById(R.id.activity_main__recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new NotesAdapter();
        recyclerView.setAdapter(adapter);
        //  App.get().colorsRepo.getColors(); заменяем в аргумент сет дата
        adapter.setData(notesRepo.getNotes());
        adapter.setOnItemClickListener(new NoteViewHolder.OnItemsClickListener() {

            @Override
            public void onDeleteItem(NoteEntity item) {
                Toast.makeText(MainActivity.this, "DELete " + item.getHexString(), Toast.LENGTH_SHORT).show();
                notesRepo.deleteItem(item.getId());
                adapter.deleteItem(item.getId()); // заменяем setData, что бы поштучно вносить изменения
                //  adapter.setData(colorsRepo.getColors());
            }

            @Override
            public void onRefreshItem(NoteEntity item) {
                Toast.makeText(MainActivity.this, "Fresh " + item.getHexString(), Toast.LENGTH_SHORT).show();

            }

            // получаеm сообщение с + данные из ColorEntity
            @Override
            public void onClickItem(NoteEntity item) {
               // rootLinearLayout.setBackgroundColor(item.getColor());

                // Чтобы стартовать активити, надо подготовить интент
                // В данном случае это будет явный интент, поскольку здесь передаётся класс активити
                Intent runSettings = new Intent(MainActivity.this, NoteRedactor.class);
              //  populateAccount();
                // Передача данных через интент
                runSettings.putExtra(YOUR_NOTE, newNoteMainActivity);
                startActivityForResult(runSettings, REQUEST_CODE_SETTING_ACTIVITY);

                Toast.makeText(MainActivity.this, "Change Color "  + item.getHexString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCreateItem(NoteEntity item) {
                onCreateButton();
                Toast.makeText(MainActivity.this, "Создавася! " + item.getHexString(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void onDeleteItem(NoteEntity noteEntity) {
        Toast.makeText(this, "DELete " + noteEntity.getHexString(), Toast.LENGTH_SHORT).show();
    }

    private void onRefreshItem(NoteEntity noteEntity) {
        Toast.makeText(this, "Fresh " + noteEntity.getHexString(), Toast.LENGTH_SHORT).show();
    }

    // получаеm сообщение с + данные из ColorEntity
    private void onClickItem(NoteEntity noteEntity) {
        Toast.makeText(this, "Root " + noteEntity.getHexString(), Toast.LENGTH_SHORT).show();
    }//

    // получаеm сообщение с + данные из ColorEntity
    private void onCreateButton() {
        addNotesRepo.regenerateAddNotes(1);

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