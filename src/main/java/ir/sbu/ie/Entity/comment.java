package ir.sbu.ie.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "comment")
public class comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic
    @NotNull
    int id;
    @Column(name = "name")
    @Basic
    @NotNull
     String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @NotNull
    @Basic
    @Column(name = "des")
    String des;
}
