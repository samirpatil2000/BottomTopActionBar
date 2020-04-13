package com.example.a39_bottomtopactionbar;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FavoritesActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);
        textView=findViewById(R.id.textView);
        textView.setText("This is Activity Favorites ");



        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navBottomView);
        BottomNavViewHelper.disableShiftMode(bottomNavigationView);




        // For Icon Notation
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(3);
        menuItem.setChecked(true);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.ic_home:
                        Intent intent1 = new Intent(FavoritesActivity.this,MainActivity.class);
                        startActivity(intent1);
                        break;

                    case R.id.ic_crop:
                        Intent intent2 = new Intent(FavoritesActivity.this,Crop2Activity.class);
                        startActivity(intent2);
                        break;
                    case R.id.ic_camera:
                        Intent intent3 = new Intent(FavoritesActivity.this,CameraActivity.class);
                        startActivity(intent3);
                        break;
                    case R.id.ic_fav:
//                        Intent intent4 = new Intent(FavoritesActivity.this,FavoritesActivity.class);
//                        startActivity(intent4);
                        break;
                    case R.id.ic_setting:
                        Intent intent5 = new Intent(FavoritesActivity.this,SettingActivity.class);
                        startActivity(intent5);
                        break;

                }
                return false;

            }
        });
    }
}
