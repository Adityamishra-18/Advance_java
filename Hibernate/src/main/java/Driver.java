import entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.Scanner;

public class Driver {
    private static EntityManagerFactory emf;
    private static EntityTransaction et;
    private static EntityManager em;
    private static Scanner sc;
    static{
        emf=Persistence.createEntityManagerFactory("HND");
        em=emf.createEntityManager();
        et=em.getTransaction();
        sc=new Scanner(System.in);
    }
    public static void main(String[] args) {
        int choice=0;

        do{
            System.out.println("1.Add Student\n2.Update the Student\n3.Find by id\n4.Delete Student");
            choice=sc.nextInt();
            switch (choice){
                case 1:
                    Student st=new Student();
                    System.out.println("Enter the Student id:");
                    st.setId(sc.nextInt());
                    System.out.println("enter Student name");
                    sc.nextLine();
                    st.setName(sc.nextLine());
                    System.out.println("Enter Student Course");
                    st.setCourse(sc.nextLine());
                    add(st);
                break;

                case 2:
                    Student st1=new Student();
                    System.out.println("Enter id to update");
                    int id=sc.nextInt();
                    update(id);
                break;
            }

        }while(choice!=0);
    }


    private static boolean add(Student st) {

        if(st!=null){
            et.begin();
            em.persist(st);
            et.commit();
            return true;
        }

        return false;
    }
    private static String update(int id){
        Student std=em.find(Student.class,id);
        if(std!=null){
            System.out.println("Enter the new course");
            sc.nextLine();
            std.setCourse(sc.nextLine());
            System.out.println("Enter the new name");
            std.setName(sc.nextLine());
            et.begin();
            em.merge(std);
            et.commit();
            return "Success";
        }else{
            return"Student not found";
        }
    }
}
