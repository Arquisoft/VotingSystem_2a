package es.uniovi.asw.persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import es.uniovi.asw.model.Votacion;
import es.uniovi.asw.persistence.Jdbc;
import es.uniovi.asw.persistence.VotacionDao;

public class VotacionJdbcDao implements VotacionDao {
	
	private Properties QUERIES = Jdbc.getQueries();
	
	@Override
	public boolean save(Votacion votacion) {
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			
			con=Jdbc.getConnection();
			ps=con.prepareStatement(QUERIES.getProperty("SAVE_VOTACION"));
			ps.setString(1, votacion.getDefinicion());
			
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

	@Override
	public List<Votacion> findAll() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Votacion> vot=new ArrayList<Votacion>();
		
		try {
			con=Jdbc.getConnection();
			ps=con.prepareStatement(QUERIES.getProperty("FIND_TODAS_VOTACIONES"));
			rs=ps.executeQuery();
			while(rs.next()){
				vot.add(new Votacion(rs.getLong("id"), rs.getString("DEFINICION")));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Jdbc.close(rs, ps, con);
		}
		
		return vot;
	
	}

}
