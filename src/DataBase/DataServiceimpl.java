package DataBase;

import java.util.ArrayList;

import Dao.Record;
import Dao.Room;
import Dao.User;

public class DataServiceimpl implements DataService {
	public void runDataBase() {
		DatabaseController.setConnection();
	}

	public boolean IsUserExist(String UserID,String password) {
		return DatabaseController.searchUserPO(UserID,password);
	}
	public boolean checkUser(String ID){
		return DatabaseController.checkUser(ID);
	}

	public void writeUserPO(User up) {
		DatabaseController.writeUserPO(up.getUserID(), up.getUserName(),up.getPassword(),up.getState(),up.getHead());
	}
	public void updateUserName(String ID,String name){
		DatabaseController.changeUserName(ID, name);
	}
	public void updatePassword(String ID,String password){
		DatabaseController.changePassword(ID, password);
	}
	public void updateUserHead(String ID,String head){
		DatabaseController.changeUserHead(ID, head);
	}

	//public void addNum(String ID) {
		//DatabaseController.addNum(ID);
		
	//}

	@Override
	public void writeChattingPO(Record cp) {
		DatabaseController.writeChattingPO(cp.getChatroom(), cp.getTime(), cp.getSpeaker(), cp.getListener(), cp.getContent(),cp.getHead());
		
	}

	@Override
	public void writeRoomPO(Room rp) {
		DatabaseController.writeRoomPO(rp.getRoomID(),rp.getRoomName(),rp.getStartTime(),rp.getEndTime(),rp.getActivity(),rp.getLocation(),rp.getPnum());
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
	public void leave(String userID){
		DatabaseController.leave(userID);
	}
	public void come(String userID,String roomID){
		DatabaseController.come(userID, roomID);
	}
	public ArrayList<String> searchRoomUser(String roomID){
		return DatabaseController.searchRoomUser(roomID);
	}

	@Override
	public void deleteRoom(String ID) {
		DatabaseController.deleteRoom(ID);
		
	}

	@Override
	public ArrayList<String> getRoomName() {
		return DatabaseController.getRoomName();
	}

	@Override
	public int getPNumByID(String ID) {
		return DatabaseController.getPNumByID(ID);
	}

	//public void subNum(String ID) {
		//DatabaseController.subNum(ID);
	//}
}
