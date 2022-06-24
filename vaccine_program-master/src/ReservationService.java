package vaccineProgram;

import java.util.Scanner;

public class ReservationService {

	private ReservationDao dao;
	
	public ReservationService() {
		dao = new ReservationDao();
	}
	
	public void addReservation(Scanner sc) {
		//날짜 입력받아서 dao호출 
		System.out.print("reserveDay :");
		String reserveDay = sc.next();
		dao.insert(new Reservation(reserveDay));
	}
	
	// runInjection에서 메뉴로 예약자확인 차원에서 가져감
	public void printAll() {
		dao.selectAll();
	}
	
	// runInjection에서 예약자
	public void delReservation() {
		dao.delete();
	}
}
