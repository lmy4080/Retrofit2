package com.circleglasses.retrofit2;

/**
 * MainActivity Functions
 * 1. Create And Call Retrofit
 * 2. Set Ui WIth A Response From WebServer
 */

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Retrofit mRetrofit;
    private RetrofitAPI mRetrofitAPI;
    private Call<ServerResponse> mCallLottery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRetrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // The Retrofit class generates an implementation of the RetrofitAPI interface.
        mRetrofitAPI = mRetrofit.create(RetrofitAPI.class);

        // Each Call from the created RetrofitAPI can make a synchronous or asynchronous HTTP request to the remote webserver.
        mCallLottery = mRetrofitAPI.getRandomNumbers();
        mCallLottery.enqueue(mRetrofitCallback);
    }

    /* Retrofit Callback */
    private Callback<ServerResponse> mRetrofitCallback = new Callback<ServerResponse>() {

        @Override
        public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
            Log.d("TAG",response.code()+"");
            Log.d("TAG",response.body().getMessage());
            Log.d("TAG",response.body().getNums());
        }

        @Override
        public void onFailure(Call<ServerResponse> call, Throwable t) {
            t.printStackTrace();
        }
    };
}
