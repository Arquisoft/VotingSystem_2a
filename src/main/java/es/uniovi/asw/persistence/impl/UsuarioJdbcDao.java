package es.uniovi.asw.persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import es.uniovi.asw.model.Usuario;
import es.uniovi.asw.persistence.Jdbc;
import es.uniovi.asw.persistence.UsuarioDao;

/**
 * Calse encargada de las acciones con la base de datos
 * 
 * @author dario
 *
 */
public class UsuarioJdbcDao implements UsuarioDao {

	private Properties QUERIES = Jdbc.getQueries();

	/**
	 * Metodo para obtener un listado de todos los usuarios que hay en la base
	 * de datos
	 * 
	 * @return lista de usuarios
	 */
	@Override
	public List<Usuario> getUsuarios() {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			con = Jdbc.getConnection();

			ps = con.prepareStatement(QUERIES.getProperty("FIND_ALL_USERS"));

			rs = ps.executeQuery();

			while (rs.next()) {
				Usuario usuario = new Usuario(rs.getString("nombre"), 
						rs.getString("Email"), rs.getString("NIF"),
						rs.getString("Password"), rs.getInt("CodColegio"), 
						rs.getInt("id"), rs.getString("login"));

				usuarios.add(usuario);
			}

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			Jdbc.close(ps);
			Jdbc.close(con);

		}

		return usuarios;

	}

	/**
	 * Metodo para guardar usuarios en la base de datos
	 * 
	 * @param user
	 *            usuario a meter en la bd
	 * @return true si el usuario se metio correctamente, false si no es asi
	 */
	@Override
	public boolean save(Usuario user) {

		Connection con = null;

		PreparedStatement ps = null;
		int rows = 0;

		if (findByNIF(user.getNIF()) == null) {

			try {

				con = Jdbc.getConnection();

				ps = con.prepareStatement(QUERIES.getProperty("SAVE_SQL"));
				ps.setString(1, user.getLogin());
				ps.setString(2, user.getNombre());
				ps.setString(3, user.getEmail());
				ps.setString(4, user.getNIF());
				ps.setInt(5, user.getCodColElectoral());
				ps.setString(6, user.getPassword());
				ps.setBoolean(7, user.isVotoElectronico());
				
				rows = ps.executeUpdate();
				if (rows != 1) {
					System.out.println("User "
							+user.getNombre()+" already exist");
					return false;
				}

				return true;

			} catch (SQLException e) {

				System.out.println(e.getMessage());

			} finally {

				Jdbc.close(ps);
				Jdbc.close(con);

			}

		}

		return false;

	}
	
	

	/**
	 * Metodo pra buscar usuario a partir de su nif
	 * 
	 * @param nif
	 *            del usuario que se quiere buscar
	 * @return el usuario al que pertenece ese nif o null en caso de que ese nif
	 *         no este en la bd
	 */
	@Override
	public Usuario findByNIF(String nif) {

		Connection con = null;

		PreparedStatement ps = null;

		try {

			con = Jdbc.getConnection();

			ps = con.prepareStatement(QUERIES.getProperty("FIND_USER"));
			ps.setString(1, nif);

			ResultSet rs = ps.executeQuery();
			Usuario user = null;

			if (rs != null && rs.next()) {

				String nombre = rs.getString(3);
				String password = rs.getString(7);
				String email = rs.getString(4);
				int CodColegio = rs.getInt(6);
				int id = rs.getInt(1);
				String login = rs.getString(2);

				user = new Usuario(nombre, email, nif,
						password, CodColegio, id, login);
				user.setVotoElectronico(rs.getBoolean("VOTOELECTRONICO"));
			}

			return user;

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			Jdbc.close(ps);
			Jdbc.close(con);

		}

		return null;

	}



}
