package com.cavistademoapp;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;

import com.cavistademoapp.adapter_section.AdapterImageList;
import com.cavistademoapp.interface_section.ClickListener;
import com.cavistademoapp.kotlin.ActivityImageDetails;
import com.cavistademoapp.request_response_section.Image;
import com.cavistademoapp.request_response_section.ResponseImageList;
import com.cavistademoapp.view_model_section.ViewModelListOfImages;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.core.ImageTranscoderType;
import com.facebook.imagepipeline.core.MemoryChunkType;

import java.util.ArrayList;
import java.util.List;


public class ActivityLandingPage extends BaseActivity implements SearchView.OnQueryTextListener, View.OnClickListener {

    public static final String KEY_LINK = "image_link";
    public static final String KEY_ID = "unique_id";
    public static final String KEY_BUNDLE = "bundle";
    private String mSearchField = "vanilla";

    private ViewModelListOfImages mViewModel;
    private AdapterImageList mAdapter;
    private int pastVisibleItems, visibleItemCount, totalItemCount;
    private String mPageNext = null;
    private String mPagePrevious = null;
    private boolean isQuerySubmit;
    private RecyclerView mRecyclerView;
    private List<Image> mList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        initViewModel();

        init();

        initFresco();

        callImages();

        initRecyclerView();

        hideKeyboard(this);
    }

    private void initRecyclerView() {

        GridLayoutManager mLayoutManager;
        if (isPortrait()) {
            mLayoutManager = new GridLayoutManager(this, 3);
        } else {
            mLayoutManager = new GridLayoutManager(this, 6);
        }

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        if (isNetworkConnected(this)) {
            /**
             * To detect the scrolling end to load next page
             */
            mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                    if (dy > 0) {
                        visibleItemCount = mLayoutManager.getChildCount();
                        totalItemCount = mLayoutManager.getItemCount();
                        pastVisibleItems = mLayoutManager.findFirstVisibleItemPosition();

                        if ((visibleItemCount + pastVisibleItems) >= totalItemCount) {
                            if (mPageNext != null) {
                                showLoading();
                                isQuerySubmit = false;
                                callImages();
                            }
                        }
                    }
                }
            });

            if (mPagePrevious == null) {

                isQuerySubmit = false;
                // request for view model to get list of Image from repository
                callImages();
                //abstract method for progress bar
                showLoading();
            }
        } else {
            showMessage(this, getString(R.string.error_internet));
        }

    }

    private void initFresco() {
        Fresco.initialize(
                this,
                ImagePipelineConfig.newBuilder(this)
                        .setMemoryChunkType(MemoryChunkType.BUFFER_MEMORY)
                        .setImageTranscoderType(ImageTranscoderType.JAVA_TRANSCODER)
                        .experiment().setNativeCodeDisabled(true)
                        .build());
    }

    /**
     * initialize listeners
     */
    private void init() {
        SearchView mSearchView = (SearchView) findViewById(R.id.searchView);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewImage);

        mSearchView.setOnQueryTextListener(this);
    }

    /**
     * view model initializer get data , set adapter for list
     */
    private void initViewModel() {
        mViewModel = ViewModelProviders.of(this).get(ViewModelListOfImages.class);
        mViewModel.initialize();

        setAdapter();

        //observer of live data change after loading from server
        mViewModel.getLiveDataUpdate().observe(this, new Observer<ResponseImageList>() {
            @Override
            public void onChanged(ResponseImageList responseImageList) {

                hideLoading();

                if (responseImageList.getData() != null) {
                    mList = new ArrayList<>();
                    for (int i = 0; i < responseImageList.getData().size(); i++) {
                        if (responseImageList.getData().get(i).getImages() != null) {
                            for (Image subList : responseImageList.getData().get(i).getImages()) {
                                mList.add(subList);
                            }
                        }
                    }
                    mAdapter.addData(mList);
                }

            }
        });
    }

    private void setAdapter() {
        mAdapter = new AdapterImageList(this, new ClickListener() {
            @Override
            public void onPositionClicked(int position) {
                Bundle mBundle = new Bundle();
                mBundle.putString(KEY_LINK, mList.get(position).getLink());
                mBundle.putString(KEY_ID, mList.get(position).getId());
                startActivity(new Intent(ActivityLandingPage.this, ActivityImageDetails.class).putExtra(KEY_BUNDLE, mBundle));
            }

            @Override
            public void onClickCurrItem() {

            }
        });
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        showLoading();
        isQuerySubmit = true;
        mSearchField = s;
        callImages();
        return false;
    }

    /**
     * method call to get list of images from server
     */
    public void callImages() {
        if (isNetworkConnected(this)) {
            mViewModel.getImageList("3/gallery/search/" + mPageNext + "?q=" + mSearchField + "");
        } else {
            showMessage(this, getString(R.string.error_internet));
        }
    }

    @Override
    public boolean onQueryTextChange(String s) {
        return false;
    }
}