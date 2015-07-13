package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.User;
import DataBase.DataService;
import DataBase.DataServiceimpl;

public class LoginServlet extends HttpServlet {
	static{
		if(!RegisterServlet.isrun){
			DataService service = new DataServiceimpl();
			service.runDataBase();
			RegisterServlet.isrun = true;
		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userID = request.getParameter("userID");
		String password = request.getParameter("password");
		System.out.println(userID+":"+password);
		DataService service = new DataServiceimpl();
		PrintWriter out = response.getWriter();
		if (!service.IsUserExist(userID, password)) {
			out.print("账户/用户密码错误！");
		} else {
			User user = service.getUserByID(userID);
			if (user.isInRoom()) {
				out.write("请先退出其他房间");
			} else {
				String username = user.getUserName();
				HttpSession session = request.getSession();
				session.setAttribute("username", username); // 保存当前登录的用户名
				session.setAttribute("loginTime", new Date().toLocaleString()); // 保存登录时间
				ServletContext application = getServletContext();
				String sourceMessage = "";
				if (null != application.getAttribute("message")) {
					sourceMessage = application.getAttribute("message")
							.toString();
				}
				sourceMessage += "系统公告：<font color='gray'>" + username
						+ "进入聊天室！</font><br>";
				application.setAttribute("message", sourceMessage);
				request.getRequestDispatcher("login_ok.jsp").forward(request,
						response);
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
