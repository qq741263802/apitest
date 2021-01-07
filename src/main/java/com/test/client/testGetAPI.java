package com.test.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.testng.TestNG;
import org.testng.collections.Lists;

public class testGetAPI {

    public static final Logger log =Logger.getLogger(testGetAPI.class);

    public static void main(String[] args){

        TestNG testng = new TestNG();

        List suites = Lists.newArrayList();

        suites.add("src/main/resources/testng.xml");//path to xml..

        testng.setTestSuites(suites);

        testng.run();



    }
//
//
//        String url = "https://api.apishop.net/communication/phone/getLocationByPhoneNum?apiKey=nMke6NK29c40********c8aa0808389b16c4&phoneNum=1861195236";
//        CloseableHttpClient httpClient;
//        HttpGet httpGet;
//        CloseableHttpResponse httpResponse;
//        HttpEntity responseBody;
//        int responseCode;
//        Header[] responseHeader;
//
//        httpClient = HttpClients.createDefault();
//        httpGet = new HttpGet(url);
//        httpResponse = httpClient.execute(httpGet);
//
//        responseCode = httpResponse.getStatusLine().getStatusCode();
//        responseBody = httpResponse.getEntity();
//        responseHeader = httpResponse.getAllHeaders();
//
//        String responseBodyString = EntityUtils.toString(responseBody,"utf-8");
//
//        HashMap<String,String> hashMap = new HashMap<String,String>();
//        for(Header header:responseHeader){
//            hashMap.put(header.getName(), header.getValue());
//        }
//
//
//        System.out.println("This is the response code:" + responseCode);
//        System.out.println("This is the response body:" + responseBodyString);
//        System.out.println("This is the response header in hash" + hashMap);
//    }

}
