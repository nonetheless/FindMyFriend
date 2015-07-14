package MatchController;

public interface MatchService {
	
	public abstract void match(Request request); //request -> join or create a room
	public abstract void cleanRoom();      // delete rooms that are out of date
	public abstract void letIn(String userId,String roomId); // use come() in data,when user
	                                   							//choose a room to join
}            
