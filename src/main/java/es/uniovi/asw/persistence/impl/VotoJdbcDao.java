package es.uniovi.asw.persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import es.uniovi.asw.model.Voto;
import es.uniovi.asw.persistence.Jdbc;
import es.uniovi.asw.persistence.VotoDao;

public class VotoJdbcDao implements VotoDao {

	private Properties QUERIES = Jdbc.getQueries();

	@Override
	public boolean save(Voto voto) {

		Connection con = null;
		PreparedStatement ps = null;

		try {

			con = Jdbc.getConnection();
			ps = con.prepareStatement(QUERIES.getProperty("SAVE_VOTE"));

			ps.setLong(1, voto.getIdOpcion());
			ps.setLong(2, voto.getIdColElect());
			ps.setLong(3, voto.getTotVotos());

			int num=ps.executeUpdate();

			return (num>0);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.close(con, ps);
		}
		
		return false;

	}

	@Override
	public boolean update(Voto voto) {

		Connection con = null;
		PreparedStatement ps = null;

		try {

			con = Jdbc.getConnection();
			ps = con.prepareStatement(QUERIES.getProperty("UPDATE_VOTE"));

			ps.setLong(1, voto.getTotVotos()+1);
			ps.setLong(2, voto.getIdOpcion());
			ps.setLong(3, voto.getIdColElect());

			int num=ps.executeUpdate();

			return (num>0);

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			Jdbc.close(con, ps);
		}
		return false;

	}

	@Override
	public Voto find(Long idOpcion, Long idColElect) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs= null;
		Voto voto= null;
		
		try {

			con = Jdbc.getConnection();
			ps = con.prepareStatement(QUERIES.getProperty("FIND_VOTE"));
			ps.setLong(1, idOpcion);
			ps.setLong(2, idColElect);

			rs=ps.executeQuery();

			if(rs.next()){
				
				Long totVotos=rs.getLong("totVotos");
				voto = new Voto(idOpcion, idColElect, totVotos);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			Jdbc.close(rs, ps, con);
		}

		return voto;
	}

}
