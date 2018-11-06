package eip.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import eip.mvc.model.dao.NoticeDAO;
import eip.mvc.model.dao.NoticeDAOImp;
import eip.mvc.model.dto.NoticeVO;



public class NoticeServiceImpl implements NoticeService {
	private NoticeDAO dao = new NoticeDAOImp();
	
	@Override
	public List<NoticeVO> selectAll() throws SQLException {
		
		List<NoticeVO> list = dao.selectAll();
		if (list == null || list.size() == 0) {
			throw new SQLException("공지사항이 없습니다.");
		}
		return list;
	}


	@Override
	public void insertNotice(NoticeVO vo) throws SQLException {
		int re = dao.insertNotice(vo);
		if(re == 0) {
			throw new SQLException("등록되지 않았습니다.");
		}
	}


	@Override
	public void deleteNotice(int NoticeNo) throws SQLException {

		int result = dao.deleteNotice(NoticeNo);
		
		if(result == 0) {
			throw new SQLException("삭제되지 않았습니다.");
		}
	}

	
	
	
	

}
