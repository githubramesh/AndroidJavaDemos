package com.example.javademos.dagger2.network;

import com.example.javademos.dagger2.model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductListApiService {

    @GET("listOfProducts")
    Call<List<Product>> getProductList();
}
