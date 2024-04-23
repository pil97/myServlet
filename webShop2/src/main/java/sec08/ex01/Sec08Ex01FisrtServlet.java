package sec08.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// http://localhost:9090/Sec08Ex01FisrtServlet
@WebServlet("/Sec08Ex01FisrtServlet")
public class Sec08Ex01FisrtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Sec08Ex01FisrtServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 서버에서 클라이언트로 보내는 응답 MIME-TYPE 정보와 인코딩 방식으로 하라.
		response.setContentType("text/html;charset=utf-8");

		PrintWriter out = response.getWriter();
		
		// 서버에서 클라이언트로 보내는 응답 정보속에 아래 헤더 작업도 추가되어 보내진다.  
		// 헤더를 클라이언트의 브라우저가 읽고, 브러우저 내용을 새로고침하는데 10초가 경과되고 url 주소로 새로고침한다. 
		// 브라우저 주소가 변경된다. 
		response.addHeader("Refresh", "10;url=/Sec08Ex01SecondServlet");

	}

}
