package Dao;


public class NewUser {
	private String id;
	private String nickName;
	
	public NewUser(User user){
		this.id = user.getUserID();
		this.nickName = user.getUserName();
	}
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
	public boolean equals(NewUser another){
		if(this.id.equals(another.getId())){
			return true;
		}else{
			return false;
		}
	}
}
