package eip.mvc.model.view;

import java.util.Iterator;
import java.util.List;

import eip.mvc.model.dto.ErrorVO;
import eip.mvc.model.dto.ProblemVO;
import eip.mvc.problemController.ErrorController;
import eip.mvc.problemController.ProblemController;

public class ProblemView {

	public static void selectPrint(List<ProblemVO> list) {
		Iterator<ProblemVO> iter = list.iterator();

		while(iter.hasNext()) {
			ProblemVO problem = iter.next();
			System.out.println(problem.getProblem());

			int answer = Integer.parseInt(MainView.prompt("���� �Է����ּ���"));
			if(answer == problem.getAnswer()) {
				System.out.println("�ڡڡڡڡڡڡڡڡ�����!!!�ڡڡڡڡڡڡڡڡڡ�");
			} else {
				System.out.println("�͢͢͢͢͢͢͢͢Ϳ����Դϴ٢͢͢͢͢͢͢͢͢�");
				saveError(answer,problem);
			}
		}
		completeMenu();
	}


	public static void printKeyword(List<ProblemVO> list) {
		Iterator<ProblemVO> iter = list.iterator();
		System.out.println("**********�����˻�*************");
		while(iter.hasNext()) {
			ProblemVO problem = iter.next();
			int answer = Integer.parseInt(MainView.prompt("���� �Է����ּ��� : "));
			if(answer == problem.getAnswer()) {
				System.out.println("�ڡڡڡڡڡڡڡڡ�����!!!�ڡڡڡڡڡڡڡڡڡ�");
			} else {
				System.out.println("�͢͢͢͢͢͢͢͢Ϳ����Դϴ٢͢͢͢͢͢͢͢͢�");
				saveError(answer,problem);
			}
		}
	}

	public static void viewInsert() {
		if(!LoginView.checkManager()) {
			return;
		}

		ProblemVO problem = new ProblemVO();
		problem.setKind(MainView.prompt("���������� ������ּ��� 1. DB, 2. ���ڰ��ⱸ��, 3. �ü�� 4. SW����, 5. ����Ÿ���"));
		problem.setProblem(MainView.prompt("������ ������ּ���"));
		problem.setAnswer(Integer.parseInt(MainView.prompt("���� �Է����ּ���")));
		problem.setExplain(MainView.prompt("�ؼ��� �Է��ϼ���"));
		problem.setKeyword(MainView.prompt("Ű���带 �Է����ּ���"));
		ProblemController.insertProblem(problem);
	}

	public static void saveError(int answer, ProblemVO problem) {
		ErrorVO vo = new ErrorVO();
		vo.setErrorAnswer(answer);
		vo.setId(LoginView.user.getId());
		vo.setProblem(problem);
		ErrorController.insertError(vo);
	}

	public static void completeMenu() {
		String answer= MainView.prompt("������ ��Ǫ�̽��ϴ�\n 1. ��� ���� ����(ä��)\n 2. �����Ʈ �� �ؼ���������");
		switch(answer) {
		case "1": //resultController
		case "2": ErrorController.selectAll();
		}
	}

}
