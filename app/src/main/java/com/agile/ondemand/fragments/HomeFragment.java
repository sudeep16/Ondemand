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
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.agile.ondemand.R;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

public class HomeFragment extends Fragment {

    private CardView cvPlumber;
    private CardView cvElectrician;
    private CardView cvHandyMan;
    private CardView cvLaundry;
    private CardView cvCatering;
    private CardView cvPainter;
    private CardView cvBabySitter;
    private CardView cvCareTaker;
    private CardView cvHouseKeeper;
    private String plumber, electrician, handyMan, laundry, catering, painter, babysitter, caretaker,
            housekeeping, gardener;
    private FragmentTransaction fragmentTransaction;
    private Bundle bundle = new Bundle();

    private int[] images = new int[]{
            R.drawable.plumber1, R.drawable.painter1,
            R.drawable.babysitter1, R.drawable.gardner1
    };

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
        CardView cvGardener = root.findViewById(R.id.cardGardener);

        CarouselView carouselView = root.findViewById(R.id.carousel);
        carouselView.setPageCount(images.length);
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(images[position]);
            }
        });

        cvPlumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTransaction = getFragmentManager().beginTransaction();
                PlumberFragment plumberFragment = new PlumberFragment();
                plumber = "Plumber";
                bundle.putString("category", plumber);
                plumberFragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.fragment_container, plumberFragment);
                fragmentTransaction.commit();
            }
        });

        cvElectrician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTransaction = getFragmentManager().beginTransaction();
                PlumberFragment plumberFragment = new PlumberFragment();
                electrician = "Electrician";
                bundle.putString("category", electrician);
                plumberFragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.fragment_container, plumberFragment);
                fragmentTransaction.commit();
            }
        });

        cvBabySitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTransaction = getFragmentManager().beginTransaction();
                PlumberFragment plumberFragment = new PlumberFragment();
                babysitter = "Baby Sitter";
                bundle.putString("category", babysitter);
                plumberFragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.fragment_container, plumberFragment);
                fragmentTransaction.commit();
            }
        });

        cvHandyMan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTransaction = getFragmentManager().beginTransaction();
                PlumberFragment plumberFragment = new PlumberFragment();
                handyMan = "Handy Man";
                bundle.putString("category", handyMan);
                plumberFragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.fragment_container, plumberFragment);
                fragmentTransaction.commit();
            }
        });

        cvLaundry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTransaction = getFragmentManager().beginTransaction();
                PlumberFragment plumberFragment = new PlumberFragment();
                laundry = "Laundry";
                bundle.putString("category", laundry);
                plumberFragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.fragment_container, plumberFragment);
                fragmentTransaction.commit();
            }
        });

        cvPainter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTransaction = getFragmentManager().beginTransaction();
                PlumberFragment plumberFragment = new PlumberFragment();
                painter = "Painter";
                bundle.putString("category", painter);
                plumberFragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.fragment_container, plumberFragment);
                fragmentTransaction.commit();
            }
        });

        cvGardener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTransaction = getFragmentManager().beginTransaction();
                PlumberFragment plumberFragment = new PlumberFragment();
                gardener = "Gardener";
                bundle.putString("category", gardener);
                plumberFragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.fragment_container, plumberFragment);
                fragmentTransaction.commit();
            }
        });

        cvCatering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTransaction = getFragmentManager().beginTransaction();
                PlumberFragment plumberFragment = new PlumberFragment();
                catering = "Catering";
                bundle.putString("category", catering);
                plumberFragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.fragment_container, plumberFragment);
                fragmentTransaction.commit();
            }
        });

        cvCareTaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTransaction = getFragmentManager().beginTransaction();
                PlumberFragment plumberFragment = new PlumberFragment();
                caretaker = "Care Taker";
                bundle.putString("category", caretaker);
                plumberFragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.fragment_container, plumberFragment);
                fragmentTransaction.commit();
            }
        });

        cvHouseKeeper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTransaction = getFragmentManager().beginTransaction();
                PlumberFragment plumberFragment = new PlumberFragment();
                housekeeping = "House Keeping";
                bundle.putString("category", housekeeping);
                plumberFragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.fragment_container, plumberFragment);
                fragmentTransaction.commit();
            }
        });

        return root;
    }
}
