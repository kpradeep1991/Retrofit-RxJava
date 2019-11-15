package com.enunui.grandma;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {


    private Context mContext ;
    private List<HerbBean> mData ;
    String imageLoaderUrl;

    private String TAG = RecyclerViewAdapter.class.getSimpleName();

    public RecyclerViewAdapter(MainActivity mContext, List<HerbBean> mData) {
        this.mContext = mContext;
        this.mData = mData;
        Log.d(TAG, "recycler constructor - "+Thread.currentThread().getName());


    }




    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view=mInflater.inflate(R.layout.cardview_main,parent,false);
        Log.d(TAG, "on create ViewHolder method - "+Thread.currentThread().getName());


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

      imageLoaderUrl=mData.get(position).getImageNailUrl();

        holder.card_title.setText(mData.get(position).getHerbTitle());

        //Setting Image in the card view


         Picasso.get().load(imageLoaderUrl).fit().into(holder.image_thumbnail);




        holder.cardview.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
   Intent intent = new Intent(mContext,ContentActivity.class);


   //values to content _activity .By setting values  in the intent and passing to the next xml view(page)

        intent.putExtra("HerbTitle",mData.get(position).getHerbTitle());

        //intent.putExtra("HerbThumbnail",mData.get(position).getHerbThumbnail());

        intent.putExtra("Description",mData.get(position).getDescription());

                    //passing image url

        intent.putExtra("ImageNailUrl",mData.get(position).getImageNailUrl());


        //passing second content for tesing

        intent.putExtra("subOneTitle",mData.get(position).getSubOneTitle());

        intent.putExtra("subOneCon",mData.get(position).getSubOneCon());

        intent.putExtra("subTwoTitle",mData.get(position).getSubTwoTitle());

        intent.putExtra("subTwoCon",mData.get(position).getSubTwoCon());

        intent.putExtra("subThreeTitle",mData.get(position).getSubThreeTitle());

        intent.putExtra("subThreeCon",mData.get(position).getSubThreeCon());

        intent.putExtra("subFourTitle",mData.get(position).getSubFourTitle());

        intent.putExtra("subFourCon",mData.get(position).getSubFourCon());


        intent.putExtra("subFiveTitle",mData.get(position).getSubFiveTitle());

        intent.putExtra("subFiveCon",mData.get(position).getSubFiveCon());




        //next page by using  intant
        mContext.startActivity(intent);



    }
});
        Log.d(TAG, "on BindViewHolder - "+Thread.currentThread().getName());

    }

    @Override
    public int getItemCount() {
        return mData.size() ;
    }

    public  static class MyViewHolder extends RecyclerView.ViewHolder {

            CardView cardview;
            TextView card_title;
            ImageView image_thumbnail;

        private String TAG = MyViewHolder.class.getSimpleName();

        public MyViewHolder(View itemView) {
            super(itemView);


            card_title=(TextView) itemView.findViewById(R.id.herb_title_id);

            image_thumbnail=(ImageView) itemView.findViewById(R.id.herb_img_id);

            cardview=(CardView)itemView.findViewById(R.id.cardview_id);


            Log.d(TAG, "My View holder constructor - "+Thread.currentThread().getName());

        }


    }
}
