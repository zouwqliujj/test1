package com.wenwo.cloud.compounder.prescriptionoutflow.common.utils;

import lombok.Data;

/**
 * @author wanqiang.zou
 * @description: TODO 请求cms参数对象
 * @date 2021/1/514:10
 */
@Data
public class RequestPara {
    private String paramType;
    private String jsonFormat;
    private String paramString;

    public RequestPara(String paramType, String jsonFormat,String paramString){
        this.paramType = paramType;
        this.jsonFormat = jsonFormat;
        this.paramString = paramString;
    }
}
