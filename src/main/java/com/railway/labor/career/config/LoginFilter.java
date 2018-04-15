package com.railway.labor.career.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.railway.labor.career.model.dto.LoginInfoDTO;

@Component
@WebFilter(urlPatterns = "/*",filterName = "loginFilter")
@Order(value = 1)
public class LoginFilter extends BaseFilter  implements Filter{
	@Override
	public void destroy() {
		log.info("destroy {}", getClass()); 
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
//		res.addHeader("Access-Control-Allow-Origin", "*");
//		res.addHeader("Access-Control-Allow-Credentials", "true");
//		res.addHeader("Access-Control-Allow-Methods", "PUT, POST, GET, OPTIONS, DELETE");
//		res.addHeader("Access-Control-Max-Age", "3600");
//		res.addHeader("Access-Control-Allow-Headers", "content-type, authorization");
		String basePath = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+req.getContextPath();
		log.info("requestURL={}",req.getRequestURL());
		boolean allowedPath = ALLOWED_PATHS.contains(req.getRequestURL().substring(basePath.length()));  
		if(allowedPath){
			filterChain.doFilter(request, response); 
			return;
		}
		LoginInfoDTO loginInfoDTO = (LoginInfoDTO) req.getSession(true).getAttribute("loginInfo");
		if(loginInfoDTO!=null){
			filterChain.doFilter(request, response); 
		}else{
			res.sendRedirect(basePath+"/login.json");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		log.info("init {}",getClass());
		
	}
}
