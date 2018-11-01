package com.example.taki.newproject.main_view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.example.taki.newproject.R;

import me.relex.circleindicator.CircleIndicator;
import technolifestyle.com.imageslider.FlipperLayout;
import technolifestyle.com.imageslider.FlipperView;

public class main_fragment extends Fragment {
    ViewFlipper viewFlipper;
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.main_layout,null);
        //initView();
        int images[]={R.drawable.fippp,R.drawable.flip,R.drawable.flipp,R.drawable.flippp,R.drawable.addmition};

        viewFlipper =  view.findViewById(R.id.viewFlipper);

        for (int image:images){
            initView(image);
        }

        return view;
    }

    private void initView(int image) {

        ImageView imageView = new ImageView(getContext());
        imageView.setBackgroundResource(image);

        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);
        viewFlipper.setInAnimation(getContext(), android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(getContext(), android.R.anim.slide_out_right);


        /*int num_of_pages = 3;
        for (int i = 0; i < num_of_pages; i++) {
            FlipperView view = new FlipperView(getActivity());
            view.setImageUrl("<valid image url>")
                    .setImageDrawable(R.drawable.programming_in_c) // Use one of setImageUrl() or setImageDrawable() functions, otherwise IllegalStateException will be thrown
                    .setImageScaleType(ImageView.ScaleType.CENTER_CROP) //You can use any ScaleType
                    .setDescription("Description")
                    .setOnFlipperClickListener(new FlipperView.OnFlipperClickListener() {
                        @Override
                        public void onFlipperClick(FlipperView flipperView) {


                            //Handle View Click here
                        }
                    });
            flipperLayout.setScrollTimeInSec(3); //setting up scroll time, by default it's 3 seconds
            flipperLayout.getScrollTimeInSec(); //returns the scroll time in sec
            flipperLayout.getCurrentPagePosition(); //returns the current position of pager
            flipperLayout.addFlipperView(view);
        }

       *//* ViewPager viewpager = (ViewPager) view.findViewById(R.id.viewpager);
        viewpager.setAdapter(adapter);

        CircleIndicator indicator = (CircleIndicator) view.findViewById(R.id.indicator);
        indicator.setViewPager(viewpager);

// optional
        adapter.registerDataSetObserver(indicator.getDataSetObserver());*//*
*/
    }
}
