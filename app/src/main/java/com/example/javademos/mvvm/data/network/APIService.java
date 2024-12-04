package com.example.javademos.mvvm.data.network;

import com.example.javademos.mvvm.data.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("userlist")
    Call<List<User>> getUserList();
}
