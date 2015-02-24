package com.example.myapplication;

import com.example.myapplication.pojo.BookModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexandr_Shegeda on 23.02.2015.
 */
public class BookUtil
{
    public static List<BookModel> initList()
    {
        List<BookModel> list = new ArrayList<BookModel>();
        list.add(new BookModel(1,"Book 1","Some book description",R.drawable.book_1));
        list.add(new BookModel(2,"Book 2","Some book description",R.drawable.book_2));
        list.add(new BookModel(3,"Book 3","Some book description",R.drawable.book_3));
        list.add(new BookModel(4,"Book 4","Some book description",R.drawable.book_4));
        list.add(new BookModel(5,"Book 5","Some book description",R.drawable.book_5));
        list.add(new BookModel(6,"Book 6","Some book description",R.drawable.book_6));
        list.add(new BookModel(7,"Book 7","Some book description",R.drawable.book_7));
        list.add(new BookModel(8,"Book 8","Some book description",R.drawable.book_8));
        list.add(new BookModel(9,"Book 9","Some book description",R.drawable.book_9));
        list.add(new BookModel(10,"Book 10","Some book description",R.drawable.book_10));
        list.add(new BookModel(11,"Book 11","Some book description",R.drawable.book_11));
        list.add(new BookModel(12,"Book 12","Some book description",R.drawable.book_12));
        list.add(new BookModel(13,"Book 13","Some book description",R.drawable.book_13));
        list.add(new BookModel(14,"Book 14","Some book description",R.drawable.book_14));
        list.add(new BookModel(15,"Book 15","Some book description",R.drawable.book_15));
        return list;
    }
}
