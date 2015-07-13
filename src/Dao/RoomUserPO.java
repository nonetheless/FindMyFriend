package Dao;

public class RoomUserPO {
private String roomID;
private String userID;
private int a;
public RoomUserPO(String userID,String roomID,int a){
	this.roomID=roomID;
	this.userID=userID;
	this.a=a;
}
public String getroomID(){
	return this.roomID;
}
public String getuserID(){
	return this.userID;
}
public int getA(){
	return this.a;
}
}
