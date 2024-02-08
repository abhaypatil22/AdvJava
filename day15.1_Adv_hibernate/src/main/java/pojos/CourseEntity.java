package pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "courses")
public class CourseEntity extends BaseEntity {
	@Column(length=30, unique=true)
	private String title;
	@Column(name="start_date")
	private LocalDate startDate;
	@Column(name="end_date")
	private LocalDate endDate;
	
	private double amount;
	@Column(name="capacity_of_students")
	private int studentCapacity;
	
	
	//Association Mapping : uni-directional association from course(1)----->(*)students
	@OneToMany(mappedBy = "chosenCourse", cascade = CascadeType.ALL, orphanRemoval = true/* , fetch = FetchType.EAGER */)
	private List<StudentEntity> students =  new ArrayList<>();//ALWAYS initialize the collection, to avoid NullPointerException;
	
	//default constructor
	public CourseEntity() {
		
	}
	
	//parameterized constructor
	public CourseEntity(String title, LocalDate startDate, LocalDate endDate, double amount, int studentCapacity) {
		super(); 
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
		this.amount = amount;
		this.studentCapacity = studentCapacity;
	}


	//getters and setters
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getStudentCapacity() {
		return studentCapacity;
	}

	public void setStudentCapacity(int studentCapacity) {
		this.studentCapacity = studentCapacity;
	}
	
	//getter and setter of ASSOCIATION MAPPING : important
	public List<StudentEntity> getStudents() {
		return students;
	}

	public void setStudents(List<StudentEntity> students) {
		this.students = students;
	}

	//toString()
	@Override
	public String toString() {
		return "CourseEntity [title=" + title + ", startDate=" + startDate + ", endDate=" + endDate + ", amount="
				+ amount + ", studentCapacity=" + studentCapacity + "]";
	}
	
	//ADD helper methods to establish bi-directional link between CourseEntity and StudentEntity
	public void addStudent(StudentEntity std) {
		//bi-dir link
		students.add(std);//course---->student
		std.setChoosenCourse(this);//student--->course
	}
	
	//ADD helper methods to remove bi-directional link between CourseEntity and StudentEntity
		public void removeStudent(StudentEntity std) {
			//bi-dir link
			students.remove(std);//course-----X----->student
			std.setChoosenCourse(null);//student----X--	--->course
		}
	
	
}
