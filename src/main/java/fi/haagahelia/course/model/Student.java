package fi.haagahelia.course.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
    @Column(name = "firstname")    
	private String firstName;
	
    @Column(name = "lastname")
	private String lastName;
	
    @Column(name = "department")
	private String department;
    
    @Column(name = "email")
    private String email;    
    
    public Student() {
    }

	public Student(String firstName, String lastName, String department, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	
}
