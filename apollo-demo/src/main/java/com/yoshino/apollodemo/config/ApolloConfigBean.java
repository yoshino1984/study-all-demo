package com.yoshino.apollodemo.config;

import com.ctrip.framework.apollo.ConfigService;
import com.ctrip.framework.apollo.spring.annotation.ApolloJsonValue;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import lombok.Data;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author wangxin
 * 2020/12/30 09:23
 * @since
 **/
@Getter
@Service
@EnableApolloConfig
public class ApolloConfigBean {

    @ApolloJsonValue(value = "${mpAppPkgServiceType:{}}")
    private Map<Integer, String> serviceType;

    @ApolloJsonValue(value = "${mpAppPkgStyleType:{}}")
    private Map<Integer, String> styleType;

    @ApolloJsonValue(value = "${mpAppPkgOrderType:{}}")
    private Map<Integer, String> orderType;

    @ApolloJsonValue(value = "${appDingBizAccessTokens:{}}")
    private Map<String, String> appCodeDingBizAccessTokenMap;

    static {
        ConfigService.getAppConfig().addChangeListener(System.out::println);
    }

}
