package com.example.simple_project.model.api.Book;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserResponse {
    @SerializedName("page")
    private int page;
    @SerializedName("per_page")
    private int perPage;
    @SerializedName("total")
    private int total;
    @SerializedName("total_pages")
    private int totalPages;
    @SerializedName("data")
    private List<Author> data;
    @SerializedName("support")
    private Support support;

    public int getPage() {
        return page;
    }

    public int getPerPage() {
        return perPage;
    }

    public int getTotal() {
        return total;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public List<Author> getData() {
        return data;
    }

    public Support getSupport() {
        return support;
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "page=" + page +
                ", perPage=" + perPage +
                ", total=" + total +
                ", totalPages=" + totalPages +
                ", data=" + getDataDetails() +
                ", support=" + support.toString() +
                '}';
    }

    private String getDataDetails(){
        StringBuilder builder = new StringBuilder();
        for (Author item : data) {
            builder.append(item.toString()).append(" ");
        }
        return builder.toString();
    }
}
