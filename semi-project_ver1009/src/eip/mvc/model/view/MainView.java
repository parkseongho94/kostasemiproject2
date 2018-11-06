package eip.mvc.model.view;

import java.util.Scanner;

import eip.mvc.model.dto.NoticeVO;
import eip.mvc.model.dto.ProblemVO;
import eip.mvc.model.dto.UserVO;
import eip.mvc.problemController.LoginController;
import eip.mvc.problemController.NoticeController;
import eip.mvc.problemController.ProblemController;

public class MainView {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		LoginView.loginMenu();//회원가입 및 로그인
		
		while(true) {
			System.out.println("------------------- 선택 -------------------");
			System.out.println("1. 문제등록 2. 문제풀기 3. 문제유형별 검색, 4. 문제삭제하기, 5. 공지사항, 6. 나가기");
			int menu = Integer.parseInt(sc.nextLine());

			switch(menu) { 
			case 1: ProblemView.viewInsert(); break;
			case 2: ProblemController.selectAll();break;
			case 3: ProblemController.keyWord(prompt("키워드를 입력해주세요"));break;
			case 4: break;
			case 5: NoticeView.noticeMenu();break;
			case 6: System.out.println("프로그램 종료");
				System.exit(0);
			}
		}
	}
	
	public static String prompt(String str) {
		System.out.print(str);
		return sc.nextLine();
	}
}







