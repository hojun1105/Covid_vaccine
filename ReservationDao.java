import java.sql.*;
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
		String sql = "insert into reservation(reserveNum,clientId,ReserveDay,injected) values(?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1,r.getReserveNum() );
			pstmt.setString(2, r.getClientId());
			pstmt.setDate(3,r.getReserveDay());
			pstmt.setBoolean(4,r.isInjected());


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
		String sql = "select * from reservation where reserveNum=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, reserveNum);
			rs = pstmt.executeQuery();

			if (rs.next()) {

				int reserveNum1 = rs.getInt(1);
				String clientId = rs.getString(2);
				Date reserveDay = rs.getDate(3);
				Boolean injected = rs.getBoolean(4);
				r = new Reservation(reserveNum1, clientId, reserveDay, injected);
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

		String sql = "select * from reservation";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Reservation(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getBoolean(4)));
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

	public void change(int reserve_num) {
		Connection conn = dbconn.getConn();
		String sql = "update reservation set injected = true where reserve_num=?";
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, reserve_num);
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

	}

