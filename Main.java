import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Menu menu = new Menu();
		System.out.println("------------------------------");
		System.out.println("");
		System.out.println("1.client 2.injection 3.hospital");
		System.out.print("select:");
		int number = sc.nextInt();
		switch (number) {
		case 1:
			menu.runClient(sc);
			break;
		case 2:
			menu.runInjection(sc);
			break;
		case 3:
			menu.runHospital(sc);
			break;
		}
	}
}
