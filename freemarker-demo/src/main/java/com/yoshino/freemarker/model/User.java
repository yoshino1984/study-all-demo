package com.yoshino.freemarker.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author wangxin
 * 2021/1/27 16:43
 * @since
 **/
@Data
@AllArgsConstructor
public class User {

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    private Integer id;
    private String name;
    private List<String> lovers;
}
