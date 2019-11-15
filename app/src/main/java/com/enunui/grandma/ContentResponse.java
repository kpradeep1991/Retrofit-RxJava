package com.enunui.grandma;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ContentResponse implements Parcelable {

    private String TAG = ContentResponse.class.getSimpleName();

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("mobile")
    @Expose
    private String mobile;

    @SerializedName("video_id")
    @Expose
    private String video_id;



    @SerializedName("content")
    @Expose

    private String content;


    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("image")
    @Expose
    private String image;


    @SerializedName("sub_one")
    @Expose

    private String sub_one;

    @SerializedName("sub_one_con")
    @Expose

    private String sub_one_con;

    @SerializedName("sub_two")
    @Expose

    private String sub_two;

    @SerializedName("sub_two_con")
    @Expose

    private String sub_two_con;

    @SerializedName("sub_three")
    @Expose

    private String sub_three;

    @SerializedName("sub_three_con")
    @Expose

    private String sub_three_con;

    @SerializedName("sub_four")
    @Expose

    private String sub_four;


    @SerializedName("sub_four_con")
    @Expose

    private String sub_four_con;


    @SerializedName("sub_five")
    @Expose

    private String sub_five;

    @SerializedName("sub_five_con")
    @Expose

    private String sub_five_con;




    @SerializedName("cdate")
    @Expose
    private String cdate;

    @SerializedName("cip")
    @Expose
    private String cip;

    @SerializedName("last_update")
    @Expose
    private String last_update;





    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getVideo_id() {
        return video_id;
    }

    public void setVideo_id(String video_id) {
        this.video_id = video_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }



    public void setImage(String image) {
        this.image = image;
    }

    public String getSub_one() {
        return sub_one;
    }

    public void setSub_one(String sub_one) {
        this.sub_one = sub_one;
    }

    public String getSub_one_con() {
        return sub_one_con;
    }

    public void setSub_one_con(String sub_one_con) {
        this.sub_one_con = sub_one_con;
    }

    public String getSub_two() {
        return sub_two;
    }

    public void setSub_two(String sub_two) {
        this.sub_two = sub_two;
    }

    public String getSub_two_con() {
        return sub_two_con;
    }

    public void setSub_two_con(String sub_two_con) {
        this.sub_two_con = sub_two_con;
    }

    public String getSub_three() {
        return sub_three;
    }

    public void setSub_three(String sub_three) {
        this.sub_three = sub_three;
    }

    public String getSub_three_con() {
        return sub_three_con;
    }

    public void setSub_three_con(String sub_three_con) {
        this.sub_three_con = sub_three_con;
    }

    public String getSub_four() {
        return sub_four;
    }

    public void setSub_four(String sub_four) {
        this.sub_four = sub_four;
    }

    public String getSub_four_con() {
        return sub_four_con;
    }

    public void setSub_four_con(String sub_four_con) {
        this.sub_four_con = sub_four_con;
    }

    public String getSub_five() {
        return sub_five;
    }

    public void setSub_five(String sub_five) {
        this.sub_five = sub_five;
    }

    public String getSub_five_con() {
        return sub_five_con;
    }

    public void setSub_five_con(String sub_five_con) {
        this.sub_five_con = sub_five_con;
    }

    public String getCdate() {
        return cdate;
    }

    public void setCdate(String cdate) {
        this.cdate = cdate;
    }

    public String getCip() {
        return cip;
    }

    public void setCip(String cip) {
        this.cip = cip;
    }

    public String getLast_update() {
        return last_update;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(status);
        dest.writeString(id);
        dest.writeString(mobile);
        dest.writeString(video_id);

        dest.writeString(content);
        dest.writeString(title);
        dest.writeString(image);

        dest.writeString(sub_one);
        dest.writeString(sub_one_con);
        dest.writeString(sub_two);
        dest.writeString(sub_two_con);
        dest.writeString(sub_three);
        dest.writeString(sub_three_con);
        dest.writeString(sub_four);
        dest.writeString(sub_four_con);
        dest.writeString(sub_five);
        dest.writeString(sub_five_con);


        dest.writeString(cdate);
        dest.writeString(cip);
        dest.writeString(last_update);
    }


    public ContentResponse() {
    }

    public static final Creator<ContentResponse> CREATOR = new Creator<ContentResponse>() {
        @Override
        public ContentResponse createFromParcel(Parcel in) {
            return new ContentResponse(in);
        }

        @Override
        public ContentResponse[] newArray(int size) {
            return new ContentResponse[size];
        }
    };

    protected ContentResponse(Parcel in) {
        status = in.readString();
        id = in.readString();
        mobile = in.readString();
        video_id = in.readString();

        content=in.readString();

        title=in.readString();
        image=in.readString();

        sub_one=in.readString();
        sub_one_con=in.readString();
        sub_two=in.readString();
        sub_two_con=in.readString();
        sub_three=in.readString();
        sub_three_con=in.readString();
        sub_four=in.readString();
        sub_four_con=in.readString();
        sub_five=in.readString();
        sub_five_con=in.readString();


        cdate = in.readString();
        cip = in.readString();
        last_update = in.readString();


        Log.d(TAG, "content response from json background - "+Thread.currentThread().getName());


    }
}
