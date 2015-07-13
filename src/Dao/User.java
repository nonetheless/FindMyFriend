package Dao;
public class User {
	private String userID;
	private String userName;
	private String password;
	private boolean inRoom;
	
	public User(String userID,String username,String password){
		this.userID =userID;
		this.userName = username;
		this.password = password;
		inRoom=false;
	}
	
	public User() {
		
	}

	public boolean isInRoom() {
		return inRoom;
	}
	public void setInRoom(boolean inRoom) {
		this.inRoom = inRoom;
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
}
