package com.yoshino.javabizcoreweb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * threadLocal
 * @author wangxin
 * 2020/4/6 21:43
 * @since
 **/
@RestController
@RequestMapping("/threadlocal")
public class ThreadLocalController {

    private static final ThreadLocal<Integer> CURRENT_USER = ThreadLocal.withInitial(() -> null);

    @GetMapping("/wrong")
    public Map<String, Object> wrong(@RequestParam("userId") Integer userId) {
        //设置用户信息之前先查询一次ThreadLocal中的用户信息
        String before = Thread.currentThread().getName() + ":" + CURRENT_USER.get();
        //设置用户信息到ThreadLocal
        CURRENT_USER.set(userId);
        //设置用户信息之后再查询一次ThreadLocal中的用户信息
        String after  = Thread.currentThread().getName() + ":" + CURRENT_USER.get();
        //汇总输出两次查询结果
        Map<String, Object> result = new HashMap();
        result.put("before", before);
        result.put("after", after);
        return result;
    }


    @GetMapping("right")
    public Map right(@RequestParam("userId") Integer userId) {
        String before  = Thread.currentThread().getName() + ":" + CURRENT_USER.get();
        CURRENT_USER.set(userId);
        try {
            String after = Thread.currentThread().getName() + ":" + CURRENT_USER.get();
            Map result = new HashMap();
            result.put("before", before);
            result.put("after", after);
            return result;
        } finally {
            //在finally代码块中删除ThreadLocal中的数据，确保数据不串
            CURRENT_USER.remove();
        }
    }
}
