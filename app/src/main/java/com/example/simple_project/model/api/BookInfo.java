package com.example.simple_project.model.api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BookInfo {
    @SerializedName("page")
    private int page;
    @SerializedName("per_page")
    private int perPage;
    @SerializedName("total")
    private int total;
    @SerializedName("total_pages")
    private int totalPages;
    @SerializedName("data")
    private List<BookAuthor> authorDataList;
    @SerializedName("support")
    private BookSupport bookSupport;
}
