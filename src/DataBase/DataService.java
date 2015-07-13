package DataBase;

import java.util.ArrayList;

import Dao.Record;
import Dao.Room;
import Dao.User;

public interface DataService {
	public void runDataBase();//运行数据库并发写
	public boolean IsUserExist(String userID,String password);
	public boolean checkUser(String ID);
	public void writeUserPO(User up);
	public void updateUserPO(String ID,String name);
	public void updateNum(String ID);
	public void wtiteChattingPO(Record cp);
	public void writeRoomPO(Room rp);
	public boolean isRoomExist(String roomID);
	public ArrayList<String> getTwentyMess(String ID);
	public ArrayList<String> showRoom();
	public User getUserByID(String ID);
	public void setStateIn(String ID);
	public void setStateOut(String ID);
	public void leave(String userID );
	public void come(String userID,String roomID);
	public void end(String roomID);
	public ArrayList<String> search(String roomID);
}
