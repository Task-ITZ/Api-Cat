package com.example.apiCat.api;

import com.example.apiCat.CatImage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.Part;

public interface ApiService {
    // "https://api.thecatapi.com/v1/images/search?limit=10
    public static final String DOMAIN = "https://api.thecatapi.com/v1/images/";

    @GET("search?limit=10")
    Call<List<CatImage>> getCatImages();
}
