package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;
import static java.time.LocalDate.parse;
import dao.ICourseDAOImpl;
import pojos.CourseEntity;
import pojos.StudentEntity;

public class _3_LaunchNewCourseWithStudents {

	public static void main(String[] args) {
		
		try(Scanner sc = new Scanner(System.in) ; SessionFactory sf = getFactory()){
			ICourseDAOImpl courseDao = new ICourseDAOImpl();
			System.out.println("Enter course details : title, startDate, endDate, fees, capacity");
			CourseEntity c = new CourseEntity(sc.next(), parse(sc.next()), parse(sc.next()), sc.nextDouble(), sc.nextInt()); 
			for(int i = 0; i < 3; i++) {
				System.out.println("Enter students details : name, email");
				c.addStudent(new StudentEntity(sc.next(), sc.next()));
			}
			//object heap : c,s1,s2,s3 with bi-directional link established
			System.out.println(courseDao.launchNewCourse(c));
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
