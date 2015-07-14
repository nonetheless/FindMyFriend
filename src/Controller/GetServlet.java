package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.Record;
import DataBase.DataService;
import DataBase.DataServiceimpl;

public class GetServlet extends HttpServlet {
	static {
		if (!RegisterServlet.isrun) {
			DataService service = new DataServiceimpl();
			service.runDataBase();
			RegisterServlet.isrun = true;
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DataService service = new DataServiceimpl();
		HttpSession session = request.getSession();
		String roomID = (String) session.getAttribute("roomID");
		if (roomID == null)
			roomID = "00001";
		ArrayList<String> allrecord = service.getTwentyMess(roomID);
		ArrayList<Record> twentyrecord = new ArrayList<Record>();
		for (String one : allrecord) {
			String[] att = one.split("//");
			Record record = new Record();
			record.setChatroom(att[0]);
			record.setTime(att[1]);
			record.setSpeaker(att[2]);
			record.setListener(att[3]);
			record.setContent(att[4]);
			twentyrecord.add(record);
		}
		request.setAttribute("twentyrecord", twentyrecord);
		request.getRequestDispatcher("/ChatRoom1/content.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
