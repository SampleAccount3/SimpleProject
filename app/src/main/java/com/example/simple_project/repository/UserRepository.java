package com.example.simple_project.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.room.Room;

import com.example.simple_project.database.AppDatabase;
import com.example.simple_project.model.User;
import com.example.simple_project.model.UserDao;

import java.util.List;
import java.util.concurrent.Executors;

public class UserRepository {
    private UserDao userDao;
    private LiveData<List<User>>  allUsers;

    public UserRepository(Application application) {
        AppDatabase db = Room.databaseBuilder(application, AppDatabase.class, "app_db").build();
        userDao = db.userDao();
        allUsers = userDao.getAllUsers();
    }

    public LiveData<List<User>> getAllUsers() {
        return allUsers;
    }

    public void insert(User user) {
        Executors.newSingleThreadExecutor().execute(() -> userDao.insert(user));
    }
}
