package com.xinma.base.wechat.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WechatRedEnvelopeLogDTO implements Serializable {

	private static final long serialVersionUID = -2324499823423168760L;

	/**
	 * 企业Id
	 */
	private Integer eseId;

	/**
	 * 产品Id
	 */
	private Integer productId;

	/**
	 * 活动Id
	 */
	private Integer promotionId;

	/**
	 * 微信公众账号配置Id
	 */
	private Integer wxpaId;

	/**
	 * 被替换重发红包单号
	 */
	private String old_mch_billno;

	/**
	 * 发红包请求的时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date sendTime;

	/**
	 * 调用发送微信红包请求体
	 */
	private WechatRedPackRequst redPackRequst;

	/**
	 * 调用发送微信响应信息
	 */
	private WechatRedPackResponse redPackResponse;

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

	public String getOld_mch_billno() {
		return old_mch_billno;
	}

	public void setOld_mch_billno(String old_mch_billno) {
		this.old_mch_billno = old_mch_billno;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public WechatRedPackRequst getRedPackRequst() {
		return redPackRequst;
	}

	public void setRedPackRequst(WechatRedPackRequst redPackRequst) {
		this.redPackRequst = redPackRequst;
	}

	public WechatRedPackResponse getRedPackResponse() {
		return redPackResponse;
	}

	public void setRedPackResponse(WechatRedPackResponse redPackResponse) {
		this.redPackResponse = redPackResponse;
	}
}
