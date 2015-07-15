package ServletController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataBase.DataService;
import DataBase.DataServiceimpl;

public class Messages extends HttpServlet {
	public static boolean isrun = false;
	static{
		if(!Messages.isrun){
			DataService service = new DataServiceimpl();
			service.runDataBase();
			Messages.isrun = true;
		}
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = (String) request.getParameter("action");
		if("Login".equals(action)){
			request.getRequestDispatcher("/servlet/LoginServlet").forward(request, response);
		} else if("Send".equals(action)){
			request.getRequestDispatcher("/servlet/SendServlet").forward(request, response);
		} else if("Leave".equals(action)){
			request.getRequestDispatcher("/servlet/LeaveServlet").forward(request, response);
		} else if("Get".equals(action)){
			request.getRequestDispatcher("/servlet/GetServlet").forward(request, response);
		} else if("Register".equals(action)){
			request.getRequestDispatcher("/servlet/RegisterServlet").forward(request, response);
		}
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
