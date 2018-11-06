package eip.mvc.model.view;

import java.util.Iterator;
import java.util.List;

import eip.mvc.model.dto.ErrorVO;

public class ErrorView {
	public static void errorPrint(List<ErrorVO> list) {
		Iterator<ErrorVO> iter = list.iterator();
		
		while(iter.hasNext()) {
			ErrorVO vo = iter.next();
			System.out.println("["+ vo.getId()+"] ���� �����Ʈ");
			System.out.println();
			System.out.println("���� :" + vo.getProblem().getKind());
			System.out.println("���� :" + vo.getProblem().getProblem());
			System.out.println();
			System.out.println("���� :" + vo.getProblem().getAnswer());
			System.out.println("���� :" + vo.getErrorAnswer());
			System.out.println();
			System.out.println("�ؼ�" + vo.getProblem().getExplain());
			System.out.println("********���͸� ġ�� ���� �����Ʈ�� �Ѿ�ϴ�.**********");
			MainView.sc.nextLine();
		}
	}
	
}
