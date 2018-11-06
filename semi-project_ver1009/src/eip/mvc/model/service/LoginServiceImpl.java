package eip.mvc.model.service;

import java.sql.SQLException;

import eip.mvc.model.dao.LoginDAO;
import eip.mvc.model.dao.LoginDAOImpl;
import eip.mvc.model.dto.UserVO;

public class LoginServiceImpl implements LoginService {

	private LoginDAO dao = new LoginDAOImpl();
	
	@Override
	public int insertAccount(String id, String pwd) throws SQLException {
		int result = dao.insertAccount(id, pwd);
		if(result == 0) {
			throw new SQLException("회원가입에 실패했습니다");
			//처리하지 않으면 가입한 메세지가 발생됨
		}
		return result;
	}

	@Override
	public UserVO selectByIdPwd(String id, String pwd) throws SQLException {
		
		UserVO result = null;
		result = dao.selectByIdPwd(id, pwd);
		
		
		return result;
	}

}
