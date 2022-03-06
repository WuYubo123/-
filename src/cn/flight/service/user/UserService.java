package cn.flight.service.user;

import java.util.ArrayList;
import java.util.List;

import cn.flight.dao.admini.AdminiLoginDao;
import cn.flight.dao.admini.AdminiLoginDaoImpl;
import cn.flight.dao.user.UserDao;
import cn.flight.dao.user.UserDaoImpl;
import cn.flight.domain.Flight;
import cn.flight.domain.SelePojo;
import cn.flight.domain.User;

public class UserService {
	private UserDao userdao = new UserDaoImpl();
	private AdminiLoginDao adminiDao = new AdminiLoginDaoImpl();

	public List<Flight> seleAllFlightByInput(SelePojo sele) {
		SelePojo seles = new SelePojo();
		seles.setBegin_from(sele.getBegin_from());
		seles.setEnd_from(sele.getEnd_from());
		seles.setBegin_date(sele.getBegin_date()+" "+sele.getBegin_time());
		
		
		List<Flight> flights =  userdao.seleAllFlightByInput(seles);
		
		return flights;
	}

	public void destineUpFlight(String destineFid) {
		Flight flight = adminiDao.seleFlightByID(destineFid);
		int flightReamin = flight.getRemain();
		userdao.destineUpFlight(destineFid, flightReamin-1);		
	}

	public List<User> seleUserByNameId(String userId, String userName) {
//		System.out.println("userdaoUserIdandUserName:"+userId+userName);
		List<User> users = userdao.seleUserByNameId(userId,userName);
//		System.out.println("userdaoUsers:"+users);
		return users;
	}

	public List<Flight> seleUserFlight(List<User> usersf) {
//		System.out.println("sfsdf");
//		System.out.println("userdaoUsersf:"+usersf);//成功获得两条航班信息。
		List<User> users = usersf;//存在多个相同的张三和不同的航班号
		List<Flight> flights = new ArrayList<Flight>();//得出所有的航班信息
		for(User user : users){//遍历每个user得到里面的航班号，通过航班号依次查询flight然后在给flights
			Flight flight = adminiDao.seleFlightByID(user.getFlight_id());
			flights.add(flight);//得到了所有的航班信息
			
		}
//		System.out.println("userdaoFlights:"+flights);
		return flights;
	}

	public void upUserFlight(String fid) {
		userdao.upUserFlight(fid);
		
	}

	public void inserDestine(User user) {
		userdao.inserDestine(user);
	}
	
	public void deleUserFlight(String fid,User user){
		userdao.deleUserFlight(fid,user);
	}

	public List<Flight> seleBeginTimeByFromandEnd(String begFrom, String endFrom) {
		List<Flight> timeFlight = userdao.seleFlightByFromAndEnd(begFrom,endFrom);
		return timeFlight;
	}

	public Flight updataUserFlight(String seleFidTime, String begFrom,String endFrom,String user_id,String oid_fid) {
		List<Flight> flights = seleBeginTimeByFromandEnd(begFrom, endFrom);//获取到所有的航班信息了
		Flight seleTimeFlight = new Flight();
		for(Flight flight : flights){
			if(flight.getBegin_time().equals(seleFidTime)){
				seleTimeFlight.setBegin_from(flight.getBegin_from());
				seleTimeFlight.setBegin_time(flight.getBegin_time());
				seleTimeFlight.setEnd_from(flight.getEnd_from());
				seleTimeFlight.setEnd_time(flight.getEnd_time());
				seleTimeFlight.setFlight_id(flight.getFlight_id());
				seleTimeFlight.setTicket_price(flight.getTicket_price());
			}
		}
		userdao.upUserGq(user_id,seleTimeFlight.getFlight_id(),oid_fid);
		destineUpFlight(seleTimeFlight.getFlight_id());//减少改签航班的一张票
		return seleTimeFlight;
		
		
	}
	

}
