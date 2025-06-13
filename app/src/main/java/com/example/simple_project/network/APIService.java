package com.example.simple_project.network;

import com.example.simple_project.model.api.Book.UserResponse;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface APIService {
    @GET("api/users?page=2")
    Single<UserResponse> getUserResponse();

}
