package com.example.taki.newproject.notice_board;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.taki.newproject.R;

import java.util.ArrayList;
import java.util.List;

public class notice_fragment extends Fragment {
    private RecyclerView recyclerView;
    private List<noticeboard_model> noticeboardModelList = new ArrayList<>();
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.notice_board,null);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView();
        loadData();
    }

    private void loadData() {

        String[] title = getResources().getStringArray(R.array.title);
        String[] publis = getResources().getStringArray(R.array.publishDate);
        String[] more = getResources().getStringArray(R.array.more);

        for (int i = 0; i < title.length; i++) {

            noticeboard_model noticeboardModel = new noticeboard_model(title[i], publis[i],more[i]);
            noticeboardModelList.add(noticeboardModel);

        }

        notice_board_adapter noticeBoardAdapter = new notice_board_adapter(getContext(), noticeboardModelList);



        //LinearLayoutManager manager = new LinearLayoutManager(this);// Linear show korar jonno
        //manager.setOrientation(LinearLayoutManager.HORIZONTAL);//for horizontal


        //GridLayoutManager manager =new GridLayoutManager(this,3);//grid view show korar jonno
        //manager.setOrientation(LinearLayoutManager.HORIZONTAL);//for horizontal

        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);

        recyclerView.setAdapter(noticeBoardAdapter);





    }

    private void initView(){
        recyclerView=view.findViewById(R.id.recyclearView);
    }
}
