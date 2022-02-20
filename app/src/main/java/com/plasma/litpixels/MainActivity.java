package com.plasma.litpixels;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
//#001324

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(navListner);
    }

    private NavigationBarView.OnItemSelectedListener navListner =
            new NavigationBarView.OnItemSelectedListener(){

                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()){
                        case R.id.homeFragment:
                            selectedFragment = new homeFragment();
                            break;

                        case R.id.browseFragment:
                            selectedFragment = new browseFragment();
                            break;

                        case R.id.accountFragment:
                            selectedFragment = new accountFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,
                            selectedFragment).commit();

                    return true;
                }
            };

}