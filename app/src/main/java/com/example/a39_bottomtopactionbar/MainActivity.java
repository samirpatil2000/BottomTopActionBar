package com.example.a39_bottomtopactionbar;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private  SectionPagerAdapter sectionPagerAdapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sectionPagerAdapter = new SectionPagerAdapter(getSupportFragmentManager());

        viewPager= findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_1);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_menu);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_setting);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navBottomView);
        BottomNavViewHelper.disableShiftMode(bottomNavigationView);

        // For Icon Notation
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);



        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.ic_home:
//                        Intent intent = new Intent(MainActivity.this,MainActivity.class);
//                        startActivity(intent);
                        break;

                    case R.id.ic_crop:
                        Intent intent2 = new Intent(MainActivity.this,Crop2Activity.class);
                        startActivity(intent2);
                        break;
                    case R.id.ic_camera:
                        Intent intent3 = new Intent(MainActivity.this,CameraActivity.class);
                        startActivity(intent3);
                        break;
                    case R.id.ic_fav:
                        Intent intent4 = new Intent(MainActivity.this,FavoritesActivity.class);
                        startActivity(intent4);
                        break;
                    case R.id.ic_setting:
                        Intent intent5 = new Intent(MainActivity.this,SettingActivity.class);
                        startActivity(intent5);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + menuItem.getItemId());
                }
                return false;

            }
        });



    }
    private void setupViewPager(ViewPager viewPager) {
        SectionPagerAdapter adapter = new SectionPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new TabFragment());
        adapter.addFragment(new Tab2Fragment());
        adapter.addFragment(new Tab3Fragment());
        viewPager.setAdapter(adapter);
    }
}
