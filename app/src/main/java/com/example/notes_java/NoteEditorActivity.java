package com.example.notes_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.HashSet;

public class NoteEditorActivity extends AppCompatActivity {

    int note_id;
    String Note_share_pref = "notes_share_pref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_editor);

        EditText et_note_editor = findViewById(R.id.et_note_editor);

        Intent intent = getIntent();

        note_id = intent.getIntExtra("note_id",-1);
        if (note_id != -1){
            et_note_editor.setText(MainActivity.notes.get(note_id));
        }else {
            MainActivity.notes.add("");
            note_id = MainActivity.notes.size() - 1;
            MainActivity.arrayAdapter.notifyDataSetChanged();
        }

        et_note_editor.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                MainActivity.notes.set(note_id,String.valueOf(s));
                MainActivity.arrayAdapter.notifyDataSetChanged();
                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.example.notes_java",MODE_PRIVATE);
                HashSet<String> set = new HashSet<>(MainActivity.notes);
                sharedPreferences.edit().putStringSet("notes",set).apply();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        SharedPreferences.Editor editor = getSharedPreferences(Note_share_pref, MODE_PRIVATE).edit();
        editor.putString("name","Ali");
        editor.putInt("age",25);
        editor.apply();

    }
}