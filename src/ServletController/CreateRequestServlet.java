package ServletController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.NewRoom;
import Dao.NewUser;
import Dao.Request;
import Dao.User;
import LogicController.MatchService;
import LogicController.MatchServiceImp;

public class CreateRequestServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String activity = request.getParameter("activity");
		String starthour = request.getParameter("starthour");
		String startmin = request.getParameter("startmin");
		String start = starthour+":"+startmin;
		String endhour = request.getParameter("endhour");
		String endmin = request.getParameter("endmin");
		String end = endhour+":"+endmin;
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String date = year+"-"+month+"-"+day;
		String location = request.getParameter("place");
		
		HttpSession session = request.getSession();
		String userID = (String)session.getAttribute("userID");
		Request activityrequest = new Request(activity, start, end, date, location);
		User user = new User();
		user.setUserID(userID);
		NewUser newUser = new NewUser(user);
		activityrequest.setCreater(newUser);
		MatchService MCservice = new MatchServiceImp();
		String roomID = MCservice.Createroom(activityrequest);
		session.setAttribute("roomID", roomID);
		request.getRequestDispatcher("/main.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
