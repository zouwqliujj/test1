package com.wenwo.cloud.compounder.prescriptionoutflow.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author wanqiang.zou
 * @description: TODO
 * @date 2021/1/515:47
 */
@ApiModel
@Data
public class PreToCmsRequest {
    @ApiModelProperty(value = "处方信息", required = true)
    @NotNull(message = "处方信息不能为空")
    @Valid
    private List<Prescription> list;
}
