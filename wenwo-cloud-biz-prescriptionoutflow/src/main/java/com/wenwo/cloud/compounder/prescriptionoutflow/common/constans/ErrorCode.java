package com.wenwo.cloud.compounder.prescriptionoutflow.common.constans;

import com.wenwo.common.domain.constant.StatusCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @ Author     ：AnShuang
 * @ Date       ：Created in 13:43 2020/8/18
 * @ Description：异常信息提示
 * @ Modified By：
 * */
@Getter
@AllArgsConstructor
public enum ErrorCode implements StatusCode {

    /**
     * 用户域服务错误
     */
    DOMAIN_SERVER_ERROR(5908000, "用户域服务错误"),
    /**
     * 参数为空或校验不通过
     */
    PARAMS_NULL_ERROR(5908001, "参数为空或校验不通过"),
    /**
     * 未绑定微博
     */
    WEIBO_NOT_FOUND_ERROR(5908002, "未绑定微博"),
    /**
     * 分享失败，请稍后再试！
     */
    SHARE_ERROR(5908003, "分享失败，请稍后再试！"),
    /**
     * 问题已结束
     */
    CONSULT_END(5908004, "问题已结束");

    private final int code;

    private final String message;
}
