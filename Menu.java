import java.util.Scanner;

public class Menu {
	ClientService c_service;
	ReservationService r_service;
	InjectionService i_service;
	HospitalService h_service;
	// HospitalService h_service;

	public Menu() {
		c_service = new ClientService();
		r_service = new ReservationService();
		i_service = new InjectionService();
		h_service = new HospitalService();
	}

	public void runClient(Scanner sc) {

		boolean flag = true;
		int m = 0;
		while (flag) {
			System.out.println("1.sign in");
			System.out.println("2.log in");
			System.out.println("3.log out");
			System.out.println("4.my info");
			System.out.println("5.update");
			System.out.println("6.reservation");
			System.out.println("7.delete client");
			System.out.println("8.exit");
			System.out.println("------------------------------");
			System.out.print("enter number : ");
			m = sc.nextInt();
			switch (m) {
			case 1:
				c_service.addClient(sc);
				break;
			case 2:
				c_service.login(sc);
				break;
			case 3:
				c_service.logout();
				break;
			case 4:
				c_service.printMyInfo(sc);
				break;
			case 5:
				c_service.editClient(sc);
				break;
			case 6:
				r_service.addReservation(sc);
				break;
			case 7:
				c_service.delClient(sc);
			 	break;
				case 8:
					flag = false;
					break;
			}
		}
	}
	public void runHospital(Scanner sc){
		boolean flag = true;
		int m = 0;
		while (flag) {
			System.out.println("1.add Vaccine");
			System.out.println("2.del Vaccine");
			System.out.println("3.Print All");
			System.out.println("4.exit");
			System.out.println("------------------------------");
			m = sc.nextInt();
			switch (m) {
				case 1:
					h_service.addVaccine(sc);
					break;
				case 2:
					h_service.delVaccine();
					h_service.delWhenZero();
					break;
					case 3:
						h_service.printAll();
						break;
				case 4:
					flag = false;
					break;



			}
		}
	}
	public void runInjection(Scanner sc) {
		boolean flag = true;
		int m = 0, num;
		while (flag) {
			System.out.println("1.vaccination");
			System.out.println("2.injection info");
			System.out.println("3.Check Reservation");
			System.out.println("4.Exit");
			System.out.println("------------------------------");
			System.out.println("Choice : int plz ");
			m = sc.nextInt();
			switch (m) {
			case 1:
				i_service.addInjection(sc);
//				r_service.delReservation();
				break;
			case 2:
				i_service.getInjection(sc);
				break;
			case 3:
				r_service.printAll();
				break;
			case 4:
				flag = false;
				break;
			}
		}
	}
}
