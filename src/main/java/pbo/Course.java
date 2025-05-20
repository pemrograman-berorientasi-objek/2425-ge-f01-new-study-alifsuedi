package pbo;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @Column(name = "kode", length = 10, nullable = false)
    private String kode;

    @Column(name = "nama", length = 50, nullable = false)
    private String nama;

    @Column(name = "semester", nullable = false)
    private int semester;

    @Column(name = "kredit", nullable = false)
    private int kredit;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Enrollment> enrollments = new ArrayList<>();

    public Course() {}

    public Course(String kode, String nama, int semester, int kredit) {
        this.kode = kode;
        this.nama = nama;
        this.semester = semester;
        this.kredit = kredit;
    }

    public String getKode() { return kode; }
    public String getNama() { return nama; }
    public int getSemester() { return semester; }
    public int getKredit() { return kredit; }
    public List<Enrollment> getEnrollments() { return enrollments; }

    @Override
    public String toString() {
        return kode + "|" + nama + "|" + semester + "|" + kredit;
    }
}