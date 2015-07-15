package Controller;
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
import DataBase.DataService;
import DataBase.DataServiceimpl;
import MatchController.MatchService;
import MatchController.MatchServiceImp;

public class LetInServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userID = (String) session.getAttribute("userID");
		String roomID = request.getParameter("roomID");
		if(roomID==null)
			roomID="00001";
		session.setAttribute("roomID", roomID);
		MatchService MCservice = new MatchServiceImp();
		DataService DTservice = new DataServiceimpl();
		MCservice.letIn(userID, roomID);
		String username = DTservice.getUserByID(userID).getUserName();
		Record record = new Record(roomID, new Date().toLocaleString(), "System message", "all", username+"entered room!��");
		DTservice.writeChattingPO(record);
		GetServlet.isnew=true;
		request.getRequestDispatcher("/servlet/OnlineServlet").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
