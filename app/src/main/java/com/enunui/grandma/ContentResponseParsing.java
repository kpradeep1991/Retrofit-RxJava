package com.enunui.grandma;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class ContentResponseParsing {

    private static String TAG = ContentResponseParsing.class.getSimpleName();
    // ...

    // Decodes business json into business model object

    public static ContentResponse fromJson(JSONObject jsonObject) {
        ContentResponse b = new ContentResponse();

        Log.d(TAG, "response parsing - "+Thread.currentThread().getName());

        // Deserialize json into object fields
        try {
            b.setId(jsonObject.getString("id"));
            b.setStatus(jsonObject.getString("status"));
            b.setMobile(jsonObject.getString("mobile"));
            b.setVideo_id(jsonObject.getString("video_id"));

            b.setContent(jsonObject.getString("content"));
            b.setTitle(jsonObject.getString("title"));
            b.setImage(jsonObject.getString("image"));


            b.setSub_one(jsonObject.getString("sub_one"));
            b.setSub_one_con(jsonObject.getString("sub_one_con"));
            b.setSub_two(jsonObject.getString("sub_two"));
            b.setSub_two_con(jsonObject.getString("sub_two_con"));
            b.setSub_three(jsonObject.getString("sub_three"));
            b.setSub_three_con(jsonObject.getString("sub_three_con"));
            b.setSub_four(jsonObject.getString("sub_four"));
            b.setSub_four_con(jsonObject.getString("sub_four_con"));
            b.setSub_five(jsonObject.getString("sub_five"));
            b.setSub_five_con(jsonObject.getString("sub_five_con"));




            b.setCdate(jsonObject.getString("cdate"));
            b.setCip(jsonObject.getString("cip"));
            b.setLast_update(jsonObject.getString("last_update"));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        // Return new object
        return b;
    }
}
