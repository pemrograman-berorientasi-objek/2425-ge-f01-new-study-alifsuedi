package pbo;

import javax.persistence.*;

@Entity
@Table(name = "enrollments")
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Course course;

    public Enrollment() {}
    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
    }
}