package com.enunui.grandma;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;


import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.squareup.picasso.Picasso;

public class ContentActivity  extends AppCompatActivity {

    private AdView mAdView1,mAdview2,mAdview3,mAdview4,mAdview5,mAdview6;

    private InterstitialAd interstitialAd;




    private  TextView HerbTitle,description
            ,sub_One_Title,sub_One_Con,sub_Two_Title
            ,sub_Two_Con,sub_Three_Title,sub_Three_Con,sub_Four_Title
            ,sub_Four_Con,sub_Five_Title,sub_Five_Con;

    private ImageView ImageThumbnail;

    private String TAG = ContentActivity.class.getSimpleName();






    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

        //for ads
        MobileAds.initialize(this,"ca-app-pub-4764818391140715~8686139961");

        mAdView1 = findViewById(R.id.adView);
        mAdview2=findViewById(R.id.adView1);
        mAdview3=findViewById(R.id.adView2);
        mAdview4=findViewById(R.id.adView3);
        mAdview5=findViewById(R.id.adView4);
        mAdview6=findViewById(R.id.adView5);

        //for ad testing using device
       // AdRequest adRequest = new AdRequest.Builder().addTestDevice("E6C0695D9CA36DA0F3A75967D91218F5").build();

        AdRequest adRequest = new AdRequest.Builder().build();

         mAdView1.loadAd(adRequest);
         mAdview2.loadAd(adRequest);
         mAdview3.loadAd(adRequest);
         mAdview4.loadAd(adRequest);
         mAdview5.loadAd(adRequest);
         mAdview6.loadAd(adRequest);



        // Initialize the Mobile Ads SDK.
       // MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");

        // Create the InterstitialAd and set the adUnitId.
        interstitialAd = new InterstitialAd(this);
        // Defined in res/values/strings.xml
        interstitialAd.setAdUnitId(getString(R.string.ad_unit_id));

        AdRequest adRequest1 = new AdRequest.Builder().build();
        interstitialAd.loadAd(adRequest1);













//redirecting to home page
    getSupportActionBar().setHomeButtonEnabled(true);






         HerbTitle=(TextView)findViewById(R.id.txt_title);

         description=findViewById(R.id.txt_Desc);

         ImageThumbnail=findViewById(R.id.herb_thumb_nail);

        //for testing purposes

        sub_One_Title=findViewById(R.id.sub_One_Head);

        sub_One_Con=findViewById(R.id.sub_One_Desc);

        sub_Two_Title=findViewById(R.id.sub_Two_Head);

        sub_Two_Con=findViewById(R.id.sub_Two_Desc);


        sub_Three_Title=findViewById(R.id.sub_Three_Head);

        sub_Three_Con=findViewById(R.id.sub_Three_Desc);

        sub_Four_Title=findViewById(R.id.sub_Four_Head);

        sub_Four_Con=findViewById(R.id.sub_Four_Desc);

        sub_Five_Title=findViewById(R.id.sub_Five_Head);

        sub_Five_Con=findViewById(R.id.sub_Five_Desc);

        Intent intent=getIntent();

        //getting values from intant which is declared  and passed in recycler Adapter class

        String content_Title=intent.getExtras().getString("HerbTitle");

        String content_Desc=intent.getExtras().getString("Description");

        //int img_thumb=intent.getExtras().getInt("HerbThumbnail");

        String image_Uri=intent.getExtras().getString("ImageNailUrl");


        String subOneTitle=intent.getExtras().getString("subOneTitle");

        String subOneCon=intent.getExtras().getString("subOneCon");

        String subTwoTitle=intent.getExtras().getString("subTwoTitle");

        String subTwoCon=intent.getExtras().getString("subTwoCon");

        String subThreeTitle=intent.getExtras().getString("subThreeTitle");

        String subThreeCon=intent.getExtras().getString("subThreeCon");

        String subFourTitle=intent.getExtras().getString("subFourTitle");

        String subFourCon=intent.getExtras().getString("subFourCon");

        String subFiveTitle=intent.getExtras().getString("subFiveTitle");

        String subFiveCon=intent.getExtras().getString("subFiveCon");





        HerbTitle.setText(content_Title);

        description.setText(content_Desc);

        Picasso.get().load(image_Uri).centerCrop().fit().into(ImageThumbnail);

        sub_One_Title.setText(subOneTitle);

        sub_One_Con.setText(subOneCon);

        sub_Two_Title.setText(subTwoTitle);

        sub_Two_Con.setText(subTwoCon);

        sub_Three_Title.setText(subThreeTitle);

        sub_Three_Con.setText(subThreeCon);

        sub_Four_Title.setText(subFourTitle);

        sub_Four_Con.setText(subFourCon);

        sub_Five_Title.setText(subFiveTitle);

        sub_Five_Con.setText(subFiveCon);






        Log.d(TAG, "content Activity - "+Thread.currentThread().getName());

    }


    @Override
    public void onBackPressed() {

        if (interstitialAd.isLoaded()) {
            interstitialAd.show();
            interstitialAd.setAdListener(new AdListener() {
                @Override
                public void onAdClosed() {
                    super.onAdClosed();
                    finish();
                }
            });
        }else{
            super.onBackPressed();
        }
    }



}


