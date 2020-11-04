
package com.cavistademoapp.request_response_section;

import java.util.List;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class AdConfig {

    @SerializedName("highRiskFlags")
    private List<Object> mHighRiskFlags;
    @SerializedName("safeFlags")
    private List<String> mSafeFlags;
    @SerializedName("showsAds")
    private Boolean mShowsAds;
    @SerializedName("unsafeFlags")
    private List<Object> mUnsafeFlags;
    @SerializedName("wallUnsafeFlags")
    private List<Object> mWallUnsafeFlags;

    public List<Object> getHighRiskFlags() {
        return mHighRiskFlags;
    }

    public void setHighRiskFlags(List<Object> highRiskFlags) {
        mHighRiskFlags = highRiskFlags;
    }

    public List<String> getSafeFlags() {
        return mSafeFlags;
    }

    public void setSafeFlags(List<String> safeFlags) {
        mSafeFlags = safeFlags;
    }

    public Boolean getShowsAds() {
        return mShowsAds;
    }

    public void setShowsAds(Boolean showsAds) {
        mShowsAds = showsAds;
    }

    public List<Object> getUnsafeFlags() {
        return mUnsafeFlags;
    }

    public void setUnsafeFlags(List<Object> unsafeFlags) {
        mUnsafeFlags = unsafeFlags;
    }

    public List<Object> getWallUnsafeFlags() {
        return mWallUnsafeFlags;
    }

    public void setWallUnsafeFlags(List<Object> wallUnsafeFlags) {
        mWallUnsafeFlags = wallUnsafeFlags;
    }

}
