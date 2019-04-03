package com.example.prince.studentrecord;

import android.provider.BaseColumns;

public final class DataContracter {
    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private DataContracter() {}
    public static final class DataEntry implements BaseColumns {
        public final static String TABLE_NAME="Student_record";
        public final static String _ID=BaseColumns._ID;
        public final static String COLUMN_STUDENT_NAME="name";
        public final static String COLUMN_STUDENT_BRANCH="branch";
        public final static String COLUMN_STUDENT_GENDER="gender";
        public final static String COLUMN_STUDENT_FACULTY_NO="facultyNo";
        public static final int GENDER_UNKNOWN = 2;
        public static final int GENDER_MALE = 1;
        public static final int GENDER_FEMALE = 0;
    }
}
