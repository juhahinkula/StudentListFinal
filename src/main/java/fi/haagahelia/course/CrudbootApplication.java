package fi.haagahelia.course;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.course.model.Student;
import fi.haagahelia.course.repository.StudentRepository;

@SpringBootApplication
public class CrudbootApplication {
	
	private static final Logger log = LoggerFactory.getLogger(CrudbootApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(CrudbootApplication.class, args);
	}
	
	/**
	 * Save students to H2 DB for testing
	 * @param repository
	 * @return
	 */
	@Bean
	public CommandLineRunner demo(StudentRepository repository) {
		return (args) -> {
			// save students
			repository.save(new Student("John", "Johnson", "IT", "john@john.com"));
			repository.save(new Student("Steve", "Stevens", "IT", "steve.stevent@st.com"));
			repository.save(new Student("Mary", "Robinson", "IT", "mary@robinson.com"));
			repository.save(new Student("Kate", "Keystone", "Nursery","kate@kate.com"));
			repository.save(new Student("Diana", "Doll", "Business","diana@doll.com"));
		};
	}
}
