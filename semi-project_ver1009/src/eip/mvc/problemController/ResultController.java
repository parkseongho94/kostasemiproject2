package eip.mvc.problemController;

import eip.mvc.model.dto.ResultVO;
import eip.mvc.model.service.ResultService;
import eip.mvc.model.service.ResultServiceImpl;

public class ResultController {
	
	private static ResultService service = new ResultServiceImpl();
	
	public static void insertResult(ResultVO result) {
		
		try {
			service.insertResult(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void selectAll() {
		
	}

}
