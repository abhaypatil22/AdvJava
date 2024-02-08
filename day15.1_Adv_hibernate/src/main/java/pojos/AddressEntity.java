package pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student_address")
public class AddressEntity extends BaseEntity {
		@Column(length = 20)
		private String city;
		@Column(length = 20)
		private String state;
		@Column(length = 20)
		private String country;
		@Column(length = 20,name = "zip_code")
		private String pinCode;
		//uni-directional association from AdressEntity ----> StudentEntity (using shared PK approach)
		@OneToOne //mandatory otherwise org.hibernate.MappingException
		@JoinColumn(name = "student_id", nullable = false) //optional but recomended
		@MapsId //to specify shared PK approach
		private StudentEntity student;
		//default constructor
		public AddressEntity() {
		}
		//parameterized constructor
		public AddressEntity(String city, String state, String country, String pinCode) {
			super();
			this.city = city;
			this.state = state;
			this.country = country;
			this.pinCode = pinCode;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public String getPinCode() {
			return pinCode;
		}
		public void setPinCode(String pinCode) {
			this.pinCode = pinCode;
		}
		public StudentEntity getStudent() {
			return student;
		}
		public void setStudent(StudentEntity student) {
			this.student = student;
		}
		@Override
		public String toString() {
			return "AdressEntity id=" + getId() +" [city=" + city + ", state=" + state + ", country=" + country + ", pinCode=" + pinCode
					+ "]";
		}
		

}
