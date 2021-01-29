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
                ${title}
            </div>


            <!-- 头部 -->
            <div class="headers">
                <div class="header-line">
                    <div>批次:501</div>
                    <div>日期:2020-01-28</div>
                </div>
                <div class="header-line">
                    <div>客户:张三</div>
                    <div>店员:李四</div>
                </div>
            </div>

            <!-- 表格 -->
            <div class="table lineType0" style="margin-top: 15px">
                <!-- 表格头部 -->
                <div class="table-head">
                    <div style="width: 15mm">款号</div>
                    <div style="width: 8mm">颜色</div>
                    <div style="width: 8mm">尺码</div>
                    <div style="width: 8mm">数量</div>
                </div>
                <!-- 表格主体 -->
                <div class="table-body">
                    <div class="table-body-line">
                        <div style="width: 15mm">0222,卫衣</div>
                        <div style="width: 8mm">黑色</div>
                        <div style="width: 8mm">s</div>
                        <div style="width: 8mm">5</div>
                    </div>
                    <div class="table-body-line">
                        <div style="width: 15mm">0222,羽绒马甲</div>
                        <div style="width: 8mm">黑色</div>
                        <div style="width: 8mm">L</div>
                        <div style="width: 8mm">5</div>
                    </div>
                </div>
            </div>

            <!-- 底部 -->
            <div class="footer" style="margin-top: 15px">
                <div class="footer-line">
                    <div>经办人:王五</div>
                    <div>电话:87654321</div>
                </div>
                <div class="footer-line">
                    <div>手机:12345678901</div>
                    <div>提醒:离店概不退换</div>
                </div>
            </div>
        </div>
    </body>
</html>
