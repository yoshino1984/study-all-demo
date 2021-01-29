package com.yoshino.freemarker.method;

import freemarker.template.*;

import java.util.List;

/**
 * @author wangxin
 * 2021/1/29 09:33
 * @since
 **/
public class IndexOfMethod implements TemplateMethodModelEx {

    @Override
    public Object exec(List args) throws TemplateModelException {
        if (args.size() != 2) {
            throw new TemplateModelException("Wrong arguments");
        }
        return String.valueOf((((SimpleScalar) args.get(1))).getAsString().indexOf(((SimpleScalar) args.get(0)).getAsString()));
    }
}
