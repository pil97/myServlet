package sec01.ex01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/input3")
public class input3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public input3Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		// 한글 깨짐 방지
		// request.setCharacterEncoding("utf-8");
		String name = request.getParameter("u_name");
		String id = request.getParameter("u_id");
		String pw = request.getParameter("u_pw");
		String address = request.getParameter("u_add");
		String tel = request.getParameter("u_tel");
		String age = request.getParameter("u_age");
		
		
		System.out.println(name);
		System.out.println(id);
		System.out.println(pw);
		System.out.println(address);
		System.out.println(tel);
		System.out.println(age);
	}

}
