package es.uniovi.asw.persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import es.uniovi.asw.model.Votado;
import es.uniovi.asw.persistence.Jdbc;
import es.uniovi.asw.persistence.VotadoDao;

public class VotadoJdbcDao implements VotadoDao {
	
	private Properties QUERIES = Jdbc.getQueries();

	@Override
	public void save(Votado votado) {
		
		Connection con=null;
		PreparedStatement ps=null;
		
		try {
			
			con=Jdbc.getConnection();
			ps=con.prepareStatement(QUERIES.getProperty("SAVE_VOTADO"));
			ps.setLong(1, votado.getIdVotante());
			ps.setLong(2, votado.getIdVotacion());
			
			ps.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			Jdbc.close(con, ps);
		}
		
	}

	@Override
	public boolean haVotado(Long idUser, Long idVotacion) {

		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs= null;
		
		try {
			
			con=Jdbc.getConnection();
			ps=con.prepareStatement(QUERIES.getProperty("SAVE_VOTADO"));
			ps.setLong(1, idUser);
			ps.setLong(2, idVotacion);
			
			rs=ps.executeQuery();
			
			if(rs!=null && rs.next()){
				
				return true;
				
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			Jdbc.close(rs, ps, con);
		}
		
		
		return false;
		
	}

	

}
