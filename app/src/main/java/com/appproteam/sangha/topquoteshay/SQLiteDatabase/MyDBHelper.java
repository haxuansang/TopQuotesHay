package com.appproteam.sangha.topquoteshay.SQLiteDatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static java.sql.Types.INTEGER;

/**
 * Created by SangHa on 3/11/2018.
 */

public class MyDBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="my_db";
    public static final String TABLE_NAME="favorite_quotes";
    public static final int DATABASE_VERSION=2;

    public MyDBHelper(Context context)
    {
            super(context,DATABASE_NAME,null,DATABASE_VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(" CREATE TABLE " + TABLE_NAME + "(" +
                "quotes_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "quotes VARCHAR(200)," +
                "author VARCHAR (8), " +
                "position  INTEGER)");

    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);

    }
}
