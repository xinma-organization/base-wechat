package com.xinma.base.wechat.model;

/**
 * 检验微信授权凭证（access_token）是否有效
 * 
 * @author Hoctor
 *
 */
public class CheckAccessTokenResult {
	private int errcode;

	private String errmsg;

	public int getErrcode() {
		return errcode;
	}

	public void setErrcode(int errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public boolean isValid() {
		if (errcode == 0) {
			return true;
		} else {
			return false;
		}
	}
}
