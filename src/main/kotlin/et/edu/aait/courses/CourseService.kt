package et.edu.aait.courses

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class CourseService(private val courseRepository: CourseRepository) {

    private val logger: Logger = LoggerFactory.getLogger(this.javaClass);

    fun getCourseByCode(code: String): Course? {
        logger.info("Get Course By Code = $code")
        return this.courseRepository.findByCode(code)
    }

    fun allCourses(): Iterable<Course> {
        logger.info("Find All Courses")
        return this.courseRepository.findAll()
    }

    fun save(course: Course): Course {
        logger.info("Save Course Code = ${course.code}")
        return this.courseRepository.save(course)
    }

    fun update(id: Long, course: Course): Course {
        logger.info("Update Course ")
        course.apply { this.id= id}
        return this.save(course)
    }

    fun deleteById(id: Long) {
        this.courseRepository.deleteById(id)
    }

    fun deleteAll(){
        this.courseRepository.deleteAll()
    }
}