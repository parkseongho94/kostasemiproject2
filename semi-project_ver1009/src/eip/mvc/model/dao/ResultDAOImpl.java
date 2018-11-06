package eip.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import eip.mvc.model.dto.ResultVO;
import eip.mvc.model.util.DBUtil;

public class ResultDAOImpl implements ResultDAO{
	
	private Properties profile = DBUtil.getProFile();
	
	@Override
	public List<ResultVO> selectAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertResult(ResultVO result) throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		int re = 0;
		String sql = profile.getProperty("result.insert");
		try {
			
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(ps, con);
		}
		
		return 0;
	}

	
}
