package dao;

import static utils.HibernateUtils.getFactory;

import org.hibernate.Transaction;

import org.hibernate.Session;

import pojos.CourseEntity;

public class ICourseDAOImpl implements ICourseDAO {

	@Override
	public String launchNewCourse(CourseEntity c) {
		String mesg = "Course launching FAILED!!!!!!!!";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.persist(c);
			tx.commit();
			mesg = "Launched new Course with ID :" + c.getId();
		}catch(RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public String cancelCourse(int courseId) {
		String mesg = "Course Cancellation FAILED!!!!!!!!";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			//get course from it's id
			CourseEntity c = session.get(CourseEntity.class, courseId);
			if(c != null) {
			//delete the course
				session.delete(c);//c : REMOVED : marked for REMOVAL
				mesg = "course cancelled with id :" + courseId;
			}
			tx.commit();//auto dirty checking : deletes child records first and then parent records
			
		}catch(RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public CourseEntity getCourseDetails(String courseTitle) {
		CourseEntity c = null;
		String jpql = "select c from CourseEntity c where c.title = :title";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			c = session.createQuery(jpql, CourseEntity.class).setParameter("title", courseTitle).getSingleResult();
			//c : PERSISTENT
			tx.commit();
			
		}catch(RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return c; // c : DETACHED
		
	}

	@Override
	public CourseEntity getCourseAndStudentDetails(String courseTitle) {
		CourseEntity course = null;
		String jpql = "select c from CourseEntity c where c.title = :title";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			course = session.createQuery(jpql, CourseEntity.class).setParameter("title", courseTitle).getSingleResult();
			//course : PERSISTENT
			tx.commit();
		}catch(RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		
		return course;
	}
	
	@Override
	public CourseEntity getCourseAndStudentDetailsUsingSize(String courseTitle) {
		CourseEntity course = null;
		String jpql = "select c from CourseEntity c where c.title = :title";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			course = session.createQuery(jpql, CourseEntity.class).setParameter("title", courseTitle).getSingleResult();
			//course : PERSISTENT
			//simply access the size of collection from within the session scope
			course.getStudents().size();//here another select query will be fired on students table
			tx.commit();
		}catch(RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		
		return course;
	}
	
	@Override
	public CourseEntity getCourseAndStudentDetailsUsingJoinFetch(String courseTitle) {
		CourseEntity course = null;
		String jpql = "select c from CourseEntity c join fetch c.students where c.title = :title";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			course = session.createQuery(jpql, CourseEntity.class).setParameter("title", courseTitle).getSingleResult();
			//course : PERSISTENT
			//here(120) single select query with inner join will be fired on course table to fetch students data
			tx.commit();
		}catch(RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		
		return course;
	}

}
