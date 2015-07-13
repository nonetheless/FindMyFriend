package DataBase;

import java.util.concurrent.LinkedBlockingQueue;

import Dao.Room;
import Dao.RoomUserPO;

public class RoomUserListConcurrent extends Concurrent implements Runnable{
	private static LinkedBlockingQueue<RoomUserPO> queue = new LinkedBlockingQueue<RoomUserPO>();

public void come(String userID,String roomID){
	try {
		queue.put(new RoomUserPO(userID,roomID,1));
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void leave(String userID,String roomID){
	try {
		queue.put(new RoomUserPO(userID,roomID,0));
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	public void run() {

		while(true){
			RoomUserPO up=queue.poll();
			if(up!=null){
				if(up.getA()==1){
					DatabaseController.come(up.getuserID(), up.getroomID());
				}
				else{
					DatabaseController.leave(up.getuserID(), up.getroomID());
				}
			}
			else{
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	
		
	}
}
