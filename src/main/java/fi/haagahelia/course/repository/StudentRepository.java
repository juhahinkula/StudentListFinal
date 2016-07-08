package fi.haagahelia.course.repository;

import java.util.List;
import fi.haagahelia.course.model.Student;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {

    List<Student> findByLastName(String lastname);
    
}
