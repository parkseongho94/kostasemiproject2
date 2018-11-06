package eip.mvc.model.dto;

public class UserVO {

	/*private int id;
	private String pwd;
	public UserVO(int id, String pwd) {
		super();
		this.id = id;
		this.pwd = pwd;
	}
	public UserVO() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	*/
	private String id;
	private String pwd;
	private int manager;
	
	public UserVO() {}
	public UserVO(String id, String pwd, int manager) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.manager = manager;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getManager() {
		return manager;
	}
	public void setManager(int manager) {
		this.manager = manager;
	}
	@Override
	public String toString() {
		return "UserVO [id=" + id + ", pwd=" + pwd + ", manager=" + manager + "]";
	}
	
	
	
	
	
	
}
