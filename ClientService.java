import java.util.Scanner;

public class ClientService {
	private ClientDao dao;
	public static int LoginNum=0;
	public static String LoginId = "";

	public ClientService() {
		dao = new ClientDao();
	}

	// 회원가입(id, pw(*주민번호다쓰기), age, gender, phone) -> num1이 생성
	public void addClient(Scanner sc) {
		if(LoginNum==1){
			System.out.println("LogOut First");
			System.out.println("------------------------------");
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
		dao.insert(new Client(0, id, pw, age, gender, phone));
	}

	// 로그인(id,pw)
	public void login(Scanner sc) {
		System.out.println("------------------------------");
		System.out.println("log in");
		if (LoginNum > 0) {
			System.out.println("logged in");
			System.out.println("------------------------------");
			return;
		}

		System.out.print("id:");
		String id = sc.next();
		System.out.print("pw:");
		String pw = sc.next();
		Client c = dao.select(id);
		if (c == null) {
			System.out.println("no number");
			System.out.println("------------------------------");
		} else {
			if (c.getPw().equals(pw)) {
				LoginId = id;
				LoginNum =1;
				System.out.println("log in success");
				System.out.println("------------------------------");
			}
		}
	}

	// 내정보확인(num)
	public void printMyInfo(Scanner sc) {
		if (LoginNum ==0) {
			System.out.println("log in plz");
			System.out.println("------------------------------");
			return;
		}

		Client c = dao.select(LoginId);
		System.out.println(c);
	}
	
	// 로그아웃(로그아웃버튼)
	public void logout() {
		LoginNum = 0;
		LoginId = "";
	}
	
	// 내정보수정
	public void editClient(Scanner sc) {
		if (LoginNum == 0) {
			System.out.println("log in plz");
			System.out.println("------------------------------");
			return;
		}
		String id = LoginId;
		System.out.print("pw:");
		String pw = sc.next();
		System.out.print("age:");
		int age = sc.nextInt();
		System.out.print("gender:");
		String gender = sc.next();
		System.out.print("phone:");
		String phone = sc.next();
		
		dao.update(new Client(0, id, pw, age, gender, phone));
	}


// 탈퇴

	public void delClient(Scanner sc) {
		if (LoginNum == 0) {
			System.out.println("------------------------------");
			System.out.println("log in plz");
			return;
		}
		dao.delete(LoginId);
		System.out.println(LoginId+" 삭제되었습니다");
		System.out.println("------------------------------");
	}

}