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

			int answer = Integer.parseInt(MainView.prompt("답을 입력해주세요"));
			if(answer == problem.getAnswer()) {
				System.out.println("★★★★★★★★★정답!!!★★★★★★★★★★");
			} else {
				System.out.println("♨♨♨♨♨♨♨♨♨오답입니다♨♨♨♨♨♨♨♨♨");
				saveError(answer,problem);
			}
		}
		completeMenu();
	}


	public static void printKeyword(List<ProblemVO> list) {
		Iterator<ProblemVO> iter = list.iterator();
		System.out.println("**********문제검색*************");
		while(iter.hasNext()) {
			ProblemVO problem = iter.next();
			int answer = Integer.parseInt(MainView.prompt("답을 입력해주세요 : "));
			if(answer == problem.getAnswer()) {
				System.out.println("★★★★★★★★★정답!!!★★★★★★★★★★");
			} else {
				System.out.println("♨♨♨♨♨♨♨♨♨오답입니다♨♨♨♨♨♨♨♨♨");
				saveError(answer,problem);
			}
		}
	}

	public static void viewInsert() {
		if(!LoginView.checkManager()) {
			return;
		}

		ProblemVO problem = new ProblemVO();
		problem.setKind(MainView.prompt("문제유형을 등록해주세요 1. DB, 2. 전자계산기구조, 3. 운영체제 4. SW공학, 5. 데이타통신"));
		problem.setProblem(MainView.prompt("문제를 등록해주세요"));
		problem.setAnswer(Integer.parseInt(MainView.prompt("답을 입력해주세요")));
		problem.setExplain(MainView.prompt("해설을 입력하세요"));
		problem.setKeyword(MainView.prompt("키워드를 입력해주세요"));
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
		String answer= MainView.prompt("문제를 다푸셨습니다\n 1. 결과 보러 가기(채점)\n 2. 오답노트 및 해설보러가기");
		switch(answer) {
		case "1": //resultController
		case "2": ErrorController.selectAll();
		}
	}

}
