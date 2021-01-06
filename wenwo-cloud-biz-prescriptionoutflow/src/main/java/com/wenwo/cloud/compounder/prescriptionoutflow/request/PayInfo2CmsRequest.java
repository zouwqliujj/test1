package com.wenwo.cloud.compounder.prescriptionoutflow.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author wanqiang.zou
 * @description: TODO 上传支付信息
 * @date 2021/1/515:47
 */
@ApiModel
@Data
@XStreamAlias("data")
public class PayInfo2CmsRequest {
    @ApiModelProperty(value = "接口类型")
    private Long ioType;
    @ApiModelProperty(value = "医院处方号")
    private String pscriptId;
    @ApiModelProperty(value = "零售收款方式代码")
    private String rtlbalmodeCode;
    @ApiModelProperty(value = "零售收款方式名称", required = true)
    @NotBlank(message = "零售收款方式名称不能为空")
    private String rtlbalmodeName;
    @ApiModelProperty(value = "用户付款金额")
    private Double payValue;
    @ApiModelProperty(value = "实际收款金额")
    private Double sumValue;
    @ApiModelProperty(value = "找零金额")
    private Double chgValue;
    @ApiModelProperty(value = "平台收款单据ID", required = true)
    @NotNull(message = "平台收款单据ID不能为空")
    private Long extBillId;
    @ApiModelProperty(value = "平台收款单据号", required = true)
    @NotBlank(message = "平台收款单据号不能为空")
    private String extBillNo;
}
