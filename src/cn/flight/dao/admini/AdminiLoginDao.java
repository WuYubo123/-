package cn.flight.dao.admini;

import java.util.List;

import cn.flight.domain.Admini;
import cn.flight.domain.Flight;

public interface AdminiLoginDao {
	public Admini getAdmini(Admini admini);
	public List<Flight> seleAllFlight();
	public void addFlight(Flight flight);
	public int deleFlight(String fid);
	public Flight seleFlightByID(String fid);
	public int updateFlight(Flight flight);

}
