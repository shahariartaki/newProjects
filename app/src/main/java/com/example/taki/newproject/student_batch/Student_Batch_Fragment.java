package com.example.taki.newproject.student_batch;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.taki.newproject.R;
import com.example.taki.newproject.notice_board.noticeboard_model;

import java.util.ArrayList;
import java.util.List;

public class Student_Batch_Fragment extends Fragment {

    private RecyclerView recyclerView;
    private List<Student_Batch_Model> studentBatchModelslist = new ArrayList<>();
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.student_batch,null);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView();

        loadData();
    }

    private void loadData() {
        String[] batch = getResources().getStringArray(R.array.batch_name);
        String[] section = getResources().getStringArray(R.array.batch_section);

        for (int i = 0; i < batch.length; i++) {
            Student_Batch_Model studentBatchModel = new Student_Batch_Model(batch[i],section[i]);
            studentBatchModelslist.add(studentBatchModel);
        }

        Student_Batch_Adapter studentBatchAdapter = new Student_Batch_Adapter(getContext(),studentBatchModelslist);

        GridLayoutManager manager =new GridLayoutManager(getContext(),2);
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        //StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);

        recyclerView.setAdapter(studentBatchAdapter);

    }

    private void initView() {
        recyclerView=view.findViewById(R.id.recyclearView_Student_Batch);
    }

}
