package com.yoshino.apollodemo;

import com.yoshino.apollodemo.config.ApolloConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApolloDemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ApolloDemoApplication.class, args);
    }

    @Autowired
    private ApolloConfigBean apolloConfigBean;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(apolloConfigBean.getServiceType());
        System.out.println(apolloConfigBean.getStyleType());
        System.out.println(apolloConfigBean.getOrderType());
        System.out.println(apolloConfigBean.getAppCodeDingBizAccessTokenMap());
    }
}
