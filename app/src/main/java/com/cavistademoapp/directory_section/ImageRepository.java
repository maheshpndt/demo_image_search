package com.cavistademoapp.directory_section;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.cavistademoapp.interface_section.ApiInterface;
import com.cavistademoapp.request_response_section.ResponseImageList;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ImageRepository {
    private static final String BASE_URL = "https://api.imgur.com/";
    private MutableLiveData<ResponseImageList> mResponseLiveData;
    private ApiInterface mApiInterface;

    /**
     * Use : create object builder for api calling
     */
    public ImageRepository() {
        this.mResponseLiveData = new MutableLiveData<>();

        HttpLoggingInterceptor mInterceptor = new HttpLoggingInterceptor();
        mInterceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient mClient = new OkHttpClient.Builder().addInterceptor(mInterceptor).build();

        mApiInterface = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .client(mClient)
                .build()
                .create(ApiInterface.class);
    }

    /**
     * Use           : trigger api call for to get list of images
     * mApiInterface : callback for response
     * @param url : api end point for images details
     */
    public void getImageList(String url){
        try {
            mApiInterface.getImageList(url).enqueue(new Callback<ResponseImageList>() {
                @Override
                public void onResponse(Call<ResponseImageList> call, Response<ResponseImageList> response) {
                    if (response.isSuccessful()) {
                        mResponseLiveData.postValue(response.body());
                    } else {
                        mResponseLiveData.postValue(null);
                    }
                }

                @Override
                public void onFailure(Call<ResponseImageList> call, Throwable t) {
                    mResponseLiveData.postValue(null);
                }
            });
        } catch (Exception e){
            mResponseLiveData.postValue(null);
        }
    }

    /*
     * use : use to get updated response to the view model
     * */
    public LiveData<ResponseImageList> getResponseLiveData(){
        return mResponseLiveData;
    }

}
