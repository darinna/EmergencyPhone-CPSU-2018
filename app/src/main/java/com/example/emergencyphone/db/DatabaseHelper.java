package com.example.emergencyphone.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Emp.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "Employ";
    public static final String COL_ID = "_id";
    public static final String COL_NAME = "name";
    public static final String COL_AGE = "age";
    public static final String COL_POSITION = "position";
    public static final String COL_DEPARTMENT = "department";
    public static final String COL_TEL = "tel";
    private static final String SQL_CREATE_TABLE_PHONE
            = "CREATE TABLE " + TABLE_NAME + "("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COL_NAME + " TEXT,"
            + COL_AGE + " TEXT,"
            + COL_POSITION + " TEXT,"
            + COL_DEPARTMENT + " TEXT, "
            + COL_TEL + " TEXT "
            + ")";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_PHONE);

        ContentValues cv = new ContentValues();
        cv.put(COL_NAME, "ศรัญญา");
        cv.put(COL_AGE, "1669");
        cv.put(COL_POSITION, "HR");
        cv.put(COL_DEPARTMENT, "IT");
        cv.put(COL_TEL, "123456789");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "ดารินน่า");
        cv.put(COL_AGE, "21");
        cv.put(COL_POSITION, "HR");
        cv.put(COL_DEPARTMENT, "IT");
        cv.put(COL_TEL, "123456789");
        db.insert(TABLE_NAME, null, cv);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
} // ปิดคลาส DatabaseHelper
