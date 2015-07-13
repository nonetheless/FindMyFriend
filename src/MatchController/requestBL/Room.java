package MatchController.requestBL;

import java.util.ArrayList;

import MatchController.requestHelper.User;

public class Room {
	
	private Request createRequest;
	private String id;
	private ArrayList<User> userList;
	
	public Room(Request createRequest,String id){
		this.userList = new ArrayList<User>();
		this.createRequest = createRequest;
		this.id = id;
		userList.add(createRequest.getCreater());
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ArrayList<User> getUserList() {
		return userList;
	}
	public void setUserList(ArrayList<User> userList) {
		this.userList = userList;
	}
	public Request getCreateRequest() {
		return createRequest;
	}
	public void setCreateRequest(Request createRequest) {
		this.createRequest = createRequest;
	}
	public void addToList(User newUser){
		this.userList.add(newUser);
	}
	public void subInList(User newUser){
		for(int i = 0;i<this.userList.size();i++){
			User temp = userList.get(i);
			if(temp.equals(newUser)){
				this.userList.remove(i);
				break;
			}
		}
	}
}
