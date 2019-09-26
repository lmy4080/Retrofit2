package com.circleglasses.retrofit2;

/**
 * Retrofit Interface
 */

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitAPI {
    @GET("/lottery")
    Call<ServerResponse> getRandomNumbers();
}
