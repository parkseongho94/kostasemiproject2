package eip.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import eip.mvc.model.dao.ResultDAO;
import eip.mvc.model.dao.ResultDAOImpl;
import eip.mvc.model.dto.ResultVO;

public class ResultServiceImpl implements ResultService{
	private ResultDAO dao =  new ResultDAOImpl();
		
	@Override
	public int insertResult(ResultVO result) throws SQLException {
		result.setAver();
		int re = dao.insertResult(result);
		
		return re;
	}
	
	
	@Override
	public List<ResultVO> selectAll() throws SQLException {
		return null;
	}

	
}
