package pbo;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {
    @Id
    private String nim;
    private String name;
    private String prodi;

    public Student() {}
    public Student(String nim, String name, String prodi) {
        this.nim = nim;
        this.name = name;
        this.prodi = prodi;
    }

    public String getNim() {
        return nim;
    }
    public String getName() {
        return name;
    }
    public String getProdi() {
        return prodi;
    }
}