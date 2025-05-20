package pbo;

import javax.persistence.*;
import java.util.*;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("f01PU");
        EntityManager em = emf.createEntityManager();
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.equals("---")) break;
            String[] parts = line.split("#");
            String cmd = parts[0];

            em.getTransaction().begin();

            switch (cmd) {
            case "student-add":
            if (em.find(Student.class, parts[1]) == null) {
            em.persist(new Student(parts[1], parts[2], parts[3]));
            }
            break;
            case "student-show-all":
                    em.createQuery("SELECT s FROM Student s ORDER BY s.nim", Student.class)
                    .getResultList()
                    .forEach(s -> System.out.println(s.getNim() + "|" + s.getName() + "|" + s.getProdi()));
                break;
            case "course-add":
                if (em.find(Course.class, parts[1]) == null) {
                em.persist(new Course(parts[1], parts[2], Integer.parseInt(parts[3]), Integer.parseInt(parts[4])));
            }
            break;
                case "course-show-all":
                    em.createQuery("SELECT c FROM Course c ORDER BY c.semester, c.code", Course.class)
                        .getResultList()
                        .forEach(c -> System.out.println(c.getCode() + "|" + c.getName() + "|" + c.getSemester() + "|" + c.getCredit()));
                    break;
                case "enroll":
                    Student st = em.find(Student.class, parts[1]);
                    Course cr = em.find(Course.class, parts[2]);
                    if (st != null && cr != null) {
                        // Cek jika sudah pernah enroll
                        Long count = em.createQuery(
                            "SELECT COUNT(e) FROM Enrollment e WHERE e.student.nim = :nim AND e.course.code = :code", Long.class)
                            .setParameter("nim", parts[1])
                            .setParameter("code", parts[2])
                            .getSingleResult();
                        if (count == 0) {
                            em.persist(new Enrollment(st, cr));
                        }
                    }
                    break;
                case "student-show":
                 Student s1 = em.find(Student.class, parts[1]);
                 if (s1 != null) {
                 System.out.println(s1.getNim() + "|" + s1.getName() + "|" + s1.getProdi());
                }
                 break;
                case "student-detail":
                    Student s = em.find(Student.class, parts[1]);
                    if (s != null) {
                        System.out.println(s.getNim() + "|" + s.getName() + "|" + s.getProdi());
                        List<Course> courses = em.createQuery(
                            "SELECT e.course FROM Enrollment e WHERE e.student.nim = :nim ORDER BY e.course.semester, e.course.code", Course.class)
                            .setParameter("nim", parts[1])
                            .getResultList();
                        for (Course c : courses) {
                            System.out.println(c.getCode() + "|" + c.getName() + "|" + c.getSemester() + "|" + c.getCredit());
                        }
                    }
                    break;
            }
            em.getTransaction().commit();
        }
        em.close();
        emf.close();
    }
}