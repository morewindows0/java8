package com.developer.jdk8.test;

/**
 * @author: dengxin.chen
 * @date: 2019/3/29 22:44
 * @description:
 */
public enum TestEnum {
    AUDIT_TEXT_COUNT_UPPER_LIMIT("80001013", "每天文本审核次数已达上限"),
    AUDIT_IMAGE_COUNT_UPPER_LIMIT("80001014", "每天图片审核次数已达上限");

    private String code;
    private String name;

    TestEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public static String getName(String code) {
        for (TestEnum item : TestEnum.values()) {
            if (item.getCode().equals(code)) {
                return item.name;
            }
        }
        return "未知错误类型";
    }
}
