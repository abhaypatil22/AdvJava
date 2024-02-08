package dao;

import pojos.CourseEntity;

public interface ICourseDAO {
	
	//launch new course
	String launchNewCourse(CourseEntity c);
	
	//cancel the course
	String cancelCourse(int courseId);
	
	//get course details
	CourseEntity getCourseDetails(String courseTitle);
	
	//get course and student details
	CourseEntity getCourseAndStudentDetails(String courseTitle);
	
	//get course and student details using size() : multiple select query fired here 
	CourseEntity getCourseAndStudentDetailsUsingSize(String courseTitle);

	//get course and student details using join fetch : single select query fired here 
	CourseEntity getCourseAndStudentDetailsUsingJoinFetch(String courseTitle);

}
