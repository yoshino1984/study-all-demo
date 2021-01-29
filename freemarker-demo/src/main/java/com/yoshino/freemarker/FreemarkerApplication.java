package com.yoshino.freemarker;

import com.google.common.collect.Lists;
import com.yoshino.freemarker.method.IndexOfMethod;
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
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("title", "销售单");
        dataMap.put("headers", Lists.newArrayList("批次:501", "日期:2020-01-28", "客户:张三", "店员:李四"));
        return freemarkerService.fillTemplate("printTemplate.ftl", dataMap);
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
