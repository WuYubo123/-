package cn.flight.service.admini;
//业务层
import java.util.List;

import cn.flight.dao.admini.AdminiLoginDao;
import cn.flight.dao.admini.AdminiLoginDaoImpl;
import cn.flight.domain.Admini;
import cn.flight.domain.Flight;

public class AdminiLoginService {
	AdminiLoginDao adminiLoginDao = new AdminiLoginDaoImpl();
	public boolean getUser(Admini admini){
		Admini adminis= adminiLoginDao.getAdmini(admini);
		if(adminis==null){
			return false;
		}else {
			return true;
		}
	}
	public List<Flight> seleAllFlight(){
		return adminiLoginDao.seleAllFlight();
	}
	
	public void addFlight(Flight flight){
		adminiLoginDao.addFlight(flight);
	}
	
	public int deleFlight(String fid){
		return adminiLoginDao.deleFlight(fid);
	}
	
	public Flight seleFlightByFid(String fid){
		return adminiLoginDao.seleFlightByID(fid);
		
	}
	public int upDateFlight(Flight flight){
		return adminiLoginDao.updateFlight(flight);
	}
	
	
	

}
