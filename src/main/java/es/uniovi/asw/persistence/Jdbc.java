package es.uniovi.asw.persistence;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
	private static final String QUERIES_PROPERTIES_FILE = "./src/main/java/sql.properties";
	private static final String DATABASE_PROPERTIES_FILE = "./src/main/java/h2.properties";
	//private static final String DATABASE_PROPERTIES_FILE = "jdbc.properties";
	//private static final String DATABASE_PROPERTIES_FILE = "mysql.properties";

	private static String BD;
	private static String DRIVER;
	private static String URL;
	private static String USER;
	private static String PASS;

	private static Properties DATABASE;
	private static Properties QUERIES;
	
	static {
		try {
			
			DATABASE=loadProperties(DATABASE_PROPERTIES_FILE);
			QUERIES=loadProperties(QUERIES_PROPERTIES_FILE);

			DRIVER = DATABASE.getProperty("DRIVER");
			URL = DATABASE.getProperty("URL");
			USER = DATABASE.getProperty("USER");
			PASS = DATABASE.getProperty("PASS");

			BD=DATABASE.getProperty("BD");
			
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
	
	public static void close(Connection c , Statement st) {
		
		close(st);
		close(c);
		
	}

	protected static void close(ResultSet rs) {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
			}

	}

	public static void close(Statement st) {
		if (st != null)
			try {
				st.close();
			} catch (SQLException e) {
			}

	}

	public static void close(Connection c) {
		if (c != null)
			try {
				c.close();
			} catch (SQLException e) {
			}

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
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, SQLException {

		List<String> listaQueries= new ArrayList<String>();
		
		listaQueries.add(QUERIES.getProperty("CREAR_TABLA_VOTANTES"));
		listaQueries.add(QUERIES.getProperty("CREAR_TABLA_COL_ELECT"));
		listaQueries.add( QUERIES.getProperty("CREAR_TABLA_VOTACIONES"));
		listaQueries.add(QUERIES.getProperty("CREAR_TABLA_VOTOS"));
		listaQueries.add(QUERIES.getProperty("CREAR_TABLA_HAN_VOTADO"));
		listaQueries.add(QUERIES.getProperty("CREAR_TABLA_OPCIONES"));
		listaQueries.add(QUERIES.getProperty("CREAR_TABLA_COM_AUTONOMAS"));
		listaQueries.add(QUERIES.getProperty("CREAR_TABLA_CIRCUNSCRIPCIONES"));
		listaQueries.add(QUERIES.getProperty("VACIAR_TABLA_VOTANTES"));

		for(String query: listaQueries){
		
			crearTabla(query);
			
		}
		
	}
	
	private static void crearTabla(String createTables)
			throws SQLException, InstantiationException,
			IllegalAccessException, ClassNotFoundException {
		
		Class.forName(DRIVER).newInstance();
		Connection con = getConnection();
		Statement stm = con.createStatement();
		
		stm.execute(createTables);

		stm.close();
		con.close();
		
	}

	private static Properties loadProperties(String fileName) {
		
		Properties prop = new Properties();
		InputStream stream;
		
		try {
			
			stream = new FileInputStream(fileName);
			prop.load( stream );
			
		} catch (IOException e) {
		}
		
		return prop;
		
	}
	
	public static Properties getQueries(){
		
		return QUERIES;
		
	}
	
}
