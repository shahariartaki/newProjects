package com.example.taki.newproject.books;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.taki.newproject.MainActivity;
import com.example.taki.newproject.R;
import com.example.taki.newproject.pdf_open.pdf_view;
import com.example.taki.newproject.utils.Book;

public class books_fragment extends Fragment {
    View view;

    String[] book_Name = {"The Pragmatic Programmer: From Journeyman to Master ",
            "The C++ Programming Language, 4th Edition (Editor’s Choice)",
            "C Programming Language",
            "Programming in Objective-C",
            " Developing Large Web Applications: Producing Code That Can Grow and Thrive",
            "Ruby Programming Master’s Handbook: A TRUE Beginner’s Guide!",
            "Python Programming: An Introduction to Computer Science",
            "The Joy of PHP: A Beginner’s Guide to Programming Interactive Web Applications with PHP and mySQL"};
    String[] book_Writer = {"Andrew Hunt and David Thomas",
            "Bjarne Stroustrup",
            "Kernighan and Ritche",
            "Stephen G. Kochan",
            "  O’Reilly Publishing",
            " Code Well Academy",
            " John Zelle", "Alan Forbes"};
    String[] publication_ = {"Unknown", "Unknown", "Unknown", " Unknown", "  Unknown", " Unknown", "Unknown", "Unknown"};
    Integer[] logo = {R.drawable.the_pragmatic, R.drawable.the_cpp_programming, R.drawable.c_programming_language, R.drawable.programming_in_c, R.drawable.developing_large_web_applications, R.drawable.ruby_programming, R.drawable.python_programming, R.drawable.the_joy_of_php_book};


    private ListView lvBook;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.books,null);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();

        loadData();
    }

    private void loadData() {
        books_adapter booksAdapter = new books_adapter(getActivity(),book_Name,book_Writer,publication_,logo);

        lvBook.setAdapter(booksAdapter);
        lvBook.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String item = (String) lvBook.getItemAtPosition(position);
                if (position==0){

                    Book.position = 0;


                }
                else if (position==1){
                    Book.position=1;
                }

                MainActivity.mainActivity.addFragment(new pdf_view());

                //MainActivity.mainActivity.addFragment(new pdf_view());
               // Toast.makeText(getActivity(), item, Toast.LENGTH_LONG).show();

            }
        });


    }

    private void initView() {
        lvBook=view.findViewById(R.id.lvBook);
    }
}
