package pbo;

import java.util.Scanner;

/**
 * 12S23025 - Alif Aflah Suedi
 * 12S23039 - Prisca R Manurung
 */

import javax.persistence.*;


public class App {
    private static EntityManager entityManager;

    public static void main(String[] _args) {
        
        Executor executor = new Executor(entityManager);
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String input = sc.nextLine();
            if(input.equals("---")){
                break;
            }else{
                String data[] = input.split("#");
                switch (data[0]){
                    case "student-add":
                        executor.addStudent(data);
                        break;
                    case "course-add":
                        executor.addCourse(data);
                        break;
                    case "student-enrollment":
                        executor.enrollStudent(data);
                        break;
                       default:
                        System.out.println("Invalid input");
                }
            }
        }
        sc.close();

    }
}