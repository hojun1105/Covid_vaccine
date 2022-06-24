package vaccineProgram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//db 연결. db서버에 로그인해서 세션 수립
public class MysqlConnect {
	private static MysqlConnect myconn = new MysqlConnect();
	//db서버 주소, 포트번호 /데이터베이스명?설정
	private String url = "jdbc:mysql://localhost:3306/jdb?serverTimezone=UTC&useSSL=false";
	//드라이버 명
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	//싱글톤. 자원관리
	private MysqlConnect() {

	}
	
	public static MysqlConnect getInstance() {
		return myconn;
	}
	
	//db연결하여 커넥션 객체 반환
	public Connection getConn() {
		try {
			//드라이버 로드
			Class.forName(driver); //여기서 에러나면 드라이버 빌드패스 확인
			//로그인. 세션 수립
			Connection conn = DriverManager.getConnection(url, "root", "1234");
			return conn;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}