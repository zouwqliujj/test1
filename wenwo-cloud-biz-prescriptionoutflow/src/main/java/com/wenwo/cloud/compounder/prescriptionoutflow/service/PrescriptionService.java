package com.wenwo.cloud.compounder.prescriptionoutflow.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.wenwo.cloud.compounder.prescriptionoutflow.common.utils.RequestUtil;
import com.wenwo.cloud.compounder.prescriptionoutflow.request.PayInfo2CmsRequest;
import com.wenwo.cloud.compounder.prescriptionoutflow.response.GoodsResponse;
import com.wenwo.common.domain.cause.RemoteException;
import com.wenwo.cloud.compounder.prescriptionoutflow.request.GoodsListRequest;
import com.wenwo.cloud.compounder.prescriptionoutflow.request.PreToCmsRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wanqiang.zou
 * @description: TODO
 * @date 2021/1/510:44
 */
@Slf4j
@Service
public class PrescriptionService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${cms.url}")
    private String url;
    /**
    　　* @description: TODO 获取药品信息列表
    　　* @param
    　　* @return
    　　* @throws
    　　* @author wanqiang.zou
    　　* @date 2021/1/5 10:54
    　　*/
    public List goodsList(GoodsListRequest goodsListRequest) {
        List data=new ArrayList<GoodsListRequest>();
        data.add(goodsListRequest);
        //封装符合cms要求的参数格式
        String requestPara= RequestUtil.getReqPara("rtl03","10",data);
        log.info("请求参数："+requestPara);
        //请求cms接口查询药品信息
        String result =  restTemplate.postForObject(url, requestPara, String.class);
        log.info("接口返回结果："+result);
        JSONObject jsonObject = JSON.parseObject(result);
        if(jsonObject==null||(jsonObject!=null && jsonObject.getString("execFlag")!=null && jsonObject.getString("execFlag").equals("-1"))){
            log.error("接口返回错误信息:"+jsonObject.getString("errInfo"));
            throw new RemoteException(500,"查询药品信息出错！");
        }
        JSONArray jsonArray = jsonObject.getJSONArray("results");
        List list = new ArrayList();
        if(jsonArray!=null&&jsonArray.size()>0){
            list = jsonArray.toJavaList(GoodsResponse.class);
        }
        return list;
    }

    /**
    　　* @description: TODO 上传处方信息
    　　* @param
    　　* @return
    　　* @throws
    　　* @author wanqiang.zou
    　　* @date 2021/1/5 18:55
    　　*/
    public void addPrescription(PreToCmsRequest preToCmsRequest) {
        List data=preToCmsRequest.getList();
        //封装符合cms要求的参数格式
        String requestPara= RequestUtil.getReqPara("rtl01","10",data);
        log.info("请求参数："+requestPara);
        //请求cms接口查询药品信息
        String result =  restTemplate.postForObject(url, requestPara, String.class);
        log.info("接口返回结果："+result);
        JSONObject jsonObject = JSON.parseObject(result);
        if(jsonObject==null||(jsonObject!=null && jsonObject.getString("execFlag")!=null && jsonObject.getString("execFlag").equals("-1"))){
            log.error("接口返回错误信息:"+jsonObject.getString("errInfo"));
            throw new RemoteException(500,"上传处方信息出错！");
        }
    }

    /**
    　　* @description: TODO 上传支付信息
    　　* @param
    　　* @return
    　　* @throws
    　　* @author wanqiang.zou
    　　* @date 2021/1/6 11:23
    　　*/
    public void addPayInfo(PayInfo2CmsRequest payInfo2CmsRequest) {
        List data=new ArrayList<PayInfo2CmsRequest>();
        data.add(payInfo2CmsRequest);
        //封装符合cms要求的参数格式
        String requestPara= RequestUtil.getReqPara("rtl05","10",data);
        log.info("请求参数："+requestPara);
        //请求cms接口查询药品信息
        String result =  restTemplate.postForObject(url, requestPara, String.class);
        log.info("接口返回结果："+result);
        JSONObject jsonObject = JSON.parseObject(result);
        if(jsonObject==null||(jsonObject!=null && jsonObject.getString("execFlag")!=null && jsonObject.getString("execFlag").equals("-1"))){
            log.error("接口返回错误信息:"+jsonObject.getString("errInfo"));
            throw new RemoteException(500,"上传支付信息出错！");
        }
    }
}
