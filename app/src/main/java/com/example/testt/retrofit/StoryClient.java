package com.example.testt.retrofit;

import com.example.testt.datamodels.DetailSeminarResponse;
import com.example.testt.datamodels.FormSemhasResponse;
import com.example.testt.datamodels.ListPesertaResponse;
import com.example.testt.datamodels.LoginResponse;
import com.example.testt.datamodels.LogoutResponse;
import com.example.testt.datamodels.ReviewersItem;

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

    @GET("/api/theses/309/seminars")
    Call<DetailSeminarResponse> detailseminar(@Header("Authorization") String token);

    @GET("/api/thesis/seminars/322/audiences")
    Call<ListPesertaResponse> getAudiens(@Header("Authorization") String token);

    @POST("/api/theses/20/seminars")
    Call<FormSemhasResponse> getFromSemhas(@Header("Authorization") String token);

}
