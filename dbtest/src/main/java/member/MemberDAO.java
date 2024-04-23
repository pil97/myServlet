package member;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	// private ResultSet rs;

	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String uid = "jspuser";
	private String pw = "jspuser";

	public MemberDAO() {

	}

	public Connection getConnection() throws SQLException {
		if (conn == null || conn.isClosed()) {
			try {
				// 메모리상에 DriverManager 객체가 로딩.
				// "oracle.jdbc.OracleDriver" 오라클에서 제공하는 JDBC 드라이버에서 참조
				Class.forName("oracle.jdbc.OracleDriver");

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			// conn 객체가 생성된다. (데이터베이스의 연결상태)
			// conn 객체가 생성시 오류가 나면, url, uid, pw 파라미터 값이 문제일 수 있다.
			conn = DriverManager.getConnection(url, uid, pw);
		}
		return conn;
	}

	// 회원가입
	public void memberJoin(MemberVO vo) {
		try {
			// 1. db 연결
			conn = getConnection();

			String id = vo.getId();
			String pwd = vo.getPwd();
			String name = vo.getName();
			String email = vo.getEmail();

			String sql = "insert into t_member(id,pwd,name,email)";
			sql += " values(?, ?, ?, ?)";

			// sql 변수안에 ?(placeholder)에 값을 대입한 insert문이 완성된다.
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);

			// 3. 쿼리 실행
			// sql 변수의 insert문을 오라클 데이터베이스 서버에게 실행요청한다.
			pstmt.executeUpdate(); // sql문이 insert, delete, update에 사용할 메서드

			// 4. 연결 닫기
			pstmt.close();
			conn.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	// 회원 삭제
	public void deleteMember(String id) {
		try {
			conn = getConnection();

			String sql = "delete from t_member" + " where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();

			pstmt.close();
			conn.close();
			

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
	


	// 회원 조회
	public List<MemberVO> showMember() {
		List<MemberVO> list = new ArrayList<MemberVO>();

		try {
			conn = getConnection();

			String sql = "select * from t_member";
			pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery(sql);

			while (rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");

				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setDate(joinDate);

				list.add(vo);

			}
			
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return list;

	}

}
