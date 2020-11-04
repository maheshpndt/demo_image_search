package com.cavistademoapp.interface_section;

import com.cavistademoapp.request_response_section.ResponseImageList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Url;

public interface ApiInterface {

    @Headers("Authorization:Client-ID 137cda6b5008a7c")
    @GET
    Call<ResponseImageList> getImageList(@Url String url);

}
