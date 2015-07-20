package ServletController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Room;
import DataBase.DataService;
import DataBase.DataServiceimpl;

public class SearchServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String detail = request.getParameter("simAct");
		DataService service = new DataServiceimpl();
		ArrayList<String> allRoom = service.getRoomName();
		ArrayList<String> wantRoom = new ArrayList<String>();
		for(String one:allRoom){
			if(one.indexOf(detail)!=-1)
				wantRoom.add(one);
		}
		ArrayList<Room> list = new ArrayList<Room>();
		for(String one:wantRoom){
			String roomID = one.split("//")[0];
			String roomName = one.split("//")[1];
			String number = one.split("//")[2];
			if(roomID.equals("-1"))
				continue;
			Room room = new Room(roomID, roomName);
			room.setPnum(Integer.valueOf(number));
			list.add(room);
		}
		request.setAttribute("list", 111);
		request.setAttribute("wantroom", list);
		request.getRequestDispatcher("/page.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
