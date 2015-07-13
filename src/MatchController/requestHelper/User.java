package MatchController.requestHelper;

import MatchController.requestHelper.User;

public class User {
	private String id;
	private String nickName;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public boolean equals(User another){
		if(this.id.equals(another.getId())){
			return true;
		}else{
			return false;
		}
	}
}
