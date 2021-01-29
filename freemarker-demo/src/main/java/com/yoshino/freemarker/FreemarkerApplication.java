package com.yoshino.freemarker;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.yoshino.freemarker.method.DivNLineNItemFormatMethodModelEx;
import com.yoshino.freemarker.method.IndexOfMethod;
import com.yoshino.freemarker.method.InvDetTableFormatMethodModelEx;
import com.yoshino.freemarker.model.InvDet;
import com.yoshino.freemarker.model.InvMain;
import com.yoshino.freemarker.model.PrintTemplateData;
import com.yoshino.freemarker.model.User;
import com.yoshino.freemarker.service.FreemarkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class FreemarkerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(FreemarkerApplication.class, args);
    }

    @Autowired
    private FreemarkerService freemarkerService;

    @Override
    public void run(String... args) throws Exception {
//        System.out.println(testBuildStringFreeMarker());
        System.out.println(testBuildPrintTemplate());
    }


    private String testBuildPrintTemplate() {
        String printTemplate = "{\"title\":\"销售单\",\"header\":[[{\"nameEn\":\"id\",\"caption\":\"批次\",\"fontSize\":10,\"fontWeight\":\"bold\",\"vType\":\"input\"},{\"nameEn\":\"optime\",\"caption\":\"日期\",\"fontSize\":10,\"fontWeight\":\"bold\",\"vType\":\"input\"}],[{\"nameEn\":\"clientname\",\"caption\":\"客户\",\"fontSize\":10,\"fontWeight\":\"bold\",\"vType\":\"input\"},{\"nameEn\":\"sellername\",\"caption\":\"店员\",\"fontSize\":10,\"fontWeight\":\"bold\",\"vType\":\"input\"}]],\"dets\":{\"head\":[{\"nameEn\":\"code\",\"caption\":\"款号\",\"width\":\"15\",\"fontSize\":10,\"fontWeight\":\"bold\",\"vType\":\"input\"},{\"nameEn\":\"color\",\"caption\":\"颜色\",\"width\":\"8\",\"fontSize\":10,\"fontWeight\":\"bold\",\"vType\":\"input\"},{\"nameEn\":\"size\",\"caption\":\"尺码\",\"width\":\"8\",\"fontSize\":10,\"fontWeight\":\"bold\",\"vType\":\"input\"},{\"nameEn\":\"num\",\"caption\":\"数量\",\"width\":\"8\",\"fontSize\":10,\"fontWeight\":\"bold\",\"vType\":\"input\"}],\"config\":{\"lineType\":\"0\",\"borderType\":\"0\"}},\"footer\":[[{\"nameEn\":\"sellername\",\"caption\":\"经办人\",\"fontSize\":10,\"fontWeight\":\"bold\",\"vType\":\"input\"},{\"nameEn\":\"dwphone\",\"caption\":\"电话\",\"fontSize\":10,\"fontWeight\":\"bold\",\"vType\":\"input\"}],[{\"nameEn\":\"dwmobile\",\"caption\":\"手机\",\"fontSize\":10,\"fontWeight\":\"bold\",\"vType\":\"input\"},{\"nameEn\":\"CUSTOM\",\"caption\":\"提醒:离店概不退换\",\"fontSize\":10,\"fontWeight\":\"bold\",\"vType\":\"input\"}]]}";
        PrintTemplateData templateData = JSON.parseObject(printTemplate, PrintTemplateData.class);
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("template", templateData);
        dataMap.put("data", JSON.toJSON(buildData()));
        dataMap.put("divNLineNItemFormat", new DivNLineNItemFormatMethodModelEx());
        dataMap.put("invDetTableFormat", new InvDetTableFormatMethodModelEx());
        return freemarkerService.fillTemplate("printTemplate.ftl", dataMap);
    }

    private InvMain buildData() {
        InvMain result = new InvMain();
        result.setId("501");
        result.setOptime("2020-01-28");
        result.setClientname("张三");
        result.setSellername("李四");
        result.setDwphone("87654321");
        result.setDwmobile("12345678901");

        InvDet invDet1 = new InvDet();
        invDet1.setCode("0222,卫衣");
        invDet1.setColor("黑色");
        invDet1.setSize("s");
        invDet1.setNum("5");
        InvDet invDet2 = new InvDet();
        invDet2.setCode("0222,羽绒马甲");
        invDet2.setColor("黑色");
        invDet2.setSize("L");
        invDet2.setNum("5");
        result.setKhjgDets(Lists.newArrayList(invDet1, invDet2));
        return result;
    }

    private String testBuildStringFreeMarker() {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("name", "yoshino");
        dataMap.put("dateTime", new Date());

        List<User> users = new ArrayList<>();
        users.add(new User(1, "yoshino"));
        users.add(new User(2, "2"));
        users.add(new User(3, "ding"));
        dataMap.put("users", users);
        dataMap.put("indexOf", new IndexOfMethod());

        return freemarkerService.fillTemplate("stringFreeMarker.ftl", dataMap);
    }

}
