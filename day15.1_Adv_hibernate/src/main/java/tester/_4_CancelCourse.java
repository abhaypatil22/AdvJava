package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.ICourseDAOImpl;
import pojos.CourseEntity;


public class _4_CancelCourse {

	public static void main(String[] args) {
		
		try(SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)){
			ICourseDAOImpl courseDao = new ICourseDAOImpl();
			System.out.println("Enter Course id");
			System.out.println(courseDao.cancelCourse(sc.nextInt()));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
