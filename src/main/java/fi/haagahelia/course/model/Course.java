package fi.haagahelia.course.model;

import java.util.Set;

import javax.persistence.*;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)	
	private long courseid;
	
    @Column(name="coursename")
	private String name; 
     
	public Course() {
	}

	public Course(String name) {
		this.name = name;
	}     

    public long getCourseid() {
		return courseid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
    
    @ManyToMany(mappedBy = "courses")    
    private Set<Student> students;  
    
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }	
}
