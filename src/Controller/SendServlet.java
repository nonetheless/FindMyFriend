package Controller;

import java.io.IOException;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.Record;
import DataBase.DataService;
import DataBase.DataServiceimpl;

public class SendServlet extends HttpServlet {
	static{
		if(!RegisterServlet.isrun){
			DataService service = new DataServiceimpl();
			service.runDataBase();
			RegisterServlet.isrun = true;
		}
	}
	public static boolean isnew = false;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DataService service = new DataServiceimpl();
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");
		String content = request.getParameter("content"); //��������
        String sendTime = new Date().toLocaleString(); //����ʱ��
        String roomID = (String) session.getAttribute("roomID");
        if(roomID==null)
        	roomID = "00001";
        Record record = new Record(roomID,sendTime,username,"all",content);
        service.writeChattingPO(record);
        isnew = true;
        request.getRequestDispatcher("/ChatRoom1/servlet/GetServlet").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}