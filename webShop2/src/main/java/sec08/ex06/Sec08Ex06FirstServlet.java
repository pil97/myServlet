package sec08.ex06;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Sec08Ex06FirstServlet")
public class Sec08Ex06FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Sec08Ex06FirstServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8"); // 한글깨짐방지
		
		response.setContentType("text/html;charset=utf-8");
		
		// request 객체: 클라이언트에서 보내온 모든정보를 관리하는 객체 
		/*
		 * 
		 *  - 사용자가 입력한 데이터
		 *  - 클라이언트의 브라우저 종류, 버전, IP등 
		 * 
		 * */
		
		request.setAttribute("address", "서울시 노원구 이젠빌딩");
		
		
		// 서버내에서 주소가 이동이 된 경우는 현재요청에 연장된 의미로 처리가 된다.  
	 RequestDispatcher dispatch = request.getRequestDispatcher("/Sec08Ex06SecondServlet");
	 dispatch.forward(request, response);
	}

}
