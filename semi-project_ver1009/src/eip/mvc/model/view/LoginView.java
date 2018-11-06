package eip.mvc.model.view;

import eip.mvc.model.dto.UserVO;
import eip.mvc.problemController.LoginController;

public class LoginView {
	static int log_flag = 0;
	public static UserVO user = null;

	public static void loginMenu() {
		
		while(log_flag!=1) {
			System.out.println("-------------- �ȳ�? ------------------");
			System.out.println("1. ȸ������  2. �α���");
			int menu_first = Integer.parseInt(MainView.sc.nextLine());

			switch(menu_first) {
			case 1: create_account();break;
			case 2: login_account();break;
			}
		}
	}

	public static void create_account() {
		String id = MainView.prompt("* ȸ�������� ID�� �Է��ϼ��� : ");
		String pwd = MainView.prompt("* ���ο� Password�� �Է��ϼ��� : ");
		LoginController.insertAccount(id, pwd);
	}

	public static void login_account() {
		String log_id = MainView.prompt("* ID�� �Է��ϼ��� : ");
		String log_pwd = MainView.prompt("* Password�� �Է��ϼ��� : ");

		user = LoginController.selectByIdPwd(log_id, log_pwd);

		if(user.getId() != null) {
			//1. user��ü�� new�� ������ null�� �Ǳ� ����
			//getid���� null�϶� �α��ν��з� ó����
			System.out.println(user);
			log_flag = 1;
		}else {
			System.out.println("����");
		}
	}
	/**
	 * @return �����ڸ� true, �����ڰ� �ƴϸ� false
	 */
	public static boolean checkManager() {
		if(LoginView.user.getManager() ==0) {
			FailView.errorMessage("�����ڸ� ����� �� �ֽ��ϴ�");
			return false;
		}
		return true;
	}
}
