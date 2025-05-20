package pbo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @Column(name = "nim", nullable = false, length = 20)
    private String nim;
    @Column(name = "name", nullable = false, length = 30)
    private String name;
    @Column(name = "major", nullable = false, length = 15)
    private String major;

    

    public Student(String nim, String name, String major) {
        this.nim = nim;
        this.name = name;
        this.major = major;
    }

    // GETTER
    public String getNim() {
        return nim;
    }
    
    public String getName() {
        return name;
    }
    
    public String major() {
        return major;
    }
    
    // SETTER
    public void setNim(String nim) {
        this.nim = nim;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setmajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return nim + "|" + name + "|" + major;
    }
}
