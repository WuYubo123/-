package cn.flight.dao.user;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.flight.dao.admini.AdminiLoginDao;
import cn.flight.dao.admini.AdminiLoginDaoImpl;
import cn.flight.domain.Admini;
import cn.flight.domain.Flight;
import cn.flight.domain.SelePojo;
import cn.flight.domain.User;
import cn.itcast.jdbc.TxQueryRunner;
/**
 * 数据库实现
 * @author MI
 */
public class UserDaoImpl implements UserDao {
	private QueryRunner qr = new TxQueryRunner();

	public List<Flight> seleAllFlightByInput(SelePojo sele) {
		try {

			StringBuilder sql = new StringBuilder(
					"select * from flight where 1=1");
			List<Object> params = new ArrayList<Object>();
			System.out.println("begin_from:" + sele.getBegin_from());
			String begin_from = sele.getBegin_from();

			if (begin_from != null && !begin_from.trim().isEmpty()) {
				sql.append(" and begin_from like ?");
				params.add("%" + begin_from + "%");
			}

			String end_from = sele.getEnd_from();
			if (end_from != null && !end_from.trim().isEmpty()) {
				sql.append(" and end_from=?");
				params.add(end_from);
			}

			String begin_time = sele.getBegin_date();
			if (begin_time != null && !begin_time.trim().isEmpty()) {
				sql.append(" and begin_time like ?");
				params.add("%" + begin_time + "%");
			}
			/*
			 * 三、执行query
			 */
			return qr.query(sql.toString(), new BeanListHandler<Flight>(
					Flight.class), params.toArray());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// 更改航班信息，使航班信息-1
	public void destineUpFlight(String fid, int ramin) {
		try {
			String sql = "update flight set remain=? where flight_id=?";
			Object[] params = { ramin, fid };
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public List<User> seleUserByNameId(String userId, String userName) {
		try {
			StringBuilder sql = new StringBuilder(
					"select * from destine where 1=1");
			List<Object> params = new ArrayList<Object>();
			if (userName != null && !userName.trim().isEmpty()) {
				sql.append(" and destine_name like ?");
				params.add("%" + userName + "%");
			}
			if (userId != null && !userId.trim().isEmpty()) {
				sql.append(" and destine_id=?");
				params.add(userId);
			}
			return qr.query(sql.toString(), new BeanListHandler<User>(
					User.class), params.toArray());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void upUserFlight(String fid) {
		try {
			String sql = "update destine set destine_status=? where flight_id=?";
			Object[] params = { "是", fid };
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void inserDestine(User user) {
		try {
			String sql = "insert into destine values(?,?,?,?,?,?,?,?,?,?)";
			Object[] params = { user.getDestine_name(), user.getDestine_id(),
					user.getDestine_sex(), user.getDestine_age(),
					user.getDestine_phone(), user.getDestine_address(),
					user.getFlight_id(), user.getDestine_count(),
					"2020-12-14 8:30", user.getDestine_status() };
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void deleUserFlight(String fid,User user) {
		try {
			String sql = "DELETE FROM destine WHERE destine_name=? and flight_id=?";
			qr.update(sql, user.getDestine_name(),fid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public List<Flight> seleFlightByFromAndEnd(String begFrom, String endFrom) {
		try {

			StringBuilder sql = new StringBuilder(
					"select * from flight where 1=1");
			List<Object> params = new ArrayList<Object>();
			if (begFrom != null && !begFrom.trim().isEmpty()) {
				sql.append(" and begin_from like ?");
				params.add("%" + begFrom + "%");
			}

			if (endFrom != null && !endFrom.trim().isEmpty()) {
				sql.append(" and end_from=?");
				params.add(endFrom);
			}
			/*
			 * 三、执行query
			 */
			return qr.query(sql.toString(), new BeanListHandler<Flight>(
					Flight.class), params.toArray());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void upUserGq(String user_id, String flight_id,String oid_fld) {
		try {
			String sql = "update destine set destine_status=?,flight_id=? where destine_id=? and flight_id=?";
			Object[] params = {"否",flight_id,user_id,oid_fld};
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

}
