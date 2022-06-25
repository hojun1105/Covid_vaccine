import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class ReservationService {

	private ReservationDao dao;
	
	public ReservationService() {
		dao = new ReservationDao();
	}

	public void addReservation(Scanner sc) {

		String client_id=ClientService.LoginId;
		boolean injected = false;

		System.out.println("What date?: yyyy/MM/dd");
		String inputDate = sc.next();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");


		try {
			java.util.Date utilDate = format.parse(inputDate);
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			Reservation reserve = new Reservation(0,client_id,sqlDate,injected);
			dao.insert(reserve);
			System.out.println("Reservation Complete");
		} catch (ParseException e) {
			e.printStackTrace();
		}


	}
	
	// runInjection에서 메뉴로 예약자확인 차원에서 가져감
	public void printAll() {
		ArrayList<Reservation> test=dao.selectAll();
		for(Reservation a: test){
			System.out.println(a);
		}
		System.out.println("------------------------------");

	}
	
	// runInjection에서 예약자
//	public void delReservation()
//	{
//		dao.delete();
//	}


}
