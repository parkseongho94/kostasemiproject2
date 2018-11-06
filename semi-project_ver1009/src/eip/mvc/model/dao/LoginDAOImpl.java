package eip.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import eip.mvc.model.dto.UserVO;
import eip.mvc.model.util.DBUtil;


public class LoginDAOImpl implements LoginDAO {
	private Properties proFile  = DBUtil.getProFile();
	
	@Override
	public int insertAccount(String id, String pwd) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = proFile.getProperty("login.insert");
		int result=0;

		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pwd);
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.getMessage();
		} finally{
			DBUtil.dbClose(ps, con);
		}
		
		return result;
	}

	@Override
	public UserVO selectByIdPwd(String id, String pwd) throws SQLException {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = proFile.getProperty("login.selectByIdPwd");
		UserVO vo = new UserVO();
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, id);
			ps.setString(2, pwd);
			rs=ps.executeQuery();
			
			if(rs.next()) {
			//rs가 있을 경우에만 실행
				vo.setId(rs.getString(1));
				vo.setPwd(rs.getString(2));
				vo.setManager(rs.getInt(3));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(rs, ps, con);
		}
		return vo;
		
	}

}
