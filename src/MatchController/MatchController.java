package MatchController;

import java.util.ArrayList;

import Dao.Room;
import DataBase.DataService;
import DataBase.DataServiceimpl;

public class MatchController {
	
	private ArrayList<NewRoom> roomList;
	
	public MatchController(ArrayList<NewRoom> rooms){
		roomList = rooms;
	}
	public ArrayList<NewRoom> getRoomList() {
		return roomList;
	}
	public void setRoomList(ArrayList<NewRoom> roomList) {
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
		NewRoom room = new NewRoom(aRequest,id);
		this.roomList.add(room);
		Room temp = room.toRoom();
		DataService data = new DataServiceimpl();
		data.writeRoomPO(temp);
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
