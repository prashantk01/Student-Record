package com.example.prince.studentrecord;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.prince.studentrecord.DataContracter.DataEntry;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
private DataProvider dprovider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingActionButton floatingActionButton=findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,EditorActivity.class);
                startActivity(intent);
            }
        });
        dprovider=new DataProvider(this);
    }
    @Override
    protected void onStart() {
        super.onStart();
        displayDatabaseInfo();
    }

    private void displayDatabaseInfo() {
        // Create and/or open a database to read from it
        SQLiteDatabase db = dprovider.getReadableDatabase();
        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                DataEntry._ID,
                DataEntry.COLUMN_STUDENT_NAME,
                DataEntry.COLUMN_STUDENT_GENDER,
                DataEntry.COLUMN_STUDENT_FACULTY_NO,
                DataEntry.COLUMN_STUDENT_BRANCH};
        // Perform a query on the studentsRecord table
        Cursor cursor = db.query(
                DataEntry.TABLE_NAME,   // The table to query
                projection,            // The columns to return
                null,                  // The columns for the WHERE clause
                null,                  // The values for the WHERE clause
                null,                  // Don't group the rows
                null,                  // Don't filter by row groups
                null);                   // The sort order
        TextView textView=(TextView)findViewById(R.id.text);
        try {
            // Create a header in the Text View that looks like this:
            //
            // The pets table contains <number of rows in Cursor> pets.
            // _id - name - gender - facultyno - branch
            //
            // In the while loop below, iterate through the rows of the cursor and display
            // the information from each column in this order.
            textView.setText("The student_record" + cursor.getCount() + "Records\n\n");
            textView.append(DataEntry._ID + " - " +
                    DataEntry.COLUMN_STUDENT_NAME + " - " +
                    DataEntry.COLUMN_STUDENT_GENDER+ " - " +
                    DataEntry.COLUMN_STUDENT_FACULTY_NO+ " - " +
                    DataEntry.COLUMN_STUDENT_BRANCH+ "\n");

            // Figure out the index of each column
            int idColumnIndex = cursor.getColumnIndex(DataEntry._ID);
            int nameColumnIndex = cursor.getColumnIndex(DataEntry.COLUMN_STUDENT_NAME);
            int genderColumnIndex = cursor.getColumnIndex( DataEntry.COLUMN_STUDENT_GENDER);
            int facultyNoColumnIndex = cursor.getColumnIndex( DataEntry.COLUMN_STUDENT_FACULTY_NO);
            int branchColumnIndex = cursor.getColumnIndex( DataEntry.COLUMN_STUDENT_BRANCH);

            // Iterate through all the returned rows in the cursor
            while (cursor.moveToNext()) {
                // Use that index to extract the String or Int value of the word
                // at the current row the cursor is on.
                int currentID = cursor.getInt(idColumnIndex);
                String currentName = cursor.getString(nameColumnIndex);
                int currentGender = cursor.getInt(genderColumnIndex);
                String currentfacultyNo = cursor.getString(facultyNoColumnIndex);
                String currentBranch = cursor.getString(branchColumnIndex);
                // Display the values from each column of the current row in the cursor in the TextView
                textView.append(("\n" + currentID + " - " +
                        currentName + " - " +
                        currentGender + " - " +
                        currentfacultyNo + " - " +
                        currentBranch));
            }
        } finally {
            // Always close the cursor when you're done reading from it. This releases all its
            // resources and makes it invalid.
            cursor.close();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    switch(item.getItemId()){
        case R.id.delete_entries:
            return true;
    }
    return super.onOptionsItemSelected(item);
    }
}
