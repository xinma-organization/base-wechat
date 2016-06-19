package com.xinma.base.wechat.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.xinma.base.wechat.util.xstream.XStreamCDATA;

@XStreamAlias("hbinfo")
public class WechatRedPackInfo {

	@XStreamCDATA
	private String openid;

	@XStreamCDATA
	private String status;

	@XStreamCDATA
	private Integer amount;

	@XStreamCDATA
	private String rcv_time;

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getRcv_time() {
		return rcv_time;
	}

	public void setRcv_time(String rcv_time) {
		this.rcv_time = rcv_time;
	}

}
