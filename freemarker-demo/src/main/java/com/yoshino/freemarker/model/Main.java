package com.yoshino.freemarker.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 主表数据类
 * @author WKY
 *
 */
@Data
public class Main implements Serializable {

	/**
	 * serialVersionUID:TODO
	 */
	private static final long serialVersionUID = 5603560435393089408L;

	/** 单据id **/
	private String mainId;

	/** 产品类型 **/
	private Integer productType;

	/** 单据来源 **/
	private String dlProductType;

	/** 设备类型 **/
	private String deviceType;

	/** mac**/
	private String mac;

	/** 序列号 **/
	private String sn;

	/** 二代服务标记 **/
	private String serverCode;

	/** 语言 **/
	private String language;

	/**打印机类型*/
	private Integer printType;

	/**打印标志*/
	private Integer printFlag;

	/**打印时间*/
	private Date printTime;

	/**打印次数*/
	private Integer printCount = 1;

	/**打印头部*/
	private String printHead;

	/**打印尾部*/
	private String printFooter;

	/**门店地址*/
	private String shopAddr;

	/**门店地址2*/
	private String shopAddr2;

	/**门店电话*/
	private String shopPhone;

	/**门店手机*/
	private String shopMobile;

	/** 版本号 **/
	private String version;

	/** 打印客户还是仓库用 **/
	private String printToInv;

	/**服务url*/
	private String serverUrl;

	/** 单元id**/
	private Long unitId;

	/**数据Hash值*/
	private String hashKey;

	/**访问编码*/
	private String accode;

	/** 单据类型 **/
	private Integer type;

	/** 单据类型名称  **/
	private String typeName;

	/**批次号*/
	private String billNo;

	/**发生日期*/
	private Date proDate;

	/**客户*/
	private Long compId;

	/**经办人*/
	private Long ownerId;

	/**门店*/
	private Long shopId;

	/**仓库*/
	private Long invId;

	/**相关仓库*/
	private Long invIdRef;

	/**订单ID*/
	private Long orderID;

	/**绑定仓库*/
	private Long bindInvIdRef;

	/**客户名称*/
	private String compName;

	/**客户地址*/
	private String compAddr;

	/**客户手机号*/
	private String compPhone;

	/**客户积分*/
	private String compScore;

	/**客户编号*/
	private String compVipCode;

	/**收货人名称*/
	private String receiverName;

	/**收货人联系方式*/
	private String receiverPhone;

	/**收货人地址*/
	private String receiverAddr;

	/**经办人名称*/
	private String ownerName;

	/**经办人工号*/
	private String ownerCode;

	/**经办人2名称*/
	private String ownerName2;

	/**经办人2工号*/
	private String ownerCode2;

	/**门店名称*/
	private String shopName;

	/**仓库名称*/
	private String invName;

	/**目的地名称*/
	private String invRefName;

	/**总数量*/
	private BigDecimal totalNum = BigDecimal.ZERO; //outnum = totalnum+backnum

	/**总金额*/
	private BigDecimal totalMoney = BigDecimal.ZERO; //outsum = totalsum+backsum-othercost+favor

	/**退货数量*/
	private BigDecimal backNum = BigDecimal.ZERO;

	/**退货金额*/
	private BigDecimal backMoney = BigDecimal.ZERO;

	/**其他特殊货品合计*/
	private BigDecimal otherCost = BigDecimal.ZERO;

	/**抹零金额*/
	private BigDecimal favorMoney = BigDecimal.ZERO;

	/** 积分抵扣 */
	private BigDecimal scoreDeduction = BigDecimal.ZERO;

	/**找零*/
	private BigDecimal cashChange = BigDecimal.ZERO;

	/**整单折扣*/
	private BigDecimal mainDiscount = BigDecimal.ONE;

	/**结余*/
	private BigDecimal balance = BigDecimal.ZERO;

	/**结余类型*/
	private Integer balanceType;

	/**核销金额*/
	private BigDecimal verifySum = BigDecimal.ZERO;

	/**现金*/
	private BigDecimal cash = BigDecimal.ZERO;

	/**刷卡*/
	private BigDecimal card = BigDecimal.ZERO;

	/**代收*/
	private BigDecimal agency = BigDecimal.ZERO;

	/**汇款*/
	private BigDecimal remit = BigDecimal.ZERO;

	/**微信支付*/
	private BigDecimal weiXinPay = BigDecimal.ZERO;

	/**支付宝支付*/
	private BigDecimal aliPay = BigDecimal.ZERO;

	/**扫码支付*/
	private BigDecimal mobilePay = BigDecimal.ZERO;

	/**未付*/
	private BigDecimal debt = BigDecimal.ZERO;

	/**其他支付 平台*/
	private BigDecimal deposit = BigDecimal.ZERO;

	/**支付方式*/
	private Integer payWay;

	/**累计余额*/
	private BigDecimal lastBalance = BigDecimal.ZERO;

	/** 上次欠 */
	private BigDecimal preLastBalance;

	/**储值支付*/
	private BigDecimal storedValueCost = BigDecimal.ZERO;

	/**储值余额*/
	private BigDecimal storedValueBalance = BigDecimal.ZERO;

	/**支付总额*/
	private BigDecimal paySum = BigDecimal.ZERO;

	/**赠送金额*/
	private BigDecimal giveSum = BigDecimal.ZERO;

	/**累计到单据余额*/
	private BigDecimal lastBillBalance = BigDecimal.ZERO;

	/**操作人*/
	private Long opId;

	/**操作时间*/
	private Date opTime;

	/**备注*/
	private String rem;

	/**照片id*/
	private String fileId;

	/**状态*/
	private Integer flag;

	/**乐观锁*/
	private Integer ver;

	/**支付单ID*/
	private Long finIoId;

	/**核销单据*/
	private Long verifyBillId;

	/**核销时间*/
	private Date verifyDate;

	/**配货标记*/
	private Integer invdisFlag;

	/**是否有效标记*/
	private Integer invalidFlag;

	/** 物流id */
	private Long logisId;

	/** 物流商名称 用于打印物流联 */
	private String logisNameNew;

	/** 物流单号 */
	private String logisNo;

	/** 物流商名称 */
	private String logisName;

	/** 物流提示语 */
	private String logisDesc;

	/**物流联系人*/
	private String logisContact;

	/**客户分店*/
	private Long childCompId;

	/**配货员id*/
	private Long invdisOpId;

	/**价格类型*/
	private Integer priceType;

	/**更新时间*/
	private Date updatedDate;

	/**更新人*/
	private Long updatedBy;

	/**作废时间*/
	private Date delDate;

	/**作废人*/
	private Long delBy;

	/**创建人*/
	protected Long createdBy;

	/**创建时间*/
	protected Date createdDate;

	/** 账户名 **/
	private String accountName;

	/** 账户号 **/
	private String accountNo;

	/** 账户名2 **/
	private String accountName2;

	/** 账户号2 **/
	private String accountNo2;

	/** 账户名3 **/
	private String accountName3;

	/** 账户号3 **/
	private String accountNo3;

	/** 账户名4 **/
	private String accountName4;

	/** 账户号4 **/
	private String accountNo4;

	/** 账户名5 **/
	private String accountName5;

	/** 账户号5 **/
	private String accountNo5;

	/** 账户名6 **/
	private String accountName6;

	/** 账户号6 **/
	private String accountNo6;

	/** 图片 **/
	private String fileUrl;

	/** 操作人名称 **/
	private String opName;

	/** 刷卡名称 **/
	private String cardName;

	/** 汇款名称 **/
	private String remitName;

	/** 订单发货状态值 **/
	private String deliverStatus;

	/** 订单发货状态 **/
	private String deliverStatusName;

	/** 总打印次数 **/
	private Integer printTotalCount;

	/** 二维码1描述 **/
	private String ticketTopic1;

	/** 二维码1内容 **/
	private String ticketContent1;

	/** 二维码1图片url **/
	private String ticketQrcode1;

	/** 二维码2描述 **/
	private String ticketTopic2;

	/** 二维码2内容 **/
	private String ticketContent2;

	/** 二维码2图片url **/
	private String ticketQrcode2;

	/** 二维码3描述 **/
	private String ticketTopic3;

	/** 二维码3内容 **/
	private String ticketContent3;

	/** 二维码3图片url **/
	private String ticketQrcode3;

	/**  订货批次 **/
	private String orderNo;

	/**  订货日期  **/
	private Date orderProdate;

	/**  本小票二维码备注  **/
	private String qrComment;

	/**  小票底部提醒文字  **/
	private String bottomTips;

	/**  调出批次 **/
	private String outBillNo;

	/**  是否启用ssl **/
	private String https;

	/** 是否显示价格名称 **/
	private Boolean showPrice = true;

	/** 是否客户折扣 **/
	private Boolean isCCRCDModel = false;

	/** 是否产品折扣 **/
	private Boolean isCCRPDModel = false;

	/** 是否整单折扣 **/
	private Boolean isCCRWDModel = false;

	/** 是否童装模式 **/
	private Boolean isKidCloth = false;

	/** 客户电子签名链接**/
	private String compSignUrl;

	/** 门店logo链接**/
	private String shopLogoUrl;

	/** 价格类型名称**/
	private String priceTypeName;

	/** 销售单据标签名称**/
	private String labelName;

	/** 打印店铺二维码**/
	private Integer printShopQr;

	/** 打印小票二维码**/
	private Integer printTicketQr;

	/** 是否打印连连看二维码 */
	private Integer printLinkQr;

	/**宽*/
	private Integer width;

	/**高*/
	private Integer high;

	/**左边距*/
	private Integer leftSize;

	/**按库存余量*/
	private Integer printCountByStockNum;

	/**显示字段*/
	private String showField;

	/**打印机类型*/
	private Integer printerTypeId;

	/**单据的作用类型*/
	private Integer srcType;

	/**实收/实付金额*/
	private BigDecimal realPayMoney = BigDecimal.ZERO;

	/** 连连看二维码 **/
	private String shopLinkQRCodeContent;

	/** 本小票二维码 **/
	private String billQRCodeContent;

	/** 打印模板json字符串 **/
	private String printFormat;

	/** SLH-23058 异地发货模式，发货门店字段 **/
	private String deliverInvName;

	/** 连连看门店连接 **/
	private String linkShopUrl;

	/** 商陆宝客户ID **/
	private String slbUserId;

	/** 商陆宝门店ID **/
	private String slbShopId;

	/** 打印配置 */
	private String printConfig;

	/**总已发数*/
	private BigDecimal totalSendNum = BigDecimal.ZERO;

	/**优惠总额*/
	private BigDecimal totaldiff = BigDecimal.ZERO;

	/**优惠券优惠金额*/
	private BigDecimal coupMoney = BigDecimal.ZERO;

	/**客户备注*/
	private String compRem;

	/**本单积分 */
	private BigDecimal billScore;

	/**是否活动单据 目前连锁用*/
	private Boolean isActBill = false;

	/** 物流商id */
	private long providerId;

	/** 活动优惠金额 **/
	private BigDecimal actMoney;

	/** 获取分享html用于电子签名 **/
	private Boolean forElectronicSignature = false;

	/** 单据发货状态 **/
	private Integer deliverFlag;

	/** 是否显示原价 **/
	private Boolean needShowOldPrice = false;
}
