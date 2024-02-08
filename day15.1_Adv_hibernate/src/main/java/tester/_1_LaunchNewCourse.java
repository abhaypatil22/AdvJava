package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.ICourseDAOImpl;
import pojos.CourseEntity;


public class _1_LaunchNewCourse {

	public static void main(String[] args) {
		
		try(SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)){
			ICourseDAOImpl courseDao = new ICourseDAOImpl();
			System.out.println("Hibernate Up an Running.....");
			System.out.println("Enter Course details : title, startDate, endDate, fees, capacity ");
			System.out.println(courseDao.launchNewCourse(new CourseEntity(sc.next(), LocalDate.parse(sc.next()), LocalDate.parse(sc.next()), sc.nextDouble(), sc.nextInt())));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
