package eip.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import eip.mvc.model.dto.ErrorVO;
import eip.mvc.model.dto.ProblemVO;
import eip.mvc.model.util.DBUtil;

public class ErrorDAOImpl implements ErrorDAO{
	private Properties proFile = DBUtil.getProFile();

	@Override
	public int insertError(ErrorVO vo) throws SQLException {
		//���� vo(Ʋ������)�� db�� �־���� ��
		Connection con = null;
		PreparedStatement ps = null;
		String sql = proFile.getProperty("error.insert");
		int result = 0;
		
		try {
			
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getProblem().getNo());
			ps.setString(2, vo.getId());
			ps.setInt(3, vo.getErrorAnswer());
			ps.setInt(4, 0);
			result = ps.executeUpdate();

			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(ps, con);
		}
		
		
		return result;
	}

	@Override
	public List<ErrorVO> selectAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = proFile.getProperty("error.selectAll");
		ProblemVO problem = null;
		List<ErrorVO> list = new ArrayList<>();
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				problem = new ProblemVO(rs.getInt("qno"),rs.getString("sub"),rs.getString("quest"),rs.getInt("ans"),rs.getString("exp"));
				
				list.add(new ErrorVO(rs.getString("userid"),problem,rs.getInt("e_ans"),rs.getInt("ecount")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, ps, con);
		}
		
		return list;
	}

	@Override
	public boolean duplicatedByNo(int qno) {
		Connection con = null;
		PreparedStatement ps  = null;
		ResultSet rs = null;
		String sql = proFile.getProperty("error.duplicatedByNo");
		boolean result = false;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, qno);
			rs = ps.executeQuery();
			result = rs.next();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, ps, con);
		}
		
		System.out.println("�Ʒ� " + result);
		return result;
	}

	@Override
	public int updateError(int qno) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = proFile.getProperty("error.update");
		int result = 0;
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, qno);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(ps, con);
		}
		
		return result;
	}
	
	
	
}
