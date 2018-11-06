package eip.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import eip.mvc.model.dto.ResultVO;

public interface ResultService {
	/**
	 * @return : List<Result> �����ȸ 
	 */
	public List<ResultVO> selectAll() throws SQLException;

	
	/**
	 * @Param : Result - ä�� ����ؼ� ����
	 * @return : int  ����� ����
	 */
	public int insertResult(ResultVO result) throws SQLException;
	
}
