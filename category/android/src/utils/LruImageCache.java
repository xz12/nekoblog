package cn.nekocode.murmur.utils;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

import com.android.volley.toolbox.ImageLoader.ImageCache;

public class LruImageCache implements ImageCache {
	private static LruImageCache instance = null;
    private LruCache<String, Bitmap> mCache;

    public static LruImageCache getLruImageCache() {
    	if(instance == null) {
    		instance = new LruImageCache();
    	}
    	
    	return instance;
    }
    
    private LruImageCache() {  
        int maxSize = 10 * 1024 * 1024;  
        mCache = new LruCache<String, Bitmap>(maxSize) {
            @Override  
            protected int sizeOf(String key, Bitmap value) {  
                return value.getRowBytes() * value.getHeight();  
            }  
        };  
    }  

    @Override  
    public Bitmap getBitmap(String url) {  
        return mCache.get(url);  
    }  

    @Override  
    public void putBitmap(String url, Bitmap bitmap) {  
        mCache.put(url, bitmap);  
    }  
}
