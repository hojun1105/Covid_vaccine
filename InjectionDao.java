import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class InjectionDao {
    private MysqlConnect dbconn;

    public InjectionDao(){
        dbconn = MysqlConnect.getInstance();
    }
    public void addInjection(Injection p) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = dbconn.getConn();
            String sql = "insert into injection(id, client_id,reserve_num, vacType, degree, part, injection_date) values(?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, p.getId());
            pstmt.setString(2, p.getClient_id());
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
    public void getInjection(String clientId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = dbconn.getConn();
            String sql = "select * from injection where client_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, clientId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("Injection Number : " + rs.getInt("id"));
                System.out.println("Reserved Number : " + rs.getInt("reserve_num"));
                System.out.println("Client ID : " + rs.getString("client_id"));
                System.out.println("VacType (Ast, Jan, PF, Mod): " + rs.getString("vacType"));
                System.out.println("Degree : " + rs.getInt("degree"));
                System.out.println("Part : " + rs.getString("part"));
                System.out.println("Date : " + rs.getDate("injection_date"));
                System.out.println("------------------------------");
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
    public String getvacType(int age){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String resout="";
        try{
            conn = dbconn.getConn();
            String sql = "select vacType from hospital where ? between age_min and age_max";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, age);
            rs = pstmt.executeQuery();
            resout =rs.getString("vacType");
        }catch (SQLException e) {
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
        return resout;
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