package com.yoshino.freemarker.model;


/**
 * @author luoxingdong
 * @date 2019-11-30 15:21
 */
public class InvDet {
    public Integer idx, i;
    /**
     * 款号
     */
    public String code = "";
    /**
     * 名称
     */
    public String name = "";
    /**
     * 颜色
     */
    public String color = "";
    /**
     * 尺码
     */
    public String cm = "", size = "";
    /**
     * 备注
     */
    public String rem = "";
    /**
     * 原始备注
     */
    public String remOrig;
    /**
     * 品牌
     */
    public String brand;
    /**
     * 条码
     */
    public String barcode;
    /**
     * 数量
     */
    public String num;  //todo
    /**
     * 单价
     */
    public String price;
    /**
     * 吊牌价
     */
    public String stdprice1;
    /**
     * 金额
     */
    public String total;
    /**
     * 折扣比例
     */
    public String discount;

    //特殊货品标记=2，价格类型，手数，补货标志
    /**
     * 货品标记	0=正常货品；2=特殊货品
     */
    public String flag;
    /**
     * 价格类型
     */
    public String stdpricetype;
    /**
     * 组数(手数，面料版匹数)
     */
    public String groupnum;
    /* 0或1 是否补货 */
    public String secondsale;

    public String key_code_name_color;
    public String codeNameColor;
    //public List<String> sizeNumList; //分尺码数量列表
    //public Double[] sizeNums;
    public String total1;
    //不显示0,序号，数量，单价，金额,原价(折前价=单价/折扣),zk0折扣(只有get方法),ss0手数
    //public String i0, sl0, dj0, je0, yj0;
    /* 尺码表头开单 2015-05-15新增属性 1,0,2,0,0,0,0,0,0 */
    public String sizenum;
    /* 尺码组id main.salessizehead=1时 */
    public String sizegid;
    /* 尺码组id main.salessizehead=0时 */
    public String sizepid;
    /**
     * 颜色数量map
     */
    //private LinkedHashMap<String, Double> colorNumMap;
    ///**
    // * 2019-09-23 颜色尺码数量map
    // */
    //private LinkedHashMap<String, Double> colorSizeNumMap;
    ///**
    // * 颜色手数map
    // */
    //private LinkedHashMap<String, Double> colorGroupnumMap;
    //
    ///**
    // * 尺码手数map
    // */
    //private LinkedHashMap<String, Double> sizeGroupnumMap;
    /**
     * stdpricetype对应价格，from ipad,模板里用于原价
     */
    public String stdprice;
    /**
     * 优惠前价格
     */
    public String pricediff;
    /**
     * 尺码表头开单时单行明细小计
     */
    public String totalsmall;
    /**
     * 特价款
     */
    public String specpricestyle;
    /**
     * 仓位
     */
    public String location;
    /**
     * 计量单位
     */
    public String unit;
    /**
     * 按款号小计数量
     */
    public String codeSubTotalNum;
    /**
     * 按款号小计金额
     */
    public String codeSubTotalSum;
    /**
     * 2016-12-29 折前价
     */
    public String pricebeforediscount;
    /**
     * 2016-12-29 折后价
     */
    public String priceafterdiscount;
    /**
     * 2017-10-21厂商款号
     */
    public String orgcode;

    /**
     * 2018-01-24 扩展
     */
    public String extend;
    /**
     * 扩展转换json对象
     */
    //public JSONObject more = new JSONObject();
    /**
     * 吊牌价 2018-06-28
     */
    public String tagprice;

    /**能力位：1标识赠品, 原来为int，传的xml里有空的，改为string*/
    public String capability;

    /**
     * 类别
     */
    private String dressclass;

    public InvDet() {
    }

    //public InvDet(String code, String name, String color, String size, Double price, String num, Integer idx) {
    //    this.code = code;
    //    this.name = name;
    //    this.color = color;
    //    this.size = size;
    //    this.price = price;
    //    this.num = num;
    //}

    public String getDressclass() {
        return dressclass;
    }

    public void setDressclass(String dressclass) {
        this.dressclass = dressclass;
    }

    public Integer getIdx() {
        return idx;
    }

    public void setIdx(Integer idx) {
        this.idx = idx;
    }

    public Integer getI() {
        return i;
    }

    public void setI(Integer i) {
        this.i = i;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    //public String getCm() {
    //    return cm;
    //}
    //
    //public void setCm(String cm) {
    //    this.cm = cm;
    //}

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getRem() {
        return rem;
    }

    public void setRem(String rem) {
        this.rem = rem;
    }

    public String getRemOrig() {
        return remOrig;
    }

    public void setRemOrig(String remOrig) {
        this.remOrig = remOrig;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStdprice1() {
        return stdprice1;
    }

    public void setStdprice1(String stdprice1) {
        this.stdprice1 = stdprice1;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getStdpricetype() {
        return stdpricetype;
    }

    public void setStdpricetype(String stdpricetype) {
        this.stdpricetype = stdpricetype;
    }

    public String getGroupnum() {
        return groupnum;
    }

    public void setGroupnum(String groupnum) {
        this.groupnum = groupnum;
    }

    public String getSecondsale() {
        return secondsale;
    }

    public void setSecondsale(String secondsale) {
        this.secondsale = secondsale;
    }

    public String getKey_code_name_color() {
        return key_code_name_color;
    }

    public void setKey_code_name_color(String key_code_name_color) {
        this.key_code_name_color = key_code_name_color;
    }

    public String getCodeNameColor() {
        return codeNameColor;
    }

    public void setCodeNameColor(String codeNameColor) {
        this.codeNameColor = codeNameColor;
    }

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

    public String getTotal1() {
        return total1;
    }

    public void setTotal1(String total1) {
        this.total1 = total1;
    }

    public String getSizenum() {
        return sizenum;
    }

    public void setSizenum(String sizenum) {
        this.sizenum = sizenum;
    }

    public String getSizegid() {
        return sizegid;
    }

    public void setSizegid(String sizegid) {
        this.sizegid = sizegid;
    }

    public String getSizepid() {
        return sizepid;
    }

    public void setSizepid(String sizepid) {
        this.sizepid = sizepid;
    }

    //public LinkedHashMap<String, Double> getColorNumMap() {
    //    return colorNumMap;
    //}
    //
    //public void setColorNumMap(LinkedHashMap<String, Double> colorNumMap) {
    //    this.colorNumMap = colorNumMap;
    //}
    //
    //public LinkedHashMap<String, Double> getColorSizeNumMap() {
    //    return colorSizeNumMap;
    //}
    //
    //public void setColorSizeNumMap(LinkedHashMap<String, Double> colorSizeNumMap) {
    //    this.colorSizeNumMap = colorSizeNumMap;
    //}
    //
    //public LinkedHashMap<String, Double> getColorGroupnumMap() {
    //    return colorGroupnumMap;
    //}
    //
    //public void setColorGroupnumMap(LinkedHashMap<String, Double> colorGroupnumMap) {
    //    this.colorGroupnumMap = colorGroupnumMap;
    //}
    //
    //
    //
    //public LinkedHashMap<String, Double> getSizeGroupnumMap() {
    //    return sizeGroupnumMap;
    //}
    //
    //public void setSizeGroupnumMap(LinkedHashMap<String, Double> sizeGroupnumMap) {
    //    this.sizeGroupnumMap = sizeGroupnumMap;
    //}

    public String getStdprice() {
        return stdprice;
    }

    public void setStdprice(String stdprice) {
        this.stdprice = stdprice;
    }

    public String getPricediff() {
        return pricediff;
    }

    public void setPricediff(String pricediff) {
        this.pricediff = pricediff;
    }

    public String getTotalsmall() {
        return totalsmall;
    }

    public void setTotalsmall(String totalsmall) {
        this.totalsmall = totalsmall;
    }

    public String getSpecpricestyle() {
        return specpricestyle;
    }

    public void setSpecpricestyle(String specpricestyle) {
        this.specpricestyle = specpricestyle;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getCodeSubTotalNum() {
        return codeSubTotalNum;
    }

    public void setCodeSubTotalNum(String codeSubTotalNum) {
        this.codeSubTotalNum = codeSubTotalNum;
    }

    public String getCodeSubTotalSum() {
        return codeSubTotalSum;
    }

    public void setCodeSubTotalSum(String codeSubTotalSum) {
        this.codeSubTotalSum = codeSubTotalSum;
    }

    public String getPricebeforediscount() {
        return pricebeforediscount;
    }

    public void setPricebeforediscount(String pricebeforediscount) {
        this.pricebeforediscount = pricebeforediscount;
    }

    public String getPriceafterdiscount() {
        return priceafterdiscount;
    }

    public void setPriceafterdiscount(String priceafterdiscount) {
        this.priceafterdiscount = priceafterdiscount;
    }

    public String getOrgcode() {
        return orgcode;
    }

    public void setOrgcode(String orgcode) {
        this.orgcode = orgcode;
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend;
    }

    public String getTagprice() {
        return tagprice;
    }

    public void setTagprice(String tagprice) {
        this.tagprice = tagprice;
    }

    public String getCapability() {
        return capability;
    }

    public void setCapability(String capability) {
        this.capability = capability;
    }

	@Override
	public String toString() {
		return "InvDet [idx=" + idx + ", i=" + i + ", code=" + code + ", name=" + name + ", color=" + color + ", cm="
				+ cm + ", size=" + size + ", rem=" + rem + ", remOrig=" + remOrig + ", brand=" + brand + ", barcode="
				+ barcode + ", num=" + num + ", price=" + price + ", stdprice1=" + stdprice1 + ", total=" + total
				+ ", discount=" + discount + ", flag=" + flag + ", stdpricetype=" + stdpricetype + ", groupnum="
				+ groupnum + ", secondsale=" + secondsale + ", key_code_name_color=" + key_code_name_color
				+ ", codeNameColor=" + codeNameColor + ", total1=" + total1 + ", sizenum=" + sizenum + ", sizegid="
				+ sizegid + ", sizepid=" + sizepid + ", stdprice=" + stdprice + ", pricediff=" + pricediff
				+ ", totalsmall=" + totalsmall + ", specpricestyle=" + specpricestyle + ", location=" + location
				+ ", unit=" + unit + ", codeSubTotalNum=" + codeSubTotalNum + ", codeSubTotalSum=" + codeSubTotalSum
				+ ", pricebeforediscount=" + pricebeforediscount + ", priceafterdiscount=" + priceafterdiscount
				+ ", orgcode=" + orgcode + ", extend=" + extend + ", tagprice=" + tagprice + ", capability="
				+ capability + "]";
	}

}
