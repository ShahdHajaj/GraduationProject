package com.example.grad;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DataBaseHelperInfo extends SQLiteOpenHelper {

    public DataBaseHelperInfo(Context context) {
        super(context, "ourProject", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE USERINFO(ID PRIMARY KEY,PASSWORD TEXT,USERNAME TEXT,GENDER TEXT, BMI TEXT ,SMOKING TEXT ,AGE TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void insertUser(UserInfo user) {
        ContentValues contentValues = new ContentValues();

        contentValues.put("password", user.getPassword());
        contentValues.put("userName", user.getUserName());
        contentValues.put("gender", user.getGender());
        contentValues.put("age", user.getAge());
        contentValues.put("bmi", user.getBmi());
        contentValues.put("smoking", user.getSmoking());
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.insert("userinfo", null, contentValues);
    }

    public Cursor getAllUser() {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM USERINFO", null);
        return cursor;
    }


}
