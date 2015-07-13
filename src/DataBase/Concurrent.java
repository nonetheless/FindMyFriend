package DataBase;

import java.util.concurrent.LinkedBlockingQueue;

public abstract class Concurrent implements Runnable{
	//private static LinkedBlockingQueue<UserPO> queue = new LinkedBlockingQueue<UserPO>();

	/*public static void main(String[] args) {
		while (true) {
			UserPO e = queue.poll();
			// System.out.println("here");
			if (e != null) {
			
			}
		}

	}*/

	public void writeOne(Object wm) {
		// TODO Auto-generated method stub
		
	}/* {
		try {
			queue.put(wm);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	public abstract void run();/*{
		while(true){
			UserPO up=queue.poll();
			if(up!=null){
				DatabaseController.writeUserPO(up.getUserID(), up.getUserName(),up.getPassword());
			}
		}
	}*/
}
