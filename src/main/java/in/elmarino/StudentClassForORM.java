package in.elmarino;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "studentData")
public class StudentClassForORM {

    @Id
    private int rollNum;

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

