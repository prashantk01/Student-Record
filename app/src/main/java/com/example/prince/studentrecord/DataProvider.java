package com.example.prince.studentrecord;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.prince.studentrecord.DataContracter.DataEntry;

import androidx.annotation.Nullable;

class DataProvider extends SQLiteOpenHelper {
    public static final String LOG_TAG=DataProvider.class.getSimpleName();
    private static final String DATABASE_NAME="records.db";
    private static final int DATABASE_VERSION = 1;


    public DataProvider(Context context) {
        super(context,DATABASE_NAME,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the student_record table
        String  SQL_CREATE_STUDENT_RECORD=  "CREATE TABLE " + DataEntry.TABLE_NAME + " ("
                + DataEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + DataEntry.COLUMN_STUDENT_NAME + " TEXT NOT NULL, "
                + DataEntry.COLUMN_STUDENT_GENDER + " INTEGER NOT NULL, "
                + DataEntry.COLUMN_STUDENT_FACULTY_NO+ " INTEGER NOT NULL, "
                + DataEntry.COLUMN_STUDENT_BRANCH+ " INTEGER NOT NULL );";
        db.execSQL(SQL_CREATE_STUDENT_RECORD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // no new version still
    }
}
