package com.qf.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qf.common.JsonResult;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class JsonUtils {
    public static void writeJsonInfo(int code, Object info, HttpServletResponse response) {
        //  {
        //  code:200,
        //  msg:登录成功,
        //  info: {
        //         登录的信息
        //  }
        //
        //  }
        JsonResult r = new JsonResult(code, info);
        //r  两个属性  code    info
        //jackjson
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            //objectMapper  把一个对象转换成了json字符串
            String jsonInfo = objectMapper.writeValueAsString(r);
            PrintWriter writer = response.getWriter();
            //返回json字符串的
            writer.write(jsonInfo);
            writer.flush();
            writer.close();
            
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
