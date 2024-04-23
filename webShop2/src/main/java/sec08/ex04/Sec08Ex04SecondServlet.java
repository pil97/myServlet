package sec08.ex04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Sec08Ex04SecondServlet")
public class Sec08Ex04SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Sec08Ex04SecondServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");

		// 서버에서 클라이언트에게 데이터를 쓰고자 할때 사용하는 출력스트림 생성
		PrintWriter out = response.getWriter();

		out.println("<html><body>");
		out.println("dispatch를 이용한 forward 실습입니다.");
		out.println("</body></html>");
	}

}
