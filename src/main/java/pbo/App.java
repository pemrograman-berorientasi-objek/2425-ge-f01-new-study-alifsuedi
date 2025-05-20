package pbo;

/**
 * @author 12S23025 Alif Aflah Suedi
 * @author 12S23039 Prisca Manurung
 */

import java.util.*;
import javax.persistence.*;

public class App {
    private static EntityManagerFactory factory;
    private static EntityManager entityManager;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        factory = Persistence.createEntityManagerFactory("study_plan_pu");
        entityManager = factory.createEntityManager();

        while (scan.hasNext()) {
            String commandLine = scan.nextLine();
            if (commandLine.equals("---")) break;

            String[] strTemp = commandLine.split("#");
            switch (strTemp[0]) {
                case "student-add":
                    entityManager.getTransaction().begin();
                    String nim = strTemp[1];
                    String nama = strTemp[2];
                    String prodi = strTemp[3];
                    if (entityManager.find(Student.class, nim) == null) {
                        entityManager.persist(new Student(nim, nama, prodi));
                    }
                    entityManager.getTransaction().commit();
                    break;
                case "student-show-all":
                    List<Student> students = entityManager.createQuery("SELECT s FROM Student s", Student.class)
                        .getResultList();
                    students.stream()
                        .sorted(Comparator.comparing(Student::getNim))
                        .forEach(s -> System.out.println(s));
                    break;
                case "course-add":
                    entityManager.getTransaction().begin();
                    String kode = strTemp[1];
                    String namaMK = strTemp[2];
                    int semester = Integer.parseInt(strTemp[3]);
                    int kredit = Integer.parseInt(strTemp[4]);
                    if (entityManager.find(Course.class, kode) == null) {
                        entityManager.persist(new Course(kode, namaMK, semester, kredit));
                    }
                    entityManager.getTransaction().commit();
                    break;
                case "course-show-all":
                    List<Course> courses = entityManager.createQuery("SELECT c FROM Course c", Course.class)
                        .getResultList();
                    courses.stream()
                        .sorted(Comparator.comparing(Course::getSemester).thenComparing(Course::getKode))
                        .forEach(c -> System.out.println(c));
                    break;
                case "enroll":
                    entityManager.getTransaction().begin();
                    String nimEnroll = strTemp[1];
                    String kodeEnroll = strTemp[2];
                    Student stu = entityManager.find(Student.class, nimEnroll);
                    Course cour = entityManager.find(Course.class, kodeEnroll);
                    if (stu != null && cour != null) {
                        boolean already = stu.getEnrollments().stream()
                            .anyMatch(e -> e.getCourse().getKode().equals(kodeEnroll));
                        if (!already) {
                            Enrollment enr = new Enrollment(stu, cour);
                            entityManager.persist(enr);
                            stu.getEnrollments().add(enr);
                            cour.getEnrollments().add(enr);
                        }
                    }
                    entityManager.getTransaction().commit();
                    break;
                case "student-show":
                    String nimShow = strTemp[1];
                    Student s = entityManager.find(Student.class, nimShow);
                    if (s != null) s.printDetail();
                    break;
                case "student-detail":
                    String nimDetail = strTemp[1];
                    Student sDetail = entityManager.find(Student.class, nimDetail);
                    if (sDetail != null) sDetail.printDetail();
                    break;
                default:
                    System.out.println("Invalid Input!");
            }
        }
        scan.close();
        entityManager.close();
        factory.close();
    }
}