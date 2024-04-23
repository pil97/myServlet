package member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/memberJoin")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost 메서드 호출");
		doHandle(request, response);
	}

	protected void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 문자열 깨지는거 방지
		response.setContentType("text/html;charset=utf-8");

		// 출력스트림
		PrintWriter out = response.getWriter();

		// db 연동 객체 생성
		MemberDAO dao = new MemberDAO();

		String command = request.getParameter("command");
		if (command != null && command.equals("addMember")) {
			// 맴버 클래스 객체 생성
			MemberVO vo = new MemberVO();

			// 클라이언트에서 보낸 데이터를 받음
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");

			// 맴버 클래스 필드에 저장
			vo.setId(id);
			vo.setPwd(pwd);
			vo.setName(name);
			vo.setEmail(email);

			dao.memberJoin(vo);
		} else if (command != null && command.equals("deleteMember")) {
			
			String id = request.getParameter("id");
			dao.deleteMember(id);
		} else if (command != null && command.equals("selectMember")) {
			
		}

		List<MemberVO> list = dao.showMember();
		
		out.print("<html><body>");
		out.print("<table border=1><tr align='center' bgcolor='lightgree'>");
		out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td><td>삭제</td><td>조회</td></tr>");
		
		for(int i = 0; i < list.size(); i++) {
			MemberVO vo = list.get(i);
			String id = vo.getId();
			String pwd = vo.getPwd();
			String name = vo.getName();
			String email = vo.getEmail();
			Date joinDate = vo.getDate();
			
			out.print("<tr><td>" + id + "</td><td>" + pwd + "</td><td>" + name + "</td><td>" + email + "</td><td>"
					+ joinDate + "</td><td>" + "<a href='/memberJoin?command=deleteMember&id=" + id + "'>삭제</a></td></tr>");
		}
		
		out.print("</table>");
		out.print("<a href='member/memberForm.html'>회원등록</a>");
		out.print("</body></html>");
	}

}
