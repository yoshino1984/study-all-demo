package com.yoshino.freemarker.model;


import java.util.List;

public class InvMain {
    /**
     * 批次号
     */
    public String id;
    /**
     * 商陆花版本号
     */
    public String version;
    /**
     * 打印份数
     */
    public String printnum;
    /**
     * 开单日期
     */
    public String optime;
    /**
     * 客户名称
     */
    public String clientname;
    /**
     * vip卡号
     */
    public String vipcode = "";
    /**
     * 店员姓名(工号)
     */
    public String sellername;
    /**
     * 小票抬头
     */
    public String printhead;
    /**
     * 门店地址
     */
    public String dwaddr;
    /**
     * 门店账号名称
     */
    public String accountname;
    /**
     * 门店账号
     */
    public String accountno;
    public String accountname2;
    public String accountno2;
    public String accountname3;
    public String accountno3;
    public String accountname4;
    public String accountno4;
    public String accountname5 = "";
    public String accountno5 = "";
    public String accountname6 = "";
    public String accountno6 = "";
    /**
     * 门店电话
     */
    public String dwphone;
    /**
     * 门店手机
     */
    public String dwmobile;
    /**
     * 小票备注
     */
    public String printfooter;
    /**
     * 整单备注
     */
    public String rem;
    /**
     * 普通或童装模式 cloth或kidcloth
     */
    public String protype;
    /**
     * 调出门店名称
     */
    public String invfrom;
    /**
     * 调入门店名称
     */
    public String invto;
    /**
     * 操作人名称
     */
    public String oper;
    /**
     * 金额相关描述
     */
    public String findesc;
    /**
     * 存入的刷卡行名称
     */
    public String cardname;
    /**
     * 支付方式	零售专用
     */
    public String payway;
    /**
     * 客户电话(零售)，批发见getKhdh
     */
    public String clientphone;
    /**
     * 实付(零售)
     */
    public String realpay;
    /**
     * 找零
     */
    public String change;
    /**
     * 存入的汇款行名称
     */
    public String remitname;
    /**
     * 客户地址
     */
    public String clientaddr;
    /**
     * 单据类别
     */
    public String type;
    /**
     * 作废标记
     */
    public String invalidflag;
    /**
     * 是否打印颜色尺码 1是0否
     */
    public String printcolorsize;
    /**
     * 代收类型
     */
    public String balancetype;  //原来是int，转换的时候会报错
    /**
     * 定行页码
     */
    public String dhym;
    /**
     * 定行页总
     */
    public String dhyz;
    /**
     * 最多尺码个数
     */
    private String maxsize;

    /**
     * 现金
     */
    public String cash;
    /**
     * 刷卡
     */
    public String card;

    /**
     * 代收
     */
    public String daishou;
    /**
     * 汇款
     */
    public String remit;

    /***
     * 订单预付
     */
    public String deposit;
    /**
     * 本次核销金额
     */
    public String verifysum;
    /**
     * 本单结余
     */
    public String balance;
    /**
     *
     */
    public String balanceadd;
    /**
     * 本单总数
     */
    public String totalnum;
    /**
     * 本单总额
     */
    public String totalsum;
    /**
     * 2018-04-23 总金额(xml发送过来的)
     */
    public String totalsumOrig;
    /**
     * 客户累计余额
     */
    public String lastbalance;
    /**
     * 退货数
     */
    public String backnum;
    /**
     * 退货额
     */
    public String backsum;
    /**
     * 整单折扣
     */
    public String maindiscount;
    /**
     * 积分
     */
    public String score;
    //public List<InvDet> details = new ArrayList<>();
    //public List<InvDet> mx; //别名，明细
    //public List<InvDetGroup> groupList; //按尺码组对明细进行分组
    //public List<VerifyDet> verifydetails = new ArrayList<>();
    //public List<VerifyDet> hx = verifydetails; //别名，核销
    //public List<Account> zh; //账户列表
    //public List<String> sizeNumList; //分尺码数量列表
    //public Double[] sizeNums;
    public String totalsum1;//折前总金额
    public String actualnum;//销售数
    public String actualsum;//销售金额
    public String othercost;//其他
    public String sumdesc;
    public String serverurl;
    public String epid;
    public String yscmgs; //颜色尺码个数
    public String prodate;
    //public List<PayDet> paydetails = new ArrayList<>();
    //public List<PayDet> fkmx; //付款明细

    //=1 表示 尺码表头开单 2015－05－15 增加
    public String salessizehead;

    /**
     * 漏打提示
     */
    public String missPrintHint;

    public Boolean sizeheadGroup;

    /**
     * 订货单批次
     */
    public String orderno;
    /**
     * 订货单日期
     */
    public String orderdate;

    /**
     * 按款号，价格合并的明细列表
     */
    private List<InvDet> khjgDets;
    /**
     * 按款号颜色价格合并的明细列表
     */
    private List<InvDet> ksjDets;
    /**
     * 产品类别
     */
    public String productcode;
    /**
     * 物流商名称 只针对代收模式有这个属性，其他的模式不会传
     */
    public String logisdwname;
    /**
     * 总金额小数位数 2016-03-24
     */
    public Integer totalsumRound = 0;
    /**
     * 找零 2016-08-16
     */
    public String cashchange;

    /**
     * 移动支付,2017-06-30取消，换成 finpayAlipay="支付宝" finpayWeixinpay="微信" public
     * double mobilepay; public String mobilepayoffer;
     */
    /**
     * 支付宝
     */
    public String finpayAlipay;
    /**
     * 微信支付
     */
    public String finpayWeixinpay;

    /**
     * http://jira.hzdlsoft.com:7082/browse/IOSFRAMEWIKI-34 1折后，0折前 > 7.25 童装
     */
    public String discountedpricemode = "1";
    /**
     * ipad-mac 2017-02-21加
     */
    public String mac;
    /**
     * =1表示挂单 2017-02-22加
     */
    public String istempbill;

    /**
     * 产品类别名称
     */
    public String dlProductType;

    /**
     * 2017-07-28 代金券
     */
    public String chit;

    /**
     * 产品类型 2：经典版 5：面料版 6零售版
     */
    public String gprotype;

    /**
     * 发货状态
     */
    public String deliverStatusName;

    /**
     * 打印次数，第几次打印
     */
    public String printcount;

    /**
     * sn,客户编号
     */
    public String sn;
    /**
     * 扩展
     */
    public String extend;
    /**
     * 扩展转换json对象
     */
    //public JSONObject more = new JSONObject();

    /**
     * 小票数据库主键id
     */
    public String mainid;

    /**
     * 储值支付(二代)
     */
    public String storedValueCost;
    /**
     * 储值余额(二代)
     */
    public String storedValueBalance;
    /** 发货门店 */
    public String deliverInvName;

    // 2018-07-20 以下为笑铺日记新增
    /**
     * 连连看门店连接 *
     */
    public String linkShopUrl;
    /**
     * 抹零金额
     */
    public String favorMoney;
    /**
     * 其他特殊货品合计
     */
    public String otherCost;
    /**
     * 实收/实付金额
     */
    public String realPayMoney;
    /**
     * 赠送金额
     */
    public String giveSum;
    /**
     * 连连看二维码
     */
    public String shopLinkQRCodeContent;
    /**
     * 是否显示价格名称
     */
    public Boolean showPrice;
    /**
     * 客户备注 2019-08-05 一代新增
     */
    public String compRem;

    /**
     * 门店id
     */
    private String invid;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getPrintnum() {
        return printnum;
    }

    public void setPrintnum(String printnum) {
        this.printnum = printnum;
    }

    public String getOptime() {
        return optime;
    }

    public void setOptime(String optime) {
        this.optime = optime;
    }

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    public String getVipcode() {
        return vipcode;
    }

    public void setVipcode(String vipcode) {
        this.vipcode = vipcode;
    }

    public String getSellername() {
        return sellername;
    }

    public void setSellername(String sellername) {
        this.sellername = sellername;
    }

    public String getPrinthead() {
        return printhead;
    }

    public void setPrinthead(String printhead) {
        this.printhead = printhead;
    }

    public String getDwaddr() {
        return dwaddr;
    }

    public void setDwaddr(String dwaddr) {
        this.dwaddr = dwaddr;
    }

    public String getAccountname() {
        return accountname;
    }

    public void setAccountname(String accountname) {
        this.accountname = accountname;
    }

    public String getAccountno() {
        return accountno;
    }

    public void setAccountno(String accountno) {
        this.accountno = accountno;
    }

    public String getAccountname2() {
        return accountname2;
    }

    public void setAccountname2(String accountname2) {
        this.accountname2 = accountname2;
    }

    public String getAccountno2() {
        return accountno2;
    }

    public void setAccountno2(String accountno2) {
        this.accountno2 = accountno2;
    }

    public String getAccountname3() {
        return accountname3;
    }

    public void setAccountname3(String accountname3) {
        this.accountname3 = accountname3;
    }

    public String getAccountno3() {
        return accountno3;
    }

    public void setAccountno3(String accountno3) {
        this.accountno3 = accountno3;
    }

    public String getAccountname4() {
        return accountname4;
    }

    public void setAccountname4(String accountname4) {
        this.accountname4 = accountname4;
    }

    public String getAccountno4() {
        return accountno4;
    }

    public void setAccountno4(String accountno4) {
        this.accountno4 = accountno4;
    }

    public String getAccountname5() {
        return accountname5;
    }

    public void setAccountname5(String accountname5) {
        this.accountname5 = accountname5;
    }

    public String getAccountno5() {
        return accountno5;
    }

    public void setAccountno5(String accountno5) {
        this.accountno5 = accountno5;
    }

    public String getAccountname6() {
        return accountname6;
    }

    public void setAccountname6(String accountname6) {
        this.accountname6 = accountname6;
    }

    public String getAccountno6() {
        return accountno6;
    }

    public void setAccountno6(String accountno6) {
        this.accountno6 = accountno6;
    }

    public String getDwphone() {
        return dwphone;
    }

    public void setDwphone(String dwphone) {
        this.dwphone = dwphone;
    }

    public String getDwmobile() {
        return dwmobile;
    }

    public void setDwmobile(String dwmobile) {
        this.dwmobile = dwmobile;
    }

    public String getPrintfooter() {
        return printfooter;
    }

    public void setPrintfooter(String printfooter) {
        this.printfooter = printfooter;
    }

    public String getRem() {
        return rem;
    }

    public void setRem(String rem) {
        this.rem = rem;
    }

    public String getProtype() {
        return protype;
    }

    public void setProtype(String protype) {
        this.protype = protype;
    }

    public String getInvfrom() {
        return invfrom;
    }

    public void setInvfrom(String invfrom) {
        this.invfrom = invfrom;
    }

    public String getInvto() {
        return invto;
    }

    public void setInvto(String invto) {
        this.invto = invto;
    }

    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }

    public String getFindesc() {
        return findesc;
    }

    public void setFindesc(String findesc) {
        this.findesc = findesc;
    }

    public String getCardname() {
        return cardname;
    }

    public void setCardname(String cardname) {
        this.cardname = cardname;
    }

    public String getPayway() {
        return payway;
    }

    public void setPayway(String payway) {
        this.payway = payway;
    }

    public String getClientphone() {
        return clientphone;
    }

    public void setClientphone(String clientphone) {
        this.clientphone = clientphone;
    }

    public String getRealpay() {
        return realpay;
    }

    public void setRealpay(String realpay) {
        this.realpay = realpay;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public String getRemitname() {
        return remitname;
    }

    public void setRemitname(String remitname) {
        this.remitname = remitname;
    }

    public String getClientaddr() {
        return clientaddr;
    }

    public void setClientaddr(String clientaddr) {
        this.clientaddr = clientaddr;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInvalidflag() {
        return invalidflag;
    }

    public void setInvalidflag(String invalidflag) {
        this.invalidflag = invalidflag;
    }

    public String getPrintcolorsize() {
        return printcolorsize;
    }

    public void setPrintcolorsize(String printcolorsize) {
        this.printcolorsize = printcolorsize;
    }

    public String getBalancetype() {
        return balancetype;
    }

    public void setBalancetype(String balancetype) {
        this.balancetype = balancetype;
    }

    public String getDhym() {
        return dhym;
    }

    public void setDhym(String dhym) {
        this.dhym = dhym;
    }

    public String getDhyz() {
        return dhyz;
    }

    public void setDhyz(String dhyz) {
        this.dhyz = dhyz;
    }

    public String getMaxsize() {
        return maxsize;
    }

    public void setMaxsize(String maxsize) {
        this.maxsize = maxsize;
    }

    public String getCash() {
        return cash;
    }

    public void setCash(String cash) {
        this.cash = cash;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }


    public String getDaishou() {
        return daishou;
    }

    public void setDaishou(String daishou) {
        this.daishou = daishou;
    }

    public String getRemit() {
        return remit;
    }

    public void setRemit(String remit) {
        this.remit = remit;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getVerifysum() {
        return verifysum;
    }

    public void setVerifysum(String verifysum) {
        this.verifysum = verifysum;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getBalanceadd() {
        return balanceadd;
    }

    public void setBalanceadd(String balanceadd) {
        this.balanceadd = balanceadd;
    }

    public String getTotalnum() {
        return totalnum;
    }

    public void setTotalnum(String totalnum) {
        this.totalnum = totalnum;
    }

    public String getTotalsum() {
        return totalsum;
    }

    public void setTotalsum(String totalsum) {
        this.totalsum = totalsum;
    }

    public String getTotalsumOrig() {
        return totalsumOrig;
    }

    public void setTotalsumOrig(String totalsumOrig) {
        this.totalsumOrig = totalsumOrig;
    }

    public String getLastbalance() {
        return lastbalance;
    }

    public void setLastbalance(String lastbalance) {
        this.lastbalance = lastbalance;
    }

    public String getBacknum() {
        return backnum;
    }

    public void setBacknum(String backnum) {
        this.backnum = backnum;
    }

    public String getBacksum() {
        return backsum;
    }

    public void setBacksum(String backsum) {
        this.backsum = backsum;
    }

    public String getMaindiscount() {
        return maindiscount;
    }

    public void setMaindiscount(String maindiscount) {
        this.maindiscount = maindiscount;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    //public List<InvDet> getDetails() {
    //    return details;
    //}
    //
    //public void setDetails(List<InvDet> details) {
    //    this.details = details;
    //}
    //
    //public List<InvDet> getMx() {
    //    return mx;
    //}
    //
    //public void setMx(List<InvDet> mx) {
    //    this.mx = mx;
    //}

    //public List<InvDetGroup> getGroupList() {
    //    return groupList;
    //}
    //
    //public void setGroupList(List<InvDetGroup> groupList) {
    //    this.groupList = groupList;
    //}

    //public List<VerifyDet> getVerifydetails() {
    //    return verifydetails;
    //}
    //
    //public void setVerifydetails(List<VerifyDet> verifydetails) {
    //    this.verifydetails = verifydetails;
    //}
    //
    //public List<VerifyDet> getHx() {
    //    return hx;
    //}
    //
    //public void setHx(List<VerifyDet> hx) {
    //    this.hx = hx;
    //}

    //public List<Account> getZh() {
    //    return zh;
    //}
    //
    //public void setZh(List<Account> zh) {
    //    this.zh = zh;
    //}
    //
    //public List<String> getSizeNumList() {
    //    return sizeNumList;
    //}
    //
    //public void setSizeNumList(List<String> sizeNumList) {
    //    this.sizeNumList = sizeNumList;
    //}

    //public Double[] getSizeNums() {
    //    return sizeNums;
    //}
    //
    //public void setSizeNums(Double[] sizeNums) {
    //    this.sizeNums = sizeNums;
    //}

    public String getTotalsum1() {
        return totalsum1;
    }

    public void setTotalsum1(String totalsum1) {
        this.totalsum1 = totalsum1;
    }

    public String getActualnum() {
        return actualnum;
    }

    public void setActualnum(String actualnum) {
        this.actualnum = actualnum;
    }

    public String getActualsum() {
        return actualsum;
    }

    public void setActualsum(String actualsum) {
        this.actualsum = actualsum;
    }

    public String getOthercost() {
        return othercost;
    }

    public void setOthercost(String othercost) {
        this.othercost = othercost;
    }

    public String getSumdesc() {
        return sumdesc;
    }

    public void setSumdesc(String sumdesc) {
        this.sumdesc = sumdesc;
    }

    public String getServerurl() {
        return serverurl;
    }

    public void setServerurl(String serverurl) {
        this.serverurl = serverurl;
    }

    public String getEpid() {
        return epid;
    }

    public void setEpid(String epid) {
        this.epid = epid;
    }

    public String getYscmgs() {
        return yscmgs;
    }

    public void setYscmgs(String yscmgs) {
        this.yscmgs = yscmgs;
    }

    public String getProdate() {
        return prodate;
    }

    public void setProdate(String prodate) {
        this.prodate = prodate;
    }

    //public List<PayDet> getPaydetails() {
    //    return paydetails;
    //}
    //
    //public void setPaydetails(List<PayDet> paydetails) {
    //    this.paydetails = paydetails;
    //}
    //
    //public List<PayDet> getFkmx() {
    //    return fkmx;
    //}
    //
    //public void setFkmx(List<PayDet> fkmx) {
    //    this.fkmx = fkmx;
    //}

    //public List<PayWay> getPaylist() {
    //    return paylist;
    //}
    //
    //public void setPaylist(List<PayWay> paylist) {
    //    this.paylist = paylist;
    //}

    public String getSalessizehead() {
        return salessizehead;
    }

    public void setSalessizehead(String salessizehead) {
        this.salessizehead = salessizehead;
    }

    public String getMissPrintHint() {
        return missPrintHint;
    }

    public void setMissPrintHint(String missPrintHint) {
        this.missPrintHint = missPrintHint;
    }

    public Boolean isSizeheadGroup() {
        return sizeheadGroup;
    }

    public void setSizeheadGroup(Boolean sizeheadGroup) {
        this.sizeheadGroup = sizeheadGroup;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    public String getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    }

    public List<InvDet> getKhjgDets() {
        return khjgDets;
    }

    public void setKhjgDets(List<InvDet> khjgDets) {
        this.khjgDets = khjgDets;
    }

    public List<InvDet> getKsjDets() {
        return ksjDets;
    }

    public void setKsjDets(List<InvDet> ksjDets) {
        this.ksjDets = ksjDets;
    }

    public String getProductcode() {
        return productcode;
    }

    public void setProductcode(String productcode) {
        this.productcode = productcode;
    }

    public String getLogisdwname() {
        return logisdwname;
    }

    public void setLogisdwname(String logisdwname) {
        this.logisdwname = logisdwname;
    }

    public Integer getTotalsumRound() {
        return totalsumRound;
    }

    public void setTotalsumRound(Integer totalsumRound) {
        this.totalsumRound = totalsumRound;
    }

    public String getCashchange() {
        return cashchange;
    }

    public void setCashchange(String cashchange) {
        this.cashchange = cashchange;
    }

    public String getFinpayAlipay() {
        return finpayAlipay;
    }

    public void setFinpayAlipay(String finpayAlipay) {
        this.finpayAlipay = finpayAlipay;
    }

    public String getFinpayWeixinpay() {
        return finpayWeixinpay;
    }

    public void setFinpayWeixinpay(String finpayWeixinpay) {
        this.finpayWeixinpay = finpayWeixinpay;
    }

    public String getDiscountedpricemode() {
        return discountedpricemode;
    }

    public void setDiscountedpricemode(String discountedpricemode) {
        this.discountedpricemode = discountedpricemode;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getIstempbill() {
        return istempbill;
    }

    public void setIstempbill(String istempbill) {
        this.istempbill = istempbill;
    }

    public String getDlProductType() {
        return dlProductType;
    }

    public void setDlProductType(String dlProductType) {
        this.dlProductType = dlProductType;
    }

    public String getChit() {
        return chit;
    }

    public void setChit(String chit) {
        this.chit = chit;
    }

    public String getGprotype() {
        return gprotype;
    }

    public void setGprotype(String gprotype) {
        this.gprotype = gprotype;
    }

    public String getDeliverStatusName() {
        return deliverStatusName;
    }

    public void setDeliverStatusName(String deliverStatusName) {
        this.deliverStatusName = deliverStatusName;
    }

    //public Integer getPrintcount() {
    //    return printcount;
    //}
    //
    //public void setPrintcount(Integer printcount) {
    //    this.printcount = printcount;
    //}

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend;
    }

    public String getMainid() {
        return mainid;
    }

    public void setMainid(String mainid) {
        this.mainid = mainid;
    }

    public String getStoredValueCost() {
        return storedValueCost;
    }

    public void setStoredValueCost(String storedValueCost) {
        this.storedValueCost = storedValueCost;
    }

    public String getStoredValueBalance() {
        return storedValueBalance;
    }

    public void setStoredValueBalance(String storedValueBalance) {
        this.storedValueBalance = storedValueBalance;
    }

    public String getDeliverInvName() {
        return deliverInvName;
    }

    public void setDeliverInvName(String deliverInvName) {
        this.deliverInvName = deliverInvName;
    }

    public String getLinkShopUrl() {
        return linkShopUrl;
    }

    public void setLinkShopUrl(String linkShopUrl) {
        this.linkShopUrl = linkShopUrl;
    }

    public String getFavorMoney() {
        return favorMoney;
    }

    public void setFavorMoney(String favorMoney) {
        this.favorMoney = favorMoney;
    }

    public String getOtherCost() {
        return otherCost;
    }

    public void setOtherCost(String otherCost) {
        this.otherCost = otherCost;
    }

    public String getRealPayMoney() {
        return realPayMoney;
    }

    public void setRealPayMoney(String realPayMoney) {
        this.realPayMoney = realPayMoney;
    }

    public String getGiveSum() {
        return giveSum;
    }

    public void setGiveSum(String giveSum) {
        this.giveSum = giveSum;
    }

    public String getShopLinkQRCodeContent() {
        return shopLinkQRCodeContent;
    }

    public void setShopLinkQRCodeContent(String shopLinkQRCodeContent) {
        this.shopLinkQRCodeContent = shopLinkQRCodeContent;
    }

    public Boolean isShowPrice() {
        return showPrice;
    }

    public void setShowPrice(Boolean showPrice) {
        this.showPrice = showPrice;
    }

    public String getCompRem() {
        return compRem;
    }

    public void setCompRem(String compRem) {
        this.compRem = compRem;
    }

    public String getInvid() {
        return invid;
    }

    public void setInvid(String invid) {
        this.invid = invid;
    }

    public String getPrintcount() {
        return printcount;
    }

    public void setPrintcount(String printcount) {
        this.printcount = printcount;
    }

    
}
