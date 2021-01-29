<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta
            name="viewport"
            content="width=device-width,initial-scale=1.0,viewport-fit=cover,user-scalable=no"
        />
        <title>打印模板</title>
        <style>
            /* 头部 */
            .header-line div {
                display: inline-block;
                min-width: 60px;
                margin-right: 20px;
            }
            /* 底部 */
            .footer-line div {
                display: inline-block;
                min-width: 60px;
                margin-right: 20px;
            }
        </style>
        <style>
            /* 表格 */
            .table-head div {
                display: inline-block;
            }
            .table-body-line div {
                display: inline-block;
            }

            /* 表格-实线 */
            .lineType1:not(.borderType2) {
                border-top: 1px solid black;
                border-bottom: 1px solid black;
            }
            .lineType1.borderType3 {
                border-left: 1px solid black;
                border-right: 1px solid black;
            }
            .lineType1:not(.borderType2) .table-head {
                border-bottom: 1px solid black;
            }
            .lineType1:not(.borderType1)
                .table-head
                div:not(:nth-last-of-type(1)) {
                border-right: 1px solid black;
            }
            .lineType1:not(.borderType2)
                .table-body-line:not(:nth-last-of-type(1)) {
                border-bottom: 1px solid black;
            }
            .lineType1:not(.borderType1)
                .table-body-line
                div:not(:nth-last-of-type(1)) {
                border-right: 1px solid black;
            }

            /* 表格-虚线 */
            .lineType2:not(.borderType2) {
                border-top: 1px dashed black;
                border-bottom: 1px dashed black;
            }
            .lineType2.borderType3 {
                border-left: 1px dashed black;
                border-right: 1px dashed black;
            }
            .lineType2:not(.borderType2) .table-head {
                border-bottom: 1px dashed black;
            }
            .lineType2:not(.borderType1)
                .table-head
                div:not(:nth-last-of-type(1)) {
                border-right: 1px dashed black;
            }
            .lineType2:not(.borderType2)
                .table-body-line:not(:nth-last-of-type(1)) {
                border-bottom: 1px dashed black;
            }
            .lineType2:not(.borderType1)
                .table-body-line
                div:not(:nth-last-of-type(1)) {
                border-right: 1px dashed black;
            }
        </style>
    </head>
    <body>
        <div
            class="outer"
            style="
                padding-top: 20px;
                line-height: 1.2;
                font-size: 8px;
                width:100%;
            "
        >
            <!-- 标题 -->
            <div
                class="title"
                style="font-size: 28px; margin-bottom: 15px; text-align: center; width: 100%"
            >
                ${template.title}
            </div>

            <!-- 头部 -->
            <div class="header">
                <#if template.header??>
                    ${divNLineNItemFormat(template.header, data, "header-line")}
                </#if>
            </div>

            <!-- 表格 -->

            <#if template.dets??>
                ${invDetTableFormat(template.dets, data.dets)}
            </#if>

            <!-- 底部 -->
            <div class="footer" style="margin-top: 15px">
                <#if template.footer??>
                    ${divNLineNItemFormat(template.footer, data, "footer-line")}
                </#if>
            </div>
        </div>
    </body>
</html>
