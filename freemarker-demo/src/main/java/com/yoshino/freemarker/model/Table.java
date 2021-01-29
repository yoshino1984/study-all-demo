package com.yoshino.freemarker.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author wangxin
 * 2021/1/29 14:38
 * @since
 **/
@Data
public class Table {
    private List<PrintItem> head;

    private Config config;

    @Data
    public static class Config implements Serializable {
        private static final long serialVersionUID = -3695153477782000457L;
        /** 表格线类型 0不要，1-实线，2-虚线 */
        private String lineType;
        /** 表格边框类型 0没有，1-横线，2-竖线，3-网格 */
        private String borderType;
    }
}
