package ServletController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Room;
import DataBase.DataService;
import DataBase.DataServiceimpl;

public class ShowRoomServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DataService service = new DataServiceimpl();
		ArrayList<String> all = service.getRoomName();
		ArrayList<Room> list = new ArrayList<Room>();
		for(String one:all){
			System.out.println(one);
			String roomID = one.split("//")[0];
			String roomName = one.split("//")[1];
			String number = one.split("//")[2];
			if(roomID.equals("-1"))
				continue;
			Room room = new Room(roomID, roomName);
			room.setPnum(Integer.valueOf(number));
			list.add(room);
		}
		request.setAttribute("allRoom", list);
		request.getRequestDispatcher("/page.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
