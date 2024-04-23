package sec02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/loginMethod")
public class LoginServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	// 클라이언트에서 get 요청 방식일 경우, 호출되는 메서드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet 메서드 호출");
		doHandle(request, response);
		
	}
	// 클라이언트에서 post 요청 방식일 경우, 호출되는 메서드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost 메서드 호출");
		doHandle(request, response);
	}
	
	// 공통메서드 get 방식 또는 Post 	방식 둘다 호출하기
	private void doHandle (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("doHandle 메서드 호출");
		
		String u_id = request.getParameter("u_id");
		String u_pw = request.getParameter("u_pw");
		
		// db 연동작업: 아이디와 비밀번호가 일치하는지 여부 
		
		System.out.println("아이디: " + u_id);
		System.out.println("비밀번호: " + u_pw);
		
	}

}
