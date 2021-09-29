package com.example.uulbarcode;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class MyDBHelper extends SQLiteAssetHelper {

    public static final String DB_NAME = "data.db";
    public static final String uiuccl_members = "uiuccl_members";
    public static final String uiuccl_excom_2019_2020 = "uiuccl_excom_2019_2020";
    public static final int VERSION_NUMBER = 1;
    public static final String SELECT_ALL_MEM = "select * from " + uiuccl_members;
    public static final String SELECT_ALL_EX = "select * from " + uiuccl_excom_2019_2020;

    public MyDBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION_NUMBER);
    }

    public Cursor displayAllMemberData() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        //Cursor cursor = sqLiteDatabase.rawQuery(SELECT_ALL + "=" + GET_UIUID, null);
        Cursor cursor = sqLiteDatabase.rawQuery(SELECT_ALL_MEM , null);
        return cursor;
    }
    public Cursor displayAllEcomData() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        //Cursor cursor = sqLiteDatabase.rawQuery(SELECT_ALL + "=" + GET_UIUID, null);
        Cursor cursor = sqLiteDatabase.rawQuery(SELECT_ALL_EX , null);
        return cursor;
    }
}
