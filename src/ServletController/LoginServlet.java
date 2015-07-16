package ServletController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

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

public class LoginServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String userID = request.getParameter("userID");
		String password = request.getParameter("password");
		DataService service = new DataServiceimpl();
		PrintWriter out = response.getWriter();
		if (!service.IsUserExist(userID, password)) {
			request.getRequestDispatcher("/loginfailed.html").forward(request, response);
		} else {
			User user = service.getUserByID(userID);
			if (user.getState()==1) {
				out.write("请先退出其他房间！");
			} else {
				user.setState(1);
				//service.writeUserPO(user);
				String username = user.getUserName();
				HttpSession session = request.getSession();
				session.setAttribute("userID", userID);
				session.setAttribute("username", username); // ���浱ǰ��¼���û���
				session.setAttribute("loginTime", new Date().toLocaleString()); // �����¼ʱ��
				String roomID = request.getParameter("roomID");
				/*if(roomID==null)
					roomID = "00001";
				session.setAttribute("roomID", roomID);
				Record record = new Record(roomID, new Date().toLocaleString(), "System message", "all", username+"entered room!");
				service.writeChattingPO(record);
				GetServlet.isnew=true;*/
				//request.getRequestDispatcher("/servlet/LetInServlet").forward(request, response);
				request.getRequestDispatcher("/servlet/ShowRoomServlet").forward(request, response);
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
