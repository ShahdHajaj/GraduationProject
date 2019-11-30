package com.example.grad;

import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class sensorDataBaseHelper extends SQLiteOpenHelper {

    public sensorDataBaseHelper(Context context) {
        super(context, "sensorData", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE SENSORINFO(ID PRIMARY KEY,weather TEXT,time TEXT,fasten TEXT, random TEXT ,active TEXT, eat TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    public void insertRow(sensorInfo user) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("Time", user.getTime());
        contentValues.put("Weather", user.getWeather());
        contentValues.put("Fasten", user.getFasten());
        contentValues.put("Random", user.getRandom());
        contentValues.put("Active", user.getActive());
        contentValues.put("Eat", user.getEat());

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.insert("sensorinfo", null, contentValues);
    }

    public Cursor getAllData() {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM SENSORINFO", null);
        return cursor;
    }
    public Cursor getDataByTime(String Time) {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(" SELECT * from SENSORINFO   WHERE  Time='" + Time +"' ORDER BY RANDOM() LIMIT 1", null);
        return cursor;
    }
}
