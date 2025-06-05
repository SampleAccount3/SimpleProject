package com.example.simple_project.view;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.example.simple_project.R;
import com.example.simple_project.model.db.User.User;
import com.example.simple_project.viewmodel.UserViewModel;

public class MainActivity extends AppCompatActivity {

    private UserViewModel userViewModel;
    TextView tvItemList;
    Button btnAddUser, btnDeleteUser, btnGetApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initUI();

        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        tvItemList = findViewById(R.id.tvItemList);

        userViewModel.getAllUsers().observe(this, users -> {
            StringBuilder builder = new StringBuilder();
            for (User item : users) {
                builder.append(item.getName()).append("\n");
                Log.d("USERNAME", "User name is: " + item.getName());
            }
            tvItemList.setText(builder.toString());
        });

    }

    private void initUI(){
        btnAddUser = findViewById(R.id.btn_add_user);
        btnDeleteUser = findViewById(R.id.btn_delete_user);
        btnGetApi = findViewById(R.id.btn_get_api);

        btnAddUser.setOnClickListener(v -> {
            User user = new User();
            user.setName("John Doe");
            userViewModel.insert(user);
        });
        btnDeleteUser.setOnClickListener(v -> {
            userViewModel.deleteAll();
        });
//        btnGetApi.setOnClickListener(v -> {
//            userViewModel.ge.observe(this, users -> {
//                StringBuilder builder = new StringBuilder();
//                for (User item : users) {
//                    builder.append(item.getName()).append(" ");
//                    Log.d("USERNAME", "User name is: " + item.getName());
//        });
    }
}