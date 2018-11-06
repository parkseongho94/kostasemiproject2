package eip.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import eip.mvc.model.dto.NoticeVO;

public interface NoticeDAO {

	/**
	 * �������� �߰� (������ �������� Ȯ�� �� ����)
	 * @param : Notice
	 * @return : 0 : ����, 1 : ����
	 * */
	public int insertNotice(NoticeVO notice) throws SQLException;
	
	/**
	 * �������� Ȯ�� (������)
	 * @return : List<Notice>
	 * */
	public List<NoticeVO> selectAll() throws SQLException;


	public int deleteNotice(int NoticeNo) throws SQLException;

}