package com.shujuniu.utils;


import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public final class HttpUtil {

    private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    private static final MediaType CONTENT_TYPE_FORM = MediaType
            .parse("application/x-www-form-urlencoded;charset=UTF-8");

    private static final MediaType APPLICATION_JSON = MediaType
            .parse("application/application/json;charset=UTF-8");



    private HttpUtil() {
    }

    public static final String get(String url) {
        String result = "";
        HttpClient client = new HttpClient();
        GetMethod method = new GetMethod(url);
        try {
            client.executeMethod(method);
            result = method.getResponseBodyAsString();
        } catch (Exception e) {
            logger.error("", e);
        } finally {
            method.releaseConnection();
        }
        return result;
    }

    public static final String post(String url, ArrayList<NameValuePair> list) {
        String result = "";
        HttpClient client = new HttpClient();
        PostMethod method = new PostMethod(url);
        try {
            NameValuePair[] params = new NameValuePair[list.size()];
            for (int i = 0; i < list.size(); i++) {
                params[i] = list.get(i);
            }
            method.addParameters(params);
            client.executeMethod(method);
            result = method.getResponseBodyAsString();
        } catch (Exception e) {
            logger.error("", e);
        } finally {
            method.releaseConnection();
        }
        return result;
    }

    public static String post(String url, String params) {
        logger.info(url+"?"+params);
        RequestBody body = RequestBody.create(CONTENT_TYPE_FORM, params);
        Request request = new Request.Builder().url(url).post(body).build();
        return exec(request);
    }

    public static String headerGet(String url,String clientKey,String shopCode){
        logger.info(url);
        Request request = new Request.Builder().url(url)
                .header("clientKey",clientKey)
                .header("shopCode",shopCode).get().build();
        return exec(request);
    }

    public static String postJson(String url, String params,String clientKey,String shopCode){
        logger.info(url);
        logger.info("params="+params);
        RequestBody body = RequestBody.create(APPLICATION_JSON, params);
        Request request = new Request.Builder().url(url)
                .header("Content-Type","application/json")
                .header("clientKey",clientKey)
                .header("shopCode",shopCode).post(body).build();
        return exec(request);

    }

    private static String exec(Request request) {
        try {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            okhttp3.Response response = new OkHttpClient.Builder()
                    .connectTimeout(2,TimeUnit.MINUTES)
                    .readTimeout(2,TimeUnit.MINUTES)
                    .build().newCall(request).execute();
            if (!response.isSuccessful()) {
                throw new RuntimeException("Unexpected code " + response);
            }
            String body = response.body().string();
            logger.info("response.body():"+body);
            return body;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public static String getEncoding(String str) {
        String encode = "GB2312";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s = encode;
                return s;
            }
        } catch (Exception exception) {
        }
        encode = "ISO-8859-1";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s1 = encode;
                return s1;
            }
        } catch (Exception exception1) {
        }
        encode = "UTF-8";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s2 = encode;
                return s2;
            }
        } catch (Exception exception2) {
        }
        encode = "GBK";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s3 = encode;
                return s3;
            }
        } catch (Exception exception3) {
        }
        return "";
    }


}
