package pbo;

import javax.persistence.*;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    private String code;
    private String name;
    private int semester;
    private int credit;

    public Course() {}
    public Course(String code, String name, int semester, int credit) {
        this.code = code;
        this.name = name;
        this.semester = semester;
        this.credit = credit;
    }

    public String getCode() {
        return code;
    }
    public String getName() {
        return name;
    }
    public int getSemester() {
        return semester;
    }
    public int getCredit() {
        return credit;
    }
}