package eip.mvc.problemController;

import java.sql.SQLException;
import java.util.List;

import eip.mvc.model.dto.NoticeVO;
import eip.mvc.model.service.NoticeService;
import eip.mvc.model.service.NoticeServiceImpl;
import eip.mvc.model.view.FailView;
import eip.mvc.model.view.LoginView;
import eip.mvc.model.view.NoticeView;
import eip.mvc.model.view.SuccessView;

public class NoticeController {
	public static NoticeService noticeService = new NoticeServiceImpl();
	
	public static void selectAll() {

		try {
			List<NoticeVO> list= noticeService.selectAll();
			NoticeView.selectPrint(list);
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	public static void insertNotice(NoticeVO noticeVO) {
		
		try {
			noticeService.insertNotice(noticeVO);
			SuccessView.messagePrint("등록되었습니다.");
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	public static void deleteNotice(int noticeNo) {
		try {
			
			noticeService.deleteNotice(noticeNo);
			SuccessView.messagePrint("삭제에 성공하였습니다.");
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}

	}

}
