package com.agile.ondemand.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.agile.ondemand.R;
import com.agile.ondemand.adapter.UsersAdapter;
import com.agile.ondemand.api.UsersApi;
import com.agile.ondemand.fragments.AddFragment;
import com.agile.ondemand.fragments.HomeFragment;
import com.agile.ondemand.fragments.NotificationFragment;
import com.agile.ondemand.fragments.ProfileFragment;
import com.agile.ondemand.fragments.SearchFragment;
import com.agile.ondemand.fragments.WishListFragment;
import com.agile.ondemand.model.UserUpdate;
import com.agile.ondemand.url.Url;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private SearchView searchView;
    private Button btnSearch;
    private RecyclerView searchRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        searchView = findViewById(R.id.searchView);
        btnSearch = findViewById(R.id.btnSearch);
        searchRecycler = findViewById(R.id.searchRecycler);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

        //Search by first letter
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SearchFragment()).commit();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                SearchFragment searchFragment = new SearchFragment();
                String firstLetter = searchView.getQuery().toString();
                Toast.makeText(MainActivity.this, "" + firstLetter, Toast.LENGTH_SHORT).show();
                Bundle bundle = new Bundle();
                bundle.putString("Firstletter", firstLetter);
                searchFragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.fragment_container, searchFragment);
                fragmentTransaction.addToBackStack(null).commit();
//                loadUserByFirstName();
            }
        });
    }

/**Button nav Selected Item Listener*/
    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()) {
                case R.id.nav_home:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.nav_notification:
                    selectedFragment = new NotificationFragment();
                    break;
                case R.id.nav_profile:
                    selectedFragment = new ProfileFragment();
                    break;
                case R.id.nav_add:
                    selectedFragment = new AddFragment();
                    break;
                case R.id.nav_wishList:
                    selectedFragment = new WishListFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).addToBackStack(null).commit();
            return true;
        }
    };

    /**three dot menu*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        return true;
    }

    /**three dot menu click listener*/
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemAboutUs:
                Intent intent = new Intent(this, AboutusActivity.class);
                startActivity(intent);
                break;
            case R.id.itemFaq:
                Intent intent1 = new Intent(this, FaqActivity.class);
                startActivity(intent1);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}