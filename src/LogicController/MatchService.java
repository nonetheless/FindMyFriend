package LogicController;

import java.util.ArrayList;

import Dao.NewRoom;
import Dao.Request;

public interface MatchService {
	
	public abstract ArrayList<NewRoom> match(Request request); //request -> join or create a room
	public abstract void cleanRoom();      // delete rooms that are out of date
	public abstract void letIn(String userId,String roomId); // use come() in data,when user
	public String Createroom(Request request);                                   							//choose a room to join
}            
