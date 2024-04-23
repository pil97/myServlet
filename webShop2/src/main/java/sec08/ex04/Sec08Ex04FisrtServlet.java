package sec08.ex04;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Sec08Ex04FisrtServlet")
public class Sec08Ex04FisrtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Sec08Ex04FisrtServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		RequestDispatcher dispatch = request.getRequestDispatcher("/Sec08Ex04SecondServlet");
		dispatch.forward(request, response);
	}

}
