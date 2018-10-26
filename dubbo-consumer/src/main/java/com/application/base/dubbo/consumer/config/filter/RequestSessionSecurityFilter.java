package com.application.base.dubbo.consumer.config.filter;

import com.application.base.cache.redis.jedis.factory.JedisSimpleSessionFactory;
import com.application.base.common.BaseCommonMsg;
import com.application.base.common.Constants;
import com.application.base.common.json.JsonConvertUtils;
import com.application.base.common.result.ResultDataVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @desc 登陆过滤器操作.
 * @author 孤狼
 */
public class RequestSessionSecurityFilter extends OncePerRequestFilter {

	private static final String AJAX_HEADER = "XMLHttpRequest";
	private static Logger logger = LoggerFactory.getLogger(RequestSessionSecurityFilter.class.getName());
	private static final String TOKEN_ID = "token";
	private static final String TYPE = "type";
	
	private String isAuth;
	private String nonAuthRequests;
	private JedisSimpleSessionFactory factory;
	
	
	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		RequestSessionSecurityFilter actionFilter = new RequestSessionSecurityFilter();
		registrationBean.setFilter(actionFilter);
		return registrationBean;
	}
	
	/**
	 * 验证.
	 * @param uri
	 * @return
	 */
	boolean isValid(String uri) {
		boolean doFilter = true;
		if (!StringUtils.isEmpty(nonAuthRequests)) {
			String[] notFilter = nonAuthRequests.split(Constants.Separator.COMMA);
			for (String s : notFilter) {
				if (uri.indexOf(s) != -1) {
					doFilter = !doFilter;
					break;
				}
			}
		}
		return doFilter;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		//打印参数
		String uri = request.getRequestURI();
		Map<String, Object> params = getRequestParams(request);
		logger.debug("<=======requestURI:{}=======>,输入的参数是:{}", uri, JsonConvertUtils.toJson(params));
		if (!StringUtils.isEmpty(isAuth) && BaseConstant.YesOrNo.NO.equalsIgnoreCase(isAuth)) {
			filterChain.doFilter(request, response);
			return;
		}
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "No-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("application/json;charset=UTF-8");
		response.setCharacterEncoding(Constants.CharSet.UTF8);
		
		PrintWriter out;
		boolean doFilter = isValid(uri);
		ResultDataVO generalVO=new ResultDataVO();
		if (doFilter) {
			String type = request.getParameter(TYPE);
			String token = request.getParameter(TOKEN_ID);
			// 如果没有获取sessionId,返回
			if (StringUtils.isEmpty(token)) {
				out = response.getWriter();
				generalVO.setCode(BaseCommonMsg.SESSION_ID_LOST_MSG.getCode()+"");
				generalVO.setMsg(BaseCommonMsg.SESSION_ID_LOST_MSG.getMsg());
				generalVO.setData("没有token,属于非法登录");
				//打印.om
				out.print(JsonConvertUtils.toJson(generalVO));
				return;
			}
			StringBuilder builder = new StringBuilder("");
			if (StringUtils.isEmpty(type)){
				out = response.getWriter();
				generalVO.setCode(BaseCommonMsg.LOGIN_TYPE_LOST_MSG.getCode()+"");
				generalVO.setMsg(BaseCommonMsg.LOGIN_TYPE_LOST_MSG.getMsg());
				generalVO.setData("没有登录类型,无法判断登录");
				//打印.
				out.print(JsonConvertUtils.toJson(generalVO));
				return;
			}
			String json=null;
			//类型.
			if (type.equals(BaseConstant.LoginType.APP)){
				json = factory.getRedisSession().getData(RedisKeyUtil.appSession()+token);
			}
			if (type.equals(BaseConstant.LoginType.PLATFORM)){
				json = factory.getRedisSession().getData(RedisKeyUtil.platformSession()+token);
			}
			// 如果根据sessionkey未能获取数据则认为没有登录或登录超时
			if (StringUtils.isEmpty(json)) {
				out = response.getWriter();
				generalVO.setCode(BaseCommonMsg.SYSTEM_AUTH_LOST_MSG.getCode()+"");
				generalVO.setMsg(BaseCommonMsg.SYSTEM_AUTH_LOST_MSG.getMsg());
				generalVO.setData("登录超时,请重新登录");
				//打印.
				out.print(JsonConvertUtils.toJson(generalVO));
				return;
			}
			else {
				// 如果获取到了则返回
				filterChain.doFilter(request, response);
			}
		}
		else {
			filterChain.doFilter(request, response);
		}
	}

	
	
	/**
	 * 获取输入参数.
	 * @param request
	 * @return
	 */
	protected Map<String, Object> getRequestParams(ServletRequest request) {
		Map<String, Object> params = new HashMap<String, Object>(BaseConstant.NumberTag.MAP_MAX_SIZE);
		Enumeration<?> paramNames = request.getParameterNames();
		if (paramNames != null) {
			while (paramNames.hasMoreElements()) {
				String paramName = (String) paramNames.nextElement();
				String paramValue = request.getParameter(paramName);
				if (org.apache.commons.lang.StringUtils.isNotBlank(paramValue)) {
					params.put(paramName, paramValue);
				}
				else {
					String[] paramValues = request.getParameterValues(paramName);
					if (paramValues != null && paramValues.length == 1) {
						paramValue = paramValues[0];
						params.put(paramName, paramValue);
					}
				}
			}
		}
		return params;
	}
	
	public String getIsAuth() {
		return isAuth;
	}
	
	public void setIsAuth(String isAuth) {
		this.isAuth = isAuth;
	}
	
	public String getNonAuthRequests() {
		return nonAuthRequests;
	}
	
	public void setNonAuthRequests(String nonAuthRequests) {
		this.nonAuthRequests = nonAuthRequests;
	}
	
	public JedisSimpleSessionFactory getFactory() {
		return factory;
	}
	
	public void setFactory(JedisSimpleSessionFactory factory) {
		this.factory = factory;
	}
}
