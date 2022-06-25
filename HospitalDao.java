import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

public class HospitalDao {
    private MysqlConnect dbconn;

    public HospitalDao() {
        dbconn = MysqlConnect.getInstance();
    }


    // 백신 등록(추가)
    public void insert(Hospital h) {
        // 1. db연결
        Connection conn = dbconn.getConn();

        // 2. sql
        String sql = "insert into hospital(hospitalId,vacType, age_min, age_max, amount, startDate, endDate,today) values(?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,h.getHospitalId());
            pstmt.setString(2, h.getVacType());
            pstmt.setInt(3, h.getAge_min());
            pstmt.setInt(4, h.getAge_max());
            pstmt.setInt(5, h.getAmount());
            pstmt.setDate(6, h.getStartDate());
            pstmt.setDate(7, h.getEndDate());
            pstmt.setDate(8,h.getToday());

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

    // endDate가 지난 백신 제거 인가?>> 이거 백신폐기 관리 에 해당하는 탭
    public void delete(Date a) {
        // db연결
        Connection conn = dbconn.getConn();
        String sql = "delete from hospital where enddate = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDate(1, a);
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

    public void delete(){
        Connection conn = dbconn.getConn();
        String sql = "delete from hospital where amount =0";
        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
        } catch (SQLException e) {
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


    // 백신 종류 총량 업데이트
    public void update(Hospital h) {// p:수정할 백신종류, min나이 max나이, 백신총량, 바꾼날
        Connection conn = dbconn.getConn();
        String sql = "update hospital set vacType=?, age_min = ? , age_max=?, amount=?, startDate=?,endDate=?,today=? where HospitalId=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, h.getVacType());
            pstmt.setInt(2, h.getAge_min());
            pstmt.setInt(3, h.getAge_max());
            pstmt.setInt(4, h.getAmount());
            pstmt.setDate(5, h.getStartDate());
            pstmt.setDate(6, h.getEndDate());
            pstmt.setDate(7, h.getToday());
            pstmt.setInt(8, h.getHospitalId());
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

    // 병원 총 백신 현황 출력
    public ArrayList<Hospital> selectAll() {
        ArrayList<Hospital> list = new ArrayList<Hospital>();
        ResultSet rs = null;
        Connection conn = dbconn.getConn();
        String sql = "select * from hospital";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int hospitalId = rs.getInt(1);
                String vacType = rs.getString(2);
                int age_min = rs.getInt(3);
                int age_max = rs.getInt(4);
                int amount = rs.getInt(5);
                Date startDate = rs.getDate(6);
                Date endDate = rs.getDate(7);
                Date today = rs.getDate(8);

                list.add(new Hospital(hospitalId, vacType, age_min, age_max, amount,startDate, endDate, today));
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
        return list;
    }

    // select
//    public Hospital select(int num) {
//        Hospital h = null;
//        ResultSet rs = null;
//        // db연결
//        Connection conn = dbconn.getConn();
//        // sql 문 작성
//        String sql = "select * from hospital where num=?";
//
//        try {
//            // preparedstmt 객체
//            PreparedStatement pstmt = conn.prepareStatement(sql);
//
//            // ?매칭
//            pstmt.setInt(1, num);
//
//            // sql 실행
//            rs = pstmt.executeQuery();// 검색한 결과를 ResultSet으로 반환
//
//            if (rs.next()) {
//                h = new Hospital(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5),
//                        rs.getString(6), rs.getString(7),rs.getString(8));
//            }
//
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } finally {
//            try {
//                conn.close();
//            } catch (SQLException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }
//        return h;
//    }

    // 백신 주입으로 인한 수량 조정 ( 출고 되는걸로)
    public void updateAmount(String vacType) {
        Connection conn = dbconn.getConn();
        String sql = "update hospital set amount= amount-1 where vacType=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, vacType);
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

//    public int compareDate(String endDate) {
//
//        ResultSet rs = null;
//        //db
//        Connection conn = dbconn.getConn();
//        //sql
//        String sql = "SELECT CURDATE(), TIMESTAMPDIFF(DAY, ?, CURDATE())";
//        try {
//            PreparedStatement pstmt = conn.prepareStatement(sql);
//            pstmt.setString(1,endDate);
//            rs = pstmt.executeQuery();
//
//            if(rs.next()) {
//                int num = rs.getInt(1);
////				if(num<0) {
////					//미완
////				}
//            }}catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } finally {
//            try {
//                conn.close();
//            } catch (SQLException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }

    }


