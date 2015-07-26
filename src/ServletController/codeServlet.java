package ServletController;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import DataBase.DataService;
import DataBase.DataServiceimpl;
public class codeServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		//String oldcode = request.getParameter("oldcode");
		String newcode = request.getParameter("newcode");
		HttpSession session = request.getSession();
		String userID = (String) session.getAttribute("userID");
		DataService service = new DataServiceimpl();
		service.updatePassword(userID, newcode);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}