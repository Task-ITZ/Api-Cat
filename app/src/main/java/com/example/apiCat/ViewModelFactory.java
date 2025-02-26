package com.example.apiCat;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.apiCat.api.ApiService;

import javax.inject.Inject;

public class ViewModelFactory implements ViewModelProvider.Factory {
    private final ApiService catApiService;

    @Inject
    public ViewModelFactory(ApiService catApiService) {
        this.catApiService = catApiService;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(CatViewModel.class)) {
            return (T) new CatViewModel(catApiService);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}

