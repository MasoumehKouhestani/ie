package ir.sbu.ie.Entity;
//

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.util.Date;

@Entity
@Table(name = "cases")
@org.hibernate.annotations.NamedQuery(name = "CaseEntity.findReport",
        query = "SELECT c FROM CaseEntity c where c.section = :sec AND c.type = :typ AND c.referTOuser = :refTo "
)
public class CaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic
    @NotNull
    int id;
    @Column(name = "topic")
    @Basic
    @NotNull
    String topic;
    @Column(name = "description")
    @Basic
    @NotNull
    String description;
    @Column(name = "type")
    @Basic
    @NotNull
    String type;
    @Column(name = "section")
    @Basic
    String section;

    @Column(name = "ismanager")
    @Basic
    boolean ismanager = false;
    @ManyToOne
    @JoinColumn(name = "SENDER_ID")

    User senderuser;
    @ManyToOne
    @JoinColumn(name = "REFERTO_ID")
    User referTOuser;
    @Column(name = "condition")
    @Basic
    @NotNull
    String condition;
    @Column(name = "startdate")
    @NotNull
    Date startdate;
    @Column(name = "enddate")
    Date enddate;
    @Column(name = "file")
    @Lob
    File file;

    public boolean isIsmanager() {
        return ismanager;
    }

    public void setIsmanager(boolean ismanager) {
        this.ismanager = ismanager;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public User getSenderuser() {
        return senderuser;
    }

    public void setSenderuser(User senderuser) {
        this.senderuser = senderuser;
    }

    public User getReferTOuser() {
        return referTOuser;
    }

    public void setReferTOuser(User referTOuser) {
        this.referTOuser = referTOuser;
        if (referTOuser.getPosition().equals("manager"))
            this.setIsmanager(true);
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
