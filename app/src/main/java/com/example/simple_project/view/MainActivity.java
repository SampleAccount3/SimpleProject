package com.example.simple_project.view;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProvider;

import com.example.simple_project.R;
import com.example.simple_project.model.api.Book.UserResponse;
import com.example.simple_project.model.db.User.User;
import com.example.simple_project.viewmodel.UserViewModel;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private UserViewModel userViewModel;
    TextView tvItemList;
    Button btnAddUser, btnDeleteUser, btnGetApi;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;

    private final String TAG = "MainActivity";

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_account_box); // optional: use your own icon
        }
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
//        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);

        actionBarDrawerToggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.open,
                R.string.close
        );
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        navigationView.setNavigationItemSelectedListener(item -> {

            if (item.getItemId() == R.id.ic_calculator) {
                Log.d(TAG, "onCreate: calculator");
                showToast("Opening Calculator");
                return true;
            } else {
                return false;
            }

        });

//        initUI();
    }

    public void showToast(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }


//    private void initUI(){
//        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
//        btnAddUser = findViewById(R.id.btn_add_user);
//        btnDeleteUser = findViewById(R.id.btn_delete_user);
//        btnGetApi = findViewById(R.id.btn_get_api);
//        tvItemList = findViewById(R.id.tvItemList);
//
//        userViewModel.getAllUsers().observe(this, users -> {
//            StringBuilder builder = new StringBuilder();
//            for (User item : users) {
//                builder.append(item.getName()).append("\n");
//                Log.d("USERNAME", "User name is: " + item.getName());
//            }
//            tvItemList.setText(builder.toString());
//        });
//
//        btnAddUser.setOnClickListener(v -> {
//            User user = new User();
//            user.setName("John Doe");
//            userViewModel.insert(user);
//        });
//
//        btnDeleteUser.setOnClickListener(v -> {
//            userViewModel.deleteAll();
//        });
//
//        btnGetApi.setOnClickListener(v -> {
//            Log.d(TAG, "initUI: ");
//            userViewModel.getApiUsers().observe(this, bookInfo -> {
//                tvItemList.setText(bookInfo.toString());
//            });
//        });
//    }
}