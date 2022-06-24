package vaccineProgram;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class InjectionDao {
    private MysqlConnect dbconn;
    public void addInjection(Injection p) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = dbconn.getConn();
            String sql = "insert into injection(id, client_id,reserve_num, vacType, degree, part, injection_date) values(?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, p.getId());
            pstmt.setInt(2, p.getClient_id());
            pstmt.setInt(3, p.getReserve_num());
            pstmt.setString(4, p.getVacType());
            pstmt.setInt(5, p.getDegree());
            pstmt.setString(6, p.getPart());
            pstmt.setDate(7, p.getInjection_date());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();    
        } finally {

            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    }
    //get injection
    public void getInjection(int client_num) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = dbconn.getConn();
            String sql = "select * from injection where client_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, client_num);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("백신 접종번호 : " + rs.getInt("id"));
                System.out.println("백신 예약번호 : " + rs.getInt("reserve_num"));
                System.out.println("클라이언트 아이디 : " + rs.getInt("client_id"));
                System.out.println("백신 종류 : " + rs.getString("vacType"));
                System.out.println("백신 차수 : " + rs.getInt("degree"));
                System.out.println("백신 접종 위치 : " + rs.getString("part"));
                System.out.println("백신 접종일 : " + rs.getDate("injection_date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
public ArrayList<Integer> getAllReserveNum(){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Integer> reserve_num = new ArrayList<Integer>();
        try {
            conn = dbconn.getConn();
            String sql = "select reserve_num from injection";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                reserve_num.add(rs.getInt("reserve_num"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return reserve_num;
    }



}