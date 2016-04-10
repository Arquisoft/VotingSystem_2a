package es.uniovi.asw.model;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase Usuario que contiene todos los datos necesarios de los votantes
 * 
 * @author VotingSystem_2a Añadidos usuarios a la BBDD y documentacion de clases
 *
 */
public class Usuario {

	private String nombre;
	private String email;
	private String NIF;
	private String password;
	private int codColElectoral;
	private int id;
	private String login;
	private boolean votoElectronico;

	/**
	 * Constructor de la clase Usuario
	 */
	public Usuario() {

		this.password = generarPassword(10);

	}
	

	/**
	 * Constructor de la clase usuario
	 * 
	 * @param nombre
	 *            , que contiene el nombre del usuario
	 * @param email
	 *            , que contiene el mail del usuario
	 * @param NIF
	 *            , que contiene el NIF del usuario
	 * @param password
	 *            , que contiene la password con la que se loguea el usuario
	 * @param codColElectoral
	 *            , que contiene el numero del colegio electoral asignado al
	 *            usuario
	 * @param id
	 * @param Login
	 *            , que contiene el nombre de usuario que el votante utilizara
	 *            como login
	 */
	public Usuario(String nombre, String email, String NIF, String password,
			int codColElectoral, int id, String login) {

		this.nombre = nombre;
		setEmail(email);
		setNIF(NIF);
		this.password = password;
		this.codColElectoral = codColElectoral;
		this.id = id;
		this.login=login;

	}

	/**
	 * Constructor de la clase usuario
	 * 
	 * @param nombre,
	 *            que contiene el nombre del usuario
	 * @param email
	 *            , que contiene el mail del usuario
	 * @param NIF,
	 *            que contiene el NIF del usuario
	 * @param codColElectoral,
	 *            que contiene el numero del colegio electoral asignado al
	 *            usuario
	 */
	public Usuario(String nombre, String email,
			String NIF,	int codColElectoral) {

		this.nombre = nombre;
		setEmail(email);
		setNIF(NIF);
		this.password = generarPassword(10);
		this.codColElectoral = codColElectoral;
		login = nombre.replace(" ", "");

	}

	/**
	 * Metodo que nos devuelve el nombre del usuario
	 * 
	 * @return nombre, el nombre del usuario
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo que nos permite cambiar el nombre de un usuario
	 * 
	 * @param nombre,
	 *            el nombre del usuario
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
		login = nombre.replace(" ", "");
	}

	/**
	 * Metodo que nos devuelve el email del usuario
	 * 
	 * @return email, el email del usuario
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Metodo que nos permtie cambiar el mail de un usuario
	 * 
	 * @param email
	 */
	public void setEmail(String email) {

		if (!validarMail(email)) {
			throw new IllegalArgumentException("Email " + email + " mal formado");
		}
		this.email = email;

	}

	/**
	 * metodo que nos devuelve el NIF de un usuario
	 * 
	 * @return NIF, el NIF del usuario
	 */
	public String getNIF() {
		return NIF;
	}

	/**
	 * Metodo que nos permite cambiar el NIF de un usuario
	 * 
	 * @param NIF,
	 *            el NIF del usuario
	 */
	public void setNIF(String NIF) {
		if (!comprobarDNI(NIF)) {
			throw new IllegalArgumentException("DNI " + NIF + " Incorrecto");
		}
		this.NIF = NIF;
	}

	/**
	 * Metodo que nos devuelve la password del usuario
	 * 
	 * @return password, la password del usuario
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Metodo que nos permtie cambiar la password de un usuario
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;

	}

	/**
	 * Metodo que nos devuelve el Cod del colegio electoral del usuario
	 * 
	 * @return codColElectoral
	 */
	public int getCodColElectoral() {
		return codColElectoral;
	}

	/**
	 * Metodo que nos permite cambiar el codigo del Colegio Electoral
	 * 
	 * @param codColElectoral
	 */
	public void setCodColElectoral(int codColElectoral) {
		this.codColElectoral = codColElectoral;
	}

	public int getId() {
		return id;
	}

	/**
	 * Metodo que nos devuelve el login del usuario
	 * 
	 * @return login, el login del usuario
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * Metodo que nos permite cambiar el login con el que se valida un usuario
	 * 
	 * @param login,
	 *            el login del usuario
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	public boolean isVotoElectronico() {
		
		return votoElectronico;
		
	}

	public void setVotoElectronico(boolean votoElectronico) {
		
		this.votoElectronico = votoElectronico;
		
	}

	/**
	 * Metodo toString que nos devuelve una cadena con toda la informacion del
	 * usuario
	 */
	@Override
	public String toString() {

		return "Usuario [nombre=" + nombre + ", email=" + email 
				+ ", NIF=" + NIF + ", password=" + password
				+ ", codColElectoral=" + codColElectoral 
				+ ", id=" + id + ", login=" + login + "]";

	}

	/**
	 * Metodo que nos permite comprobar si un mail es correcto
	 * 
	 * @param mail,
	 *            el mail del usuario
	 * @return true, en el caso de que la validacion sea verdadera, falso en
	 *         caso contrario
	 */
	private boolean validarMail(String mail) {

		String patronMail = "^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@"
				+ "([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)"
				+ "+[a-zA-Z]{2,3})$";

		Pattern patron = Pattern.compile(patronMail);

		Matcher comparador = patron.matcher(mail);

		return comparador.matches();

	}

	/**
	 * Metodo privado que nos permite comprobar si un DNI esta formado
	 * correctamente
	 * 
	 * @param dni,
	 *            el NIF del usuario
	 * @return true en caso de que este bien formado, false en el caso contrario
	 */
	private boolean comprobarDNI(String dni) {

		char[] letraDni = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V',
				'H', 'L', 'C', 'K', 'E' };

		int numero = Integer.valueOf(dni.substring(0, dni.length() - 1));
		String letra = dni.substring(dni.length() - 1, dni.length());
		numero = numero % 23;
		String letraArray = String.valueOf(letraDni[numero]);

		return letra.equals(letraArray);
		
	}

	/**
	 * Metodo privado que nos permite generar la password de un usuario
	 * 
	 * @param longitud,
	 *            la longitud de la password
	 * @return retorno, que es un string que contiene la password
	 */
	private String generarPassword(int longitud) {

		String clave = "0123456789"
				+ "abcdefghijklmnopqrstuvwxyz"
				+ "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random r = new Random();
		String retorno = "";

		for (int i = 0; i < longitud; i++) {

			retorno += clave.charAt(r.nextInt(clave.length()));

		}

		return retorno;

	}

}
