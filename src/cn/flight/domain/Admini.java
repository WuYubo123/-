package cn.flight.domain;

public class Admini {
	public String username;
	public String password;
	
	public Admini(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public Admini() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "admini [username=" + username + ", password=" + password + "]";
	}
	
	

}
