package MatchController.conditionBL;

import java.util.ArrayList;

public class MatchController {
	
	private ArrayList<Room> roomList;
	private ArrayList<Request> requestList;
	
	public ArrayList<Request> getRequestList() {
		return requestList;
	}
	public void setRequestList(ArrayList<Request> requestList) {
		this.requestList = requestList;
	}
	public ArrayList<Room> getRoomList() {
		return roomList;
	}
	public void setRoomList(ArrayList<Room> roomList) {
		this.roomList = roomList;
	}
	private String createId(){
		if(this.roomList.size() == 0){
			return "0";
		}else{
			return this.roomList.size()+1+"";
		}
	}
	private void createRoom(Request aRequest){
		String id = this.createId();
		Room room = new Room(aRequest,id);
		this.roomList.add(room);
	}
	public void match(Request request){
		boolean isExist = false;
		for(int i = 0;i<this.roomList.size();i++){
			Request temp = roomList.get(i).getCreateRequest();
			if(temp.equals(request)){
				isExist = true;
				this.roomList.get(i).addToList(request.getCreater());
				break;
			}
		}
		if(!isExist){
			this.createRoom(request);
		}
	}
}
