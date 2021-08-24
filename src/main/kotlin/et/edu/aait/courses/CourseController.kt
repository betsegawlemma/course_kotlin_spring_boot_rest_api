package et.edu.aait.courses

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI

@RestController
@RequestMapping("/api/v1/courses")
class CourseController(private val courseService: CourseService) {
    @GetMapping("/{code}")
    fun fetchByCode(@PathVariable(name="code", required = true) code: String): ResponseEntity<Course?> {
       val course = this.courseService.getCourseByCode(code)
        return ResponseEntity.ok(course)
    }

    @GetMapping
    fun fetchAll(): ResponseEntity<Iterable<Course>> {
        val courses = this.courseService.allCourses()
        return ResponseEntity.ok(courses)
    }

    @PostMapping
    fun save(@RequestBody(required = true) course: Course): ResponseEntity<Course>{
        val savedCourse = this.courseService.save(course)
        val uri: URI = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(savedCourse.id)
            .toUri()

        return ResponseEntity.created(uri).body(savedCourse)
    }

    @PutMapping("/{id}" )
    fun update(@PathVariable(name = "id", required =  true) id: Long, @RequestBody course: Course): ResponseEntity<Course>{
        val updatedCourse = this.courseService.update(id, course)
        return ResponseEntity.ok(updatedCourse)
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable(name = "id", required = true) id: Long): ResponseEntity<Any> {
        this.courseService.deleteById(id)
        return ResponseEntity.noContent().build()
    }

    @DeleteMapping
    fun deleteAll(): ResponseEntity<Any> {
        this.courseService.deleteAll()
        return ResponseEntity.noContent().build()
    }
}