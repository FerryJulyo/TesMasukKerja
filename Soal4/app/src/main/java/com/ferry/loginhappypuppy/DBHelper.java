package com.ferry.loginhappypuppy;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "HappyPuppy.db";

    public DBHelper(Context context) {
        super(context, DBNAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create table users(id INTEGER primary key autoincrement, username TEXT, password TEXT, level TEXT)");
        DB.execSQL("INSERT INTO users(username, password, level) VALUES ('AIN','AI1','ACCOUNTING')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists users");
    }

    public  Boolean checkUsernamePassword(String username, String password){
        SQLiteDatabase DB = this.getWritableDatabase();
        @SuppressLint("Recycle") Cursor cursor = DB.rawQuery("Select * from users where username = ? and password = ?", new String[] {username,password});
        return cursor.getCount() > 0;
    }
}
