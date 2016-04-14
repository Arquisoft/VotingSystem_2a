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
						rs.getLong("CODCOMAUTONOMA"),
						rs.getBoolean("VOTOSFISICOS"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return col;
	}

	@Override
	public boolean save(ColegioElectoral col) {
		
			Connection con = null;
			PreparedStatement ps = null;
			
			try {
				
				con = Jdbc.getConnection();
				
				ps = con.prepareStatement(QUERIES.getProperty("SAVE_COL"));
				ps.setLong(1, col.getIdCircunscripcion());
				ps.setLong(2, col.getIdComAutonoma());
				ps.setBoolean(3, false);
				int num=ps.executeUpdate();
				
				return (num>0);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				Jdbc.close(con, ps);
			}
			return false;
		
	}

	@Override
	public boolean update(ColegioElectoral col) {
		
		Connection con = null;
		PreparedStatement ps = null;
		//QUERIES= loadProperties("./src/main/java/sql.properties");
		
		try {
			
			con = Jdbc.getConnection();
			
			ps = con.prepareStatement(QUERIES.getProperty("UPDATE_COL"));
			ps.setBoolean(3, col.isVotoFisico());
			
			int num=ps.executeUpdate();
			
			return (num>0);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Jdbc.close(con, ps);
		}
		return false;
		
	}

	
	
}
