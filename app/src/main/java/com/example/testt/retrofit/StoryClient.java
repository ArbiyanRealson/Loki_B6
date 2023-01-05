package com.example.testt.retrofit;

import androidx.annotation.Nullable;

import com.example.testt.datamodels.DetailLogbookResponse;
import com.example.testt.datamodels.DetailTAResponse;
import com.example.testt.datamodels.ListLogbookResponse;
import com.example.testt.datamodels.ListLogbookkResponse;
import com.example.testt.datamodels.LoginResponse;
import com.example.testt.datamodels.LogoutResponse;
import com.example.testt.datamodels.TambahLogbookResponse;

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

    @GET("/api/theses/309")
    Call<DetailTAResponse> detailta(
            @Header("Authorization")String token
    );

    @FormUrlEncoded
    @POST("/api/theses/309/logbooks")
    Call<TambahLogbookResponse> tambahLogbook(
            @Field("supervisor_id") String supervisor_id,
            @Field("date") String date,
            @Field("progress") String progress,
            @Field("problem") String problem,
            @Header("Authorization") String token
    );

    @GET("/api/theses/309/logbooks")
    Call<ListLogbookkResponse> listlb(
            @Header("Authorization") String token
    );
}
