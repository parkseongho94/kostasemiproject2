package eip.mvc.problemController;

import java.sql.SQLException;

import eip.mvc.model.dto.ErrorVO;
import eip.mvc.model.service.ErrorService;
import eip.mvc.model.service.ErrorServiceImpl;
import eip.mvc.model.view.ErrorView;

public class ErrorController {
	private static ErrorService service = new ErrorServiceImpl();
	
	public static void insertError(ErrorVO vo) {
		try {
			service.insertError(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void selectAll() {
		try {
			ErrorView.errorPrint(service.selectAll());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
