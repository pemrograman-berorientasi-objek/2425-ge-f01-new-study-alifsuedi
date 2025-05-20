package pbo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "enrollment")
public class Enrollment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Ubah dari Long ke int

    @ManyToOne
    @JoinColumn(name = "student_nim", referencedColumnName = "nim")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_kode", referencedColumnName = "kode")
    private Course course;

    public Enrollment() {}

    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    public Student getStudent() { return student; }
    public Course getCourse() { return course; }
}