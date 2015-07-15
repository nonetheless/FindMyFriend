package ServletController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DataBase.DataService;
import DataBase.DataServiceimpl;

public class OnlineServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String roomID = (String) session.getAttribute("roomID");
		DataService service = new DataServiceimpl();
		ArrayList<String> all = service.searchRoomUser(roomID);
		Map<String,String> map = new HashMap<String, String>();
		for(String user:all){
			String userID = user.split("//")[0];
			String username = user.split("//")[1];
			System.out.println(username);
			map.put(userID, username);
		}
		request.setAttribute("allUser", map);
		request.getRequestDispatcher("/main.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
