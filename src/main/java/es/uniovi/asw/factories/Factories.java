package es.uniovi.asw.factories;

import es.uniovi.asw.business.ServiceFactory;
import es.uniovi.asw.business.impl.SimpleserviceFactory;
import es.uniovi.asw.persistence.PersistenceFactory;
import es.uniovi.asw.persistence.impl.SimplePersistenceFactory;

public class Factories {
	
	public static PersistenceFactory persistence = new SimplePersistenceFactory();
	public static ServiceFactory service = new SimpleserviceFactory();
	
}
