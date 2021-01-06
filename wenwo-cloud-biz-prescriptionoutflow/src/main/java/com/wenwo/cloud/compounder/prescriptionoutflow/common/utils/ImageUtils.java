package com.wenwo.cloud.compounder.prescriptionoutflow.common.utils;

public class ImageUtils {

    private static final String prefix = "https://pic.wenwo.com/fimg/";
    private static final String suffix = ".jpg";

    private ImageUtils() {
    }

    public static String image(String code) {
        return prefix + code + suffix;
    }
}
