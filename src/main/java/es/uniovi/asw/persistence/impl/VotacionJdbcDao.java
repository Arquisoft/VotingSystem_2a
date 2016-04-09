package es.uniovi.asw.persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import es.uniovi.asw.model.Votacion;
import es.uniovi.asw.persistence.Jdbc;
import es.uniovi.asw.persistence.VotacionDao;

public class VotacionJdbcDao implements VotacionDao {
	
	private Properties QUERIES = Jdbc.getQueries();
	
	@Override
	public void save(Votacion votacion) {
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			
			con=Jdbc.getConnection();
			ps=con.prepareStatement(QUERIES.getProperty("SAVE_VOTACION"));
			ps.setString(1, votacion.getDefinicion());
			
			ps.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Jdbc.close(con, ps);
		}
		
	}

	@Override
	public Votacion findById(Long id) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Votacion vot=null;
		
		try {
			con=Jdbc.getConnection();
			ps=con.prepareStatement(QUERIES.getProperty("FIND_VOTACION"));
			ps.setLong(1, id);
			
			rs=ps.executeQuery();
			
			if(rs.next()){

				vot=new Votacion(id, rs.getString("DEFINICION"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Jdbc.close(rs, ps, con);
		}
		
		
		return vot;
		
	}

}
