package com.example.apiCat.api;

import com.example.apiCat.CatImage;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    // "https://api.thecatapi.com/v1/images/search?limit=10
    @GET("search?limit=10")
    Call<List<CatImage>> getCatImages();
}
