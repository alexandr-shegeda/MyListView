package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.pojo.BookModel;

/**
 * Created by Alexandr Shegeda on 22.02.2015.
 */
public class BookActivity extends ActionBarActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_view);

        BookModel book = (BookModel) getIntent().getParcelableExtra("book");

        TextView bookTitle  = (TextView)findViewById(R.id.textView2);
        TextView bookDesc   = (TextView)findViewById(R.id.textView3);
        ImageView bookCover = (ImageView)findViewById(R.id.imageView2);

        bookTitle.setText( book.getBookTitle() );
        bookDesc. setText(book.getDescription());
        bookCover.setBackground(this.getResources().getDrawable(book.getImage()));


    }
}
