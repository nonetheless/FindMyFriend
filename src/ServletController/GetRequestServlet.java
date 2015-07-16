package ServletController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.NewRoom;
import Dao.NewUser;
import Dao.Record;
import Dao.Request;
import Dao.User;
import DataBase.DataService;
import DataBase.DataServiceimpl;
import LogicController.MatchService;
import LogicController.MatchServiceImp;

public class GetRequestServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String kind = request.getParameter("kind");
		String activity = request.getParameter("activity");
		String starthour = request.getParameter("starthour");
		String startmin = request.getParameter("startmin");
		String start = starthour+":"+startmin;
		String endhour = request.getParameter("endhour");
		String endmin = request.getParameter("endmin");
		String end = endhour+":"+endmin;
		String date = request.getParameter("date");
		String userID = (String)request.getSession().getAttribute("userID");
		String location = request.getParameter("place");
		Request activityrequest = new Request(activity, start, end, date, location);
		MatchService MCservice = new MatchServiceImp();
		DataService DTservice = new DataServiceimpl();
		User user = DTservice.getUserByID(userID);
		if("CreateRoom".equals(kind)){
			User create = DTservice.getUserByID(userID);
			activityrequest.setCreater( new NewUser(create));
			String roomID = MCservice.Createroom(activityrequest);
			request.setAttribute("roomID", roomID);
			HttpSession session = request.getSession();
			session.setAttribute("roomID", roomID);
			Record record = new Record(roomID, new Date().toLocaleString(), "System message", "all", user.getUserName()+"entered room!");
			DTservice.writeChattingPO(record);
			GetServlet.isnew=true;
			request.getRequestDispatcher("/servlet/OnlineServlet").forward(request, response);
		}else if("SearchRoom".equals(kind)){
			ArrayList<NewRoom> list = MCservice.match(activityrequest);
			request.setAttribute("wantroom", list);
			request.getRequestDispatcher("/searchresult.jsp").forward(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doGet(request, response);
		}
}