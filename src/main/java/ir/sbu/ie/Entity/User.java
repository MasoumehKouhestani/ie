package ir.sbu.ie.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    public List<CaseEntity> getSendcases() {
        return sendcases;
    }

    public void setSendcases(List<CaseEntity> sendcases) {
        this.sendcases = sendcases;
    }

    public List<CaseEntity> getReccases() {
        return reccases;
    }

    public void setReccases(List<CaseEntity> reccases) {
        this.reccases = reccases;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_case_send",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "case_id", referencedColumnName = "ID")
    )
    private List<CaseEntity> sendcases;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_case_rec",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "case_id", referencedColumnName = "ID")
    )
    private List<CaseEntity> reccases;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @NotNull
    @Pattern(regexp = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$")
    @Column(name = "email")
    private String email;
    @Basic
    @NotNull
    @Column(name = "name")
    private String name;

    @Basic
    @NotNull
    @Size(min = 6, max = 30)
    @Column(name = "username")
    private String username;
    @Basic
    @NotNull
    @Column(name = "password")
    @Size(min = 8, max = 16)
    private String password;
    @Basic
    @Column(name = "confirmed")
    private boolean confirmed;
    @Basic
    @Column(name = "position")
    private String position;
    @Basic
    @Column(name = "section")
    private String section;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }
}

