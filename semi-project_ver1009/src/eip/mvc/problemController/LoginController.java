package eip.mvc.problemController;

import eip.mvc.model.dto.UserVO;
import eip.mvc.model.service.LoginService;
import eip.mvc.model.service.LoginServiceImpl;
import eip.mvc.model.view.FailView;
import eip.mvc.model.view.SuccessView;

public class LoginController {


	private static LoginService service = new LoginServiceImpl();
	public static void insertAccount(String id, String pwd) {
		try {
			service.insertAccount(id, pwd);
			SuccessView.messagePrint("가입이 완료되었습니다.");

		}catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}


	}
	/*public UserVO selectByIdPwd(String id, String pw) {
		return new LoginDAO().selectByIdPwd(id,pw);

	}*/
	public static UserVO selectByIdPwd(String id, String pwd) {
		UserVO user = null;
		try {
			user = service.selectByIdPwd(id, pwd);
		}catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
		return user;
	}

}
