package pbo;

import javax.persistence.*;

public class Executor {
    private EntityManager entityManager;
    public Executor(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void addStudent(String[] data){
        entityManager.getTransaction().begin();
        Student tempStudent;
        if((tempStudent = entityManager.find(Student.class, data[1])) == null){
            Student student = new Student(data[1], data[2], data[3]);
            entityManager.persist(student);
        }else{
            if(!tempStudent.getNim().equals(data[1])){
                Student student = new Student(data[1], data[2], data[3]);
                entityManager.persist(student);
            }
        }
    }

        public void addCourse(String[] data){
        entityManager.getTransaction().begin();
        Student tempCourse;
        if((tempCourse = entityManager.find(Student.class, data[1])) == null){
            Student course = new Student(data[1], data[2], data[3]);
            entityManager.persist(course);
        }else{
            if(!tempCourse.getNim().equals(data[1])){
                Student student = new Student(data[1], data[2], data[3]);
                entityManager.persist(student);
            }
        }
    }
        public void enrollStudent(String[] data){
        entityManager.getTransaction().begin();
        Student tempEnroll;
        if((tempEnroll = entityManager.find(Student.class, data[1])) == null){
            Student enroll = new Student(data[1], data[2], data[3]);
            entityManager.persist(enroll);
        }else{
            if(!tempEnroll.getNim().equals(data[1])){
                Student enroll = new Student(data[1], data[2], data[3]);
                entityManager.persist(enroll);
            }
        }
    }
    }
