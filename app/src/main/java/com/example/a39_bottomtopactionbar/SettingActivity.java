package com.example.a39_bottomtopactionbar;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SettingActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        textView=findViewById(R.id.textView);
        textView.setText("This is Activity Setting ");


        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navBottomView);
        BottomNavViewHelper.disableShiftMode(bottomNavigationView);


        // For Icon Notation
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(4);
        menuItem.setChecked(true);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.ic_home:
                        Intent intent1 = new Intent(SettingActivity.this,MainActivity.class);
                        startActivity(intent1);
                        break;

                    case R.id.ic_crop:
                        Intent intent2 = new Intent(SettingActivity.this,Crop2Activity.class);
                        startActivity(intent2);
                        break;
                    case R.id.ic_camera:
                        Intent intent3 = new Intent(SettingActivity.this,CameraActivity.class);
                        startActivity(intent3);
                        break;
                    case R.id.ic_fav:
                        Intent intent4 = new Intent(SettingActivity.this,FavoritesActivity.class);
                        startActivity(intent4);
                        break;
                    case R.id.ic_setting:
//                        Intent intent5 = new Intent(SettingActivity.this,SettingActivity.class);
//                        startActivity(intent5);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + menuItem.getItemId());
                }
                return false;

            }
        });
    }
}
