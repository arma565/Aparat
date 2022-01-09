package com.android_learn.aparatpro.ui.activity.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.android_learn.aparatpro.R;
import com.android_learn.aparatpro.databinding.ActivityMainBinding;
import com.android_learn.aparatpro.ui.fragment.category.CategoryFragment;
import com.android_learn.aparatpro.ui.fragment.favorite.FavoriteFragment;
import com.android_learn.aparatpro.ui.fragment.home.HomeFragment;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new HomeFragment());
        fragmentList.add(new CategoryFragment());
        fragmentList.add(new FavoriteFragment());

        ViewPager2Adapter adapter = new ViewPager2Adapter(this, fragmentList);
        binding.viewPager2.setAdapter(adapter);


        binding.btnNavi.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                switch (item.getItemId()) {
                    case R.id.item_home:
                        binding.viewPager2.setCurrentItem(0);
                        binding.btnNavi.getMenu().findItem(R.id.item_home).setChecked(true);
                        break;
                    case R.id.item_category:
                        binding.viewPager2.setCurrentItem(1);
                        binding.btnNavi.getMenu().findItem(R.id.item_category).setChecked(true);
                        break;
                    case R.id.item_favorite:
                        binding.viewPager2.setCurrentItem(2);
                        binding.btnNavi.getMenu().findItem(R.id.item_favorite).setChecked(true);
                        break;
                }
                return false;
            }
        });

        binding.viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                switch (position) {
                    case 0:
                        binding.btnNavi.getMenu().findItem(R.id.item_home).setChecked(true);
                        break;
                    case 1:
                        binding.btnNavi.getMenu().findItem(R.id.item_category).setChecked(true);
                        break;
                    case 2:
                        binding.btnNavi.getMenu().findItem(R.id.item_favorite).setChecked(true);
                        break;
                }


            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });


        binding.viewPager2.setUserInputEnabled(false);
    }
}