package com.yoshino.freemarker.service;

import freemarker.cache.FileTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.annotation.Resource;
import java.io.StringWriter;
import java.io.Writer;

/**
 * @author wangxin
 * 2021/1/27 16:52
 * @since
 **/
@Service
@Slf4j
public class FreemarkerServiceImpl implements FreemarkerService, InitializingBean {

    @Resource
    private FreeMarkerConfigurer freeMarkerConfigurer;

    @Override
    public Template getTemplate(String templateName) {
        try {
            Configuration configuration = this.freeMarkerConfigurer.getConfiguration();
            Template template = configuration.getTemplate(templateName);
            if (template == null) {
                throw new RuntimeException("Can not find freemarker template[" + templateName + "]");
            } else {
                return template;
            }
        } catch (Exception var4) {
            log.error("ex=" + var4.getMessage(), var4);
            throw new RuntimeException(var4.getMessage());
        }
    }

    @Override
    public String fillTemplate(String templateName, Object dataModel) {
        StringWriter writer = new StringWriter();
        this.fillTemplate(templateName, dataModel, writer);
        writer.flush();
        return writer.toString();
    }

    @Override
    public void fillTemplate(String templateName, Object dataModel, Writer writer) {
        Template template = this.getTemplate(templateName);

        try {
            template.process(dataModel, writer);
        } catch (Exception var6) {
            log.error("ex=" + var6.getMessage(), var6);
            throw new RuntimeException(var6.getMessage());
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        org.springframework.core.io.Resource path = new DefaultResourceLoader().getResource("classpath:/templates/");
        freeMarkerConfigurer.getConfiguration().setTemplateLoader(new FileTemplateLoader(path.getFile()));
    }

}
