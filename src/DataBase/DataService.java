package DataBase;

import java.util.ArrayList;

import Dao.Record;
import Dao.Room;
import Dao.User;

public interface DataService {
	public void runDataBase();
	public boolean IsUserExist(String userID,String password);
	public boolean checkUser(String ID);
	public void writeUserPO(User up);
	public void updateUserPO(String ID,String name);
	//public void addNum(String ID);
	//public void subNum(String ID);
	public void writeChattingPO(Record cp);
	public void writeRoomPO(Room rp);
	public boolean isRoomExist(String roomID);
	public ArrayList<String> getTwentyMess(String ID);
	public ArrayList<String> showRoom();
	public User getUserByID(String ID);
	public void setStateIn(String ID);
	public void setStateOut(String ID);
	public void leave(String userID );
	public void come(String userID,String roomID);
	public ArrayList<String> searchRoomUser(String roomID);
	public void deleteRoom(String ID);
	public ArrayList<String> getRoomName();
	public int getPNumByID(String ID);
}
