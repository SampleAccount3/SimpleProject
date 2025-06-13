package com.example.simple_project.model.api.Book;

import com.google.gson.annotations.SerializedName;

public class Support {
    @SerializedName("url")
    private String url;
    @SerializedName("text")
    private String text;

    public String getUrl() {
        return url;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Support{" +
                "url='" + url + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
