package com.wenwo.cloud.compounder.prescriptionoutflow.common.utils;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import lombok.Data;
import java.util.List;

/**
 * @author wanqiang.zou
 * @description: TODO 入参对象对应xml形式对象
 * @date 2021/1/416:19
 */
@Data
//别名注解
@XStreamAlias("input")
public class RequestObject {
    //省略集合根节点
    @XStreamImplicit
    private List data;

    public RequestObject(List data){
        this.data = data;
    }
}
