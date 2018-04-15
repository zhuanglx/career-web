package com.railway.labor.career.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.railway.labor.career.common.Pagination;
import com.railway.labor.career.model.dto.LoginInfoDTO;
import com.railway.labor.career.model.dto.UserDTO;
import com.railway.labor.career.model.query.UserQuery;

public interface UserMapper {

	LoginInfoDTO login(@Param("account") String account,
			@Param("password") String password);

	List<UserDTO> query(@Param("userQuery") UserQuery userQuery, @Param("pagination") Pagination<UserQuery, UserDTO> pagination);

	Long count(@Param("userQuery") UserQuery userQuery);

	UserDTO get(Long id);

	void insert(UserDTO userDTO);

	void update(UserDTO userDTO);

	void delete(Long id);
}
