package eip.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import eip.mvc.model.dao.ProblemDAO;
import eip.mvc.model.dao.ProblemDAOImpl;
import eip.mvc.model.dto.ProblemVO;

public class ProblemServiceImpl implements ProblemService{
	
	private ProblemDAO dao = new ProblemDAOImpl();
	
	@Override
	public  List<ProblemVO> selectAll() throws SQLException {
		 List<ProblemVO> list = dao.selectAll();
		 
		if(list == null || list.size() == 0)
			throw new SQLException("검색된 레코드가 없습니다.");
	
		return list;
	}
	
	@Override
	public int insertProblem(ProblemVO problem) throws SQLException {

		int result = dao.insertProblem(problem);
		
		if(result == 0)
			throw new SQLException("삽입실패했습니다.");
		
		return result;
	}
	
	
	public List<ProblemVO> keyWord(String Keyword) throws SQLException {
		List<ProblemVO> list = dao.keyWord(Keyword);
		
		if(list == null || list.size() == 0)
			throw new SQLException("검색된 레코드가 없습니다.");
		
		return list;
	}

}
