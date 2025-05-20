package pbo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ENROLLMENTS")
public class Enrollment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "STUDENT_NIM", referencedColumnName = "nim")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "COURSE_CODE", referencedColumnName = "kode")
    private Course course;

    public Enrollment() {}

    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    public Student getStudent() { return student; }
    public Course getCourse() { return course; }
}