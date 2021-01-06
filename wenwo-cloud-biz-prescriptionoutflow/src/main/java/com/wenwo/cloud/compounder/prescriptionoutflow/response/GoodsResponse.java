package com.wenwo.cloud.compounder.prescriptionoutflow.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author wanqiang.zou
 * @description: TODO
 * @date 2021/1/518:32
 */
@Data
@ApiModel
public class GoodsResponse {
    @ApiModelProperty(value = "商品代码")
    private String goods;
    @ApiModelProperty(value = "商品名称")
    private String name;
    @ApiModelProperty(value = "通用名称")
    private String gname;
    @ApiModelProperty(value = "规格")
    private String spec;
    @ApiModelProperty(value = "药品类型")
    private String managerangeName;
    @ApiModelProperty(value = "生产厂家")
    private String producer;
    @ApiModelProperty(value = "产地")
    private String prdarea;
    @ApiModelProperty(value = "品牌")
    private String wareBrand;
}
