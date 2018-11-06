package eip.mvc.model.view;

import java.util.Iterator;
import java.util.List;

import eip.mvc.model.dto.ErrorVO;

public class ErrorView {
	public static void errorPrint(List<ErrorVO> list) {
		Iterator<ErrorVO> iter = list.iterator();
		
		while(iter.hasNext()) {
			ErrorVO vo = iter.next();
			System.out.println("["+ vo.getId()+"] 님의 오답노트");
			System.out.println();
			System.out.println("유형 :" + vo.getProblem().getKind());
			System.out.println("문제 :" + vo.getProblem().getProblem());
			System.out.println();
			System.out.println("정답 :" + vo.getProblem().getAnswer());
			System.out.println("오답 :" + vo.getErrorAnswer());
			System.out.println();
			System.out.println("해설" + vo.getProblem().getExplain());
			System.out.println("********엔터를 치면 다음 오답노트로 넘어갑니다.**********");
			MainView.sc.nextLine();
		}
	}
	
}
