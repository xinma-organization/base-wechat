package com.xinma.base.wechat.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 微信红包重发信息DTO定义
 * 
 * @author zhangyongyi
 */

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WechatRedBagResendDTO implements Serializable {

	private static final long serialVersionUID = -1367504038188282881L;

	private Integer eseId;

	private Integer productId;

	private Integer promotionId;

	private Integer wxpaId;

	private String mchBillno;

	private String mchId;

	private String reOpenId;

	private Integer totalAmount;

	private Integer totalNum;

	private String clientIp;

	public Integer getEseId() {
		return eseId;
	}

	public void setEseId(Integer eseId) {
		this.eseId = eseId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getPromotionId() {
		return promotionId;
	}

	public void setPromotionId(Integer promotionId) {
		this.promotionId = promotionId;
	}

	public Integer getWxpaId() {
		return wxpaId;
	}

	public void setWxpaId(Integer wxpaId) {
		this.wxpaId = wxpaId;
	}

	public String getMchBillno() {
		return mchBillno;
	}

	public void setMchBillno(String mchBillno) {
		this.mchBillno = mchBillno;
	}

	public String getMchId() {
		return mchId;
	}

	public void setMchId(String mchId) {
		this.mchId = mchId;
	}

	public String getReOpenId() {
		return reOpenId;
	}

	public void setReOpenId(String reOpenId) {
		this.reOpenId = reOpenId;
	}

	public Integer getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Integer getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}

	public String getClientIp() {
		return clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

}
