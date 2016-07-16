package fi.haagahelia.course.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import fi.haagahelia.course.model.Course;

public interface CourseRepository extends CrudRepository<Course, Long>  {
    
	List<Course> findByName(String name);
}

