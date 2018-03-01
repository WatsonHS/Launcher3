package com.watsonh.fractlauncher;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by WatsonH on 2018/2/28.
 */

public class HttpDownload {
    public String httpRequest(String requestUrl) {
        StringBuffer buffer = null;
        String result = null;
        try {
            URL url = new URL(requestUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            /*conn.setDoOutput(true);*/
            conn.setDoInput(true);
            conn.setRequestMethod("GET");
            conn.setReadTimeout(8000);
            conn.setConnectTimeout(8000);
            conn.connect();

            //读取服务器端返回的内容
            InputStream is = conn.getInputStream();
            InputStreamReader isr = new InputStreamReader(is, "utf-8");
            BufferedReader br = new BufferedReader(isr);
            buffer = new StringBuffer();
            String line = null;
            while ((line = br.readLine()) != null) {
                buffer.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            result =  buffer.toString();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

}