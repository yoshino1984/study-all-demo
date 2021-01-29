package com.yoshino.freemarker.service;

import freemarker.template.Template;

import java.io.Writer;

/**
 * @author wangxin
 * 2021/1/27 16:53
 * @since
 **/
public interface FreemarkerService {
    Template getTemplate(String templateName);

    String fillTemplate(String templateName, Object dataModel);

    void fillTemplate(String templateName, Object dataModel, Writer writer);
}

