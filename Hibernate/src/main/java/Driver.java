import entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Driver {
    public static void main(String[] args) {
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("HND");
        EntityManager em=emf.createEntityManager();
        EntityTransaction et=em.getTransaction();

        //Student s1=new Student(101,"Aditya","Java Fullstack");
        et.begin();
//        Student student=em.find(Student.class,102);
//        System.out.println(student);

//        em.remove(101);


//        em.persist(s1);
//        em.merge(s1);
        et.commit();
    }
}
