package ServletController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataBase.DataService;
import DataBase.DataServiceimpl;

public class SearchServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String detail = request.getParameter("simAct");
		DataService service = new DataServiceimpl();
		ArrayList<String> allRoom = service.showRoom();
		ArrayList<String> wantRoom = new ArrayList<String>();
		for(String one:allRoom){
			if(one.indexOf(detail)!=-1)
				wantRoom.add(one);
		}
		request.setAttribute("list", 111);
		request.setAttribute("wantroom", wantRoom);
		request.getRequestDispatcher("/page.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
