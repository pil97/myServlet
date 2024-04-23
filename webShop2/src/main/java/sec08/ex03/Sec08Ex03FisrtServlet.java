package sec08.ex03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Sec08Ex03FisrtServlet")
public class Sec08Ex03FisrtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Sec08Ex03FisrtServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.println("<script type='text/javascript'>");
		out.println("location href='/Sec08Ex03SecondServlet'");
		out.println("script");
	}

}
