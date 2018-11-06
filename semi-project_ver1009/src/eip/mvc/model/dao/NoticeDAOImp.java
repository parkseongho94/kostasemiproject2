package eip.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import eip.mvc.model.dto.NoticeVO;
import eip.mvc.model.util.DBUtil;


public class NoticeDAOImp implements NoticeDAO {
	private Properties proFile  = DBUtil.getProFile();

	@Override
	public int insertNotice(NoticeVO notice) throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = proFile.getProperty("notice.insert");
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, notice.getTitle());
			ps.setString(2, notice.getContent());

			result = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(ps, con);
		}

		return result;
	}

	@Override
	public List<NoticeVO> selectAll() throws SQLException {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<NoticeVO> list = new ArrayList<>();
		String sql = proFile.getProperty("notice.selectAll");

		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while(rs.next()){
				list.add(
						new NoticeVO(rs.getInt(1), 
								rs.getString(2),
								rs.getString(3), 
								rs.getString(4), 
								rs.getString(5)));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs,ps, con);
		}

		return list;
	}

	public int deleteNotice(int NoticeNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = proFile.getProperty("notice.deleteByNo");

		int result = 0;
		try {
			
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, NoticeNo);
			result = ps.executeUpdate();
			
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(ps,con);
		}
		return result;
	}
}
