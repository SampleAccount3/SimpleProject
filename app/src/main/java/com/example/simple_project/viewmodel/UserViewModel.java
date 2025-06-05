package com.example.simple_project.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.simple_project.model.User;
import com.example.simple_project.repository.UserRepository;

import java.util.List;

import io.reactivex.rxjava3.annotations.NonNull;

public class UserViewModel extends AndroidViewModel {
    private final UserRepository repository;
    private final LiveData<List<User>> allUsers;

    public UserViewModel(@NonNull Application application) {
        super(application);
        repository = new UserRepository(application);
        allUsers = repository.getAllUsers();
    }

    public LiveData<List<User>> getAllUsers() {
        return allUsers;
    }

    public void insert(User user) {
        repository.insert(user);
    }
}
