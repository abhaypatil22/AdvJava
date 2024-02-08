package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.IAddressDAOImpl;
import dao.ICourseDAOImpl;
import pojos.AddressEntity;
import pojos.CourseEntity;

public class _10_LinkStudentAddress {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in) ; SessionFactory sf = getFactory() ){
			IAddressDAOImpl addressDao = new IAddressDAOImpl();
			System.out.println("Enter Student Id to link Address Details");
			int studentId = sc.nextInt();
			System.out.println("Enter Address Details : city, state, country, zincode");
			System.out.println(addressDao.assignAddressDetails(studentId, new AddressEntity(sc.next(), sc.next(), sc.next(), sc.next())));
			
		}

	}

}
