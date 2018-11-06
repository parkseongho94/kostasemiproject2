package eip.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import eip.mvc.model.dao.ErrorDAO;
import eip.mvc.model.dao.ErrorDAOImpl;
import eip.mvc.model.dao.ProblemDAO;
import eip.mvc.model.dao.ProblemDAOImpl;
import eip.mvc.model.dto.ErrorVO;

public class ErrorServiceImpl implements ErrorService{
	private ErrorDAO dao = new ErrorDAOImpl();
	
	@Override
	public int insertError(ErrorVO vo) throws SQLException {
		
		int result = 0;
		boolean a = dao.duplicatedByNo(vo.getProblem().getNo());
		if(a) {
			// ������Ʈ ó�� 
			result = dao.updateError(vo.getProblem().getNo());
			System.out.println("error update �Ϸ�");
		} else {
			// false �ߺ����� ����
			result = dao.insertError(vo);
			System.out.println("error insert �Ϸ�");
		}
		
		return result;
	}

	@Override
	public List<ErrorVO> selectAll() throws SQLException {
		List<ErrorVO> list = dao.selectAll();
		return list;
	}

}
