package ServletController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.Record;
import Dao.User;
import DataBase.DataService;
import DataBase.DataServiceimpl;

public class OnlineServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userID = (String) session.getAttribute("userID");
		String roomID = (String) request.getParameter("roomID");
		if(roomID!=null)
			session.setAttribute("roomID", roomID);
		DataService service = new DataServiceimpl();
		User user = service.getUserByID(userID);
		ArrayList<String> all = service.searchRoomUser(roomID);
		Map<String,String> map = new HashMap<String, String>();
		for(String one:all){
			String ID = one.split("//")[0];
			String username = one.split("//")[1];
			map.put(ID, username);
		}
		System.out.println("map size:"+map.size());
		request.setAttribute("allUser", map);
		/*Record record = new Record(roomID, new Date().toLocaleString(), "System message", "all", user.getUserName()+"entered room!");
		service.writeChattingPO(record);
		GetServlet.isnew=true;*/
		request.getRequestDispatcher("/jump.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
