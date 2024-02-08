package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.ICourseDAOImpl;
import dao.IStudentDAOImpl;
import pojos.CourseEntity;
import pojos.StudentEntity;


public class _2_admitNewStudent {

	public static void main(String[] args) {
		
		try(SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)){
			IStudentDAOImpl studentDao = new IStudentDAOImpl();
			System.out.println("Hibernate Up an Running.....");
			System.out.println("Enter Student details : courseName, studentName, email");
			System.out.println(studentDao.admitNewStudent(sc.next(), new StudentEntity(sc.next(), sc.next())));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
