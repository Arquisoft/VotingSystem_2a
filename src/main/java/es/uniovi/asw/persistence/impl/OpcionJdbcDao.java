package es.uniovi.asw.persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import es.uniovi.asw.model.Opcion;
import es.uniovi.asw.persistence.Jdbc;
import es.uniovi.asw.persistence.OpcionDao;

public class OpcionJdbcDao implements OpcionDao {

	private Properties QUERIES = Jdbc.getQueries();

	@Override
	public Opcion findById(Long id) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Opcion opc=null;
		
		try {
			con=Jdbc.getConnection();
			ps=con.prepareStatement(QUERIES.getProperty("FIND_OPCION"));
			ps.setLong(1, id);
			rs=ps.executeQuery();
			
			if(rs.next()){
				
				opc=new Opcion(id, rs.getLong("CODVOTACION"), rs.getString("DEFINICION"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Jdbc.close(rs, ps, con);
		}
		
		
		return opc;
		
	}

	@Override
	public boolean save(Opcion opcion) {
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			
			con=Jdbc.getConnection();
			ps=con.prepareStatement(QUERIES.getProperty("SAVE_OPCION"));
			ps.setLong(1, opcion.getIdVotacion());
			ps.setString(2, opcion.getDescripcion());
			
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
	public List<Opcion> listOpcionesByVotacion(Long idVotacion) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Opcion> listaOpciones = new ArrayList<Opcion>();
		
		try {
			con=Jdbc.getConnection();
			
			ps=con.prepareStatement(QUERIES.getProperty("FIND_OPCIONES_VOTACION"));
			ps.setLong(1, idVotacion);
			rs=ps.executeQuery();
			
			Opcion opc=null;
			
			while(rs.next()){
				
				opc=new Opcion(rs.getLong("id"), idVotacion, rs.getString("DEFINICION"));
				
				listaOpciones.add(opc);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			Jdbc.close(rs, ps, con);
		}
		
		return listaOpciones;
		
	}

}
