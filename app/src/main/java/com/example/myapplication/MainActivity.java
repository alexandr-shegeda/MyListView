package com.example.myapplication;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.example.myapplication.adapter.BookAdapter;
import com.example.myapplication.pojo.BookModel;

import java.util.ArrayList;
import java.util.List;

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
    }

    public void openBook(View view,int position)
    {
        Intent intent = new Intent(this,BookActivity.class);

        BookModel bookModel = (BookModel) listView.getAdapter().getItem(position);
        intent.putExtra("book",bookModel);
        startActivity(intent);
    }

}
