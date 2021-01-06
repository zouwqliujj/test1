package com.wenwo.cloud.compounder.prescriptionoutflow.common.utils;

import com.alibaba.fastjson.JSONObject;
import com.thoughtworks.xstream.XStream;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wanqiang.zou
 * @description: TODO
 * @date 2021/1/416:14
 */
public class RequestUtil {
    /**
    　　* @description: TODO 封装成最终请求参数
    　　* @param
    　　* @return
    　　* @throws
    　　* @author wanqiang.zou
    　　* @date 2021/1/5 14:15
    　　*/
   public static String getReqPara(String paramType, String jsonFormat, List data){
        RequestObject requestObject =  new RequestObject(data);
        RequestPara requestPara = new RequestPara(paramType,jsonFormat,javaToXml(requestObject));
        return JSONObject.toJSONString(requestPara);
   }

   /**
   　　* @description: TODO java对象转化为xml字符串工具类
   　　* @param
   　　* @return
   　　* @throws
   　　* @author wanqiang.zou
   　　* @date 2021/1/5 14:06
   　　*/
    public static String javaToXml(RequestObject requestObject) {
        XStream xStream = new XStream();
        xStream.autodetectAnnotations(true);
        //XML序列化
        return xStream.toXML(requestObject);
    }
}
