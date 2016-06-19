/**    
 * <p>Copyright (c) Shanghai TY Technology Co., Ltd. All Rights Reserved.</p>
 *
 * @FileName: 	WechatRedPackHelper.java    
 * @Description:WechatRedPackHelper  
 * @author: 	Hoctor
 * @Creat: 		2015年12月15日  
 *
 * Modification History:
 * Data			Author		Version		   Description
 * -------------------------------------------------------------
 * 2015年12月15日		Hoctor		
 */
package com.xinma.base.wechat.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.net.ssl.SSLContext;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.conn.ssl.DefaultHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;

import com.thoughtworks.xstream.XStream;
import com.xinma.base.util.HexUtil;
import com.xinma.base.wechat.model.WechatRedPackInfo;
import com.xinma.base.wechat.model.WechatRedPackInfoRequest;
import com.xinma.base.wechat.model.WechatRedPackInfoResponse;
import com.xinma.base.wechat.util.xstream.XStreamFactory;

/**
 * WechatRedPackHelper
 */
public class WechatRedPackUtils {
	private final static String getRedPackInfourl = "https://api.mch.weixin.qq.com/mmpaymkttransfers/gethbinfo";

	/**
	 * 获取发送现金红包的订单号
	 * 
	 * @param partnerId
	 *            参与人ID
	 * @return 红包订单号
	 */
	public static String getOrderNo(String partnerId) {
		return new StringBuilder(partnerId).append(new SimpleDateFormat("yyyyMMdd").format(new Date()))
				.append(RandomGenerator.randomNumericString(10)).toString();
	}

	/**
	 * 创建md5摘要,规则是:按参数名称a-z排序,遇到空值的参数不参加签
	 * 
	 * @param map
	 *            摘要的参数列表明文信息
	 * @param partnerkey
	 *            微信商户支付密码
	 * @return 摘要信息
	 */
	public static String signWithMD5(Map<String, Object> map, String partnerkey) throws Exception {

		SortedMap<String, Object> sortedMap = new TreeMap<String, Object>(map);
		sortedMap.remove("sign");
		StringBuilder sb = new StringBuilder();

		Set<Entry<String, Object>> set = sortedMap.entrySet();
		Iterator<Entry<String, Object>> it = set.iterator();
		while (it.hasNext()) {
			Entry<String, Object> entry = it.next();
			if (entry.getValue() == null || StringUtils.isBlank(entry.getValue().toString())) {
				continue;
			}

			String key = entry.getKey();
			String value = entry.getValue().toString();
			sb.append(key + "=" + value + "&");
		}

		if (StringUtils.isNotBlank(partnerkey)) {
			sb.append("key=" + partnerkey);
		}

		return digestWithMD5(sb.toString(), "UTF-8").toUpperCase();
	}

	/**
	 * 字符串MD5加密
	 * 
	 * @param plainText
	 *            明文字符串
	 * @param charsetName
	 *            字符集
	 * @return MD5解密后的字符串
	 * @throws Exception
	 *             解密异常时抛出的Exception
	 */
	public static String digestWithMD5(String plainText, String charsetName) throws Exception {
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		byte[] bytes = md5.digest(plainText.getBytes(charsetName));

		StringBuilder sb = new StringBuilder();
		for (byte b : bytes) {
			int bt = b & 0xff;
			if (bt < 16) {
				sb.append(0);
			}
			sb.append(Integer.toHexString(bt));
		}

		return sb.toString();
	}

	/**
	 * * 获取已发送红包信息
	 * 
	 * @param redPackRequstInfo
	 *            获取微信红包请求体
	 * @param partnerkey
	 *            微信商户支付密码
	 * @param certContent
	 *            证书内容
	 * @param certPassword
	 *            证书密码
	 * 
	 * @return
	 * @throws Exception
	 */
	public static WechatRedPackInfoResponse getWechatRedPackInfo(WechatRedPackInfoRequest redPackRequstInfo,
			String partnerkey, String certContent, String certPassword) throws Exception {

		HttpClient httpClient = null;
		try {
			Map<String, Object> map = BeanMapUtils.toMap(redPackRequstInfo);
			redPackRequstInfo.setSign(WechatRedPackUtils.signWithMD5(map, partnerkey));
			final XStream xStream = XStreamFactory.createXstream(redPackRequstInfo.getClass());
			xStream.processAnnotations(redPackRequstInfo.getClass());
			String requestXml = xStream.toXML(redPackRequstInfo);

			httpClient = HttpClients.custom()
					.setSSLSocketFactory(loadSocketFactoryByCertContent(certContent, certPassword)).build();
			HttpEntity entity = new StringEntity(requestXml, "UTF-8");
			HttpPost httpost = new HttpPost(getRedPackInfourl); // 设置响应头信息
			httpost.setEntity(entity);

			return httpClient.execute(httpost, new ResponseHandler<WechatRedPackInfoResponse>() {

				@Override
				public WechatRedPackInfoResponse handleResponse(HttpResponse response)
						throws ClientProtocolException, IOException {

					BufferedReader br = new BufferedReader(
							new InputStreamReader(response.getEntity().getContent(), "utf-8"));
					String line = null;
					StringBuilder sb = new StringBuilder();
					while ((line = br.readLine()) != null) {
						sb.append(line);
					}
					String respBody = sb.toString();

					XStream responseStream = XStreamFactory.createXstream(WechatRedPackInfoResponse.class,
							WechatRedPackInfo.class);
					responseStream.processAnnotations(WechatRedPackInfoResponse.class);
					return (WechatRedPackInfoResponse) responseStream.fromXML(respBody);
				}
			});
		} finally {
			if (httpClient != null) {
				HttpClientUtils.closeQuietly(httpClient);
			}
		}
	}

	/**
	 * 加载ssl证书内容
	 * 
	 * @param certContent
	 *            证书内容
	 * @param keyStorePassword
	 *            证书密码
	 * @return SSLConnectionSocketFactory
	 * @throws Exception
	 *             Exception
	 */
	public static SSLConnectionSocketFactory loadSocketFactoryByCertContent(String certContent, String keyStorePassword)
			throws Exception {
		KeyStore keyStore = KeyStore.getInstance("PKCS12");
		InputStream instream = new ByteArrayInputStream(HexUtil.parseByteArray(certContent));

		try {
			// keystore密码,默认是你的MCHID
			keyStore.load(instream, keyStorePassword.toCharArray());
		} finally {
			instream.close();
		}

		// Trust own CA and all self-signed certs
		SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, keyStorePassword.toCharArray()).build();
		// Allow TLSv1 protocol only
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[] { "TLSv1" }, null,
				new DefaultHostnameVerifier());

		return sslsf;
	}
}
