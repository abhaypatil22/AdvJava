package utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//Creates SINGLETON, IMMUTABLE, HEAVY WEIGHT SessionFactory object (INHERENTLY THREAD SAFE)
public class HibernateUtils {
	
	private static SessionFactory factory;
	static {
		System.out.println("In static initializer block of HibernateUtils.....");
		factory = new Configuration().configure().buildSessionFactory();
	}
	
	//as it is a private member, supply getter
	public static SessionFactory getFactory() {
		return factory;
	}

}
