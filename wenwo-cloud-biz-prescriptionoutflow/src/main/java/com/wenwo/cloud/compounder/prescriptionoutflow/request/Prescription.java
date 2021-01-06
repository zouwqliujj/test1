package com.wenwo.cloud.compounder.prescriptionoutflow.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author wanqiang.zou
 * @description: TODO 处方实体
 * @date 2021/1/515:05
 */
@ApiModel
@Data
@XStreamAlias("data")
public class Prescription {
    @ApiModelProperty(value = "公司")
    private Long compID;
    @ApiModelProperty(value = "接口类型")
    private Long ioType;
    @ApiModelProperty(value = "货主")
    private Long ownerID;
    @ApiModelProperty(value = "部门")
    private Long bizDeptID;
    @ApiModelProperty(value = "生成时间")
    private String createDate;
    @ApiModelProperty(value = "药品订单编号")
    private String orderNO;
    @ApiModelProperty(value = "药品订单支付ID", required = true)
    @NotNull(message = "药品订单支付ID不能为空")
    private Long orderID;
    @ApiModelProperty(value = "发票抬头")
    private String invoiceTitle;
    @ApiModelProperty(value = "订单总费用")
    private Double orderFee;
    @ApiModelProperty(value = "订单药费")
    private Double drugFee;
    @ApiModelProperty(value = "取药方式：0-快递，1-到店自取")
    private Long isExpress;
    @ApiModelProperty(value = "匹配流水", required = true)
    @NotBlank(message = "匹配流水不能为空")
    private String matchID;
    @ApiModelProperty(value = "处方单号")
    private String pscriptID;
    @ApiModelProperty(value = "处方开具日期")
    @XStreamAlias("pscript_date")
    private String pscriptDate;
    @ApiModelProperty(value = "医院代码")
    private String genhosCode;
    @ApiModelProperty(value = "医院名称")
    private String hosName;
    @ApiModelProperty(value = "门诊名称", required = true)
    @NotBlank(message = "门诊名称不能为空")
    private String deptName;
    @ApiModelProperty(value = "医生姓名", required = true)
    @NotBlank(message = "医生姓名不能为空")
    private String docName;
    @ApiModelProperty(value = "医院处方单号")
    private String accPscriptID;
    @ApiModelProperty(value = "医院就诊流水(对应多个处方单)")
    private String accessVisitID;
    @ApiModelProperty(value = "诊断", required = true)
    @NotBlank(message = "诊断信息不能为空")
    private String diagnosis;
    @ApiModelProperty(value = "患者姓名", required = true)
    @NotBlank(message = "患者姓名不能为空")
    private String patName;
    @ApiModelProperty(value = "药品明细ID")
    private String pscriptDtlID;
    @ApiModelProperty(value = "药商处方明细映射ID", required = true)
    @NotBlank(message = "药商处方明细映射ID不能为空")
    private String dpPscriptDtlID;
    @ApiModelProperty(value = "药商药品ID", required = true)
    @NotNull(message = "药商药品ID不能为空")
    private Long dpDrugID;
    @ApiModelProperty(value = "药商药品编码")
    private String dpDrugCode;
    @ApiModelProperty(value = "云医院药品编号", required = true)
    @NotBlank(message = "云医院药品编号不能为空")
    private String drugCode;
    @ApiModelProperty(value = "云医院药品商品名", required = true)
    @NotBlank(message = "云医院药品商品名不能为空")
    private String drugTradeName;
    @ApiModelProperty(value = "医院化学名", required = true)
    @NotBlank(message = "医院化学名不能为空")
    private String hosDrugName;
    @ApiModelProperty(value = "医院商品名", required = true)
    @NotBlank(message = "医院商品名不能为空")
    private String hosDrugTradeName;
    @ApiModelProperty(value = "云医院药品名称(化学名，通用名) ", required = true)
    @NotBlank(message = "云医院药品名称(化学名，通用名)不能为空")
    private String drugName;
    @ApiModelProperty(value = "药品包装规格", required = true)
    @NotBlank(message = "药品包装规格不能为空")
    private String drugSpec;
    @ApiModelProperty(value = "剂型名称", required = true)
    @NotBlank(message = "剂型名称不能为空")
    private String drugDose;
    @ApiModelProperty(value = "单次服用剂量，保留两位小数", required = true)
    @NotNull(message = "单次服用剂量不能为空")
    private Double oneDosage;
    @ApiModelProperty(value = "单次服用剂量单位", required = true)
    @NotBlank(message = "单次服用剂量单位不能为空")
    private String oneDosageUnit;
    @ApiModelProperty(value = "总剂量，保留两位小数", required = true)
    @NotNull(message = "总剂量不能为空")
    private Double totalDosage;
    @ApiModelProperty(value = "总剂量单位", required = true)
    @NotBlank(message = "匹配流水不能为空")
    private String totalDosageUnit;
    @ApiModelProperty(value = "整包装数量")
    private Long amount;
    @ApiModelProperty(value = "整包装单位", required = true)
    @NotBlank(message = "整包装单位不能为空")
    private String units;
    @ApiModelProperty(value = "单价", required = true)
    @NotNull(message = "单价不能为空")
    private Double price;
    @ApiModelProperty(value = "总金额", required = true)
    @NotNull(message = "总金额不能为空")
    private Double sumValue;
    @ApiModelProperty(value = "频次编码 如TID/QID/QD", required = true)
    @NotBlank(message = "频次编码不能为空")
    private String frequencyCode;
    @ApiModelProperty(value = "频次说明", required = true)
    @NotBlank(message = "频次说明不能为空")
    private String frequency;
    @ApiModelProperty(value = "频次数量", required = true)
    @NotNull(message = "匹配流水不能为空")
    private Double frequencyQty;
    @ApiModelProperty(value = "用法编码 如PO", required = true)
    @NotBlank(message = "用法编码不能为空")
    private String usageCode;
    @ApiModelProperty(value = "用法说明", required = true)
    @NotBlank(message = "用法说明不能为空")
    private String usage;
    @ApiModelProperty(value = "药品类型 0-处方药；1-OTC", required = true)
    @NotBlank(message = "药品类型不能为空")
    private String drugType;
    @ApiModelProperty(value = "一品两规 1-国产；2-进口；3-合资", required = true)
    @NotBlank(message = "一品两规不能为空")
    private String drugSource;
    @ApiModelProperty(value = "是否整装 1-是；0-否", required = true)
    @NotBlank(message = "是否整装不能为空")
    private String assemble;
    @ApiModelProperty(value = "药品生产厂家", required = true)
    @NotBlank(message = "药品生产厂家不能为空")
    private String manuFaturer;
    @ApiModelProperty(value = "总的用法说明：口服 一天三次 一次1片", required = true)
    @NotBlank(message = "总的用法说明不能为空")
    private String usageDesc;
    @ApiModelProperty(value = "CMS接口类型")
    @XStreamAlias("CMS_IOTYPE")
    private Long cmsIoType;
    @ApiModelProperty(value = "零售合并销售单ID")
    private Long gensalBillhdrID;
    @ApiModelProperty(value = "处方单ID", required = true)
    @NotNull(message = "处方单ID不能为空")
    private Long rxID;
    @ApiModelProperty(value = "零售合并销售单数量")
    private Double gensalBillhdrQty;
    @ApiModelProperty(value = "CMS订单数量")
    private Double billQty;
}
