package com.example.apiCat;

import com.google.gson.annotations.SerializedName;

public class CatImage {
    @SerializedName("url")
    private String url;

    public String getUrl() {
        return url;
    }

}
