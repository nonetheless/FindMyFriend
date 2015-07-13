package DataBase;

import java.util.ArrayList;

import Dao.Record;
import Dao.Room;
import Dao.User;

public class DataServiceimpl implements DataService {
	Concurrent ucon =new UserConcurrent();
	Concurrent rcon=new RoomConcurrent();
	public void runDataBase() {
		DatabaseController.setConnection();
		//Concurrent ucon =new UserConcurrent();
		//Concurrent rcon=new RoomConcurrent();
		Thread t1=new Thread(ucon);
		Thread t2=new Thread(rcon);
		t1.start();
		t2.start();
	}

	public boolean IsUserExist(String UserID,String password) {
		return DatabaseController.searchUserPO(UserID,password);
	}
	public boolean checkUser(String ID){
		return DatabaseController.checkUser(ID);
	}

	public void writeUserPO(User up) {
		 ucon.writeOne(up);
		
	}
	public void updateUserPO(String ID,String name){
		DatabaseController.changeUserName(ID, name);
	}

	@Override
	public void updateNum(String ID) {
		DatabaseController.updateNum(ID);
		
	}

	@Override
	public void wtiteChattingPO(Record cp) {
		DatabaseController.writeChattingPO(cp.getChatroom(), cp.getTime(), cp.getSpeaker(), cp.getListener(), cp.getContent());
		
	}

	@Override
	public void writeRoomPO(Room rp) {
		rcon.writeOne(rp);
		
	}

	@Override
	public boolean isRoomExist(String roomID) {
		return DatabaseController.checkRoomID(roomID);
	}

	@Override
	public ArrayList<String> getTwentyMess(String ID) {
		return DatabaseController.getTwentyMess(ID);
	}

	@Override
	public ArrayList<String> showRoom() {
		return DatabaseController.showRoom();
	}

	public User getUserByID(String ID) {
		return DatabaseController.getUserByID(ID);
	}

	@Override
	public void setStateIn(String ID) {
		DatabaseController.setUserState(ID);
	}

	@Override
	public void setStateOut(String ID) {
		DatabaseController.ReturnState(ID);
	}
}
