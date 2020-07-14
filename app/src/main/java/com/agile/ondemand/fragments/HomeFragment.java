package com.agile.ondemand.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.agile.ondemand.R;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class HomeFragment extends Fragment {

    private CardView cvPlumber, cvElectrician, cvHandyMan, cvLaundry, cvCatering, cvPainter,
            cvBabySitter, cvCareTaker, cvHouseKeeper, cvGardener;
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
        cvGardener = root.findViewById(R.id.cardGardener);

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
                CategoryFragment categoryFragment = new CategoryFragment();
                plumber = "Plumber";
                bundle.putString("category", plumber);
                categoryFragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.fragment_container, categoryFragment);
                fragmentTransaction.commit();
            }
        });

        cvElectrician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTransaction = getFragmentManager().beginTransaction();
                CategoryFragment categoryFragment = new CategoryFragment();
                electrician = "Electrician";
                bundle.putString("category", electrician);
                categoryFragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.fragment_container, categoryFragment);
                fragmentTransaction.commit();
            }
        });

        cvBabySitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTransaction = getFragmentManager().beginTransaction();
                CategoryFragment categoryFragment = new CategoryFragment();
                babysitter = "Baby Sitter";
                bundle.putString("category", babysitter);
                categoryFragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.fragment_container, categoryFragment);
                fragmentTransaction.commit();
            }
        });

        cvHandyMan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTransaction = getFragmentManager().beginTransaction();
                CategoryFragment categoryFragment = new CategoryFragment();
                handyMan = "Handy Man";
                bundle.putString("category", handyMan);
                categoryFragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.fragment_container, categoryFragment);
                fragmentTransaction.commit();
            }
        });

        cvLaundry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTransaction = getFragmentManager().beginTransaction();
                CategoryFragment categoryFragment = new CategoryFragment();
                laundry = "Laundry";
                bundle.putString("category", laundry);
                categoryFragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.fragment_container, categoryFragment);
                fragmentTransaction.commit();
            }
        });

        cvPainter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTransaction = getFragmentManager().beginTransaction();
                CategoryFragment categoryFragment = new CategoryFragment();
                painter = "Painter";
                bundle.putString("category", painter);
                categoryFragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.fragment_container, categoryFragment);
                fragmentTransaction.commit();
            }
        });

        cvGardener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTransaction = getFragmentManager().beginTransaction();
                CategoryFragment categoryFragment = new CategoryFragment();
                gardener = "Gardener";
                bundle.putString("category", gardener);
                categoryFragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.fragment_container, categoryFragment);
                fragmentTransaction.commit();
            }
        });

        cvCatering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTransaction = getFragmentManager().beginTransaction();
                CategoryFragment categoryFragment = new CategoryFragment();
                catering = "Catering";
                bundle.putString("category", catering);
                categoryFragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.fragment_container, categoryFragment);
                fragmentTransaction.commit();
            }
        });

        cvCareTaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTransaction = getFragmentManager().beginTransaction();
                CategoryFragment categoryFragment = new CategoryFragment();
                caretaker = "Care Taker";
                bundle.putString("category", caretaker);
                categoryFragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.fragment_container, categoryFragment);
                fragmentTransaction.commit();
            }
        });

        cvHouseKeeper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTransaction = getFragmentManager().beginTransaction();
                CategoryFragment categoryFragment = new CategoryFragment();
                housekeeping = "House Keeping";
                bundle.putString("category", housekeeping);
                categoryFragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.fragment_container, categoryFragment);
                fragmentTransaction.commit();
            }
        });

        return root;
    }
}
