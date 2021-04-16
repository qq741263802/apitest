//package com.test.testcase.commodity;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.alibaba.fastjson.JSONPath;
//import com.test.client.RestfulClient;
//import com.test.utils.HttpUtil;
//import com.test.utils.PropertiesUtil;
//import org.testng.Assert;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//import javax.xml.crypto.Data;
//import java.io.IOException;
//import java.net.URL;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author lhm
// * @date 2021/1/10 13:37
// */
//public class productUnitManage {
//
//    RestfulClient httpClientPost = new RestfulClient();
//    Map map = new HashMap();
//    HashMap<String,String> header = new HashMap<>();
//    String url;
//    @BeforeTest
//    public void setup(){
//     url= PropertiesUtil.getProperty("url");
//
//        //构造登录参数
//        String loging_url=url+"/gateway/deepexi.dd.system.mall/admin-api/v1/app/login/loging";
//        JSONObject json = new JSONObject();
//        json.put("enterpriseCode","gree");
//        json.put("username","gree");
//        json.put("password","j8SO9AgDXXyZEuFIrcmaPMmvNuzhNSBIf3c3HQAEkZTBUjQbO1RsFKinoEarsf9z1P2Y5aj/1Ejrj8GptHnpxQo4LoadXkj6yWDLa3At449AgAO2m1GHILdVoMl5M8NaeCRZ8YhwfHhASFSAtW+YUoUeDnZjVGhiwYpi8FH+MpU=");
//        String result = HttpUtil.doPostByJson(loging_url,json.toString(),header);
//        JSONObject resultJson = JSON.parseObject(result);
//        Assert.assertEquals(resultJson.get("code"),"0");
//        Assert.assertEquals(JSONPath.eval(resultJson,"$.payload.userInfo.username"),"gree");
//        header.put("Authorization", "Bearer "+(String) JSONPath.eval(resultJson,"$.payload.access_token"));
//        header.put("Content-Type","application/json;charset=UTF-8");
//    }
//    @Test
//    public void unit() throws IOException {
//        String data="{\"accuracy\":0,\"isDefault\":\"0\",\"unitCode\":\"DW109\",\"unitName\":\"条\",\"unitType\":1,\"userId\":10074,\"tenantId\":\"gree\",\"appId\":623}";
//        String unit_url=url+"gateway/admin-api/deepexi-domain-commodity/v1/unit";
//        String result = HttpUtil.doPostByJson(unit_url,data,header);
//        JSONObject resultJson = JSON.parseObject(result);
//        Assert.assertEquals(resultJson.get("code"),"0");
//
//    }
//
//    @Test(dependsOnMethods ="login" )
//    public void home()
//    {
//        System.out.println("Home page");
//
//    }
//
//    @Test
//    public void login()
//    {
//        System.out.println("Login page");
//    }
//
//
//    @AfterTest
//    public void teardown(){
//
//        System.out.println("用例执行完后执行");
//    }
//}
