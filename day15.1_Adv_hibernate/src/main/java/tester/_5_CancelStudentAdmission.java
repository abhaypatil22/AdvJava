package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.ICourseDAOImpl;
import dao.IStudentDAOImpl;
import pojos.CourseEntity;
import pojos.StudentEntity;


public class _5_CancelStudentAdmission {

	public static void main(String[] args) {
		
		try(SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)){
			IStudentDAOImpl studentDao = new IStudentDAOImpl();
			System.out.println("Hibernate Up an Running.....");
			System.out.println("Enter courseName and student id");
			System.out.println(studentDao.cancelAdmission(sc.next(), sc.nextInt()));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
