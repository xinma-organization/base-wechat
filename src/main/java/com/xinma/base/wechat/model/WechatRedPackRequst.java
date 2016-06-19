/**    
 * <p>Copyright (c) Shanghai TY Technology Co., Ltd. All Rights Reserved.</p>
 *
 * @FileName: 	WechatRedPackRequst.java    
 * @Description:WechatRedPackRequst  
 * @author: 	Hoctor
 * @Creat: 		2015年12月15日  
 *
 * Modification History:
 * Data			Author		Version		   Description
 * -------------------------------------------------------------
 * 2015年12月15日		Hoctor		
 */
package com.xinma.base.wechat.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.xinma.base.wechat.util.xstream.XStreamCDATA;

/**
 * WechatRedPack 微信发送红包请求实体类
 */

@XStreamAlias("xml")
public class WechatRedPackRequst {

	@XStreamCDATA
	private String nonce_str; // 随机字符串

	@XStreamCDATA
	private String sign; // 签名

	@XStreamCDATA
	private String mch_billno;// 订单号

	@XStreamCDATA
	private String mch_id;// 商户号

	@XStreamCDATA
	private String wxappid;// 公众账号appid

	@XStreamCDATA
	private String send_name;// 红包发送者名称

	@XStreamCDATA
	private String re_openid;// 接受收红包的用户 用户在该appid下的openid

	@XStreamCDATA
	private int total_amount;// 付款金额

	@XStreamCDATA
	private int total_num;// 红包发放总人数

	@XStreamCDATA
	private String wishing;// 红包祝福语

	@XStreamCDATA
	private String client_ip;// 调用接口的机器Ip地址

	@XStreamCDATA
	private String act_name;// 活动名称

	@XStreamCDATA
	private String remark;// 备注信息

	// TODO 该属性必须给吗
	@XStreamCDATA
	private String nick_name;// 提供方名称

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

	public String getWxappid() {
		return wxappid;
	}

	public void setWxappid(String wxappid) {
		this.wxappid = wxappid;
	}

	public String getSend_name() {
		return send_name;
	}

	public void setSend_name(String send_name) {
		this.send_name = send_name;
	}

	public String getRe_openid() {
		return re_openid;
	}

	public void setRe_openid(String re_openid) {
		this.re_openid = re_openid;
	}

	public int getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(int total_amount) {
		this.total_amount = total_amount;
	}

	public int getTotal_num() {
		return total_num;
	}

	public void setTotal_num(int total_num) {
		this.total_num = total_num;
	}

	public String getWishing() {
		return wishing;
	}

	public void setWishing(String wishing) {
		this.wishing = wishing;
	}

	public String getClient_ip() {
		return client_ip;
	}

	public void setClient_ip(String client_ip) {
		this.client_ip = client_ip;
	}

	public String getAct_name() {
		return act_name;
	}

	public void setAct_name(String act_name) {
		this.act_name = act_name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getNick_name() {
		return nick_name;
	}

	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
}
