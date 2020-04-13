package com.example.a39_bottomtopactionbar;

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



    }



    private void setupViewPager(ViewPager viewPager) {
        SectionPagerAdapter adapter = new SectionPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new TabFragment());
        adapter.addFragment(new Tab2Fragment());
        adapter.addFragment(new Tab3Fragment());
        viewPager.setAdapter(adapter);


    }
}
