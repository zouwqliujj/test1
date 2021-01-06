package com.wenwo.cloud.compounder.prescriptionoutflow.controller;


import com.wenwo.cloud.compounder.prescriptionoutflow.request.GoodsListRequest;
import com.wenwo.cloud.compounder.prescriptionoutflow.request.PayInfo2CmsRequest;
import com.wenwo.cloud.compounder.prescriptionoutflow.request.PreToCmsRequest;
import com.wenwo.cloud.compounder.prescriptionoutflow.service.PrescriptionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wanqiang.zou
 * @Description TODO 处方外流接口
 * @createTime 2021/01/04
 */
@Api(tags = "处方外流接口")
@Slf4j
@RestController
@RequestMapping(value = "/biz")
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    @ApiOperation("获取药品信息列表")
    @PostMapping(value = "/goods/queryList")
    public List queryList(@Validated @RequestBody GoodsListRequest goodsListRequest) {
        List result =  prescriptionService.goodsList(goodsListRequest);
        return result;
    }

    @ApiOperation("上传处方到cms")
    @PostMapping(value = "/prescription/add")
    public void addPrescription(@Validated  @RequestBody PreToCmsRequest preToCmsRequest) {
        prescriptionService.addPrescription(preToCmsRequest);
    }


    @ApiOperation("上传支付信息到cms")
    @PostMapping(value = "/pay/add")
    public void addPayInfo(@Validated @RequestBody PayInfo2CmsRequest preToCmsRequest) {
        prescriptionService.addPayInfo(preToCmsRequest);
    }
}
