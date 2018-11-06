package eip.mvc.model.view;

import eip.mvc.model.dto.UserVO;
import eip.mvc.problemController.LoginController;

public class LoginView {
	static int log_flag = 0;
	public static UserVO user = null;

	public static void loginMenu() {
		
		while(log_flag!=1) {
			System.out.println("-------------- 안녕? ------------------");
			System.out.println("1. 회원가입  2. 로그인");
			int menu_first = Integer.parseInt(MainView.sc.nextLine());

			switch(menu_first) {
			case 1: create_account();break;
			case 2: login_account();break;
			}
		}
	}

	public static void create_account() {
		String id = MainView.prompt("* 회원가입할 ID를 입력하세요 : ");
		String pwd = MainView.prompt("* 새로운 Password를 입력하세요 : ");
		LoginController.insertAccount(id, pwd);
	}

	public static void login_account() {
		String log_id = MainView.prompt("* ID를 입력하세요 : ");
		String log_pwd = MainView.prompt("* Password를 입력하세요 : ");

		user = LoginController.selectByIdPwd(log_id, log_pwd);

		if(user.getId() != null) {
			//1. user자체가 new로 생성시 null이 되기 힘듬
			//getid값이 null일때 로그인실패로 처리함
			System.out.println(user);
			log_flag = 1;
		}else {
			System.out.println("실패");
		}
	}
	/**
	 * @return 관리자면 true, 관리자가 아니면 false
	 */
	public static boolean checkManager() {
		if(LoginView.user.getManager() ==0) {
			FailView.errorMessage("관리자만 등록할 수 있습니다");
			return false;
		}
		return true;
	}
}
