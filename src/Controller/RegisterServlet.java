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
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String userID = request.getParameter("userID");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username);
		DataService service = new DataServiceimpl();
		PrintWriter out = response.getWriter();
		if(!service.checkUser(userID)){
			User user = new User(userID, username, password);
			service.writeUserPO(user);
			request.getRequestDispatcher("/main.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/registerfailed.html").forward(request, response);
		}
		System.out.println(service.getUserByID(userID).getUserName());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
