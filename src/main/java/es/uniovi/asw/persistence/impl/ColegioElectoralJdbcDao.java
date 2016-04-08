package es.uniovi.asw.persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import es.uniovi.asw.model.ColegioElectoral;
import es.uniovi.asw.persistence.ColegioElectoralDao;
import es.uniovi.asw.persistence.Jdbc;

public class ColegioElectoralJdbcDao implements ColegioElectoralDao {

	private Properties QUERIES = Jdbc.getQueries();
	
	@Override
	public ColegioElectoral findById(Long id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ColegioElectoral col= null;
		
		try {
			con = Jdbc.getConnection();

			ps = con.prepareStatement(QUERIES.getProperty("FIND_COL"));
			ps.setLong(1, id);
			rs=ps.executeQuery();
			
			if(rs.next()){
				
				col = new ColegioElectoral(id,
						rs.getLong("CODCINCURSCRIPCION"),
						rs.getLong("CODCOMAUTONOMA"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return col;
	}

}
