package vaccineProgram;
import java.util.Scanner;
import java.sql.Date;

public class InjectionService {
    private InjectionDao dao;
    public InjectionService(){
        dao = new InjectionDao();
    }
    //백신 접종
    public void addInjection(Scanner sc){
        
        System.out.println("백신 예약번호 : ");
        int reserve_num = sc.nextInt();

        System.out.println("클라이언트 아이디 : ");
        int client_id = sc.nextInt();

        System.out.print("Vaccine Type:");
        String vacType = sc.next();

        System.out.print("1cha? or 2cha? input int");
        int degree = sc.nextInt();

        System.out.print("Where did you get injected? Left or Right?");
        String part = sc.next();

        long miliseconds = System.currentTimeMillis();
        Date date = new Date(miliseconds);

        Injection p = new Injection(0, client_id,reserve_num, vacType, degree, part, date);
        dao.addInjection(p);
    }
    //get injection
    public void getInjection(Scanner sc){
        System.out.println("백신 클라이언트 번호 : ");
        int client_num = sc.nextInt();
        dao.getInjection(client_num);
    }
	//return all reserve num
    public void getAllReserveNum(){
        dao.getAllReserveNum();
    }

}