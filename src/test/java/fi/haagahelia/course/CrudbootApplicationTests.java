package fi.haagahelia.course;

import org.junit.Test;
import org.junit.runner.*;

import static org.junit.Assert.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fi.haagahelia.course.domain.Student;
import fi.haagahelia.course.domain.StudentRepository;
import fi.haagahelia.course.domain.User;
import fi.haagahelia.course.domain.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {CrudbootApplication.class, WebSecurityConfig.class })
public class CrudbootApplicationTests {


	private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private StudentRepository studentRepository;

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }    
    
    @Test
    public void addUser() {
    	User user = new User("testuser", "testuser", "USER");

    	assertNull(user.getId());
    	userRepository.save(user);
    	assertNotNull(user.getId());
    }
    
	@Test
    public void addStudent() {
		Student student = new Student("Test", "Student", "IT", "test@test.com");
		
		studentRepository.save(student);
		Student findStudent = studentRepository.findOne(student.getId());
		assertNotNull(findStudent);
    }
    
}
