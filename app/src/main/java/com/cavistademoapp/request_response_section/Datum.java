
package com.cavistademoapp.request_response_section;

import java.util.List;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Datum {

    @SerializedName("account_id")
    private Long mAccountId;
    @SerializedName("account_url")
    private String mAccountUrl;
    @SerializedName("ad_config")
    private AdConfig mAdConfig;
    @SerializedName("ad_type")
    private Long mAdType;
    @SerializedName("ad_url")
    private String mAdUrl;
    @SerializedName("comment_count")
    private Long mCommentCount;
    @SerializedName("cover")
    private String mCover;
    @SerializedName("cover_height")
    private Long mCoverHeight;
    @SerializedName("cover_width")
    private Long mCoverWidth;
    @SerializedName("datetime")
    private Long mDatetime;
    @SerializedName("description")
    private Object mDescription;
    @SerializedName("downs")
    private Long mDowns;
    @SerializedName("favorite")
    private Boolean mFavorite;
    @SerializedName("favorite_count")
    private Long mFavoriteCount;
    @SerializedName("id")
    private String mId;
    @SerializedName("images")
    private List<Image> mImages;
    @SerializedName("images_count")
    private Long mImagesCount;
    @SerializedName("in_gallery")
    private Boolean mInGallery;
    @SerializedName("in_most_viral")
    private Boolean mInMostViral;
    @SerializedName("include_album_ads")
    private Boolean mIncludeAlbumAds;
    @SerializedName("is_ad")
    private Boolean mIsAd;
    @SerializedName("is_album")
    private Boolean mIsAlbum;
    @SerializedName("layout")
    private String mLayout;
    @SerializedName("link")
    private String mLink;
    @SerializedName("nsfw")
    private Boolean mNsfw;
    @SerializedName("points")
    private Long mPoints;
    @SerializedName("privacy")
    private String mPrivacy;
    @SerializedName("score")
    private Long mScore;
    @SerializedName("section")
    private String mSection;
    @SerializedName("tags")
    private List<Tag> mTags;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("topic")
    private String mTopic;
    @SerializedName("topic_id")
    private Long mTopicId;
    @SerializedName("ups")
    private Long mUps;
    @SerializedName("views")
    private Long mViews;
    @SerializedName("vote")
    private Object mVote;

    public Long getAccountId() {
        return mAccountId;
    }

    public void setAccountId(Long accountId) {
        mAccountId = accountId;
    }

    public String getAccountUrl() {
        return mAccountUrl;
    }

    public void setAccountUrl(String accountUrl) {
        mAccountUrl = accountUrl;
    }

    public AdConfig getAdConfig() {
        return mAdConfig;
    }

    public void setAdConfig(AdConfig adConfig) {
        mAdConfig = adConfig;
    }

    public Long getAdType() {
        return mAdType;
    }

    public void setAdType(Long adType) {
        mAdType = adType;
    }

    public String getAdUrl() {
        return mAdUrl;
    }

    public void setAdUrl(String adUrl) {
        mAdUrl = adUrl;
    }

    public Long getCommentCount() {
        return mCommentCount;
    }

    public void setCommentCount(Long commentCount) {
        mCommentCount = commentCount;
    }

    public String getCover() {
        return mCover;
    }

    public void setCover(String cover) {
        mCover = cover;
    }

    public Long getCoverHeight() {
        return mCoverHeight;
    }

    public void setCoverHeight(Long coverHeight) {
        mCoverHeight = coverHeight;
    }

    public Long getCoverWidth() {
        return mCoverWidth;
    }

    public void setCoverWidth(Long coverWidth) {
        mCoverWidth = coverWidth;
    }

    public Long getDatetime() {
        return mDatetime;
    }

    public void setDatetime(Long datetime) {
        mDatetime = datetime;
    }

    public Object getDescription() {
        return mDescription;
    }

    public void setDescription(Object description) {
        mDescription = description;
    }

    public Long getDowns() {
        return mDowns;
    }

    public void setDowns(Long downs) {
        mDowns = downs;
    }

    public Boolean getFavorite() {
        return mFavorite;
    }

    public void setFavorite(Boolean favorite) {
        mFavorite = favorite;
    }

    public Long getFavoriteCount() {
        return mFavoriteCount;
    }

    public void setFavoriteCount(Long favoriteCount) {
        mFavoriteCount = favoriteCount;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public List<Image> getImages() {
        return mImages;
    }

    public void setImages(List<Image> images) {
        mImages = images;
    }

    public Long getImagesCount() {
        return mImagesCount;
    }

    public void setImagesCount(Long imagesCount) {
        mImagesCount = imagesCount;
    }

    public Boolean getInGallery() {
        return mInGallery;
    }

    public void setInGallery(Boolean inGallery) {
        mInGallery = inGallery;
    }

    public Boolean getInMostViral() {
        return mInMostViral;
    }

    public void setInMostViral(Boolean inMostViral) {
        mInMostViral = inMostViral;
    }

    public Boolean getIncludeAlbumAds() {
        return mIncludeAlbumAds;
    }

    public void setIncludeAlbumAds(Boolean includeAlbumAds) {
        mIncludeAlbumAds = includeAlbumAds;
    }

    public Boolean getIsAd() {
        return mIsAd;
    }

    public void setIsAd(Boolean isAd) {
        mIsAd = isAd;
    }

    public Boolean getIsAlbum() {
        return mIsAlbum;
    }

    public void setIsAlbum(Boolean isAlbum) {
        mIsAlbum = isAlbum;
    }

    public String getLayout() {
        return mLayout;
    }

    public void setLayout(String layout) {
        mLayout = layout;
    }

    public String getLink() {
        return mLink;
    }

    public void setLink(String link) {
        mLink = link;
    }

    public Boolean getNsfw() {
        return mNsfw;
    }

    public void setNsfw(Boolean nsfw) {
        mNsfw = nsfw;
    }

    public Long getPoints() {
        return mPoints;
    }

    public void setPoints(Long points) {
        mPoints = points;
    }

    public String getPrivacy() {
        return mPrivacy;
    }

    public void setPrivacy(String privacy) {
        mPrivacy = privacy;
    }

    public Long getScore() {
        return mScore;
    }

    public void setScore(Long score) {
        mScore = score;
    }

    public String getSection() {
        return mSection;
    }

    public void setSection(String section) {
        mSection = section;
    }

    public List<Tag> getTags() {
        return mTags;
    }

    public void setTags(List<Tag> tags) {
        mTags = tags;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getTopic() {
        return mTopic;
    }

    public void setTopic(String topic) {
        mTopic = topic;
    }

    public Long getTopicId() {
        return mTopicId;
    }

    public void setTopicId(Long topicId) {
        mTopicId = topicId;
    }

    public Long getUps() {
        return mUps;
    }

    public void setUps(Long ups) {
        mUps = ups;
    }

    public Long getViews() {
        return mViews;
    }

    public void setViews(Long views) {
        mViews = views;
    }

    public Object getVote() {
        return mVote;
    }

    public void setVote(Object vote) {
        mVote = vote;
    }

}
