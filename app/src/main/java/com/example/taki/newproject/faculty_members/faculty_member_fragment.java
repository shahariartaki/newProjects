package com.example.taki.newproject.faculty_members;

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

import com.example.taki.newproject.R;

public class faculty_member_fragment extends Fragment {
    View view;

    private ListView lv;

    String[] techerName = {"DR. MD. MIJANUR RAHMAN ", "MD. SHAHNEWAZ KHAN", "MD. SHAFIUL ALAM CHOWDHURY ", "MST. NAJNIN SULTANA ", " MD. CHOWDHURY SAJADUL ISLAM", "DR. A.H.M. SAIFULLAH SADI", "DR. MD. AKHTARUZZAMAN", "TANZILLAH WAHID"};
    String[] techerposition = {"Chairman", "Professor", "Associate Professor", " Assistant Professor", "  Assistant Professor", " Assistant Professor", " Assistant Professor", "Senior Lecturer"};
    String[] techeredu = {"example@uucse.com", "example@uucse.com", "example@uucse.com", " example@uucse.com", "  example@uucse.com", " example@uucse.com", "example@uucse.com", "example@uucse.com"};
    Integer[] logo = {R.drawable.mizanur, R.drawable.shanewaz, R.drawable.saiful, R.drawable.naznin, R.drawable.sajadul, R.drawable.sadi, R.drawable.aktaruzzaman, R.drawable.tazila};


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.faculy_member, null);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView();

        loadData();


    }

    private void loadData() {

        faculty_member_adapter facultyMemberAdapter = new faculty_member_adapter(getActivity(), techerName, techerposition, techeredu, logo);
        //  lv=(ListView)findViewById(R.id.lv);
        lv.setAdapter(facultyMemberAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String item = (String) lv.getItemAtPosition(position);
                Toast.makeText(getActivity(), item, Toast.LENGTH_LONG).show();

            }
        });
    }

    private void initView() {

        lv = view.findViewById(R.id.lv);
    }
}
