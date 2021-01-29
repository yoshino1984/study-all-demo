package com.yoshino.freemarker.model;

import lombok.Data;

import java.util.List;

/**
 * @author wangxin
 * 2021/1/29 14:24
 * @since
 **/
@Data
public class PrintTemplateData {

    private String title;
    private List<List<PrintItem>> header;
    private Table dets;
    private List<List<PrintItem>> footer;

}
