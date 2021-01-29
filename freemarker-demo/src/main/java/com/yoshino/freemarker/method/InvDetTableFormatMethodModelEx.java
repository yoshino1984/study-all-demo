package com.yoshino.freemarker.method;

import com.alibaba.fastjson.JSONObject;
import com.yoshino.freemarker.model.InvDet;
import com.yoshino.freemarker.model.PrintItem;
import com.yoshino.freemarker.model.Table;
import freemarker.ext.beans.StringModel;
import freemarker.template.*;
import sun.tools.jconsole.Tab;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author wangxin
 * 2021/1/29 09:33
 * @since
 **/
public class InvDetTableFormatMethodModelEx implements TemplateMethodModelEx {

    @Override
    public TemplateModel exec(List args) throws TemplateModelException {
        Table table = (Table) ((StringModel)args.get(0)).getWrappedObject();
        SimpleSequence invDets = (SimpleSequence) args.get(1);

        String result = new StringBuilder()
            .append("<div class=\"table lineType" + table.getConfig().getLineType() + "\" style=\"margin-top: 15px\">")
            .append(buildTableHead(table.getHead()))
            .append(buildTableBody(table.getHead(), invDets))
            .append("</div>").append("\n")
            .toString();
        return SimpleScalar.newInstanceOrNull(result);
    }

    private StringBuilder buildTableHead(List<PrintItem> head) throws TemplateModelException {
        StringBuilder result = new StringBuilder();
        result.append("<div class=\"table-head\">");
        for (PrintItem printItem : head) {
            result.append(getDivItemOneLine(printItem, null));
        }
        result.append("</div>").append("\n");
        return result;
    }

    private StringBuilder buildTableBody(List<PrintItem> head, SimpleSequence invDets) throws TemplateModelException {
        StringBuilder result = new StringBuilder();
        result.append("<div class=\"table-body\">");
        for (int i = 0; i < invDets.size(); i++) {
            SimpleHash invDet = (SimpleHash) invDets.get(i);
            result.append("<div class=\"table-body-line\">");
            for (PrintItem printItem : head) {
                result.append(getDivItemOneLine(printItem, invDet));
            }
            result.append("</div>").append("\n");
        }
        result.append("</div>").append("\n");
        return result;
    }

    private StringBuilder getDivItemOneLine(PrintItem printItem, SimpleHash invDet) throws TemplateModelException {
        return new StringBuilder()
            .append("<div ").append(getStyle(printItem)).append(">")
            .append(Objects.isNull(invDet) ? printItem.getCaption() : invDet.get(printItem.getNameEn()))
            .append("</div>").append("\n");
    }

    private String getStyle(PrintItem printItem) {
        return "style=\"width: " + printItem.getWidth() + "mm\"";
    }
}