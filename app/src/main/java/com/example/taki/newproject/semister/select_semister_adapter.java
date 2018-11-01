package com.example.taki.newproject.semister;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.taki.newproject.MainActivity;
import com.example.taki.newproject.R;
import com.example.taki.newproject.student_batch.Student_Batch_Adapter;
import com.example.taki.newproject.student_batch.Student_Batch_Model;

import java.util.List;

public class select_semister_adapter extends RecyclerView.Adapter<select_semister_adapter.MyViewHolder>{
    private Context context;
    private List<select_semister_model> selectSemisterModels;

    public select_semister_adapter(Context context, List<select_semister_model> selectSemisterModels) {
        this.context = context;
        this.selectSemisterModels = selectSemisterModels;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
        //final int pos=1;
        final View view = LayoutInflater.from(context).inflate(R.layout.select_semister_example,null);
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
        myViewHolder.semester.setText(selectSemisterModels.get(i).getSemester());
        myViewHolder.year.setText(selectSemisterModels.get(i).getYear());
    }

    @Override
    public int getItemCount() {
        return selectSemisterModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView semester,year;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            semester=itemView.findViewById(R.id._semester_name);
            year=itemView.findViewById(R.id._semester_year);

            Log.i("test", "ViewHolder");

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    MainActivity.mainActivity.addFragment(new select_semister_fragment());
                    Toast.makeText(context, " "+selectSemisterModels.get(getAdapterPosition()).getSemester(), Toast.LENGTH_SHORT).show();
                }
            });




        }


    }
}
