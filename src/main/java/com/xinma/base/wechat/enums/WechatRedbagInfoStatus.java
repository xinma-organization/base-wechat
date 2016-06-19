package com.xinma.base.wechat.enums;

/**
 * 微信红包发放信息状态定义
 * 
 * @author zhangyongyi
 *
 */
public enum WechatRedbagInfoStatus {
	/**
	 * 0:发放请求失败
	 */
	SendFail(0),

	/**
	 * 1:发放请求成功
	 */
	SendSuccess(1),

	/**
	 * 2:红包发放成功(已验证)
	 */
	SentSuccess(2),

	/**
	 * 3:红包发放失败(已验证)
	 */
	SentFail(3),

	/**
	 * 4:红包验证失败
	 */
	ValidFail(4);

	int status;

	WechatRedbagInfoStatus(int status) {
		this.status = status;
	}

	public int getValue() {
		return status;
	}
}
