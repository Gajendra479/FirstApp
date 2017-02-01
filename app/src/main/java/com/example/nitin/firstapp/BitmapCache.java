package com.example.nitin.firstapp;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.StringRequest;

/**
 * Created by nitin on 1/30/2017.
 */

public class BitmapCache extends LruCache<String,Bitmap> implements ImageLoader.ImageCache {
    /**
     * @param maxSize for caches that do not override {@link #sizeOf}, this is
     *                the maximum number of entries in the cache. For all other caches,
     *                this is the maximum sum of the sizes of the entries in this cache.
     */
    public BitmapCache(int maxSize) {
        super(maxSize);
    }

    public BitmapCache() {
        this(getDefaultCacheSize());
    }

    @Override
    protected int sizeOf(String key, Bitmap value) {
        return value.getRowBytes()*value.getHeight()/1024;
    }
    public static int getDefaultCacheSize(){
        final int maxMemory=(int)(Runtime.getRuntime().maxMemory()/1024);
        final int cacheSize=maxMemory/8;
        return cacheSize;
    }

    public Bitmap getBitmap(String url) {
        return get(url);
    }
    public void putBitmap(String url,Bitmap bitmap){
    put(url, bitmap);
    }
}
