package et.edu.aait.courses

import java.io.Serializable
import javax.persistence.*


@Entity
@Table(name = "courses")
class Course(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,
    @Column(name = "title")
    var title: String = "",
    @Column(name = "code", unique = true)
    var code: String = "",
    @Column(name="ects")
    var ects: Int,
    @Column(name="description")
    var description: String = ""
) : Serializable