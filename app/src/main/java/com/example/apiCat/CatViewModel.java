package com.example.apiCat;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.apiCat.api.ApiService;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CatViewModel extends ViewModel {
    private final MutableLiveData<List<CatImage>> cats = new MutableLiveData<>();
    private final MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    private final ApiService apiService;
    @Inject
    public CatViewModel(ApiService apiService) {
        this.apiService = apiService;
        fetchCats();
    }
    public LiveData<List<CatImage>> getCats() {
        return cats;
    }
    private void fetchCats() {
        isLoading.postValue(true);
        apiService.getCatImages().enqueue(new Callback<List<CatImage>>() {
            @Override
            public void onResponse(Call<List<CatImage>> call, Response<List<CatImage>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    cats.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<CatImage>> call, Throwable t) {
            }
        });
    }
}
