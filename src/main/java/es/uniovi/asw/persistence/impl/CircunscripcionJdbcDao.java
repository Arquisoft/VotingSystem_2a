package es.uniovi.asw.persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import es.uniovi.asw.model.Circunscripcion;
import es.uniovi.asw.persistence.CircunscripcionDao;
import es.uniovi.asw.persistence.Jdbc;

public class CircunscripcionJdbcDao implements CircunscripcionDao {

	private Properties QUERIES = Jdbc.getQueries();

	@Override
	public Circunscripcion findById(Long id) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Circunscripcion circ= null;
		
		try {
			con = Jdbc.getConnection();

			ps = con.prepareStatement(QUERIES.getProperty("FIND_CIRC"));
			ps.setLong(1, id);
			rs=ps.executeQuery();
			
			if(rs.next()){
				
				String nombre= rs.getString("nombre");
				circ = new Circunscripcion(id, nombre);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			Jdbc.close(rs, ps, con);
		}

		return circ;

	}

	@Override
	public void save(Circunscripcion circ) {
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = Jdbc.getConnection();

			ps = con.prepareStatement(QUERIES.getProperty("SAVE_CIRC"));
			ps.setString(1, circ.getNombre());
			
			ps.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Jdbc.close(con, ps);
		}
		
	}

}
