package com.enunui.grandma;

public class HerbBean  {


    private String HerbTitle;
    private  String Description;
    private int HerbThumbnail;
    private String ImageNailUrl;
    //Setting List
    private String subOneTitle;
    private String subOneCon;
    private  String subTwoTitle;
    private String subTwoCon;
    private  String subThreeTitle;
    private String subThreeCon;
    private String subFourTitle;
    private String subFourCon;
    private String subFiveTitle;
    private String subFiveCon;

    public HerbBean() {
    }

    public HerbBean(String herbTitle, String description, String imageNailUrl, String subOneTitle, String subOneCon, String subTwoTitle, String subTwoCon, String subThreeTitle, String subThreeCon, String subFourTitle, String subFourCon, String subFiveTitle, String subFiveCon) {
        HerbTitle = herbTitle;
        Description = description;
        ImageNailUrl = imageNailUrl;
        this.subOneTitle = subOneTitle;
        this.subOneCon = subOneCon;
        this.subTwoTitle = subTwoTitle;
        this.subTwoCon = subTwoCon;
        this.subThreeTitle = subThreeTitle;
        this.subThreeCon = subThreeCon;
        this.subFourTitle = subFourTitle;
        this.subFourCon = subFourCon;
        this.subFiveTitle = subFiveTitle;
        this.subFiveCon = subFiveCon;
    }

    public String getHerbTitle() {
        return HerbTitle;
    }

    public void setHerbTitle(String herbTitle) {
        HerbTitle = herbTitle;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getHerbThumbnail() {
        return HerbThumbnail;
    }

    public void setHerbThumbnail(int herbThumbnail) {
        HerbThumbnail = herbThumbnail;
    }

    public String getImageNailUrl() {
        return ImageNailUrl;
    }

    public void setImageNailUrl(String imageNailUrl) {
        ImageNailUrl = imageNailUrl;
    }

    //herb List


    public String getSubOneTitle() {
        return subOneTitle;
    }

    public void setSubOneTitle(String subOneTitle) {
        this.subOneTitle = subOneTitle;
    }

    public String getSubOneCon() {
        return subOneCon;
    }

    public void setSubOneCon(String subOneCon) {
        this.subOneCon = subOneCon;
    }

    public String getSubTwoTitle() {
        return subTwoTitle;
    }

    public void setSubTwoTitle(String subTwoTitle) {
        this.subTwoTitle = subTwoTitle;
    }

    public String getSubTwoCon() {
        return subTwoCon;
    }

    public void setSubTwoCon(String subTwoCon) {
        this.subTwoCon = subTwoCon;
    }

    public String getSubThreeTitle() {
        return subThreeTitle;
    }

    public void setSubThreeTitle(String subThreeTitle) {
        this.subThreeTitle = subThreeTitle;
    }

    public String getSubThreeCon() {
        return subThreeCon;
    }

    public void setSubThreeCon(String subThreeCon) {
        this.subThreeCon = subThreeCon;
    }

    public String getSubFourTitle() {
        return subFourTitle;
    }

    public void setSubFourTitle(String subFourTitle) {
        this.subFourTitle = subFourTitle;
    }

    public String getSubFourCon() {
        return subFourCon;
    }

    public void setSubFourCon(String subFourCon) {
        this.subFourCon = subFourCon;
    }

    public String getSubFiveTitle() {
        return subFiveTitle;
    }

    public void setSubFiveTitle(String subFiveTitle) {
        this.subFiveTitle = subFiveTitle;
    }

    public String getSubFiveCon() {
        return subFiveCon;
    }

    public void setSubFiveCon(String subFiveCon) {
        this.subFiveCon = subFiveCon;
    }
}
