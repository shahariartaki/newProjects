package com.example.taki.newproject.notice_board;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.taki.newproject.R;

import java.util.List;

public class notice_board_adapter extends RecyclerView.Adapter<notice_board_adapter.MyViewHolder>{
    private Context context;
    private List<noticeboard_model> noticeBoardAdapterList;

    public notice_board_adapter(Context context, List<noticeboard_model> noticeBoardAdapterList){
        this.context=context;
        this.noticeBoardAdapterList=noticeBoardAdapterList;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
        //final int pos=1;
        final View view = LayoutInflater.from(context).inflate(R.layout.notice_board_example,null);
        //MyViewHolder holder= new MyViewHolder(view);
       /* view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, ""+studentList.get(pos).getName(), Toast.LENGTH_SHORT).show();
            }
        });

        Log.i("test", "onCreate View");*/
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.title.setText(noticeBoardAdapterList.get(i).getTitle());
        myViewHolder.publishDate.setText(noticeBoardAdapterList.get(i).getPublishDate());
        myViewHolder.more.setText(noticeBoardAdapterList.get(i).getMore());


        Log.i("test", "onBindView");

    }

    @Override
    public int getItemCount() {
        return noticeBoardAdapterList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView title,publishDate,more;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title=itemView.findViewById(R.id._title);
            publishDate=itemView.findViewById(R.id._publishDate);
            more=itemView.findViewById(R.id._more);
            Log.i("test", "ViewHolder");

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, " "+noticeBoardAdapterList.get(getAdapterPosition()).getTitle(), Toast.LENGTH_SHORT).show();
                }
            });




        }
    }

}
