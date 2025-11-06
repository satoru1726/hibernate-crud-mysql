package in.elmarino;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class StudentClassForFetch {

    @Id
    private int rollNum;
    private String favLang;
    private String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "StudentClassForFetch{" +
                "rollNum=" + rollNum +
                ", favLang='" + favLang + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
