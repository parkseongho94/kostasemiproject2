package eip.mvc.model.view;

import java.util.List;

import eip.mvc.model.dto.NoticeVO;
import eip.mvc.problemController.NoticeController;

public class NoticeView {
	public static void noticeMenu() {
		while(true) {
			System.out.println("1.공지사항 등록 2.공지사항 확인 3.공지사항 삭제 4.메인메뉴로 돌아가기");
			int NoticeSelect = Integer.parseInt(MainView.sc.nextLine());
			switch(NoticeSelect) { 
			case 1:insertNotice();break;
			case 2:selectAllNotice();break;
			case 3:delectNoticeByNo();break;
			case 4: return;
			}// switch
		}
	}

	public static void insertNotice() {
		if(!LoginView.checkManager()) {
			return;
		}
		
		String title = MainView.prompt("제목을 입력해주세요");
		String content = MainView.prompt("내용을 입력해주세요");
		NoticeVO notice = new NoticeVO(0,title,content,null,"test");
		NoticeController.insertNotice(notice);
	}


	public static void selectAllNotice() {
		NoticeController.selectAll();
	}

	public static void delectNoticeByNo() {
		if(!LoginView.checkManager()) {
			return;
		} 
		
		System.out.println("삭제 게시물 번호는?");
		int no = Integer.parseInt(MainView.sc.nextLine());
		NoticeController.deleteNotice(no);
	}

	public static void selectPrint(List<NoticeVO> list) {
		System.out.println("--------게시글 LIST--------");
		for(NoticeVO NoticeVO : list) {
			System.out.println(NoticeVO);
		}
	}
}
