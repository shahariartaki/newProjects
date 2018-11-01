package com.example.taki.newproject.books;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.taki.newproject.R;

public class books_adapter extends BaseAdapter {

    private final Context context;
    private final String[] bookName;
    private final String[] bookWriter;
    private final String[] publication;
    private final Integer[] bookLogo;


    public books_adapter(Context context, String[] bookName, String[] bookWriter, String[] publication, Integer[] bookLogo){

        this.context = context;

        this.bookName =bookName;
        this.bookWriter = bookWriter;
        this.publication = publication;
        this.bookLogo = bookLogo;
    }


    @Override
    public int getCount() {
        return publication.length;
    }

    @Override
    public Object getItem(int position) {
        return publication[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.books_example, null, true);
        }

        TextView tvBookName = (TextView) convertView.findViewById(R.id.tvBookName);
        TextView tvBookWriter = (TextView) convertView.findViewById(R.id.tvBookWriter);
        TextView tvPublication = (TextView) convertView.findViewById(R.id.tvPublication);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView2);



        tvBookName.setText(bookName[position]);
        tvBookWriter.setText(bookWriter[position]);
        tvPublication.setText(publication[position]);
        imageView.setImageResource(bookLogo[position]);

        return convertView;
    }
}
