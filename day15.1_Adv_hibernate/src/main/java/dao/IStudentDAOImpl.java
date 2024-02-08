package dao;

import static utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.CourseEntity;
import pojos.StudentEntity;

public class IStudentDAOImpl implements IStudentDAO {

	@Override
	public String admitNewStudent(String courseName, StudentEntity studentDetails) {
		String mesg = "Student admission FAILED!!!!!!";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			//session.persist(courseName, studentDetails);
			//get course from course name :JPQL
			CourseEntity crs = session.createQuery("select c from CourseEntity c where c.title=:title",
					 CourseEntity.class).setParameter("title", courseName).getSingleResult();
			//course found : crs : PERSISTENT
			//establish bi-directional link using helper methods in CourseEntity
			crs.addStudent(studentDetails);
			//session.persist(studentDetails);//Explicitly saving student details
			//to avoid explicitly saving the details we use cascade in CourseEntity(parent side) so that hibernate can do it automatically
			tx.commit();
			mesg = "Student " + studentDetails.getName() +" Admitted SUCCESSFULLY in course " + courseName;
		}catch(Exception e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public String cancelAdmission(String courseName, int studentId) {
		String mesg = "Student admission cancellation FAILED!!!!!";
		String jpql = "select c from CourseEntity c where c.title=:title";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			//get course from its name
			CourseEntity c = session.createQuery(jpql, CourseEntity.class).setParameter("title", courseName).getSingleResult();
			StudentEntity s = session.get(StudentEntity.class, studentId);
			if(s != null) {
				//remove bi-directional link : helper method : removeStudent
				c.removeStudent(s);
				mesg = "Student " + s.getName() + " admission cancelled successfully..... ";
			}
			
			tx.commit();
		}catch(RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
 		return mesg;
	}

}
