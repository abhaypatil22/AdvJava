package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;


public class TestBootStrappingOfHibernateFramework {

	public static void main(String[] args) {
		
		try(SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)){
			System.out.println("Hibernate Up an Running.....");
		}//sf.close() : closing of connection pool

	}

}
