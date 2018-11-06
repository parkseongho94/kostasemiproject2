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
			throw new SQLException("ȸ�����Կ� �����߽��ϴ�");
			//ó������ ������ ������ �޼����� �߻���
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
