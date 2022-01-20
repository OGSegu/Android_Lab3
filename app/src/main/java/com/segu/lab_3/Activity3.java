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

public class Activity3 extends BasicActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);
        initNav(findViewById(R.id.thirdActivity));

        Button toFirstBtn = findViewById(R.id.to_first_btn);
        toFirstBtn.setOnClickListener((btn) -> {
            startActivity(new Intent(this, Activity1.class).addFlags(FLAG_ACTIVITY_CLEAR_TOP));
        });

        Button toSecondBtn = findViewById(R.id.to_second_btn);
        toSecondBtn.setOnClickListener((btn) -> finish());
    }
}
