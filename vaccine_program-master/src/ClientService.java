package vaccineProgram;

import java.util.Scanner;

public class ClientService {
	private ClientDao dao;
	public static int LoginNum = 0;
	public static String LoginId = "";

	public ClientService() {
		dao = new ClientDao();
	}

	// 회원가입(id, pw(*주민번호다쓰기), age, gender, phone) -> num1이 생성
	public void addClient(Scanner sc) {
		System.out.println("sign in");
		System.out.print("id:");
		String id = sc.next();
		System.out.print("pw:");
		String pw = sc.next();
		System.out.print("age:");
		int age = sc.nextInt();
		System.out.print("gender:");
		String gender = sc.next();
		System.out.print("phone:");
		String phone = sc.next();
		dao.insert(new Client(0, id, pw, age, gender, phone));
	}

	// 로그인(id,pw)
	public void login(Scanner sc) {
		System.out.println("log in");
		if (LoginNum > 0) {
			System.out.println("logged in");
			return;
		}

		System.out.print("id:");
		String id = sc.next();
		System.out.print("pw:");
		String pw = sc.next();
		Client c = dao.select(LoginNum);
		if (c == null) {
			System.out.println("no number");
		} else {
			if (c.getPw().equals(pw)) {
				System.out.println("log in success");
			}
		}
	}

	// 내정보확인(num)
	public void printMyInfo(Scanner sc) {
		if (LoginNum == 1) {
			System.out.println("log in plz");
			return;
		}
		Client c = dao.select(LoginNum);
		System.out.println(c);
	}
	
	// 로그아웃(로그아웃버튼)
	public void logout() {
		if (LoginNum == 1) {
			System.out.println("log in plz");
			return;
		}
		LoginNum = 0;
		LoginId = "";
	}
	
	// 내정보수정
	public void editClient(Scanner sc) {
		if (LoginNum == 1) {
			System.out.println("log in plz");
			return;
		}
		System.out.print("id:");
		String id = sc.next();
		System.out.print("pw:");
		String pw = sc.next();
		System.out.print("age:");
		int age = sc.nextInt();
		System.out.print("gender:");
		String gender = sc.next();
		System.out.print("phone:");
		String phone = sc.next();
		
		dao.update(new Client(LoginNum, id, pw, age, gender, phone));
		
	}


// 탈퇴

	public void delClient(Scanner sc) {
		if (LoginNum == 1) {
			System.out.println("log in plz");
			return;
		}
		dao.delete(LoginNum);
	}
}