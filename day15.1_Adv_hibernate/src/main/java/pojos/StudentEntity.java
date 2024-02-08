package pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class StudentEntity extends BaseEntity {
	
	@Column(length = 30)
	private String name;
	@Column(length = 30, unique = true)
	private String email;
	
	//Association Mapping : uni-directional association from students(*)----->(1)course
	//i.e collection of many students(references) can have one course
	@ManyToOne
	@JoinColumn(name = "course_id", nullable = false)//annotation is optional but recommended and nullable = false implies NOTNULL CONSTRAINT(F.K)  
	private CourseEntity chosenCourse ;
	

	//default constructor
	public StudentEntity() {
		
	}
	
	//parameterized constructor
	public StudentEntity(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}


	//getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	//getter and setter of ASSOCIATION MAPPING : important
	public CourseEntity getChoosenCourse() {
		return chosenCourse;
	}

	public void setChoosenCourse(CourseEntity choosenCourse) {
		this.chosenCourse = choosenCourse;
	}
	

	//toString
	@Override
	public String toString() {
		return "StudentEntity [name=" + name + ", email=" + email + "]";
	}
}
