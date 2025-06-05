package com.example.simple_project.model.api;

import com.google.gson.annotations.SerializedName;

public class BookAuthor {
    @SerializedName("id")
    private int id;
    @SerializedName("email")
    private String email;
    @SerializedName("first_name")
    private String firstName;
    @SerializedName("last_name")
    private String lastName;
    @SerializedName("avatar")
    private String avatar;
}
