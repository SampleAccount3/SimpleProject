package com.example.simple_project.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.simple_project.model.User;
import com.example.simple_project.model.UserDao;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
