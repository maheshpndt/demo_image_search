package com.cavistademoapp.view_model_section;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.cavistademoapp.directory_section.ImageRepository;
import com.cavistademoapp.request_response_section.ResponseImageList;

/*
* Store and manage user data and also useful for handle rotation change scenario
* */

public class ViewModelListOfImages extends AndroidViewModel {

    private ImageRepository mBookRepository;
    private LiveData<ResponseImageList> mResponseLiveData;

    public ViewModelListOfImages(@NonNull Application application) {
        super(application);
    }

    public void initialize(){
        mBookRepository = new ImageRepository();
        mResponseLiveData = mBookRepository.getResponseLiveData();
    }

    public void getImageList(String url){
        mBookRepository.getImageList(url);
    }

    public LiveData<ResponseImageList> getLiveDataUpdate(){
        return mResponseLiveData;
    }

}
