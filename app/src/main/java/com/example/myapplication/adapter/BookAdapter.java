package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.pojo.BookModel;

import java.util.List;

/**
 * Created by Александр on 22.02.2015.
 */
public class BookAdapter extends BaseAdapter
{
    public List<BookModel> list;
    private LayoutInflater inflater;

    public BookAdapter(Context context, List<BookModel> list) {
        this.list = list;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if( view == null )
        {
            view = inflater.inflate(R.layout.book_item,parent,false);
        }
        BookModel book = getBookModel(position);

        TextView textView = (TextView) view.findViewById(R.id.textView);
        textView.setText(book.getBookTitle());

        return view;
    }

    private BookModel getBookModel( int position )
    {
        return (BookModel) getItem(position);
    }
}
