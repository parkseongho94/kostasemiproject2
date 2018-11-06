package eip.mvc.model.view;

import java.util.List;

import eip.mvc.model.dto.NoticeVO;
import eip.mvc.problemController.NoticeController;

public class NoticeView {
	public static void noticeMenu() {
		while(true) {
			System.out.println("1.�������� ��� 2.�������� Ȯ�� 3.�������� ���� 4.���θ޴��� ���ư���");
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
		
		String title = MainView.prompt("������ �Է����ּ���");
		String content = MainView.prompt("������ �Է����ּ���");
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
		
		System.out.println("���� �Խù� ��ȣ��?");
		int no = Integer.parseInt(MainView.sc.nextLine());
		NoticeController.deleteNotice(no);
	}

	public static void selectPrint(List<NoticeVO> list) {
		System.out.println("--------�Խñ� LIST--------");
		for(NoticeVO NoticeVO : list) {
			System.out.println(NoticeVO);
		}
	}
}
