package com.example.apiCat;

import androidx.lifecycle.ViewModelProvider;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component (modules = {NetworkModule.class})
public interface AppComponent {
    void inject(MainActivity mainActivity);
    ViewModelProvider.Factory getViewModelFactory();
}
