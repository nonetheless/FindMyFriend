package Dao;

public class Room {
	private String roomID;
	private String roomName;
	private String startTime;
	private String endTime;
	private String activity;
	private String location;
	private int pnum;
	public Room(String ID,String roomName){
		this.roomID=ID;
		this.roomName=roomName;
		this.startTime=roomName.split(";")[0];
		this.endTime=roomName.split(";")[1];
		this.activity=roomName.split(";")[2];
		this.location=roomName.split(";")[3];
		this.setPnum(0);
	}
	public String getRoomID() {
		return roomID;
	}
	public void setRoomID(String roomID) {
		this.roomID = roomID;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
}
