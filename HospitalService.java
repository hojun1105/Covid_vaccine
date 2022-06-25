import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.Date;
public class HospitalService {
    private HospitalDao dao; // 서비스는 기능 제공, 대부분기능은 db연동이 필요

    public HospitalService() {
        dao = new HospitalDao();
    }

    public void addVaccine(Scanner sc){

        System.out.println("vacType:");
        String vacType = sc.next();

        System.out.println("age_min:");
        int age_min = sc.nextInt();

        System.out.println("age_max:");
        int age_max = sc.nextInt();

        System.out.println("amount:");
        int amount = sc.nextInt();

        System.out.println("startDate:");
        String startDate = sc.next();

        System.out.println("endDate:");
        String endDate = sc.next();
        System.out.println("------------------------------");

        try {
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        java.util.Date utilDate = format.parse(startDate);
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        java.util.Date utilDate2 = format.parse(endDate);
        java.sql.Date sqlDate2 = new java.sql.Date(utilDate2.getTime());

        long miliseconds = System.currentTimeMillis();
        Date today = new Date(miliseconds);

        Hospital p = new Hospital(0,vacType,age_min,age_max,amount,sqlDate,sqlDate2,today);
        dao.insert(p);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public void delVaccine(){
        long miliseconds = System.currentTimeMillis();
        Date today = new Date(miliseconds);
        dao.delete(today);
    }

    public void printAll() {
	ArrayList<Hospital> list = dao.selectAll();
		for(Hospital h : list) {
			System.out.println(h);
		}
    }

    public void injectVaccine(String vacType){
        dao.updateAmount(vacType);
    }
    //나이에 따른 백신 확인 공지용

    public void delWhenZero(){
        dao.delete();
    }




//    //수정하는 서비스
//    public void editHospital(Scanner sc) {
//        //inject_num
//        System.out.print("new vacType:");
//        String vacType = sc.next();
//
//        System.out.print("new age_min:");
//        int age_min = sc.nextInt();
//
//        System.out.print("new age_max:");
//        int age_max = sc.nextInt();
//
//        System.out.print("new amount:");
//        int amount = sc.nextInt();
//
//        System.out.print("new startDate:");
//        String startDate = sc.next();
//
//        System.out.print("new endDate:");
//        String endDate = sc.next();
//
//        System.out.print("new today:");
//        String today = sc.next();
//
//        dao.update(new Hospital(vacType, age_min,age_max,amount,startDate,endDate,today));
//    }





//
//	//endDate가 지난 거 파기
//	public void deleteHospital() {
//
//	}
//	//날짜 계산
//	public void checkkkHospital() {
//		SimpleDateFormat date = new SimpleDateFormat("yyyy-mm-dd", Locale.getDefault());
//		String d = date.format(System.currentImeMillis());
//	}
//    //백신타입으로 검색
//    public void getProductByName(String vacType) {
//        String vacType = sc.next();
//
//        ArrayList<Hospital> list = dao.selectByName(vacType);
//        if (list.size() == 0) {
//            System.out.println("없는 제품명");
//            //
//        } else {
//            System.out.println(list);
//        }
//    }

//    //injection으로 인한 amount 출고 되는것
//    public ArrayList<Hospital> out(Scanner sc, ArrayList<Hospital> list) {// o: 출고대상 목록
//        System.out.println("출고 처리");
//        ArrayList<Hospital> res = new ArrayList<Hospital>();// 출고처리가 완료된 주문 담아서 반환
//
//        for (Hospital h : list) {
//            System.out.println(h);
//            String vacType = h.getVacType();// 주문한 제품 번호
//            Hospital h = dao.selectByName(vacType);
//            if (h.getAmount() >= h.getAmount()) {
//                dao.updateAmount(vacType), -h.getAmount());// 수량 변경
//                System.out.println(h.getNum() + "번 주문이 출고완료됨");
//                res.add(h);
//            } else {
//                System.out.println(h.getNum() + "번 주문이 수량부족으로 출고취소");
//            }
//        }
//        return res;
//    }




}
