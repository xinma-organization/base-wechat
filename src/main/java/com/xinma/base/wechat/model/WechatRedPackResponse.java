/**    
 * <p>Copyright (c) Shanghai TY Technology Co., Ltd. All Rights Reserved.</p>
 *
 * @FileName: 	WechatRedPackResponse.java    
 * @Description:WechatRedPackResponse  
 * @author: 	Hoctor
 * @Creat: 		2015年12月16日  
 *
 * Modification History:
 * Data			Author		Version		   Description
 * -------------------------------------------------------------
 * 2015年12月16日		Hoctor		
 */
package com.xinma.base.wechat.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.xinma.base.wechat.util.xstream.XStreamCDATA;

/**
 * WechatRedPackResponse 调用红包发送接口返回参数信息实体类
 */

@XStreamAlias("xml")
public class WechatRedPackResponse {

	@XStreamCDATA
	private String return_code; // 返回状态码,此字段是通信标识，非交易标识，交易是否成功需要查看result_code来判断，
								// 成功为SUCCESS，失败为FAIL

	@XStreamCDATA
	private String return_msg; // 返回信息

	/****** 以下字段在return_code为SUCCESS的时候有返回 *************/

	@XStreamCDATA
	private String sign;

	@XStreamCDATA
	private String result_code; // 业务结果, SUCCESS/FAIL

	@XStreamCDATA
	private String err_code; // 错误代码

	@XStreamCDATA
	private String err_code_des; // 错误代码描述

	/******** 以下字段在return_code和result_code都为SUCCESS的时候有返回 *****************/

	@XStreamCDATA
	private String mch_billno; // 商户订单号

	@XStreamCDATA
	private String mch_id; // 商户号

	@XStreamCDATA
	private String wxappid; // 公众账号appid

	@XStreamCDATA
	private String re_openid; // 接受收红包的用户在wxappid下的openid

	@XStreamCDATA
	private Integer total_amount; // 付款金额，单位分

	@XStreamCDATA
	private Long send_time; // 红包发送时间

	@XStreamCDATA
	private String send_listid; // 红包订单的微信单号

	public String getReturn_code() {
		return return_code;
	}

	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}

	public String getReturn_msg() {
		return return_msg;
	}

	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getResult_code() {
		return result_code;
	}

	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}

	public String getErr_code() {
		return err_code;
	}

	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}

	public String getErr_code_des() {
		return err_code_des;
	}

	public void setErr_code_des(String err_code_des) {
		this.err_code_des = err_code_des;
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

	public String getRe_openid() {
		return re_openid;
	}

	public void setRe_openid(String re_openid) {
		this.re_openid = re_openid;
	}

	public Integer getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(Integer total_amount) {
		this.total_amount = total_amount;
	}

	public Long getSend_time() {
		return send_time;
	}

	public void setSend_time(Long send_time) {
		this.send_time = send_time;
	}

	public String getSend_listid() {
		return send_listid;
	}

	public void setSend_listid(String send_listid) {
		this.send_listid = send_listid;
	}

	/**
	 * 判断微信红包是否发送成功
	 * 
	 * @return
	 */
	@JsonIgnore
	public boolean isSuccess() {
		boolean isSuccess = getReturn_code().equals("SUCCESS") && getResult_code().equals("SUCCESS");
		if (!isSuccess) {
			isSuccess = getErr_code().equals("SYSTEMERROR");
		}

		return isSuccess;
	}
}
