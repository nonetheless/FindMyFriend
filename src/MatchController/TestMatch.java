package MatchController;

import java.util.ArrayList;

import Dao.User;
import DataBase.DataService;
import DataBase.DataServiceimpl;


public class TestMatch {
	public static void main(String args[]){
		DataService data = new DataServiceimpl();
		data.runDataBase();
		User lzt = data.getUserByID("kkk");//new User("374698133@qq.com","shuaibiliu","123");
		//data.writeUserPO(lzt);
		Request request = new Request("diablo3","8:00","23:00","2015-7-15",lzt,"sushe");
		MatchController matchC = new MatchController(new TestMatch().getRooms());
		//matchC.match(request);
		//matchC.deleteRoom();
		matchC.letIn(lzt.getUserID(), "5");
	}
	public ArrayList<NewRoom> getRooms(){
		DataService data = new DataServiceimpl();
		data.runDataBase();
		ArrayList<NewRoom> rooms = new ArrayList<NewRoom>();
		ArrayList<String> temp = data.showRoom();
		for(int i = 0;i<temp.size();i++){
			String[] temps = temp.get(i).split("//");
			//System.out.println(temps[1]);
			NewRoom tempRoom = new NewRoom(temps[0],temps[1],temps[2],temps[3],temps[4]);
			rooms.add(tempRoom);
		}
		return rooms;
	}
}
