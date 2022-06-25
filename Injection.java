import java.sql.Date;

public class Injection {
    private int id;
    private String client_id;
    private String vacType;
    private int degree;
    private String part;
    private Date injection_date;
    private int reserve_num;
    
    public Injection() {
    }

    //initialize injection
    public Injection(int id, String client_id,int reserve_num, String vacType, int degree, String part, Date injection_date) {
        
        this.id = id;
        this.client_id = client_id;
        this.reserve_num = reserve_num;
        
        this.vacType = vacType;
        this.degree = degree;
        this.part = part;
        
        this.injection_date = injection_date;
    }

    //num
    
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public String getClient_id() {
        return client_id;
    }
    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public int getReserve_num() {
        return reserve_num;
    }

    public void setReserve_num(int reserve_num) {
        this.reserve_num = reserve_num;
    }

    public String getVacType() {
        return vacType;
    }
    public void setVacType(String vacType) {
        this.vacType = vacType;
    }



    public int getDegree() {
        return degree;
    }
    public void setDegree(int degree) {
        this.degree = degree;
    }

    

    public String getPart() {
        return part;
    }
    public void setPart(String part) {
        this.part = part;
    }

    //update

    public Date getInjection_date() {
        return injection_date;
    }
    public void setInjection_date(Date injection_date) {
        this.injection_date = injection_date;
    }


    //to_string
    @Override
    public String toString() {
        return "injection{" +
                "id=" + id +
                ", client_id=" + client_id +
                ", reserve_num=" + reserve_num +
                ", vacType='" + vacType + '\'' +
                ", degree=" + degree +
                ", part='" + part + '\'' +
                ", injection_date=" + injection_date +
                '}';
    }

   


}