package com.example.javademos.dagger2.network;

import com.example.javademos.dagger2.view.ProductListActivity;

import dagger.Component;

@Component(modules = {NetworkModule.class})
public interface AppComponent {
    ProductListApiService getAPIService();

    void inject(ProductListActivity productListActivity);
}
