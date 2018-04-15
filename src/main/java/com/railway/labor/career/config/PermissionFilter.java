package com.railway.labor.career.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.railway.labor.career.common.Pagination;
import com.railway.labor.career.model.dto.LoginInfoDTO;
import com.railway.labor.career.model.dto.PermissionDTO;
import com.railway.labor.career.model.dto.RolePermissionDTO;
import com.railway.labor.career.model.dto.UserPermissionDTO;
import com.railway.labor.career.model.dto.UserRoleDTO;
import com.railway.labor.career.model.query.RolePermissionQuery;
import com.railway.labor.career.model.query.UserPermissionQuery;
import com.railway.labor.career.model.query.UserRoleQuery;
import com.railway.labor.career.service.PermissionService;
import com.railway.labor.career.service.RolePermissionService;
import com.railway.labor.career.service.UserPermissionService;
import com.railway.labor.career.service.UserRoleService;
@Component
@WebFilter(urlPatterns = "/*",filterName = "permissionFilter")
@Order(value = 2)
public class PermissionFilter  extends BaseFilter implements Filter{
	@Autowired
	private UserRoleService userRoleService;
	@Autowired
	private RolePermissionService rolePermissionService;
	@Autowired
	private UserPermissionService userPermissionService;
	@Autowired
	private PermissionService permissionService;
	@Override
	public void destroy() {
		log.info("destroy {}", getClass()); 
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		String basePath = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+req.getContextPath();
		log.info("requestURL={}",req.getRequestURL());
		boolean allowedPath = ALLOWED_PATHS.contains(req.getRequestURL().substring(basePath.length()));
		if(allowedPath){
			filterChain.doFilter(request, response); 
			return;
		}
		@SuppressWarnings("unchecked")
		List<PermissionDTO> permissionDTOList =  (List<PermissionDTO>) req.getSession(true).getAttribute("permissionDTOList");
		if(permissionDTOList==null){
			LoginInfoDTO loginInfoDTO = (LoginInfoDTO) req.getSession(true).getAttribute("loginInfo");
			
			
			UserPermissionQuery  userPermissionQuery = new UserPermissionQuery();
			userPermissionQuery.setUserId(loginInfoDTO.getId());
			Pagination<UserPermissionQuery, UserPermissionDTO> userPermissionDTOPagination = new Pagination<>();
			userPermissionDTOPagination.setQuery(userPermissionQuery);
			userPermissionDTOPagination.setPageSize(10000);
			userPermissionDTOPagination.setPageIndex(0);
			List<UserPermissionDTO> userPermissionDTOList = userPermissionService.query(userPermissionDTOPagination).getRows();
			
			UserRoleQuery userRoleQuery = new UserRoleQuery();
			userRoleQuery.setUserId(loginInfoDTO.getId());
			Pagination<UserRoleQuery, UserRoleDTO> userRoleDTOPagination = new Pagination<>();
			userRoleDTOPagination.setQuery(userRoleQuery);
			userRoleDTOPagination.setPageSize(10000);
			userRoleDTOPagination.setPageIndex(0);
			userRoleDTOPagination = userRoleService.query(userRoleDTOPagination);
			RolePermissionQuery  rolePermissionQuery = new RolePermissionQuery();
			List<RolePermissionDTO> rolePermissionDTOList = new ArrayList<>();
			for (UserRoleDTO userRoleDTO : userRoleDTOPagination.getRows()) {
				rolePermissionQuery.setRoleId(userRoleDTO.getRoleId());
				rolePermissionDTOList.addAll(rolePermissionService.query(rolePermissionQuery).getRows());
			}
			
			List<Long> ids = new ArrayList<>(userPermissionDTOList.size() + rolePermissionDTOList.size());
			for (UserPermissionDTO userPermissionDTO : userPermissionDTOList) {
				ids.add(userPermissionDTO.getPermissionId());
			}
			for (RolePermissionDTO rolePermissionDTO : rolePermissionDTOList) {
				ids.add(rolePermissionDTO.getPermissionId());
			}
			permissionDTOList = permissionService.queryByIds(ids);
			if(CollectionUtils.isNotEmpty(permissionDTOList)){
				req.getSession(true).setAttribute("permissionDTOList", permissionDTOList);
			}
		}
		if(permissionDTOList!=null){
			for (PermissionDTO permissionDTO : permissionDTOList) {
				if(StringUtils.equals(req.getRequestURL(), permissionDTO.getValue())){
					filterChain.doFilter(request, response); 
					return;
				}
			}
		}
		res.sendRedirect(basePath+"/error.json?errorCode=noPermission");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		log.info("init {}",getClass()); 		
	}

}
