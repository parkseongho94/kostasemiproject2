package eip.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import eip.mvc.model.dto.ProblemVO;
import eip.mvc.model.util.DBUtil;


public class ProblemDAOImpl implements ProblemDAO{
	
	private Properties proFile = DBUtil.getProFile();
	
	@Override
	public int insertProblem(ProblemVO problem) throws SQLException {
		
		Connection con = null;
		PreparedStatement ps = null;
		
		int result = 0;
		String sql = proFile.getProperty("problem.insert");
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, problem.getKind());
			ps.setString(2, problem.getProblem());
			ps.setInt(3, problem.getAnswer());
			ps.setString(4, problem.getExplain());
			ps.setString(5, problem.getKeyword());
			result = ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(ps, con);
		}
		
		return result;
	}

	@Override
	public List<ProblemVO> selectAll() throws SQLException {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ProblemVO> list = new ArrayList<>();
		String sql = proFile.getProperty("problem.selectAll");
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ProblemVO dto = new ProblemVO();
				dto.setNo(rs.getInt("qno"));
				dto.setKind(rs.getString("sub"));
				dto.setProblem(rs.getString("quest"));
				dto.setAnswer(rs.getInt("ans"));
				dto.setExplain(rs.getString("exp"));
				dto.setKeyword(rs.getString("keywd"));
				dto.setIncorrect(rs.getDouble("inans"));
				list.add(dto);
			}
		} finally {
			DBUtil.dbClose(rs,ps, con);
		}
		
		return list;
	}

	
	@Override
	public List<ProblemVO> keyWord(String Keyword) throws SQLException {
	
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ProblemVO> list = new ArrayList<>();
		String sql = proFile.getProperty("problem.keyword");
		try {
			 
			  con=DBUtil.getConnection();
			  ps=con.prepareStatement(sql);
			  ps.setString(1, Keyword);
			  rs=ps.executeQuery();
			  
		      while(rs.next()) {
		    	  ProblemVO dto = new ProblemVO();
					dto.setProblem(rs.getString("quest"));
					list.add(dto);
		      }
		  }finally {
			  DBUtil.dbClose(rs, ps , con);
		  }
			return list;

	}
	@Override
	public int updateProblem(ProblemVO problem) throws SQLException {
		return 0;
	}

	@Override
	public int deleteProblem(int no) throws SQLException {
		return 0;
	}

}
