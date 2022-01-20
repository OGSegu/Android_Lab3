package com.segu.lab_3;

import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public abstract class BasicActivity extends AppCompatActivity {

    protected void initNav(DrawerLayout rootDrawer) {
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener((item) -> {
            if (item.getItemId() == R.id.about) {
                Intent aboutActivity = new Intent(this, AboutActivity.class);
                startActivity(aboutActivity);
                rootDrawer.closeDrawer(GravityCompat.START);
                return true;
            }
            return false;
        });
    }

}
