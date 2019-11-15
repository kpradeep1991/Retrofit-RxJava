package com.enunui.grandma;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.enunui.grandma.Interface.Api;
import com.enunui.grandma.Interface.core.ApiFail;
import com.enunui.grandma.Interface.core.HttpErrorResponse;


import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {



    private AdView mAdView1;
    private InterstitialAd interstitialAd1;

    final static List<ContentResponse> pollResponseList = new ArrayList<>();
    final List<HerbBean> HerbList = new ArrayList<>();
    private ProgressDialog pDialog;

    private String TAG = MainActivity.class.getSimpleName();




    RecyclerView recycleView;
    RecyclerViewAdapter myadapter;


    @Override
    protected void onCreate(final Bundle savedInstanceState) throws RuntimeException {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        pDialog = new ProgressDialog(MainActivity.this);
        pDialog.setMessage("Fetching Contents");

        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();


        recycleView = (RecyclerView) findViewById(R.id.card_recycler_view_id);

        getProductData();

        //for ads
        //for card ads
        

        
        MobileAds.initialize(this,"ca-app-pub-4764818391140715~8686139961");
        mAdView1 = findViewById(R.id.adView);

        //for testing ad using device
        //AdRequest adRequest = new AdRequest.Builder().addTestDevice("69D4BEA53FCAC3B62D091F44A8AEE390").build();

        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView1.loadAd(adRequest);


        //for refreshing new ads each time

        //mAdView.loadAd(new AdRequest.Builder().build())
        //AdView.loadAd(new AdRequest())



        // Create the InterstitialAd and set the adUnitId.
        interstitialAd1 = new InterstitialAd(this);
        // Defined in res/values/strings.xml
        interstitialAd1.setAdUnitId(getString(R.string.ad_unit_id));

        AdRequest adRequest1 = new AdRequest.Builder().build();
        interstitialAd1.loadAd(adRequest1);




    }

    private void getProductData() {

        Observable<String> observable = Api.ApiInterface().get_jsonContent("get_all_cmt", "7")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                //Dismiss Dialog
                pDialog.dismiss();


            }

            @Override
            public void onNext(String reportResponse) {

                try {
                    JSONArray jsonObject = new JSONArray(reportResponse);

                    System.out.println("json entered" + jsonObject);

                    for (int i = 0; i < jsonObject.length(); i++) {

                        JSONObject jsonObject1 = jsonObject.getJSONObject(i);

                        ContentResponse pollResponses = ContentResponseParsing.fromJson(jsonObject1);
                        pollResponseList.add(pollResponses);
                        //testing purposes for setting operations

                        if (pollResponseList.size() != 0) {

                            String contentView = jsonObject1.getString("content");
                            String titleView = jsonObject1.getString("title");
                            String imageUrl = jsonObject1.getString("image");
                            String sub_One_title = jsonObject1.getString("sub_one");
                            String sub_One_con = jsonObject1.getString("sub_one_con");
                            String sub_Two_title = jsonObject1.getString("sub_two");
                            String sub_Two_con = jsonObject1.getString("sub_two_con");
                            String sub_Three_title = jsonObject1.getString("sub_three");
                            String sub_Three_con = jsonObject1.getString("sub_three_con");
                            String sub_Four_title = jsonObject1.getString("sub_four");
                            String sub_Four_con = jsonObject1.getString("sub_four_con");
                            String sub_Five_title = jsonObject1.getString("sub_five");
                            String sub_Five_con = jsonObject1.getString("sub_five_con");

                            HerbList.add(new HerbBean(titleView, contentView, imageUrl, sub_One_title, sub_One_con, sub_Two_title
                                    , sub_Two_con, sub_Three_title, sub_Three_con, sub_Four_title, sub_Four_con, sub_Five_title, sub_Five_con));
                            //end of the setting segments
                            System.out.println(imageUrl);


                        }

                    }

                    System.out.println(HerbList.size() + "herblist from json block");


                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Toast.makeText(getApplicationContext(),reportResponse,Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(), "WELCOME FOLKS", Toast.LENGTH_LONG).show();
                //Dismiss Dialog
                pDialog.dismiss();

                recycleView = (RecyclerView) findViewById(R.id.card_recycler_view_id);
                //myadapter = new RecyclerViewAdapter(this, HerbList);
                RecyclerView.LayoutManager recyce = new GridLayoutManager(MainActivity.this, 2);
                recycleView.setLayoutManager(recyce);

                //recycleView.setLayoutManager(new GridLayoutManager(this, 2));
                recycleView.setAdapter(myadapter);


            }


        }); new ApiFail() {
            @Override
            protected void unknownError(Throwable e) {

                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();


            }

            @Override
            protected void noNetworkError() {

                Toast.makeText(getApplicationContext(), "No Internet", Toast.LENGTH_LONG).show();

            }



            @Override
            protected void httpStatus(HttpErrorResponse response) {
                Toast.makeText(getApplicationContext(), response.getError(), Toast.LENGTH_LONG).show();

            }
        };

        myadapter = new RecyclerViewAdapter(this, HerbList);
    }



    @Override
    public void onBackPressed() {

        if (interstitialAd1.isLoaded()) {
            interstitialAd1.show();
            interstitialAd1.setAdListener(new AdListener() {
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
