package com.xinma.base.wechat.model;

import com.fasterxml.jackson.annotation.JsonView;

/**
 * 微信公众号设置DTO定义
 * 
 * @author zhangyongyi
 *
 */
public class WechatSettingsDTO {

	// 微信公众账号配置Id(主键，自动生成)
	private Integer wxpaId;

	// 企业Id
	private Integer eseId;

	// 微信公众账号appId
	private String appId;

	// 微信公众账号appsecret
	private String appSecret;

	// 微信公众账号基本配置的Token(令牌)
	private String appToken;

	private String encodingAESKey;

	// 公众账号标识名称，一般用于标识企业
	private String appName;

	// 微信支付证书的内容
	private String certificateContent;

	// 微信证书密码
	private String certificatePassword;

	// 微信支付密码
	private String payPassword;

	// 微信商户号
	private String merchantId;

	// 微信公众号服务器配置
	private String url;

	// 微信公众号处理类名
	private String className;
	
	private String accessToken;

	private String jsTicket;

	public Integer getWxpaId() {
		return wxpaId;
	}

	public void setWxpaId(Integer wxpaId) {
		this.wxpaId = wxpaId;
	}

	public Integer getEseId() {
		return eseId;
	}

	public void setEseId(Integer eseId) {
		this.eseId = eseId;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	public String getAppToken() {
		return appToken;
	}

	public void setAppToken(String appToken) {
		this.appToken = appToken;
	}

	public String getEncodingAESKey() {
		return encodingAESKey;
	}

	public void setEncodingAESKey(String encodingAESKey) {
		this.encodingAESKey = encodingAESKey;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getCertificateContent() {
		return certificateContent;
	}

	public void setCertificateContent(String certificateContent) {
		this.certificateContent = certificateContent;
	}

	public String getCertificatePassword() {
		return certificatePassword;
	}

	public void setCertificatePassword(String certificatePassword) {
		this.certificatePassword = certificatePassword;
	}

	public String getPayPassword() {
		return payPassword;
	}

	public void setPayPassword(String payPassword) {
		this.payPassword = payPassword;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getJsTicket() {
		return jsTicket;
	}

	public void setJsTicket(String jsTicket) {
		this.jsTicket = jsTicket;
	}
}
