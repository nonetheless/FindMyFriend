package ServletController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;

import Dao.Record;
import DataBase.DataService;
import DataBase.DataServiceimpl;

public class GetServlet extends HttpServlet {
	public static boolean isnew = false;
	public static Map<String,ArrayList<Record>> twentyrecord = new LinkedHashMap<String, ArrayList<Record>>();
  	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String roomID = (String) session.getAttribute("roomID");
		if (!isnew) {
			request.setAttribute("record", twentyrecord);
			request.getRequestDispatcher("/content.jsp").forward(request, response);
		}
		else {
			System.out.println("New Message!");
			DataService service = new DataServiceimpl();
			ArrayList<String> allrecord = service.getTwentyMess(roomID);
			ArrayList<Record> all = new ArrayList<Record>();
			for (int i=allrecord.size()-1;i>=0;i--) {
				String one = allrecord.get(i);
				String[] att = one.split("//");
				Record record = new Record();
				record.setChatroom(att[0]);
				record.setTime(att[1]);
				record.setSpeaker(att[2]);
				record.setListener(att[3]);
				record.setContent(att[4]);
				record.setHead(att[5]);
				all.add(record);
				twentyrecord.put(roomID,all);
			}
			request.setAttribute("record", twentyrecord);
			isnew = false;
			request.getRequestDispatcher("/content.jsp").forward(request, response);
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
