package ServletController;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class codeServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		request.setCharacterEncoding("utf-8");
		String oldcode = request.getParameter("oldcode");
		String newcode = request.getParameter("newcode");
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}