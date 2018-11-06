package eip.mvc.model.dto;

public class NoticeVO {

	private int no;
	private String title;
    private String content;
    private String regdate;
    private String userid;
    
	public NoticeVO() {}
	public NoticeVO(int no, String title, String content, String regdate, String userid) {
		this.no = no;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
		this.userid = userid;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	@Override
	public String toString() {
		return "NoticeVO [no=" + no + ", title=" + title + ", content=" + content + ", regdate=" + regdate + ", userid="
				+ userid + "]";
	}
    
}