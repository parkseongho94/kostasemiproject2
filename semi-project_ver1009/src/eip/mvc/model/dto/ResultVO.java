package eip.mvc.model.dto;

public class ResultVO {
	private int no;
	private String id;
	private int sub1;
	private int sub2;
	private int sub3;
	private int sub4;
	private int sub5;
	private double aver;
	private String testDate;
	
	
	public ResultVO() {}
	public ResultVO(int no, String id, int sub1, int sub2, int sub3, int sub4, int sub5, double aver, String testDate) {
		this.no = no;
		this.id = id;
		this.sub1 = sub1;
		this.sub2 = sub2;
		this.sub3 = sub3;
		this.sub4 = sub4;
		this.sub5 = sub5;
		this.aver = aver;
		this.testDate = testDate;
	}

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getSub1() {
		return sub1;
	}
	public void setSub1(int sub1) {
		this.sub1 = sub1;
	}
	public int getSub2() {
		return sub2;
	}
	public void setSub2(int sub2) {
		this.sub2 = sub2;
	}
	public int getSub3() {
		return sub3;
	}
	public void setSub3(int sub3) {
		this.sub3 = sub3;
	}
	public int getSub4() {
		return sub4;
	}
	public void setSub4(int sub4) {
		this.sub4 = sub4;
	}
	public int getSub5() {
		return sub5;
	}
	public void setSub5(int sub5) {
		this.sub5 = sub5;
	}
	public double getAver() {
		return aver;
	}
	public void setAver() {
		aver = (this.sub1 + this.sub2 + this.sub3 + this.sub4 + this.sub5)/5;
	}
	public String getTestDate() {
		return testDate;
	}
	public void setTestDate(String testDate) {
		this.testDate = testDate;
	}
	@Override
	public String toString() {
		return "ResultVO [no=" + no + ", id=" + id + ", sub1=" + sub1 + ", sub2=" + sub2 + ", sub3=" + sub3 + ", sub4="
				+ sub4 + ", sub5=" + sub5 + ", aver=" + aver + ", testDate=" + testDate + "]";
	}
	
}
