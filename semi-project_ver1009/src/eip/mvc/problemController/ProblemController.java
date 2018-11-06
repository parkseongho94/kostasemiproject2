package eip.mvc.problemController;

import java.util.List;

import eip.mvc.model.dto.ProblemVO;
import eip.mvc.model.service.ProblemService;
import eip.mvc.model.service.ProblemServiceImpl;
import eip.mvc.model.view.FailView;
import eip.mvc.model.view.LoginView;
import eip.mvc.model.view.ProblemView;
import eip.mvc.model.view.SuccessView;

public class ProblemController {
	private static ProblemService service = new ProblemServiceImpl();
	
	public static void insertProblem(ProblemVO problem) {
		
		
		try {
			service.insertProblem(problem);
			SuccessView.messagePrint(problem.getNo()+"번 문제가 추가 되었습니다.");
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	public static void selectAll() {
		
		try {
			ProblemView.selectPrint(service.selectAll());
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	
	public static void keyWord(String Keyword){
		 List<ProblemVO> list = null;
			try {
			  list = service.keyWord(Keyword);
			  ProblemView.printKeyword(list);
			}catch (Exception e) {
				e.printStackTrace();
			}
			
	}
	
	
	
}
