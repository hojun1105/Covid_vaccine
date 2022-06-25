import java.awt.*;
import java.util.Scanner;
import java.sql.Date;

public class InjectionService {
    public ReservationDao rdao;
    public HospitalDao hdao;
    public ClientDao cdao;
    private InjectionDao dao;
    public InjectionService(){
        dao = new InjectionDao();
        rdao = new ReservationDao();
        hdao = new HospitalDao();
        cdao = new ClientDao();
    }
    //백신 접종

    public void addInjection(Scanner sc){
        
        System.out.println("Reservation Number : ");
        int reserve_num = sc.nextInt();

        String client_id = rdao.select(reserve_num).getClientId();

        int client_age = cdao.select(client_id).getAge();
        String vacType = dao.getvacType(client_age);

        System.out.print("what degree?");
        int degree = sc.nextInt();

        System.out.print("Where: L or R?");
        String part = sc.next();

        long miliseconds = System.currentTimeMillis();
        Date date = new Date(miliseconds);
        System.out.println("------------------------------");
        Injection p = new Injection(0, client_id,reserve_num, vacType, degree, part, date);
        hdao.updateAmount(vacType);
        rdao.change(reserve_num);
        dao.addInjection(p);
    }
    //get injection
    public void getInjection(Scanner sc){
        System.out.println("Client Id : ");
        String clientId = sc.next();
        dao.getInjection(clientId);
        System.out.println("------------------------------");
    }


}