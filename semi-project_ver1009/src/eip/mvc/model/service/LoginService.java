package eip.mvc.model.service;

import java.sql.SQLException;

import eip.mvc.model.dto.UserVO;

public interface LoginService {
	
	public int insertAccount(String id, String pwd) throws SQLException;

	public UserVO selectByIdPwd(String id, String pwd) throws SQLException;
}
