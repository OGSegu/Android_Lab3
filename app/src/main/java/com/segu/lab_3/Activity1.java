package com.segu.lab_3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class Activity1 extends BasicActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);

        initNav(findViewById(R.id.firstActivity));

        Button toSecondActivityBtn = findViewById(R.id.to_second_btn);
        toSecondActivityBtn.setOnClickListener(btn -> {
            Intent secondActivityIntent = new Intent(this, Activity2.class);
            startActivity(secondActivityIntent);
        });
    }
}
