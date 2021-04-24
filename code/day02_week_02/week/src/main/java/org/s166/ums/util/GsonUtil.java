package org.s166.ums.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.Map;

public class GsonUtil {
    public static Map<String,String> parseMap(String jsonData){
        //创建Gson对象
        Gson gson = new Gson();

        //转换
        Map<String,String> map = gson.fromJson(jsonData,new TypeToken<Map<String,String>>(){}.getType());

        //返回结果
        return map;
    }
}
