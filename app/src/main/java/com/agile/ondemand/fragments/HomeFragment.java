package com.agile.ondemand.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.agile.ondemand.R;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

public class HomeFragment extends Fragment {

    private CardView cvPlumber, cvElectrician, cvHandyMan, cvLaundry, cvCatering, cvPainter, cvBabySitter, cvCareTaker, cvHouseKeeper;

    private int[] images = new int[]{
            R.drawable.plumber1, R.drawable.painter1,
            R.drawable.babysitter1, R.drawable.gardner1
    };
//
//    private String[] imageTitle = new String[]{
//            "x", "y", "z", "g"
//    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        cvPlumber = root.findViewById(R.id.cardPlumber);
        cvElectrician = root.findViewById(R.id.cardElectrician);
        cvHandyMan = root.findViewById(R.id.cardHandyman);
        cvLaundry = root.findViewById(R.id.cardLaundry);
        cvCatering = root.findViewById(R.id.cardCatering);
        cvPainter = root.findViewById(R.id.cardPainter);
        cvBabySitter = root.findViewById(R.id.cardBabySitter);
        cvCareTaker = root.findViewById(R.id.cardCareTaker);
        cvHouseKeeper = root.findViewById(R.id.cardHouseKeeping);

        CarouselView carouselView = root.findViewById(R.id.carousel);
        carouselView.setPageCount(images.length);
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(images[position]);
            }
        });

//        carouselView.setImageClickListener(new ImageClickListener() {
//            @Override
//            public void onClick(int position) {
//                Toast.makeText(getActivity(), imageTitle[position] , Toast.LENGTH_SHORT).show();
//            }
//        });

        cvPlumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new PlumberFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
            }
        });

        return root;
    }
}
