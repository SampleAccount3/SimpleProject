package com.example.simple_project.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Room;

import com.example.simple_project.database.AppDatabase;
import com.example.simple_project.model.api.Book.UserResponse;
import com.example.simple_project.model.db.User.User;
import com.example.simple_project.model.db.User.UserDao;
import com.example.simple_project.network.APIClient;
import com.example.simple_project.network.APIService;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;

import io.reactivex.Observable;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class UserRepository {
    private UserDao userDao;
    private LiveData<List<User>>  allUsers;
    private APIService apiService;
    private final CompositeDisposable disposables = new CompositeDisposable();

    public UserRepository(Application application) {
        AppDatabase db = Room.databaseBuilder(application, AppDatabase.class, "app_db.db").build();
        userDao = db.userDao();
        apiService = APIClient.getAPIService();
        allUsers = userDao.getAllUsers();
    }

    public LiveData<List<User>> getAllUsers() {
        return allUsers;
    }
    public void deleteAll() {
        Executors.newSingleThreadExecutor().execute(() -> userDao.deleteAll());
    }

    public void insert(User user) {
        Executors.newSingleThreadExecutor().execute(() -> userDao.insert(user));
    }

    public LiveData<UserResponse> getApiUsers() {
        MutableLiveData<UserResponse> usersLiveData = new MutableLiveData<>();

        Disposable disposable = apiService.getUserResponse()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(usersLiveData::setValue, e -> usersLiveData.setValue(null));

        disposables.add(disposable);
        return usersLiveData;
    }



}
