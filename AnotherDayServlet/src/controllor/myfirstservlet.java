package controllor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class myfirstservlet
 */
@WebServlet(name = "servlet1", urlPatterns = { "/servlet1" })
public class myfirstservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public myfirstservlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<HEAD><TITLE> Preferences Servlet </TITLE></HEAD>");
		out.println("<BODY><H1> Preferences Servlet</H1>");
		out.println("<UL>");
		out.println("<L1><B> Name:</B>" + request.getParameter("name"));
		out.println("<L1><B> Colour: </B>" + request.getParameter("colour"));
		out.println("</UL>");
		out.println("</body></HTML>");

	}

}
