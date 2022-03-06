package cn.flight.domain;

public class SelePojo {
	String begin_from;
	String end_from;
	String begin_date;
	String begin_time;
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
	public String getBegin_date() {
		return begin_date;
	}
	public void setBegin_date(String begin_date) {
		this.begin_date = begin_date;
	}
	public String getBegin_time() {
		return begin_time;
	}
	public void setBegin_time(String begin_time) {
		this.begin_time = begin_time;
	}
	public SelePojo(String begin_from, String end_from, String begin_date,
			String begin_time) {
		super();
		this.begin_from = begin_from;
		this.end_from = end_from;
		this.begin_date = begin_date;
		this.begin_time = begin_time;
	}
	public SelePojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "SelePojo [begin_from=" + begin_from + ", end_from=" + end_from
				+ ", begin_date=" + begin_date + ", begin_time=" + begin_time
				+ "]";
	}
	
	
	

}
