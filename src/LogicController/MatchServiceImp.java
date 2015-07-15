package LogicController;

import java.util.ArrayList;

import Dao.NewRoom;
import Dao.Request;
import DataBase.DataService;
import DataBase.DataServiceimpl;

public class MatchServiceImp implements MatchService{

	private ArrayList<NewRoom> roomList;
	private MatchController matchC;
	
	public MatchServiceImp(){
		roomList = getRooms();
		matchC = new MatchController(roomList);
	}
	
	public ArrayList<NewRoom> getRooms(){
		DataService data = new DataServiceimpl();
		data.runDataBase();
		ArrayList<NewRoom> rooms = new ArrayList<NewRoom>();
		ArrayList<String> temp = data.showRoom();
		for(int i = 0;i<temp.size();i++){
			String[] temps = temp.get(i).split("//");
			NewRoom tempRoom = new NewRoom(temps[0],temps[1],temps[2],temps[3],temps[4]);
			rooms.add(tempRoom);
		}
		return rooms;
	}
	@Override
	public ArrayList<NewRoom> match(Request request) {
		return matchC.match(request);
	}

	@Override
	public void cleanRoom() {
		matchC.deleteRoom();
	}

	@Override
	public void letIn(String userId, String roomId) {
		matchC.letIn(userId, roomId);
	}

	@Override
	public String Createroom(Request request) {
		return matchC.createRoom(request);
	}

}
