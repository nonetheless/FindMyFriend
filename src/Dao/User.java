package Dao;
public class User {
	private String userID;
	private String userName;
	private String password;
	private int state;
	private String head;
	public User(String userID,String username,String password){
		this.userID =userID;
		this.userName = username;
		this.password = password;
		setState(0);
		this.head = "avatar-1.png";
	}
	
	public User() {
		
	}

	public String getUserID(){
		return userID;
	}
	public String getUserName(){
		return userName;
	}
	public void  setUserID(String userid){
		this.userID = userid;
	}
	public void setUserName(String username){
		this.userName=username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}
}
