package et.edu.aait.courses

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface CourseRepository : JpaRepository<Course, Long> {
    fun findByCode(code: String): Course?
    @Modifying
    @Query("DELETE FROM Course c WHERE c.code=:code")
    fun deleteByCode(@Param("code") code: String)
}
