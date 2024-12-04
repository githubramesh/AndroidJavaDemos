package com.example.javademos.dagger2.network;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {
    private final String baseURL;

    public NetworkModule(String baseURL) {
        this.baseURL = baseURL;
    }

    @Provides
    Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    ProductListApiService provideAPIService(Retrofit retrofit) {
        return retrofit.create(ProductListApiService.class);
    }
}
