package com.example.aplikaslogindanregister.api;

import com.example.aplikaslogindanregister.model.login.Login;
import com.example.aplikaslogindanregister.model.register.Register;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

   @FormUrlEncoded
   @POST("login.php")
    Call<Login> loginResponse(
     @Field("username") String username,
     @Field("password") String password
   );

    @FormUrlEncoded
    @POST("register.php")
    Call<Register> registerResponse(
            @Field("username") String username,
            @Field("password") String password,
            @Field("name") String name
    );

}
