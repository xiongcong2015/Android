package cn.mobiletrain.asynctask.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 工具类，用于获取网络数据
 */
public class HttpUtils {
    // 通过url获取Json数据
    public static String getJsonFromUrl(String url) {
        String json = "";
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        try {
            HttpResponse httpResponse = httpClient.execute(httpGet);
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                InputStream is = httpResponse.getEntity().getContent();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String line = null;
                while ((line = br.readLine()) != null) {
                    json += line;
                }
                is.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }


    // 通过url获取网络Bitmap数据
    public static Bitmap getBitmapFromUrl(String url) {
        Bitmap bitmap = null;
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        try {
            HttpResponse httpResponse = httpClient.execute(httpGet);
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                InputStream is = httpResponse.getEntity().getContent();
                bitmap = BitmapFactory.decodeStream(is);
                is.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }

}
