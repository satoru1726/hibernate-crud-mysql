package in.elmarino;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
static void main(String[] args) {

StudentName name = new StudentName();
name.setFname("first-name");
name.setMname("middle-name");
name.setLname("last-name");

StudentClassForFetch student01 = new StudentClassForFetch();

student01.setRollNum(001);
student01.setName(String.valueOf(name)); 
student01.setFavLang("Java + SpringBoot");

SessionFactory factory = new Configuration().addAnnotatedClass(StudentClassForFetch.class).configure("cfg.xml").buildSessionFactory();

Session session = factory.openSession();

Transaction transaction = session.beginTransaction();
session.persist(student01); 

// to update data
session.merge(student01);

// to delete data
session.remove(student01);
   
transaction.commit();

session.close();
factory.close();

// code for fetch operation [note: run it on a seperate file.]
org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
configuration.addAnnotatedClass(StudentClassForORM.class);
configuration.configure("configurationFile.xml");

SessionFactory sessionFactory = configuration.buildSessionFactory();
Session session = sessionFactory.openSession();

StudentClassForORM student = session.byId(StudentClassForORM.class).getReference(3);

System.out.println(student);

session.close();
sessionFactory.close(); 

}
}
