package sec02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/input4")
public class inputServlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public inputServlet4() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 하나의 이름으로 선택된 여러개의 값을 받을 때 사용
		String[] subjects = request.getParameterValues("subject");
		
		for(String s: subjects) {
			System.out.println("선택한 과목: " + s);
		}
	}

}
