package com.test.client;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.test.client.RestfulClient;
import com.test.utils.HttpUtil;
import org.apache.http.NameValuePair;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Test
public class LoginCase {


    RestfulClient httpClientPost = new RestfulClient();
    Map map = new HashMap();
    HashMap<String,String> header = new HashMap<>();
    @BeforeTest
    public void setup(){
        System.out.println("用例执行前执行");
    }
    @Test
    public void test1() throws IOException {
        //构造登录参数
        String url="http://124.172.188.110:31907/gateway/deepexi.dd.system.mall/admin-api/v1/app/login/loging";
        JSONObject json = new JSONObject();
        json.put("enterpriseCode","gree");
        json.put("username","gree");
        json.put("password","j8SO9AgDXXyZEuFIrcmaPMmvNuzhNSBIf3c3HQAEkZTBUjQbO1RsFKinoEarsf9z1P2Y5aj/1Ejrj8GptHnpxQo4LoadXkj6yWDLa3At449AgAO2m1GHILdVoMl5M8NaeCRZ8YhwfHhASFSAtW+YUoUeDnZjVGhiwYpi8FH+MpU=");
        String result = HttpUtil.doPostByJson(url,json.toString(),header);
        JSONObject resultJson = JSON.parseObject(result);
        Assert.assertEquals(resultJson.get("code"),"0");
        Assert.assertEquals(JSONPath.eval(resultJson,"$.payload.userInfo.username"),"gree");
        header.put("Authorization", "Bearer "+(String) JSONPath.eval(resultJson,"$.payload.access_token"));

    }
    @Test
    public void test2() throws Exception{

        String url="http://124.172.188.110:31907/gateway/deepexi.dd.domain.tool/admin-api/v1/domain/toolAuthorizeCommodity/pageEsGoodInformation?userId=10074&tenantId=gree&appId=623&sortType=5&size=20&page=1";
        String result = HttpUtil.doGet(url,map,header);
        JSONObject resultJson = JSON.parseObject(result);
        System.out.println(resultJson);
        Assert.assertEquals(resultJson.get("code"),"0");

    }
    @AfterTest
    public void teardown(){

        System.out.println("用例执行完后执行");
    }

}
