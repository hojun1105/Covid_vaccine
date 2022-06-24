package vaccineProgram;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReservationDao {
	private MysqlConnect dbconn;

	public InjectionDao idao;

	public ReservationDao() {
		dbconn = MysqlConnect.getInstance();
		idao = new InjectionDao();
	}

	public void insert(Reservation r) {
		Connection conn = dbconn.getConn();
		String sql = "insert into reservation(clientNum,reserveDay,injected) values(?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ClientService.LoginNum);
			pstmt.setString(2, r.getReserveDay());
			pstmt.setBoolean(3, false);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public Reservation select(int reserveNum) {
		ResultSet rs;
		Reservation r = null;
		Connection conn = dbconn.getConn();
		String sql = "select * from client where ReserveNum=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, reserveNum);
			rs = pstmt.executeQuery();

			if (rs.next()) {

				int reserveNum1 = rs.getInt(1);
				int clientNum = rs.getInt(2);
				String reserveDay = rs.getString(3);
				Boolean injected = rs.getBoolean(4);
				r = new Reservation(reserveNum1, clientNum, reserveDay, injected);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return r;
	}

	public ArrayList<Reservation> selectAll() {
		ResultSet rs = null;
		ArrayList<Reservation> list = new ArrayList<Reservation>();

		Connection conn = dbconn.getConn();

		String sql = "select * from test order by num";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Reservation(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getBoolean(4)));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public void delete() {
		Connection conn = dbconn.getConn();
		ArrayList<Integer> list = idao.getAllReserveNum();
		for (int i = 0; i < list.size(); i++) {
			String sql = "delete from reservation where num = ?";

			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, list.get(i));
				pstmt.executeUpdate();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					conn.close();

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("delete from reservation ");
	}
}
