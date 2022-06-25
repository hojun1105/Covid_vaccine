import java.sql.Date;

public class Reservation {
	private int reserveNum;
	private String clientId;
	private Date reserveDay;
	private boolean injected;
	
	public Reservation() {}


	public Reservation(int reserveNum, String clientId, Date reserveDay, boolean injected) {
		this.reserveNum = reserveNum;
		this.clientId = clientId;
		this.reserveDay = reserveDay;
		this.injected = injected;
	}

	public int getReserveNum() {return reserveNum;}

	public void setReserveNum(int reserveNum) {
		this.reserveNum = reserveNum;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public Date getReserveDay() {
		return reserveDay;
	}

	public void setReserveDay(Date reserveDay) {
		this.reserveDay = reserveDay;
	}

	public boolean isInjected() {
		return injected;
	}

	public void setInjected(boolean injected) {
		this.injected = injected;
	}

	@Override
	public String toString() {
		return "Reservation [reserveNum=" + reserveNum + ", clientNum=" + clientId + ", reserveDay=" + reserveDay
				+ ", injected=" + injected + "]";
	}

	
}

	














