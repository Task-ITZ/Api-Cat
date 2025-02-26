package com.example.apiCat;


import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import javax.inject.Inject;


public class MainActivity extends AppCompatActivity {
    @Inject
    ViewModelProvider.Factory viewModelFactory;
    private CatViewModel catViewModel;
    private RecyclerView recyclerView;
    private CatAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppComponent appComponent = DaggerAppComponent.create();
        appComponent.inject(this);
        viewModelFactory = appComponent.getViewModelFactory();

        recyclerView = findViewById(R.id.rcv_cat);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CatAdapter();
        recyclerView.setAdapter(adapter);

        catViewModel = new ViewModelProvider(this, viewModelFactory).get(CatViewModel.class);
        catViewModel.getCats().observe(this, cats -> adapter.setCatAdapter(cats));
    }


}