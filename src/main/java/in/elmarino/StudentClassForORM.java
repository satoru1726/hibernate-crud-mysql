package in.elmarino;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // **this belongs to JPA -- indicates that this is a class whose object needs to be stored in DB.
// let's create a JavaBean now

// to change the table name, use @Entity(name = ""newname) or @Table(name = "newName");
@Table(name = "studentData")
public class StudentClassForORM {

    @Id// ** this is also very imp., indicates that this is our PK [Primary Key/unique and not null attribute]
    private int rollNum;

    // to change column name use @Column(name = "newName")
    @Column(name = "studentName")
    private StudentName name;
    @Column(name = "favTech")
    private String favLang;

    public StudentName getName() {
        return name;
    }

    public void setName(StudentName name) {
        this.name = name;
    }

    public int getRollNum() {
        return rollNum;
    }

    public void setRollNum(int rollNum) {
        this.rollNum = rollNum;
    }

    public String getFavLang() {
        return favLang;
    }

    public void setFavLang(String favLang) {
        this.favLang = favLang;
    }

    @Override
    public String toString() {
        return "StudentClassForFetch{" +
                "rollNum=" + rollNum +
                ", name='" + name + '\'' +
                '}';
    }
}

