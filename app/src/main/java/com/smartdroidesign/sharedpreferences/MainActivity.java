package com.smartdroidesign.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String SHARED_PREFS = "sharedPrefs";
    private static final String EDIT_TEXT = "editText";
    private SharedPreferences.Editor mEditor;
    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText = findViewById(R.id.editText);

        loadData();
    }

    private void loadData() {
        // Get the shared preferences file and set the mode (private in this example)
        SharedPreferences mSharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        // Storing the value via editor
        mEditor = mSharedPreferences.edit();
        mEditor.apply();

        // Retrieving and setting saved value
        String editTextString = mSharedPreferences.getString(EDIT_TEXT, "");
        mEditText.setText(editTextString);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Saving the value to the editText
        mEditor.putString(EDIT_TEXT, mEditText.getText().toString());
        mEditor.apply();
    }


}
