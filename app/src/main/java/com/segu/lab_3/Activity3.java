package com.segu.lab_3;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.navigation.NavigationView;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);

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
        toFirstBtn.setOnClickListener((btn) -> {
            setResult(1);
            finish();
        });

        Button toSecondBtn = findViewById(R.id.to_second_btn);
        toSecondBtn.setOnClickListener((btn) -> {
            finish();
        });
    }
}
