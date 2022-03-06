package cn.flight.dao.admini;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.flight.domain.Admini;
import cn.flight.domain.Flight;
import cn.itcast.jdbc.TxQueryRunner;
/**
 * 管理员数据库实现
 * @author MI
 *
 */
public class AdminiLoginDaoImpl implements AdminiLoginDao {
	QueryRunner qr = new TxQueryRunner();

	public Admini getAdmini(Admini admini) {
		try {
			String sql = "select * from admini where username=?";
			return qr.query(sql, new BeanHandler<Admini>(Admini.class),
					admini.getUsername());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Flight> seleAllFlight() {
		try {
			String sql = "select * from flight";
			return qr.query(sql, new BeanListHandler<Flight>(Flight.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void addFlight(Flight flight) {
		try {
			String sql = "insert into flight values(?,?,?,?,?,?,?)";
			Object[] params = { flight.getFlight_id(), flight.getBegin_from(),
					flight.getEnd_from(), flight.getBegin_time(),
					flight.getEnd_time(), flight.getRemain(),
					flight.getTicket_price() };
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public int deleFlight(String infid) {
		try {
			String sql = "DELETE FROM flight WHERE flight_id=?";
			qr.update(sql, infid);
			return 1;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public Flight seleFlightByID(String fid) {
		try {
			String sql = "select * from flight where flight_id=?";
			return qr.query(sql, new BeanHandler<Flight>(Flight.class), fid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public int updateFlight(Flight flight) {
		try {
			String sql = "update flight set begin_from=?,end_from=?,begin_time=?," +
					"end_time=?,remain=?,ticket_price=? where flight_id=?";
			Object[] params = {flight.getBegin_from(), flight.getEnd_from(),
					flight.getBegin_time(), flight.getEnd_time(), flight.getRemain(),
					flight.getTicket_price(), flight.getFlight_id()};
			qr.update(sql, params);
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return 0;
	}

}
