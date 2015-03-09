package com.example.myapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.example.myapplication.adapter.BookAdapter;
import com.example.myapplication.pojo.BookModel;

import java.io.File;

public class MainActivity extends ActionBarActivity {

    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                openBook(view,position);
            }
        });

        BaseAdapter adapter = new BookAdapter(this,BookUtil.initList());
        listView.setAdapter(adapter);
        BookUtil db = new BookUtil();


        // Инициализируем наш класс-обёртку
        BookDatabaseHelper sqlHelper = new BookDatabaseHelper(this);


        // База нам нужна для записи и чтения
        SQLiteDatabase sdb = sqlHelper.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(sqlHelper.UID, "1");
        cv.put(sqlHelper.BOOK_TITLE, "Book 1");
        cv.put(sqlHelper.BOOK_AUTHOR, "author 1");
        cv.put(sqlHelper.BOOK_DESC, "Some book description");
        cv.put(sqlHelper.BOOK_YEAR, "1890");
        cv.put(sqlHelper.IMAGE_PATH, new File(this.getFileStreamPath("book_1.jpg").toURI()).getPath());

        // вызываем метод вставки
        sdb.insert(sqlHelper.TABLE_NAME, sqlHelper.UID, cv);

        // закрываем соединения с базой данных
        sdb.close();
        sqlHelper.close();
    }

    public void openBook(View view,int position)
    {
        Intent intent = new Intent(this,BookActivity.class);

        BookModel bookModel = (BookModel) listView.getAdapter().getItem(position);
        intent.putExtra("book",bookModel);
        startActivity(intent);
    }

}
