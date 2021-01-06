package com.wenwo.cloud.compounder.prescriptionoutflow.common.constans;

import java.util.Arrays;
import java.util.Optional;

/**
 * 描述：医生执业类型枚举类
 *
 * @author pin.zhao
 * @version golden-v1.0.0
 * @create 2020-11-05 10:49
 */
public enum ProfessionTypeEnum {
    /**
     * 执业医师
     */
    PROFESSION_DOCTOR("1", "执业医师"),
    /**
     * 执业药师
     */
    PROFESSION_MEDICINE("2", "执业药师"),
    /**
     * 执业护师
     */
    PROFESSION_NURSE("3", "执业护师"),
    /**
     * 医学检验技师
     */
    PROFESSION_TECHNICIAN("4", "心里咨询师"),
    /**
     * 康复治疗师
     */
    PROFESSION_RECOVERY("5", "公共营养师"),
    /**
     * 药剂师
     */
    PROFESSION_PHARMACIST("6", "健康管理师"),
    /**
     * 公共营养师
     */
    PROFESSION_DIETICIAN("7", "医学检验技师"),
    /**
     * 健康管理师
     */
    PROFESSION_HEALTH("8", "康复治疗师"),
    /**
     * 心理咨询师
     */
    PROFESSION_PSYCHOLOGY("9", "药剂师");


    /**
     * 值
     */
    private String value;
    /**
     * 名称
     */
    private String name;

    ProfessionTypeEnum(String value, String name){
        this.value = value;
        this.name = name;
    }
    /**
     * 获取枚举值
     * @return String
     */
    public String getValue() {
        return value;
    }

    /**
     * 获取枚举名称
     * @return String
     */
    public String getName() {
        return name;
    }
    /**
     * 获取名称通过值
     * @param value
     * @return
     */
    public static String getEnumNameByValue(String value) {
        Optional<ProfessionTypeEnum> first = Arrays.stream(ProfessionTypeEnum.values()).filter(a -> value.equals(a.getValue())).findFirst();
        if (first.isPresent()) {
            return first.get().getName();
        } else {
            return value;
        }
    }




}
