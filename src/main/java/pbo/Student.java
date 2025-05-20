package pbo;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "nim", length = 10, nullable = false)
    private String nim;

    @Column(name = "nama", length = 50, nullable = false)
    private String nama;

    @Column(name = "prodi", length = 50, nullable = false)
    private String prodi;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Enrollment> enrollments = new ArrayList<>();

    public Student() {}

    public Student(String nim, String nama, String prodi) {
        this.nim = nim;
        this.nama = nama;
        this.prodi = prodi;
    }

    public String getNim() { return nim; }
    public String getNama() { return nama; }
    public String getProdi() { return prodi; }
    public List<Enrollment> getEnrollments() { return enrollments; }

    @Override
    public String toString() {
        return nim + "|" + nama + "|" + prodi;
    }

    public void printDetail() {
        System.out.println(this);
        enrollments.stream()
            .map(Enrollment::getCourse)
            .sorted(Comparator.comparing(Course::getSemester).thenComparing(Course::getKode))
            .forEach(c -> System.out.println(c));
    }
}