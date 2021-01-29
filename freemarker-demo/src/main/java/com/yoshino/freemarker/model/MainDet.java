package com.yoshino.freemarker.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * 明细数据类
 * @author WKY
 *
 */
@Data
public class MainDet implements Serializable {

	/**  
	 * serialVersionUID:TODO 
	 */
	private static final long serialVersionUID = -1458456870486040408L;
	
	/** 赠品 */
	public static final String CAPABILITY_GIFT = "1";
	/** 特价 */
	public static final String CAPABILITY_SPECIAL = "2";

	/** 明细id **/
	private Long detId;
	
	/** 款号id  **/
	private Long tenantSpuId;
	
	/** 款号  **/
	private String code;
	
	/** 厂商款号  **/
	private String orgcode;
	
	/** 名称  **/
	private String name;
	
	/** 颜色  **/
	private String color;
	
	/** 尺码  **/
	private String size;
	
	/** 数量  **/
	private BigDecimal num = BigDecimal.ZERO;
	
	/** 已发数量  **/
	private BigDecimal deliverNum = BigDecimal.ZERO;
	
	/** 未发数量  **/
	private BigDecimal diffDeliverNum = BigDecimal.ZERO;
	
	/** 折扣  **/
	private BigDecimal discount  = BigDecimal.ONE;
	
	/** 价格  **/
	private BigDecimal price = BigDecimal.ZERO;

	/** 进货价 **/
	private BigDecimal purPrice = BigDecimal.ZERO;
	
	/** 原价  **/
	private BigDecimal stdprice = BigDecimal.ZERO;
	
	/** 零批价  **/
	private BigDecimal stdprice1 = BigDecimal.ZERO;
	
	/** 价格2  **/
	private BigDecimal stdprice2 = BigDecimal.ZERO;
	
	/** 价格3  **/
	private BigDecimal stdprice3 = BigDecimal.ZERO;
	
	/** 价格4  **/
	private BigDecimal stdprice4 = BigDecimal.ZERO;
	
	/** 价格5  **/
	private BigDecimal stdprice5 = BigDecimal.ZERO;
	
	/** 明细款号的类型 **/
	private Integer flag;
	
	/** 补货补字 **/
	private Integer repFlag;
	
	/** 特价商品  **/
	private Integer specPriceStyle;
	
	/** 小计  **/
	private BigDecimal totalSmall = BigDecimal.ZERO;
	
	/** 吊牌价  **/
	private BigDecimal tagPrice = BigDecimal.ZERO;
	
	/** 折后价  **/
	private BigDecimal realPrice = BigDecimal.ZERO;
	
	/** 按尺码表头所处行号  **/
	private Integer rowId = 0;
	
	/** 是否按组，童装尺码表头格式用  **/
	private Integer groupFlag;
	
	/** 组数  **/
	private BigDecimal groupNum = BigDecimal.ZERO;
	
	/** 尺码所在的尺码组id  **/
	private Integer sizeGroupId;
	
	/** 图片链接  **/
	private String imgUrl;
	
	/** 图片链接 大图  **/
	private String imgUrlBig;
	
	/** 单位  **/
	private String unit;
	
	/**
	 * 仅用于尺码表头
	 * 用于保存明细明细这一行尺码 sid-数量  
	 */
	private Map<Integer, BigDecimal> sizeNumMap = new LinkedHashMap<Integer, BigDecimal>();
	
	/** 尺码id  **/
	private Integer sizeId;
	
	/** 颜色id  **/
	private Integer colorId;
	
	/** 明细备注  **/
	private String remark;
	
	/** 货品条码  **/
	private String barCode;
	
	/** 品牌  **/
	private String brand;
	
	/** 合并的时候尺码组  **/
	private Set<String> sizes;
	
	/** 合并的时候颜色组  **/
	private Set<String> colors;
	
	/** 合并的时候颜色尺码数量组  颜色-尺码+: 数量 **/
	private Map<String, String> nums;
	
	/** 仓位  **/
	private String position;
	
	/** 面料版扣送 **/
	private BigDecimal fabricGift = BigDecimal.ZERO;
	
	/** 视频封面图片 **/
	private String coverUrl;
	
	/** 视频地址 **/
	private String videoUrl;
	
	/** 赠品=1 特价=2  **/
	private String capability = "0";
	
	/** 活动id  **/
	private String actId;
	
	/** 活动名称 **/
	private String actIdName;
	
	/** 所有图片链接 大图  **/
	private String allImgUrlBig;

	/** 商品类别 */
	private String className;

	/**
	 * 季节
	 */
	private String seasonName;

	/**
	 * 风格
	 */
	private String themeName;

	/**
	 * 面料
	 */
	private String fabricName;

	/**
	 * 客户
	 */
	private Long compId;

	/**
	 * 客户名称
	 */
	private String compName;
}
