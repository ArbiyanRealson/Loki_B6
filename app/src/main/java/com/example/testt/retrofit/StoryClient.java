package com.example.testt.retrofit;

import androidx.annotation.Nullable;

import com.example.testt.datamodels.DetailLogbookResponse;
import com.example.testt.datamodels.LoginResponse;
import com.example.testt.datamodels.LogoutResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.GET;

public interface StoryClient {
    @FormUrlEncoded
    @POST("/api/login")
    Call<LoginResponse> login(@Field("username") String username, @Field("password") String password);

    @POST("/api/logout")
    Call<LogoutResponse> logout(@Header("Authorization") String token);


    @GET("/api/theses/200/logbooks/399")
    Call<DetailLogbookResponse> detailLogbook(
            @Header("Authorization")String token
    );
}
