package com.example.simple_project.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.simple_project.model.api.Book.UserResponse;
import com.example.simple_project.model.db.User.User;
import com.example.simple_project.repository.UserRepository;

import java.util.List;

import io.reactivex.rxjava3.annotations.NonNull;

public class UserViewModel extends AndroidViewModel {
    private final UserRepository repository;
    private final LiveData<List<User>> allUsers;
    private final LiveData<UserResponse> apiUsers;

    public UserViewModel(@NonNull Application application) {
        super(application);
        repository = new UserRepository(application);
        allUsers = repository.getAllUsers();
        apiUsers = repository.getApiUsers();
    }
    public LiveData<List<User>> getAllUsers() {
        return allUsers;
    }
    public void insert(User user) {
        repository.insert(user);
    }
    public void deleteAll() {
        repository.deleteAll();
    }
    public LiveData<UserResponse> getApiUsers() {
        return apiUsers;
    }

}
