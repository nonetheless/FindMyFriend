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
import Dao.Record;
import Dao.Request;
import Dao.Room;
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
		String start = request.getParameter("start").split(";")[1];
		String end = request.getParameter("end").split(";")[1];
		String date = request.getParameter("start").split(";")[0];
		String userID = (String)request.getSession().getAttribute("userID");
		String location = request.getParameter("place");
		Request activityrequest = new Request(activity, start, end, date, location);
		MatchService MCservice = new MatchServiceImp();
		DataService DTservice = new DataServiceimpl();
		User user = DTservice.getUserByID(userID);
		if("CreateRoom".equals(kind)){
			User create = DTservice.getUserByID(userID);
			if(create.getState()==1){
				return;
			}
			create.setState(1);
			DTservice.writeUserPO(create);
			activityrequest.setCreater(create);
			String roomID = MCservice.Createroom(activityrequest);
			request.setAttribute("roomID", roomID);
			HttpSession session = request.getSession();
			session.setAttribute("roomID", roomID);
			Record record = new Record(roomID, new Date().toLocaleString(), "System message", "all", user.getUserName()+"entered room!","avatar-1.png");
			DTservice.writeChattingPO(record);
			GetServlet.isnew=true;
			OnlineServlet.newcome = true;
			request.getRequestDispatcher("/servlet/OnlineServlet").forward(request, response);
		}else if("SearchRoom".equals(kind)){
			ArrayList<NewRoom> list = MCservice.match(activityrequest);
			ArrayList<Room> list1 = new ArrayList<Room>();
			int i = list.size();
			for(int j=0;j<i;j++){
				list1.add(list.get(j).toRoom());
			}
			request.setAttribute("list", 111);
			request.setAttribute("wantroom", list1);
			request.getRequestDispatcher("/page.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doGet(request, response);
		}
}