package com.example.prince.studentrecord;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class EditorActivity extends AppCompatActivity {
    private EditText mNameEditText;
    private Spinner mGenderSpinner;
    private EditText mFacultyEditText;
    private EditText mBranchEditText;
    private int mGender = DataContracter.DataEntry.GENDER_UNKNOWN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        // Find all relevant views that we will need to read user input from
        mNameEditText = (EditText) findViewById(R.id.edit_student_name);
        mGenderSpinner = (Spinner) findViewById(R.id.spinner_gender);
        mFacultyEditText = (EditText) findViewById(R.id.edit_student_facultyNo);
        mBranchEditText = (EditText) findViewById(R.id.edit_student_branch);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_editor,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_save:
                return true;
            case R.id.action_delete:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
