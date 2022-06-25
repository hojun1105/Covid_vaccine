import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.sql.Date;
public class Hospital {
    private int hospitalId;
    private String vacType;//백신 타입
   //백신번호
    private int age_min;//최소나이
    private int age_max;//최대 나이
    private int amount;//백신 총량
    private Date startDate;//백신 공급 날짜
    private Date endDate;//백신 유통 기한 날짜
    private Date today;//현재 날짜

    //등록을 데외한 기능에서 사용할 생성자
    public Hospital() {

    }
    public Hospital(int hospitalId,String vacType, int age_min, int age_max, int amount, Date startDate,
                    Date endDate, Date today) {
       this.hospitalId = hospitalId;
        this.vacType = vacType;
        this.age_min = age_min;
        this.age_max = age_max;
        this.amount = amount;
        this.startDate = startDate;
        this.endDate = endDate;
        this.today = today;
    }

    public int getHospitalId(){
        return hospitalId;
    }
    public void setHospitalId(int hospitalId){
        this.hospitalId = hospitalId;
    }
    public String getVacType() {
        return vacType;
    }

    public int getAge_min() {
        return age_min;
    }


    public void setAge_min(int age_min) {
        this.age_min = age_min;
    }


    public int getAge_max() {
        return age_max;
    }


    public void setAge_max(int age_max) {
        this.age_max = age_max;
    }


    public int getAmount() {
        return amount;
    }


    public void setAmount(int amount) {
        this.amount = amount;
    }


    public Date getStartDate() {
        return startDate;
    }


    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }


    public Date getEndDate() {
        return endDate;
    }


    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }


    public Date getToday() {
        return today;
    }


    public void setToday(Date today) {
        this.today = today;
    }


    public void setVacType(String vacType) {
        this.vacType = vacType;
    }


    @Override
    public String toString() {
        return "Hospital [vacType=" + vacType + ", num=" + hospitalId + ", inject_num=" + ", age_min=" + age_min
                + ", age_max=" + age_max + ", amount=" + amount + ", startDate=" + startDate + ", endDate=" + endDate
                + ", today=" + today + "]";
    }


}
