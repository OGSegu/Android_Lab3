package com.segu.lab_3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.navigation.NavigationView;

public class Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener((item) -> {
            if (item.getItemId() == R.id.about) {
                Intent aboutActivity = new Intent(this, AboutActivity.class);
                startActivity(aboutActivity);
                return true;
            }
            return false;
        });

        Button toSecondActivityBtn = findViewById(R.id.to_second_btn);
        toSecondActivityBtn.setOnClickListener(btn -> {
            Intent secondActivityIntent = new Intent(this, Activity2.class)
                    .addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);;
            startActivity(secondActivityIntent);

        });
    }
}
