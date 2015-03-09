package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Alexandr Shegeda on 09.03.2015.
 */
public class BookDatabaseHelper extends SQLiteOpenHelper
{

    private static final String DATABASE_NAME = "book_database.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "book_table";
    public static final String UID = "_id";
    public static final String BOOK_TITLE = "bookTitle";
    public static final String BOOK_AUTHOR = "bookAuthor";
    public static final String BOOK_DESC = "description";
    public static final String BOOK_YEAR = "year";
    public static final String IMAGE_PATH = "imagePath";


    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE "
            + TABLE_NAME + " (" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + BOOK_TITLE + " TEXT, "+ BOOK_AUTHOR + " TEXT, "+BOOK_DESC + " TEXT, "
            + BOOK_YEAR + " INTEGER, "+ IMAGE_PATH + " TEXT);";

    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS "
            + TABLE_NAME;

    public BookDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w("LOG_TAG", "Обновление базы данных с версии " + oldVersion
                + " до версии " + newVersion + ", которое удалит все старые данные");
        // Удаляем предыдущую таблицу при апгрейде
        db.execSQL(SQL_DELETE_ENTRIES);
        // Создаём новый экземпляр таблицы
        onCreate(db);
    }
}
