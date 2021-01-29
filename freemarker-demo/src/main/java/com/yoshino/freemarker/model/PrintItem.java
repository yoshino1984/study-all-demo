package com.yoshino.freemarker.model;

import lombok.Data;

/**
 * @author wangxin
 * 2021/1/29 14:26
 * @since
 **/
@Data
public class PrintItem {

    public final static String TYPE_CUSTOM = "CUSTOM";

    /** 字段英文名 */
    private String nameEn;
    /** 字段中文名*/
    private String caption;
    /** 绝对宽度 单位：mm*/
    private String width;
    /** 字体大小*/
    private int fontSize;
    /** 是否加粗 */
    private String fontWeight;
    /** 字段类型*/
    private String vType;

    /**
     * 非自定义类型（如果是自定义类型则直接显示）
     *
     * @param
     * @return boolean
     * @author wangxin
     * @date 2021/1/29 16:01
     */
    public boolean notCustom() {
        return !TYPE_CUSTOM.equals(nameEn);
    }
}
