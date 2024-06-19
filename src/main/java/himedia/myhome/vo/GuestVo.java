package himedia.myhome.vo;

import java.util.Date;

public class GuestVo {
	
	private Long no;
	private String name;
	private String password;
	private String content;
	private Date date;
	

	public GuestVo() {
		super();
	}
	


	public GuestVo(Long no, String name, String password, String content, Date date) {
		super();
		this.no = no;
		this.name = name;
		this.password = password;
		this.content = content;
		this.date = date;
	}

	


	public GuestVo(String name, String password, String content) {
		super();
		this.name = name;
		this.password = password;
		this.content = content;
	}



	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "GuestVo [no=" + no + ", name=" + name + ", password=" + password + ", content=" + content + ", date="
				+ date + "]";
	}


	

}
