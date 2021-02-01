package com.yoshino.freemarker;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.yoshino.freemarker.method.DivNLineNItemFormatMethodModelEx;
import com.yoshino.freemarker.method.IndexOfMethod;
import com.yoshino.freemarker.method.InvDetTableFormatMethodModelEx;
import com.yoshino.freemarker.model.*;
import com.yoshino.freemarker.service.FreemarkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
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
        String printTemplate = "{\"title\":\"销售单\",\"header\":[[{\"nameEn\":\"mainId\",\"caption\":\"批次\",\"fontSize\":2,\"fontWeight\":\"bold\",\"vType\":\"input\"},{\"nameEn\":\"opTime\",\"caption\":\"日期\",\"fontSize\":2,\"fontWeight\":\"bold\",\"vType\":\"input\"}],[{\"nameEn\":\"compName\",\"caption\":\"客户\",\"fontSize\":2,\"fontWeight\":\"bold\",\"vType\":\"input\"},{\"nameEn\":\"opName\",\"caption\":\"店员\",\"fontSize\":2,\"fontWeight\":\"bold\",\"vType\":\"input\"}]],\"dets\":{\"head\":[{\"nameEn\":\"code\",\"caption\":\"款号\",\"width\":\"15\",\"fontSize\":2,\"fontWeight\":\"bold\",\"vType\":\"input\"},{\"nameEn\":\"color\",\"caption\":\"颜色\",\"width\":\"8\",\"fontSize\":2,\"fontWeight\":\"bold\",\"vType\":\"input\"},{\"nameEn\":\"size\",\"caption\":\"尺码\",\"width\":\"8\",\"fontSize\":2,\"fontWeight\":\"bold\",\"vType\":\"input\"},{\"nameEn\":\"num\",\"caption\":\"数量\",\"width\":\"8\",\"fontSize\":2,\"fontWeight\":\"bold\",\"vType\":\"input\"}],\"config\":{\"lineType\":\"0\",\"borderType\":\"0\"}},\"footer\":[[{\"nameEn\":\"ownerName\",\"caption\":\"经办人\",\"fontSize\":2,\"fontWeight\":\"bold\",\"vType\":\"input\"},{\"nameEn\":\"shopPhone\",\"caption\":\"电话\",\"fontSize\":2,\"fontWeight\":\"bold\",\"vType\":\"input\"}],[{\"nameEn\":\"shopMobile\",\"caption\":\"手机\",\"fontSize\":2,\"fontWeight\":\"bold\",\"vType\":\"input\"},{\"nameEn\":\"CUSTOM\",\"caption\":\"提醒:离店概不退换\",\"fontSize\":2,\"fontWeight\":\"bold\",\"vType\":\"input\"}]]}";
        PrintTemplateData templateData = JSON.parseObject(printTemplate, PrintTemplateData.class);
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("template", templateData);
        dataMap.put("data", buildData());
        dataMap.put("divNLineNItemFormat", new DivNLineNItemFormatMethodModelEx());
        dataMap.put("invDetTableFormat", new InvDetTableFormatMethodModelEx());
        return freemarkerService.fillTemplate("printTemplate.ftl", dataMap);
    }

    private JSON buildData() {
        Main invMain = new Main();
        invMain.setMainId("501");
        invMain.setOpTime(new Date());
        invMain.setCompName("张三");
        invMain.setOpName("李四");
        invMain.setOwnerName("王五");
        invMain.setShopPhone("87654321");
        invMain.setShopMobile("12345678901");
        JSONObject result = (JSONObject) JSON.toJSON(invMain);


        MainDet invDet1 = new MainDet();
        invDet1.setCode("0222,卫衣");
        invDet1.setColor("黑色");
        invDet1.setSize("s");
        invDet1.setNum(BigDecimal.valueOf(5));
        MainDet invDet2 = new MainDet();
        invDet2.setCode("0222,羽绒马甲");
        invDet2.setColor("黑色");
        invDet2.setSize("L");
        invDet2.setNum(BigDecimal.valueOf(5));
        result.put("dets", JSON.toJSON(Lists.newArrayList(invDet1, invDet2)));
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
