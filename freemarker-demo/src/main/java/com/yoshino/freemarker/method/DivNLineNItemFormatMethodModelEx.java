package com.yoshino.freemarker.method;

import com.alibaba.fastjson.JSONObject;
import com.yoshino.freemarker.model.InvMain;
import com.yoshino.freemarker.model.PrintItem;
import freemarker.ext.beans.StringModel;
import freemarker.template.*;

import java.util.List;

/**
 * 将 List<List<PrintItem>> 转换成多行的
 *
 * @author wangxin
 * 2021/1/29 09:33
 * @since
 **/
public class DivNLineNItemFormatMethodModelEx implements TemplateMethodModelEx {

    @Override
    public TemplateModel exec(List args) throws TemplateModelException {
        if (args.size() != 3) {
            throw new TemplateModelException("Wrong arguments! 3 arguments are needed");
        }
        SimpleSequence items = (SimpleSequence)args.get(0);
        SimpleHash data = (SimpleHash) args.get(1);
        String divClass = ((SimpleScalar)args.get(2)).getAsString();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < items.size(); i++) {
            SimpleSequence lineItems =  (SimpleSequence)items.get(i);
            result.append("<div class=\"").append(divClass).append("\">").append("\n");
            for (int j = 0; j < lineItems.size(); j++) {
                PrintItem item = (PrintItem) ((StringModel)lineItems.get(j)).getWrappedObject();
                String str = item.getCaption();
                if (item.notCustom()) {
                    str += ":" + data.get(item.getNameEn());
                }
                result.append("<div>").append(str).append("</div>").append("\n");
            }
            result.append("</div>").append("\n");
        }
        return SimpleScalar.newInstanceOrNull(result.toString());
    }
}
