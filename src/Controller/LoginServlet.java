package Controller;

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
				out.write("请先退出其他房间");
			} else {
				user.setState(1);
				String username = user.getUserName();
				HttpSession session = request.getSession();
				session.setAttribute("userID", userID);
				session.setAttribute("username", username); // 保存当前登录的用户名
				session.setAttribute("loginTime", new Date().toLocaleString()); // 保存登录时间
				String roomID = request.getParameter("roomID");
				if(roomID==null)
					roomID = "00001";
				session.setAttribute("roomID", roomID);
				Record record = new Record(roomID, new Date().toLocaleString(), "系统消息", "all", username+"进入房间");
				service.writeChattingPO(record);
				GetServlet.isnew=true;
				request.getRequestDispatcher("/main.jsp").forward(request,
						response);
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
