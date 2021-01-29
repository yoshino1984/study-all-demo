package com.yoshino.freemarker.method;

import freemarker.template.*;

import java.util.List;

/**
 * @author wangxin
 * 2021/1/29 09:33
 * @since
 **/
public class TableFormatMethod implements TemplateMethodModelEx {

    @Override
    public TemplateModel exec(List args) throws TemplateModelException {
        int count = 0;
        StringBuilder result = new StringBuilder();
        SimpleSequence items = (SimpleSequence)args.get(0);
        for (int i = 0; i < items.size(); i++) {
            SimpleScalar item = (SimpleScalar) items.get(i);
            boolean lineStart = ++count % 2 == 1;
            if (lineStart) {
                result.append("<div class=\"header-line\">").append("\n");
            }
            result.append("<div>").append(item.getAsString()).append("</div>").append("\n");
            if (!lineStart) {
                result.append("</div>").append("\n");
            }
        }
        if (count % 2 == 1) {
            result.append("</div>").append("\n");
        }
        return SimpleScalar.newInstanceOrNull(result.toString());
    }
}
