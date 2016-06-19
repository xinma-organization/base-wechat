package com.xinma.base.wechat.model;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.xinma.base.wechat.util.xstream.XStreamCDATA;

/**
 * 用于商户对已发放的红包进行查询红包的具体信息响应体，可支持普通红包和裂变包
 * 
 * @author Hoctor
 *
 */
@XStreamAlias("xml")
public class WechatRedPackInfoResponse {

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
	private String appid; // 公众账号appid

	@XStreamCDATA
	private String openid;

	@XStreamCDATA
	private String mch_billno; // 商户订单号

	@XStreamCDATA
	private String mch_id; // 商户号

	/**
	 * 红包单号
	 */
	@XStreamCDATA
	private String detail_id; // 使用API发放现金红包时返回的红包单号

	/**
	 * 红包状态
	 */
	@XStreamCDATA
	private String status; // SENDING:发放中 ; SENT:已发放待领取 ; FAILED：发放失败 ;
							// RECEIVED:已领取; REFUND:已退款

	/**
	 * 发放类型
	 */
	@XStreamCDATA
	private String send_type; // API:通过API接口发放; UPLOAD:通过上传文件方式发放 ;
								// ACTIVITY:通过活动方式发放

	/**
	 * 红包类型
	 */
	@XStreamCDATA
	private String hb_type; // GROUP:裂变红包 ; NORMAL:普通红包

	/**
	 * 红包个数
	 */
	@XStreamCDATA
	private Integer total_num;

	/**
	 * 红包金额
	 */
	@XStreamCDATA
	private Integer total_amount; // 付款金额，单位分

	/**
	 * 失败原因
	 */
	@XStreamCDATA
	private String reason; // 发送失败原因

	@XStreamCDATA
	private String send_time; // 红包发送时间

	/**
	 * 红包退款时间
	 */
	@XStreamCDATA
	private String refund_time; // 红包的退款时间（如果其未领取的退款）

	/**
	 * 红包退款金额
	 */
	@XStreamCDATA
	private Integer refund_amount;

	@XStreamCDATA
	private String wishing;// 红包祝福语

	@XStreamCDATA
	private String act_name;// 活动名称

	@XStreamCDATA
	private String remark;// 备注信息

	@XStreamCDATA
	private String rcv_time;// 红包接收时间

	/**
	 * 裂变红包领取列表
	 */
	@XStreamAlias("hblist")
	private List<WechatRedPackInfo> redPackInfoList = new ArrayList<WechatRedPackInfo>();

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

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
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

	public String getDetail_id() {
		return detail_id;
	}

	public void setDetail_id(String detail_id) {
		this.detail_id = detail_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSend_type() {
		return send_type;
	}

	public void setSend_type(String send_type) {
		this.send_type = send_type;
	}

	public String getHb_type() {
		return hb_type;
	}

	public void setHb_type(String hb_type) {
		this.hb_type = hb_type;
	}

	public Integer getTotal_num() {
		return total_num;
	}

	public void setTotal_num(Integer total_num) {
		this.total_num = total_num;
	}

	public Integer getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(Integer total_amount) {
		this.total_amount = total_amount;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getSend_time() {
		return send_time;
	}

	public void setSend_time(String send_time) {
		this.send_time = send_time;
	}

	public String getRefund_time() {
		return refund_time;
	}

	public void setRefund_time(String refund_time) {
		this.refund_time = refund_time;
	}

	public Integer getRefund_amount() {
		return refund_amount;
	}

	public void setRefund_amount(Integer refund_amount) {
		this.refund_amount = refund_amount;
	}

	public String getWishing() {
		return wishing;
	}

	public void setWishing(String wishing) {
		this.wishing = wishing;
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

	public List<WechatRedPackInfo> getRedPackInfoList() {
		return redPackInfoList;
	}

	public void setRedPackInfoList(List<WechatRedPackInfo> redPackInfoList) {
		this.redPackInfoList = redPackInfoList;
	}

	public String getRcv_time() {
		return rcv_time;
	}

	public void setRcv_time(String rcv_time) {
		this.rcv_time = rcv_time;
	}

}
