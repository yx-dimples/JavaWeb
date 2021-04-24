package org.s166.ums.controller;

import org.s166.ums.commons.ResultDto;
import org.s166.ums.util.GsonUtil;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

/**
 * 基本通用的Servlet:用于封装响应数据
 */
public class BaseServlet extends HttpServlet {

    public ResultDto successJson(Object value){
        ResultDto resultDto = new ResultDto();
        resultDto.setValue(value);
        return resultDto;
    }

    public ResultDto successJson(Object value,int code,String msg){
        ResultDto resultDto = new ResultDto();
        resultDto.setValue(value);
        resultDto.setCode(code);
        resultDto.setMsg(msg);
        return resultDto;
    }

    public ResultDto errorJson(){
        ResultDto resultDto = new ResultDto();
        resultDto.setCode(500);
        resultDto.setMsg("系统繁忙，请稍后再试！");
        return resultDto;
    }

    public ResultDto errorJson(int code,String msg){
        ResultDto resultDto = new ResultDto();
        resultDto.setCode(code);
        resultDto.setMsg(msg);
        return resultDto;
    }

    public ResultDto errorJson(String msg){
        ResultDto resultDto = new ResultDto();
        resultDto.setCode(500);
        resultDto.setMsg(msg);
        return resultDto;
    }

    public Map<String,String> getParameterMap(HttpServletRequest req) throws IOException{
        BufferedReader reader = req.getReader();
        String str = null;
        String jsonParams = "";

        while ((str = reader.readLine() )!= null){
            //把读取的数据，串联起来
            jsonParams = jsonParams + str;
        }

        return GsonUtil.parseMap(jsonParams);
    }
}
