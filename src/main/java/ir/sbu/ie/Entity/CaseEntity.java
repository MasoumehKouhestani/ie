package ir.sbu.ie.Entity;
//

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.util.Date;
import java.util.HashMap;

@Entity
@Table(name = "cases")
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
    @Column(name = "sender")

    @NotNull



    User sender;
    @Column(name = "referTo")

    @NotNull
    User referTo;
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

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReferTo() {
        return referTo;
    }

    public void setReferTo(User referTo) {
        this.referTo = referTo;
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
