package vaccineProgram;

import java.sql.Date;

public class Reservation {
	private int reserveNum;
	private int clientNum;
	private String reserveDay;
	private boolean injected;
	
	public Reservation() {}

	public Reservation(String reserveDay) {
		this.reserveDay=reserveDay;
	}
	public Reservation(int reserveNum, int clientNum, String reserveDay, boolean injected) {
		this.reserveNum = reserveNum;
		this.clientNum = clientNum;
		this.reserveDay = reserveDay;
		this.injected = injected;
	}

	public int getReserveNum() {
		return reserveNum;
	}

	public void setReserveNum(int reserveNum) {
		this.reserveNum = reserveNum;
	}

	public int getClientNum() {
		return clientNum;
	}

	public void setClientNum(int clientNum) {
		this.clientNum = clientNum;
	}

	public String getReserveDay() {
		return reserveDay;
	}

	public void setReserveDay(String reserveDay) {
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
		return "Reservation [reserveNum=" + reserveNum + ", clientNum=" + clientNum + ", reserveDay=" + reserveDay
				+ ", injected=" + injected + "]";
	}

	
}

	














