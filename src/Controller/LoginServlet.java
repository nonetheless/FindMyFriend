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

import Dao.Record;
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
			out.print("�˻�/�û��������");
		} else {
			User user = service.getUserByID(userID);
			if (user.getState()==1) {
				out.write("�����˳���������");
			} else {
				user.setState(1);
				String username = user.getUserName();
				HttpSession session = request.getSession();
				session.setAttribute("username", username); // ���浱ǰ��¼���û���
				session.setAttribute("loginTime", new Date().toLocaleString()); // �����¼ʱ��
				String roomID = request.getParameter("roomID");
				Record record = new Record(roomID, new Date().toLocaleString(), "ϵͳ��Ϣ", "all", username+"���뷿��");
				service.writeChattingPO(record);
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
