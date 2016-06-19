package com.xinma.base.wechat.util;

import java.io.IOException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang3.StringUtils;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xinma.base.wechat.model.AccessTokenResult;
import com.xinma.base.wechat.model.CheckAccessTokenResult;
import com.xinma.base.wechat.model.UserBasicInfo;

public class WechatBasicHelper {
	private static String oauthAccessTokenUrl = "https://api.weixin.qq.com/sns/oauth2/access_token";
	private static String oauthRefreshAccessTokenUrl = "https://api.weixin.qq.com/sns/oauth2/refresh_token";
	private static String checkAccessTokenUrl = "https://api.weixin.qq.com/sns/auth";
	private static String userInfoUrl = "https://api.weixin.qq.com/cgi-bin/user/info";
	private static String snsapi_userinfoUrl = "https://api.weixin.qq.com/sns/userinfo";

	private static Client client = ClientBuilder.newClient(new ClientConfig()
			.property(ClientProperties.CONNECT_TIMEOUT, 10000).property(ClientProperties.READ_TIMEOUT, 10000));

	/**
	 * 销毁资源，应用程序销毁前，必须调用该方法
	 */
	public static void destroy() {
		if (client != null) {
			client.close();
		}
	}

	/**
	 * 根据token获取微信openId
	 * 
	 * @param code
	 *            auth2认证token
	 * @param weixinAppId
	 *            微信appId
	 * @param weixinSecret
	 *            微信appSecret
	 * @return
	 * @throws IOException
	 */
	public static String getOpenIdWithToken(String code, String weixinAppId, String weixinSecret) throws IOException {
		return getWechatAccessTokenResult(code, weixinAppId, weixinSecret).getOpenid();
	}

	/**
	 * 获取微信access token
	 * 
	 * @param code
	 *            auth2认证token
	 * @param weixinAppId
	 *            微信appId
	 * @param weixinSecret
	 *            微信appSecret
	 * @return
	 * @throws IOException
	 */
	public static AccessTokenResult getWechatAccessTokenResult(String code, String weixinAppId, String weixinSecret)
			throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		WebTarget target = client.target(oauthAccessTokenUrl).queryParam("appid", weixinAppId)
				.queryParam("secret", weixinSecret).queryParam("code", code)
				.queryParam("grant_type", "authorization_code");

		String data = target.request(MediaType.APPLICATION_JSON_TYPE).get(String.class);
		AccessTokenResult tokenResult = mapper.readValue(data, AccessTokenResult.class);
		return tokenResult;

	}

	/**
	 * 刷新微信access token
	 * 
	 * @param weixinAppId
	 *            微信appId
	 * @param refreshToken
	 *            通过code换取网页授权access_token后获取的refresh_token
	 * @return
	 * @throws IOException
	 */
	public static AccessTokenResult refreshWechatAccessTokenResult(String weixinAppId, String refreshToken)
			throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		WebTarget target = client.target(oauthRefreshAccessTokenUrl).queryParam("appid", weixinAppId)
				.queryParam("grant_type", "refresh_token").queryParam("refresh_token", refreshToken);

		String data = target.request(MediaType.APPLICATION_JSON_TYPE).get(String.class);
		AccessTokenResult tokenResult = mapper.readValue(data, AccessTokenResult.class);
		return tokenResult;
	}

	/**
	 * 检验授权凭证（access_token）是否有效
	 * 
	 * @param openId
	 * @param accessToken
	 * @return
	 * @throws IOException
	 */
	public static CheckAccessTokenResult checkWechatAccessTokenResult(String openId, String accessToken)
			throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		WebTarget target = client.target(checkAccessTokenUrl).queryParam("access_token", accessToken)
				.queryParam("openid", openId);

		String data = target.request(MediaType.APPLICATION_JSON_TYPE).get(String.class);
		CheckAccessTokenResult tokenResult = mapper.readValue(data, CheckAccessTokenResult.class);
		return tokenResult;
	}

	/**
	 * 获取微信公众账号用户基本信息
	 * 
	 * @param accessToken
	 *            调用接口凭证
	 * @param openid
	 *            普通用户的标识，对当前公众号唯一
	 * @param language
	 *            返回国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语
	 * @return
	 * @throws IOException
	 */
	public static UserBasicInfo getBasicUserInfo(String accessToken, String openid, String language, boolean isSnsApi)
			throws IOException {
		ObjectMapper mapper = new ObjectMapper();

		if (StringUtils.isBlank(language)) {
			language = "zh_CN";
		}
		String url = isSnsApi ? snsapi_userinfoUrl : userInfoUrl;
		WebTarget target = client.target(url).queryParam("access_token", accessToken).queryParam("openid", openid)
				.queryParam("lang", language);

		String data = target.request(MediaType.APPLICATION_JSON_TYPE).get(String.class);
		return mapper.readValue(data, UserBasicInfo.class);
	}

	/**
	 * 判断用户是否订阅(关注)公众号
	 * 
	 * @param basicInfo
	 *            用户信息
	 * @return
	 * @throws IOException
	 */
	public static boolean checkIfSubscribe(UserBasicInfo basicInfo) throws Exception {
		if (basicInfo.getErrcode() != null) {
			String errorDescription = String.format("获取用户基本信息失败,error code is %d, error message is %s",
					basicInfo.getErrcode(), basicInfo.getErrmsg());
			throw new Exception(errorDescription);
		} else {
			return basicInfo.isSubscribe();
		}
	}

	/**
	 * 判断用户是否订阅(关注)公众号
	 * 
	 * @param accessToken
	 *            调用接口凭证
	 * @param openid
	 *            普通用户的标识，对当前公众号唯一
	 * @return
	 * @throws IOException
	 */
	public static boolean checkIfSubscribe(String accessToken, String openid) throws Exception {
		// logger.info("checkIfSubscribe, accessToken:{}", accessToken);
		UserBasicInfo basicInfo = getBasicUserInfo(accessToken, openid, "zh_CN", false);

		if (basicInfo.getErrcode() != null) {
			String errorDescription = String.format("获取用户基本信息失败,error code is %d, error message is %s",
					basicInfo.getErrcode(), basicInfo.getErrmsg());
			throw new Exception(errorDescription);
		} else {
			return basicInfo.isSubscribe();
		}
	}
}
