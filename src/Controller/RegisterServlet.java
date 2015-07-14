package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.User;
import DataBase.DataService;
import DataBase.DataServiceimpl;

public class RegisterServlet extends HttpServlet {
	public static boolean isrun=false;
	static{
		if(!isrun){
			DataService service = new DataServiceimpl();
			service.runDataBase();
			isrun = true;
		}
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String userID = request.getParameter("userID");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		DataService service = new DataServiceimpl();
		PrintWriter out = response.getWriter();
		if(!service.checkUser(userID)){
			User user = new User(userID, username, password);
			service.writeUserPO(user);
			out.write("注册成功！");
		}else{
			out.write("用户名已存在");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
