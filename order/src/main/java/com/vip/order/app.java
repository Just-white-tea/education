package com.vip.order;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.vip.order.utils.NetMessage;
import lombok.Builder;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.*;

@Builder
public class app {


    public static String getNetMessage(String url,Map<String, String> BodyParams){
        OkHttpClient client=new OkHttpClient();
        String data = null;
        String reqUrl=setUrlParams(url,BodyParams);
        Request request=new Request.Builder()
                .url(reqUrl)
                .get()
                .build();
        //创建回调对象
        Call call=client.newCall(request);
        //获取返回值
        try {
            Response response=call.execute();
            data=response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public  static String postNetMessage(String url,Map<String, String> BodyParams){
        OkHttpClient client=new OkHttpClient();
        String data = null;
        //创建Request对象，设置url值和发送方式
        Request request=new Request.Builder()
                .url(url)
                .post(SetRequestBody(BodyParams))
                .build();
        //创建回调对象
        Call call=client.newCall(request);
        //获取返回值
        try {
            Response response=call.execute();
            data=response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
    //封装RequestBody
    private static RequestBody SetRequestBody(Map<String, String> BodyParams){
        //requestBody以Builder()和build()结尾,中间添加参数，因此创建builder对象
        RequestBody body=null;
        okhttp3.FormBody.Builder formEncodingBuilder=new okhttp3.FormBody.Builder();
        if(BodyParams != null){
            Iterator<String> iterator = BodyParams.keySet().iterator();
            String key = "";
            //通过迭代器动态加入键值对参数
            while (iterator.hasNext()) {
                key = iterator.next().toString();
                formEncodingBuilder.add(key, BodyParams.get(key));
            }
        }
        //最后添加build结束
        body=formEncodingBuilder.build();
        return body;
    }
    //封装get方法拼接参数
    private static String setUrlParams(String url,Map<String, String> mapParams){
        StringBuffer sf=new StringBuffer();
        sf.append(url).append("?");
        if(mapParams != null){
            Iterator<String> iterator = mapParams.keySet().iterator();
            String key = "";
            while (iterator.hasNext()) {
                key = iterator.next().toString();
                sf.append("&").append(key).append("=").append(mapParams.get(key));
            }
        }
        return sf.toString();
    }

    //封装获取json数据(Array)
    public static String getJsonArrayMes(String json,String key){
        //创建JSON对象
        JSONObject jsonObject = JSON.parseObject(json);
        //获取对象中的data数组
        JSONArray data = jsonObject.getJSONArray("data");
        //由于数组中仅有一条数据，所以获得数组中第一个对象
        JSONObject data2= data.getJSONObject(0);
        //获取具体键值对的值
        String value=data2.get(key).toString();
        return value;
    }
    public static String getJsonObjectMes(String json,String key){
        //创建JSON对象
        JSONObject jsonObject = JSON.parseObject(json);
        //获取对象中的data数组
        JSONObject data = jsonObject.getJSONObject("data");
        //获得对象中所需key的对象
        JSONObject data2= data.getJSONObject(key);
        //获取具体键值对的值
        String value=data2.get(key).toString();
        return value;
    }
    public static void main(String[] args) {
//        String data=post("http://10.3.135.53:8080/account/selectStudent","eStudentId","1");
//        String data1=postMes("http://10.3.135.53:8080/account/resetPassword");
//        System.out.println(data1);
//        System.out.println(data);
//        http://10.3.135.53:8080/account/selectStudent?eParentId=1&oldPassword=123&newPassword


//        //post请求
//        Map<String,String> map=new HashMap<>();
//        map.put("eParentId","1");
//        map.put("oldPassword","456456");
//        map.put("newPassword","1451321");
//        String data=postNetMessage("http://10.3.135.53:8080/account/resetPassword",map);
//        System.out.println(data);
//
//        //get请求
//        Map<String,String> map=new HashMap<>();
//        map.put("eStudentId","1");
//        String url="http://10.3.135.53:8080/account/selectStudent";
//        String netMessage = getNetMessage(url, map);
//        System.out.println(netMessage);
//
//        System.out.println(getJsonArrayMes(netMessage, "estudentGrade"));

        Map<String,String> map=new HashMap<>();
        map.put("eStudentId","1");
        String url="http://10.3.135.53:8080/account/selectStudent";
        String netMessage = NetMessage.getNetMessage(url, map);
        System.out.println(netMessage);

    }
}
