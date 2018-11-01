package com.example.taki.newproject.pdf_open;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.taki.newproject.R;
import com.example.taki.newproject.utils.Book;
import com.github.barteksc.pdfviewer.PDFView;

public class pdf_view extends Fragment {
    View view;
    private PDFView pdfView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.pdf_read, null);

        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {


         pdfView=view.findViewById(R.id.pdfView);


        loadPDF();

    }

    private void loadPDF() {

        if (Book.position==0){

            pdfView.fromAsset("the-pragmatic-programmer-from-journeyman-to-master.pdf").load();


        }
        else if (Book.position==1){

            pdfView.fromAsset("the_cpp.pdf").load();

        }
    }
}


