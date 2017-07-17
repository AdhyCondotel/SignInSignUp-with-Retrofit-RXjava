package com.ammase.latihanprodukdetail.api;

import com.ammase.latihanprodukdetail.model.listuser.ResponseGetListUser;
import com.ammase.latihanprodukdetail.model.sigin.ResponseAuth;
import com.ammase.latihanprodukdetail.model.sigin.ResponseGetLogin;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface RequestAPI {
    String a="";
    @FormUrlEncoded
    @POST("/m/register")
    Observable<ResponseAuth> register(@Field("name") String name,
                                      @Field("email") String email,
                                      @Field("password") String password);

    @FormUrlEncoded
    @POST("/m/login")
    Observable<ResponseGetLogin> login(@Field("email") String username,
                                       @Field("password") String password);

    @GET("/m/users")
    Observable<ResponseGetListUser> getUser(@Header("Authorization") String token);

}
