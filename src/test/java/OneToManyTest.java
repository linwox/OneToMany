import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import se.yrgo.domain.Student;
import se.yrgo.domain.Tutor;

import java.util.List;

public class OneToManyTest {
    private static SessionFactory sessionFactory = null;

    public static void main(String[] args) {
        Tutor tutor = new Tutor("12345", "Nahid", 55000);

        Student student1 = new Student("Helene");
        Student student2 = new Student("Poya");
        Student student3 = new Student("Demi");

        tutor.addStudentToTeachingGroup(student1);
        tutor.addStudentToTeachingGroup(student2);
        tutor.addStudentToTeachingGroup(student3);

        SessionFactory sf = getSessionFactory();

        // Start session with db
        Session session = sf.openSession();

        // Begin transaction
        Transaction tx = session.beginTransaction();

//        1. Run the code with session.save() lines uncommented
//        2. Comment out the session.save() lines
        session.save(tutor);
        session.save(student1);
        session.save(student2);
        session.save(student3);

//        3. Check the db for correct tutor id and change it in below line
//        4. Uncomment below lines (until // Commit transaction) and run the code
//        Tutor myTutor = session.get(Tutor.class, 34);
//
//        List<Student> students = myTutor.getTeachingGroup();
//
//        for (Student student : students) {
//            System.out.println(student);
//        }

        // Commit transaction
        tx.commit();

        // End session with db
        session.close();

    }

    private static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            configuration.configure();

            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }
}
