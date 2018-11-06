package eip.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import eip.mvc.model.dto.ProblemVO;

public interface ProblemDAO {
	/**
	 * ���� �߰� (������ �������� Ȯ�� �� ����)
	 * @param : Problem
	 * @return : 0 : ����, 1 : ����
	 * */
	public int insertProblem(ProblemVO problem) throws SQLException;
	
	
	/**
	 * ���� Ǯ�� (������)
	 * @return : List<Problem>
	 * */
	public List<ProblemVO> selectAll() throws SQLException;
	
	
	/**
	 * ���� ������Ʈ (������ ����)
	 * @param : Problem 
	 * @return : int ������ ���� 
	 * */
	public int updateProblem(ProblemVO problem) throws SQLException;
	
	
	/**
	 * ���� ����(������ ����)
	 * @param : no ������ȣ
	 * @return : int ������ ����
	 * */
	public int deleteProblem(int no) throws SQLException;
	
	
	/**
	 * ���� Ű���� �˻�
	 * */
	public List<ProblemVO> keyWord(String Keyword) throws SQLException;
}
