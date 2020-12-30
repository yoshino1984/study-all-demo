package com.yoshino.apollodemo.config;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wangxin
 * 2020/12/30 09:37
 * @since
 **/
@Data
public class TypeBean implements Serializable {

    private Integer type;

    private String caption;
}
