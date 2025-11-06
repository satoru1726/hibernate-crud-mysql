package in.elmarino;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/* ORM - Object Relational Mapping/Mapper -- it'll store an object in database without having to write rdbms query manually.
   ORM tool - best example - Hibernate[everything data!] */
public class Main {
    static void main(String[] args) {

        StudentName name = new StudentName();
        name.setFname("Jayanth");
        name.setMname("Ramachandra");
        name.setLname("Anekere");

        StudentClassForFetch student01 = new StudentClassForFetch();

        student01.setRollNum(85);
        student01.setName(String.valueOf(name)); // embeddable concept -- name is an instance of StudentName class that has first, middle and last names for a student name.
        student01.setFavLang("Java + SpringBoot");

        // Configuration config = new Configuration();
        // config.addAnnotatedClass(in.elmarino.StudentClassForFetch.class); // ** here you need to mention the fully qualified class name.
        // config.configure("cfg.xml"); // pass the configuration file here. [by default it'll read hibernate.cfg.xml]

        // SessionFactory factory = config.builSessionFactory();
        // ** you can write the above four statements in a single line

        SessionFactory factory = new Configuration().addAnnotatedClass(StudentClassForFetch.class).configure("cfg.xml").buildSessionFactory();

        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();

           // session.save(student01); // save() is deprecated since JAP(Java/Jakarta Persistence API), use persist() method.
session.persist(student01); // pass your object as an argument here --> it'll fire an inset query.

        // to update data ***
/* session.merge(student01); // --> if the object exists then it'll update it, if it doesn't then it'll create it.

        /* to delete data ***
session.remove(student01); */

        transaction.commit(); // ** this statement is most impt.,

        session.close(); // --> it's important to close the session and factory objects.
        factory.close();

        // code for fetch operation
        /* org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
        configuration.addAnnotatedClass(StudentClassForORM.class);
        configuration.configure("configurationFile.xml");

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        // StudentClassForORM student = session.get(StudentClassForORM.class, 3); // this is deprecated, use find() -- from JPA --> get() or find() is an example for "Eager fetching" ****

        // StudentClassForORM studentClassForORM = session.find(StudentClassForORM.class, 6); or you can also use StudentClassForORM student = session.byId(StudentClassForORM.class).load(6) or the below one too
        StudentClassForORM student = session.byId(StudentClassForORM.class).getReference(3); // this is "Lazy fetching" *****

        System.out.println(student);

        session.close();
        sessionFactory.close(); */
    }
}
