package com.example.taki.newproject.semister;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.taki.newproject.R;
import com.example.taki.newproject.student_batch.Student_Batch_Adapter;
import com.example.taki.newproject.student_batch.Student_Batch_Model;

import java.util.ArrayList;
import java.util.List;

public class select_semister_fragment extends Fragment {
    private RecyclerView recyclerView;
    private List<select_semister_model>selectSemisterModelslist=new ArrayList<>();


    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.select_semister,null);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView();

        loadData();
    }

    private void loadData() {
        String[] semister = getResources().getStringArray(R.array.semester_name);
        String[] years = getResources().getStringArray(R.array.year);

        for (int i = 0; i < semister.length; i++) {
            select_semister_model selectSemisterModel = new select_semister_model(semister[i],years[i]);
            selectSemisterModelslist.add(selectSemisterModel);
        }


        select_semister_adapter selectSemisterAdapter = new select_semister_adapter(getContext(),selectSemisterModelslist);


        GridLayoutManager manager =new GridLayoutManager(getContext(),2);
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        //StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);

        recyclerView.setAdapter(selectSemisterAdapter);
    }

    private void initView() {
        recyclerView=view.findViewById(R.id.recyclearView_semister);

    }

}
