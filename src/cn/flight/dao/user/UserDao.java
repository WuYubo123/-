package cn.flight.dao.user;

import java.util.List;

import cn.flight.domain.Flight;
import cn.flight.domain.SelePojo;
import cn.flight.domain.User;

public interface UserDao {
	public List<Flight> seleAllFlightByInput(SelePojo sele);
	//用户订票更改航班的余票量
	public void destineUpFlight(String fid,int ramin);
	public List<User> seleUserByNameId(String userId, String userName);
	public void upUserFlight(String fid);
	public void inserDestine(User user);
	public void deleUserFlight(String fid, User user);
	public List<Flight> seleFlightByFromAndEnd(String begFrom, String endFrom);
	public void upUserGq(String user_id, String flight_id,String oid_fid);

}
