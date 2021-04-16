package com.test.testcase.commodity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.test.common.Const;
import com.test.utils.HttpUtil;
import com.test.utils.PropertiesUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

/**
 * @author lhm
 * @date 2021/1/20 22:50
 */
public class LoginCase {


    HashMap<String,String> header = new HashMap<>();


    @Test
    public void greeLogin() throws IOException {
        //构造登录参数
        String url= PropertiesUtil.getProperty("url");
        String loging_url=url+"/gateway/deepexi.dd.system.mall/admin-api/v1/app/login/loging";
        JSONObject json = new JSONObject();
        json.put("enterpriseCode","gree");
        json.put("username","gree");
        json.put("password","j8SO9AgDXXyZEuFIrcmaPMmvNuzhNSBIf3c3HQAEkZTBUjQbO1RsFKinoEarsf9z1P2Y5aj/1Ejrj8GptHnpxQo4LoadXkj6yWDLa3At449AgAO2m1GHILdVoMl5M8NaeCRZ8YhwfHhASFSAtW+YUoUeDnZjVGhiwYpi8FH+MpU=");
        String result = HttpUtil.doPostByJson(loging_url,json.toString(),header);
        JSONObject resultJson = JSON.parseObject(result);
        Assert.assertEquals(resultJson.get("code"),"0");
        Assert.assertEquals(JSONPath.eval(resultJson,"$.payload.userInfo.username"),"gree");
        Const.Token=(String) JSONPath.eval(resultJson,"$.payload.access_token");

    }


}
