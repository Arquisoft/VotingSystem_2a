package es.uniovi.asw.persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import es.uniovi.asw.model.ComunidadAutonoma;
import es.uniovi.asw.persistence.ComunidadAutonomaDao;
import es.uniovi.asw.persistence.Jdbc;

public class ComunidadAutonomaJdbcDao implements ComunidadAutonomaDao {
	
	private Properties QUERIES = Jdbc.getQueries();

	@Override
	public ComunidadAutonoma findById(Long id) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ComunidadAutonoma com= null;
		
		try {
			con = Jdbc.getConnection();

			ps = con.prepareStatement(QUERIES.getProperty("FIND_COM"));
			ps.setLong(1, id);
			rs=ps.executeQuery();
			
			if(rs.next()){
				
				String nombre= rs.getString("nombre");
				com = new ComunidadAutonoma(id, nombre);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return com;

	}
	
}
