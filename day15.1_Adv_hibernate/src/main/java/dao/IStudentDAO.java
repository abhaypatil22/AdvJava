package dao;

import pojos.StudentEntity;

public interface IStudentDAO {
	
	//method to add student
	String admitNewStudent(String courseName, StudentEntity studentDetails);
	
	//method to delete single student admission
	String cancelAdmission(String courseName, int studentId);

}
