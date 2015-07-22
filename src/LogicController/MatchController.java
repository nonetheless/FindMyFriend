package LogicController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Dao.NewRoom;
import Dao.Request;
import Dao.Room;
import DataBase.DataService;
import DataBase.DataServiceimpl;

public class MatchController {
	
	private ArrayList<NewRoom> roomList;
	DataService data;
	
	public MatchController(ArrayList<NewRoom> rooms){
		roomList = rooms;
		data = new DataServiceimpl();
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
			return Integer.valueOf(this.roomList.get(roomList.size()-1).getId())+1+"";
		}
	}
	
	public String createRoom(Request aRequest){
		String id = this.createId();
		NewRoom room = new NewRoom(aRequest,id);
		this.roomList.add(room);
		Room temp = room.toRoom();
		data.writeRoomPO(temp);
		data.come(aRequest.getCreater().getUserID(), room.getId());
		return room.getId();
	}
	
	public void deleteRoom(){
		 Date date=new Date();
		 DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 String time=format.format(date);
		 String nowDate = time.split(" ")[0];
		 String nowTime = time.split(" ")[1];
		 int noD = this.DateintoDay(nowDate);
		 int now = this.TimeIntoSecond(nowTime);
		 for(int i = 0;i<this.roomList.size();i++){
			 String tempDate = roomList.get(i).getCreateRequest().getTime().getDate();					 
			 String tempEnd	 = roomList.get(i).getCreateRequest().getTime().getEndTime();
			 int temD = this.DateintoDay(tempDate);
			 int temp = this.TimeIntoSecond(tempEnd);
			 //System.out.println(nowDate+" "+tempDate);
			 //System.out.println(nowTime+" "+tempEnd);
			 if((noD-temD>=0)&&(now-temp>=0)){
				 //System.out.println("1");
				 data.deleteRoom(roomList.get(i).getId());
			 }
		 }
	}
	private int DateintoDay(String date){
		String[] temp = date.split("-");
		int year = Integer.parseInt(temp[0]);
		int month = Integer.parseInt(temp[1]);
		int day = Integer.parseInt(temp[2]);
		
		return 365*(year-1)+30*(month-1)+day;
	}
	private int TimeIntoSecond(String time){
		
		String[] temp = time.split(":");
		int hour = Integer.parseInt(temp[0]);
		int min = Integer.parseInt(temp[1]);
		int second = 0;
		int total = -1;
		
		if(hour>=0&&hour<=24&&min>=0&&min<60){
			total = hour*60*60+min*60+second;
		}
		return total;
	}
	public ArrayList<NewRoom> match(Request request){         		
		ArrayList<NewRoom> result = new ArrayList<NewRoom>();
		for(int i = 0;i<this.roomList.size();i++){
			Request temp = roomList.get(i).getCreateRequest();
			if(temp.equals(request)){
				result.add(roomList.get(i));
			}
		}
		return result;
	}
	
	public void letIn(String userId,String roomId){
		data.come(userId, roomId);
	}
}
