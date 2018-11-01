package com.example.taki.newproject.faculty_members;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.taki.newproject.R;

public class faculty_member_adapter extends BaseAdapter {


    private final Context context;
    private final String[] techerName;
    private final String[] techerposition;
    private final String[] teacherMail;
    private final Integer[] logo;

    public faculty_member_adapter(Context context, String[] techerName, String[] techerposition, String[] techeredu, Integer[] logo) {
        // super(context, R.layout.faculty_mrmber_example);
        this.context = context;
        this.techerName = techerName;
        this.techerposition = techerposition;
        this.teacherMail = techeredu;
        this.logo = logo;
    }

    @Override
    public int getCount() {
        return teacherMail.length;
    }

    @Override
    public Object getItem(int position) {
        return teacherMail[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        if (convertView == null) {


            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.faculty_mrmber_example, null, true);

        }
        TextView textView = (TextView) convertView.findViewById(R.id.tvfn);
        TextView textView1 = (TextView) convertView.findViewById(R.id.tvfp);
        TextView textView2 = (TextView) convertView.findViewById(R.id.tvMail);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView2);

        textView.setText(techerName[position]);
        textView1.setText(techerposition[position]);
        textView2.setText(teacherMail[position]);
        imageView.setImageResource(logo[position]);

        return convertView;
    }
}
