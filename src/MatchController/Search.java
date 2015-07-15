package MatchController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Search extends HttpServlet {
	String activity;
	String start;
	String end;
	String date;
	String user;
	String location;
//	public Search() {
//		super();
//	}
//	public void destroy() {
//		super.destroy();
//		
//	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		activity = request.getParameter("activity");
		String starthour = request.getParameter("starthour");
		String startmin = request.getParameter("startmin");
		start = starthour+":"+startmin;
		String endhour = request.getParameter("endhour");
		String endmin = request.getParameter("endmin");
		end = endhour+":"+endmin;
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		date = year+"-"+month+"-"+day;
		user = "666";
		location = request.getParameter("place");
		System.out.println(activity+"£»"+start+"£»"+end+"£»"+date+"£»"+user+"£»"+location);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}
//	public void init() throws ServletException {
//		
//	}
}