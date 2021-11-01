package com.segu.lab_3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.navigation.NavigationView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener((item) -> {
            if (item.getItemId() == R.id.about) {
                Intent aboutActivity = new Intent(this, AboutActivity.class);
                startActivity(aboutActivity);
                return true;
            }
            return false;
        });

        Button toFirstBtn = findViewById(R.id.to_first_btn);
        toFirstBtn.setOnClickListener((btn) -> finish());

        Button toThirdBtn = findViewById(R.id.to_third_btn);
        toThirdBtn.setOnClickListener((btn) -> {
            Intent thirdActivityIntent = new Intent(this, Activity3.class);
            startActivity(thirdActivityIntent);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == 1) {
            finish();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
