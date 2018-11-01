package com.example.taki.newproject.student_batch;

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
import com.example.taki.newproject.semister.select_semister_fragment;

import java.util.List;

public class Student_Batch_Adapter extends RecyclerView.Adapter<Student_Batch_Adapter.MyViewHolder>{
    private Context context;
    private List<Student_Batch_Model> studentBatchModels;


    public Student_Batch_Adapter(Context context,List<Student_Batch_Model> studentBatchModels){
        this.context=context;
        this.studentBatchModels=studentBatchModels;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
        //final int pos=1;
        final View view = LayoutInflater.from(context).inflate(R.layout.student_batch_example,null);
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
        myViewHolder.batch.setText(studentBatchModels.get(i).getBatch_name());
        myViewHolder.section.setText(studentBatchModels.get(i).getSection());
    }

    @Override
    public int getItemCount() {
        return studentBatchModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView batch,section;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            batch=itemView.findViewById(R.id._batch_name);
            section=itemView.findViewById(R.id._section);

            Log.i("test", "ViewHolder");

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    MainActivity.mainActivity.addFragment(new select_semister_fragment());
                    Toast.makeText(context, " "+studentBatchModels.get(getAdapterPosition()).getBatch_name(), Toast.LENGTH_SHORT).show();
                }
            });




        }


    }
}
