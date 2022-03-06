package cn.flight.domain;

public class Flight {
	String flight_id;
	String begin_from;
	String end_from;
	String begin_time;
	String end_time;
	int remain;
	float ticket_price;
	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Flight(String flight_id, String begin_from, String end_from,
			String begin_time, String end_time, int remain, float ticket_price) {
		super();
		this.flight_id = flight_id;
		this.begin_from = begin_from;
		this.end_from = end_from;
		this.begin_time = begin_time;
		this.end_time = end_time;
		this.remain = remain;
		this.ticket_price = ticket_price;
	}
	public String getFlight_id() {
		return flight_id;
	}
	public void setFlight_id(String flight_id) {
		this.flight_id = flight_id;
	}
	public String getBegin_from() {
		return begin_from;
	}
	public void setBegin_from(String begin_from) {
		this.begin_from = begin_from;
	}
	public String getEnd_from() {
		return end_from;
	}
	public void setEnd_from(String end_from) {
		this.end_from = end_from;
	}
	public String getBegin_time() {
		return begin_time;
	}
	public void setBegin_time(String begin_time) {
		this.begin_time = begin_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public int getRemain() {
		return remain;
	}
	public void setRemain(int remain) {
		this.remain = remain;
	}
	public float getTicket_price() {
		return ticket_price;
	}
	public void setTicket_price(float ticket_price) {
		this.ticket_price = ticket_price;
	}
	@Override
	public String toString() {
		return "Flight [flight_id=" + flight_id + ", begin_from=" + begin_from
				+ ", end_from=" + end_from + ", begin_time=" + begin_time
				+ ", end_time=" + end_time + ", remain=" + remain
				+ ", ticket_price=" + ticket_price + "]";
	}
	

}
