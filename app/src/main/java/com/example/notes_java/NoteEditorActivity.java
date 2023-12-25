package com.example.notes_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

public class NoteEditorActivity extends AppCompatActivity {

    String Note = "notes";
    String Note_share_pref = "notes_share_pref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_editor);

        SharedPreferences.Editor editor = getSharedPreferences(Note_share_pref, MODE_PRIVATE).edit();
        editor.putString("name","Ali");
        editor.putInt("age",25);
        editor.apply();

    }
}