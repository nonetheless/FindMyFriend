package Dao;

public class Record {
	private String chatroomID;
	private String time;
	private String speaker;
	private String listener;
	private String content;
	public Record(String chatroom,String time,String speaker,String listener,String content){
		this.listener=listener;
		this.chatroomID=chatroom;
		this.time=time;
		this.speaker=speaker;
		this.content=content;
	}
	public String getChatroom() {
		return chatroomID;
	}
	public void setChatroom(String chatroom) {
		this.chatroomID = chatroom;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getSpeaker() {
		return speaker;
	}
	public void setSpeaker(String speaker) {
		this.speaker = speaker;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getListener() {
		return listener;
	}
	public void setListener(String listener) {
		this.listener = listener;
	}
}
