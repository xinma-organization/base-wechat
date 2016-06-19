package com.xinma.base.wechat.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 微信红包设置DTO
 * 
 * @author zhangyongyi
 *
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WechatRedEnvelopeConfigDTO {

	private Integer oid;

	private String nickName;// 提供方名称

	private String sendName;// 红包发送者名称(商户名称)

	private String wishing;// 红包祝福语

	private String actName;// 活动名称

	private String remark;// 备注信息

	private int totalNum;// 裂变红包总人数

	private int wxpaId;// 微信公众账号配置Id

	private int pdId;// 产品Id

	private Integer promotionId; // 活动Id

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getSendName() {
		return sendName;
	}

	public void setSendName(String sendName) {
		this.sendName = sendName;
	}

	public String getWishing() {
		return wishing;
	}

	public void setWishing(String wishing) {
		this.wishing = wishing;
	}

	public String getActName() {
		return actName;
	}

	public void setActName(String actName) {
		this.actName = actName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}

	public int getWxpaId() {
		return wxpaId;
	}

	public void setWxpaId(int wxpaId) {
		this.wxpaId = wxpaId;
	}

	public int getPdId() {
		return pdId;
	}

	public void setPdId(int pdId) {
		this.pdId = pdId;
	}

	public Integer getPromotionId() {
		return promotionId;
	}

	public void setPromotionId(Integer promotionId) {
		this.promotionId = promotionId;
	}

}
