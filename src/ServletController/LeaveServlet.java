package ServletController;

import java.io.IOException;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.Record;
import Dao.User;
import DataBase.DataService;
import DataBase.DataServiceimpl;

public class LeaveServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		DataService service = new DataServiceimpl();
		HttpSession session = request.getSession();
		String userID = (String) session.getAttribute("userID");
		String username = (String) session.getAttribute("username");
		String roomID = (String) session.getAttribute("roomID");
		User user = service.getUserByID(userID);
		user.setState(0);
		Record record = new Record(roomID, new Date().toLocaleString(), "System message", "all", username+"entered room!");
		service.writeChattingPO(record);
		service.writeUserPO(user);
		service.leave(userID);
		session.invalidate();
		request.getRequestDispatcher("/jumpTolog.jsp").forward(request,
				response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
