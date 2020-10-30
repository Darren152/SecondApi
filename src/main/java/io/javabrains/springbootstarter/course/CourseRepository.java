package io.javabrains.springbootstarter.course;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface CourseRepository extends CrudRepository<Course, String> {
    //Spring Data JPA allows someone to create Method Declarations/Defining Methods

    //Takes in a topic Id and returns a list of courses.

    //name of method should start with "find"
    List<Course> findCoursesByTopicId(String topicId);

}
