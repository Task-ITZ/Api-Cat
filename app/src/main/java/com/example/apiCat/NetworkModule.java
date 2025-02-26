package com.example.apiCat;

import androidx.lifecycle.ViewModelProvider;

import com.example.apiCat.api.ApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {
    private static final String DOMAIN = "https://api.thecatapi.com/v1/images/";
    @Provides
    @Singleton
    public Retrofit provideEtrofit(){
        return new Retrofit.Builder()
                .baseUrl(DOMAIN)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public ApiService provideCatApiService(Retrofit retrofit){
        return retrofit.create(ApiService.class);
    }

    @Provides
    @Singleton
    public ViewModelProvider.Factory provideViewModelFactory(ApiService catApiService) {
        return new ViewModelFactory(catApiService);
    }
}
