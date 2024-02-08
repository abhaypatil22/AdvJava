package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.ICourseDAOImpl;
import pojos.CourseEntity;


public class _7_GetCourseAndStudentDetails {

	public static void main(String[] args) {
		
		try(SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)){
			ICourseDAOImpl courseDao = new ICourseDAOImpl();
			System.out.println("Enter Course name to display the details ");
			CourseEntity courses = courseDao.getCourseDetails(sc.next());
			System.out.println("Course details ");
			System.out.println(courses);
			System.out.println("Students details");
			courses.getStudents().forEach(System.out::println);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
