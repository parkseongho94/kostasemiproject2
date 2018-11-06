package eip.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import eip.mvc.model.dto.ErrorVO;

public interface ErrorDAO {
	/**
	 * �����߰�  - ����Ʋ���� �����Ʈ�� �߰�
	 * @param ID : ���� �α��� �� ���̵�, ProblemNo : ������ȣ, inputAns : �Է��� ��
	 * @return ���н� 0, ������ 1
	 */
	
	public int insertError(ErrorVO vo) throws SQLException;
	
	/**
	 * �����Ʈ Ȯ��  - ����, ��, �Է��� ��, �ؼ� ���
	 * @return list
	 */
	
	public List<ErrorVO> selectAll() throws SQLException;
	
	/**
	 * �����Ʈ ���� : ����  
	 * @param
	 * @return list
	
	 	�߰����� ����
		public int DeleteByErrorNo(int ErrorNo);
	*/
	public boolean duplicatedByNo(int qno) throws SQLException;
	
	public int updateError(int qno) throws SQLException;
	
}
