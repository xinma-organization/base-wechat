package com.xinma.base.wechat.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.xinma.base.wechat.util.xstream.XStreamCDATA;

/**
 * 用于商户对已发放的红包进行查询红包的具体信息请求体，可支持普通红包和裂变包
 * 
 * @author Hoctor
 *
 */
@XStreamAlias("xml")
public class WechatRedPackInfoRequest {

	/**
	 * 随机字符串
	 */
	@XStreamCDATA
	private String nonce_str;

	/**
	 * 签名
	 */
	@XStreamCDATA
	private String sign;

	/**
	 * 订单号
	 */
	@XStreamCDATA
	private String mch_billno;

	/**
	 * 商户号
	 */
	@XStreamCDATA
	private String mch_id;

	/**
	 * 公众账号appid
	 */
	@XStreamCDATA
	private String appid;

	/**
	 * 订单类型
	 */
	private String bill_type = "MCHT"; // MCHT:通过商户订单号获取红包信息。

	public String getNonce_str() {
		return nonce_str;
	}

	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getMch_billno() {
		return mch_billno;
	}

	public void setMch_billno(String mch_billno) {
		this.mch_billno = mch_billno;
	}

	public String getMch_id() {
		return mch_id;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getBill_type() {
		return bill_type;
	}

	public void setBill_type(String bill_type) {
		this.bill_type = bill_type;
	}
}
