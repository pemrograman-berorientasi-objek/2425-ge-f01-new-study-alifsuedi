package pbo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @Column(name = "name", nullable = false, length = 30)
    private String name;
    @Column(name = "code", nullable = false, length = 30)
    private String code;
    @Column(name = "years", nullable = false, length = 30)
    private int years;
    @Column(name = "credit", nullable = false, length = 30)
    private int credit;
    

    public Course(String name, String code, int years, int credit) {
        this.name = name;
        this.code = code;
        this.years = years;
        this.credit = credit;
    }

    // GETTER
    public String getName() {
        return name;
    }
   
    public String getCode() {
        return code;
    }
   
    public int getYears() {
        return years;
    }

    public int getCredit() {
        return credit;
    }

    // SETTER
    public void setName(String name) {
        this.name = name;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public void setYears(int years) {
        this.years = years;
    }
    public void setCredit(int credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return name + "|" + code + "|" + years + "|" + credit;
    }
}
