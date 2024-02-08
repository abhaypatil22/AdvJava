package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.ICourseDAOImpl;
import pojos.CourseEntity;

public class _9_GetCourseAndStudentsDetailsUsingJoinFetch {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in) ; SessionFactory sf = getFactory() ){
			ICourseDAOImpl courseDao = new ICourseDAOImpl();
			System.out.println("Enter course name to display student details");
			CourseEntity course = courseDao.getCourseAndStudentDetailsUsingJoinFetch(sc.next());
			System.out.println("Course details......");
			System.out.println(course);
			System.out.println("Students details......");
			course.getStudents().forEach(System.out::println);;
		}

	}

}
