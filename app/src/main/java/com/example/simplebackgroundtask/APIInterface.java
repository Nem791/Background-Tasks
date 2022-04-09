package com.example.simplebackgroundtask;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface APIInterface {
    @GET("users")
    Call<ArrayList<User>> getAllUsers();

    @GET("users/{id}")
    Call<User> getUsersByID(@Path("id") int id);

    String token = "cf6d270da8ffe5a4ccb5ecb9fb17cbf36ef8ef01ea39f557ade18207fdc533f1";
    @POST("users?access-token=" + token)
    Call<User> addUser(@Body() User user);

    @DELETE("users/{id}?access-token=" + token)
    Call<Void> deleteUser(@Path("id") int id);

    @PUT("users/{id}?access-token=" + token)
    Call<Void> updateUser(@Path("id") int id, @Body() User user);
}
