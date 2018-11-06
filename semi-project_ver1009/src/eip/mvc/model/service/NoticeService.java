package eip.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import eip.mvc.model.dto.NoticeVO;



public interface NoticeService {

	List<NoticeVO>selectAll() throws SQLException;
	
	void insertNotice(NoticeVO NVO) throws SQLException;
	
	void deleteNotice(int NoticeNo) throws SQLException;
	
}
