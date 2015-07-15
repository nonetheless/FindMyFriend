package Controller;

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
			String roomID = one.split("//")[0];
			String roomName = one.split("//")[1];
			String number = one.split("//")[2];
			Room room = new Room(roomID, roomName);
			room.setPnum(Integer.valueOf(number));
			list.add(room);
		}
		request.setAttribute("allRoom", list);
		request.getRequestDispatcher("").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
