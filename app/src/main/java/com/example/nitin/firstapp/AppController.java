package com.example.nitin.firstapp;

import android.app.Application;
import android.nfc.Tag;
import android.support.design.widget.TabLayout;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

import static android.R.attr.tag;

/**
 * Created by nitin on 1/30/2017.
 */

public class AppController extends Application {
    public static final String TAG=AppController.class.getSimpleName();
    private RequestQueue nRequestQueue;
    private ImageLoader mImageLoader;
    private static AppController mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static synchronized AppController getmInstance() {
        return mInstance;

    }

    public RequestQueue getnRequestQueue() {
        if (nRequestQueue == null) {
            nRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return nRequestQueue;

    }

    public ImageLoader getmImageLoader() {
        getnRequestQueue();
        if (mImageLoader == null) {
            mImageLoader = new ImageLoader(this.nRequestQueue, new BitmapCache(

            ));
        }
        return this.mImageLoader;
    }
    public <T> void addtorequestqueue(Request <T> request,String tag){
        request.setTag((TextUtils.isEmpty(tag) ? TAG :tag));
        getnRequestQueue().add(request);
    }
    public <T> void addtorequestqueue(Request <T> request){
        request.setTag(TAG);
        getnRequestQueue().add(request);
    }
    public void cancelPendingRequest(Object tag){
        if (nRequestQueue !=null){
            nRequestQueue.cancelAll(tag);
        }
    }
}