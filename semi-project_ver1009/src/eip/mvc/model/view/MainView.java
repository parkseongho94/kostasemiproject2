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
		
		LoginView.loginMenu();//ȸ������ �� �α���
		
		while(true) {
			System.out.println("------------------- ���� -------------------");
			System.out.println("1. ������� 2. ����Ǯ�� 3. ���������� �˻�, 4. ���������ϱ�, 5. ��������, 6. ������");
			int menu = Integer.parseInt(sc.nextLine());

			switch(menu) { 
			case 1: ProblemView.viewInsert(); break;
			case 2: ProblemController.selectAll();break;
			case 3: ProblemController.keyWord(prompt("Ű���带 �Է����ּ���"));break;
			case 4: break;
			case 5: NoticeView.noticeMenu();break;
			case 6: System.out.println("���α׷� ����");
				System.exit(0);
			}
		}
	}
	
	public static String prompt(String str) {
		System.out.print(str);
		return sc.nextLine();
	}
}







