package MatchController;

import java.util.ArrayList;

import Dao.Room;
import Dao.User;
import DataBase.DataService;
import DataBase.DataServiceimpl;

public class NewRoom {
	
	private Request createRequest;
	private String id;
	private ArrayList<NewUser> userList;
	
	public NewRoom(Room room){
		this.createRequest = new Request(room.getActivity(),room.getStartTime(),room.getEndTime(),room.getStartTime().split(" ")[0],room.getLocation());
		this.id = room.getRoomID();
		userList = new ArrayList<NewUser>();
	}
	public NewRoom(String id,String start,String end,String activity,String location){
		this.createRequest = new Request(activity,start.split(" ")[1],end.split(" ")[1],end.split(" ")[0],location);
		this.id = id;
		userList = new ArrayList<NewUser>();
	}
	public NewRoom(Request createRequest,String id){
		this.userList = new ArrayList<NewUser>();
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
	public ArrayList<NewUser> getUserList() {
		return userList;
	}
	public void setUserList(ArrayList<NewUser> userList) {
		this.userList = userList;
	}
	public Request getCreateRequest() {
		return createRequest;
	}
	public void setCreateRequest(Request createRequest) {
		this.createRequest = createRequest;
	}
	public void addToList(NewUser newUser){
		this.userList.add(newUser);
		DataService data = new DataServiceimpl();
		data.come(newUser.getId(), this.id);
	}
	public void subInList(NewUser newUser){
		for(int i = 0;i<this.userList.size();i++){
			NewUser temp = userList.get(i);
			if(temp.equals(newUser)){
				this.userList.remove(i);
				DataService data = new DataServiceimpl();
				data.leave(newUser.getId());
				break;
			}
		}
	}
	public Room toRoom(){
		String start = this.createRequest.getTime().getStartTime();
		String end = this.createRequest.getTime().getEndTime();
		String date = this.createRequest.getTime().getDate();
		String activity = String.valueOf(this.createRequest.getActivity());
		String location = this.createRequest.getPlace().getName();
		
		String name = date+" "+start+";"+date+" "+end+";"+activity+";"+location;
		
		return new Room(this.id,name);
	}
}
