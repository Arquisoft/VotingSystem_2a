package es.uniovi.asw.persistence;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Clase para realizar la conexion con la base de datos
 * 
 * @author dario
 *
 */
public class Jdbc {

	/*
	 * Configuration for Oracle private static String DRIVER =
	 * "oracle.jdbc.driver.OracleDriver"; private static String URL =
	 * "jdbc:oracle:thin:@156.35.94.99:1521:DESA"; private static String USER =
	 * ""; private static String PASS = "";
	 */
	/*
	 * Configuration for Hsqldb
	 */
	private static String BD;
	private static String DRIVER;
	private static String URL;
	private static String USER;
	private static String PASS;

	Properties database = new Properties();

	public Jdbc() {

		try {
			database.load(new FileInputStream("h2.properties"));

			DRIVER = database.getProperty("DRIVER");
			URL = database.getProperty("URL");
			USER = database.getProperty("USER");
			PASS = database.getProperty("PASS");

			BD=database.getProperty("BD");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Jdbc(String fileName) {

		try {
			database.load(new FileInputStream(fileName));

			DRIVER = database.getProperty("DRIVER");
			URL = database.getProperty("URL");
			USER = database.getProperty("USER");
			PASS = database.getProperty("PASS");

			BD=database.getProperty("BD");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	static {
		try {
			
			Class.forName(DRIVER);
			if ("h2".equals(BD)) {

				try {
					crearDB();
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Driver not found in classpath", e);
		}
	}

	public static Connection getConnection() throws SQLException {

		return DriverManager.getConnection(URL, USER, PASS);
	}

	public static void close(ResultSet rs, Statement st, Connection c) {
		close(rs);
		close(st);
		close(c);
	}

	public static void close(ResultSet rs, Statement st) {
		close(rs);
		close(st);
	}

	protected static void close(ResultSet rs) {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
			}
		;
	}

	public static void close(Statement st) {
		if (st != null)
			try {
				st.close();
			} catch (SQLException e) {
			}
		;
	}

	public static void close(Connection c) {
		if (c != null)
			try {
				c.close();
			} catch (SQLException e) {
			}
		;
	}

	/**
	 * Metodo privado para crear la base de datos en caso de usar h2
	 * 
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws SQLException
	 */
	private static void crearDB()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		// ejecutamos el script de creacion de la BD
		String createTables = "CREATE TABLE  IF NOT EXISTS VOTANTES(ID BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL PRIMARY KEY,LOGIN VARCHAR(32768),NOMBRE VARCHAR(32768),EMAIL VARCHAR(32768),NIF VARCHAR(32768),CODCOLEGIO INTEGER,PASSWORD VARCHAR(32768))";

		Class.forName(DRIVER).newInstance();
		Connection con = getConnection();
		java.sql.Statement stm = con.createStatement();
		// stm.execute("drop table Votantes");
		stm.execute(createTables);
		stm.execute("truncate table Votantes");
		stm.close();
		con.close();
	}

}
