package com.wenwo.cloud.compounder.prescriptionoutflow.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author wanqiang.zou
 * @description: TODO 药品信息查询
 * @date 2021/1/416:08
 */
@ApiModel
@Data
@XStreamAlias("data")
public class GoodsListRequest {
    @ApiModelProperty(value = "公司", required = true)
    @NotNull(message = "公司id不能为空！")
    private Long compid;
    @ApiModelProperty(value = "CMS商品编码")
    private String goods;
    @ApiModelProperty(value = "药品名称")
    private String name;

    private String ownerId = "0001000";
}
