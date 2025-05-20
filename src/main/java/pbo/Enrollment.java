package pbo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "enrollments")
public class Enrollment {

    @Id
    @Column(name = "nim", nullable = false, length = 20)
    private String nim;
    @Column(name = "code", nullable = false, length = 30)
    private String code;
    

    public Enrollment(String nim, String code) {
        this.nim = nim;
        this.code = code;
    }

    // GETTER
    public String getNim() {
        return nim;
    }
    
    public String getCode() {
        return code;
    }
   
    // SETTER
    public void setNim(String nim) {
        this.nim = nim;
    }
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return nim + "|" + code;
    }
}
