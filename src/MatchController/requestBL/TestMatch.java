package MatchController.requestBL;

import java.util.ArrayList;

import DataBase.DataService;
import DataBase.DataServiceimpl;


public class TestMatch {
	public static void main(String args[]){
		Request request = new Request("soccer","8:00","19:00","2015-7-14","playground");
		MatchController matchC = new MatchController(new TestMatch().getRooms());
		matchC.match(request);
	}
	public ArrayList<NewRoom> getRooms(){
		DataService data = new DataServiceimpl();
		data.runDataBase();
		ArrayList<NewRoom> rooms = new ArrayList<NewRoom>();
		ArrayList<String> temp = data.showRoom();
		for(int i = 0;i<temp.size();i++){
			String[] temps = temp.get(i).split("//");
			System.out.println(temps[1]);
			NewRoom tempRoom = new NewRoom(temps[0],temps[1],temps[2],temps[3],temps[4]);
			rooms.add(tempRoom);
		}
		return rooms;
	}
}
