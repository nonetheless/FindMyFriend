package DataBase;

import java.util.concurrent.LinkedBlockingQueue;

import Dao.User;

public class UserConcurrent extends Concurrent implements Runnable{
	private static LinkedBlockingQueue<User> queue = new LinkedBlockingQueue<User>();

	public void writeOne(Object wm) {
		try {
			queue.put((User)wm);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void run(){
		while(true){
			User up=queue.poll();
			if(up!=null){
				DatabaseController.writeUserPO(up.getUserID(), up.getUserName(),up.getPassword(),up.getState());
			}
		}
	}
}
