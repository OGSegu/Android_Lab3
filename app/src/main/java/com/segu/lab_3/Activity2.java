package com.segu.lab_3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class Activity2 extends BasicActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        initNav(findViewById(R.id.secondActivity));

        Button toFirstBtn = findViewById(R.id.to_first_btn);
        toFirstBtn.setOnClickListener((btn) -> finish());

        Button toThirdBtn = findViewById(R.id.to_third_btn);
        toThirdBtn.setOnClickListener((btn) -> {
            Intent thirdActivityIntent = new Intent(this, Activity3.class);
            startActivityForResult(thirdActivityIntent, 2);
        });
    }
}
