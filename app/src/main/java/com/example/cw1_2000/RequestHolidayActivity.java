package com.example.cw1_2000;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;
import android.view.MenuItem;

public class RequestHolidayActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_holiday);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigation_view);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.home){
                    startActivity(new Intent(RequestHolidayActivity.this, HomeActivity.class));
                }
                else if (id == R.id.nav_request_holiday) {
                    // You're already on the Request Holiday page
                } else if (id == R.id.nav_edit_details) {
                    startActivity(new Intent(RequestHolidayActivity.this, EditDetailsActivity.class));
                } else if (id == R.id.nav_logout) {
                    startActivity(new Intent(RequestHolidayActivity.this, Logout.class));
                    finish();
                }

                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }
}
