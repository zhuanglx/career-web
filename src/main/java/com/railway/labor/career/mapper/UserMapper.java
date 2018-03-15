package com.railway.labor.career.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.railway.labor.career.model.dto.LoginInfoDTO;
import com.railway.labor.career.model.dto.UserDTO;
import com.railway.labor.career.model.query.UserQuery;

public interface UserMapper {

	LoginInfoDTO login(@Param("userNo") String userNo, @Param("password") String password);
	
	List<UserDTO> query(UserQuery userQuery);

	UserDTO get(Long id);

	void insert(UserDTO userDTO);

	void update(UserDTO userDTO);

	void delete(Long id);
}
