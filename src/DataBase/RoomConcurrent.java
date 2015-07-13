package DataBase;

import java.util.concurrent.LinkedBlockingQueue;

import Dao.Room;


public class RoomConcurrent extends Concurrent implements Runnable{
	private static LinkedBlockingQueue<Room> queue = new LinkedBlockingQueue<Room>();

	public void writeOne(Object wm) {
		try {
			queue.put((Room)wm);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void run(){
		while(true){
			Room rp=queue.poll();
			if(rp!=null){
				DatabaseController.writeRoomPO(rp.getRoomID(),rp.getRoomName(),rp.getStartTime(),rp.getEndTime(),rp.getActivity(),rp.getLocation(),rp.getPnum());
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
