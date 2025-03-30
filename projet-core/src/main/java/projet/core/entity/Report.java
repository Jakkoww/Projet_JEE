package projet.core.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Report extends GenericEntity{
    private String reporterName;
    private String phone;
    private String email;
    private String location;
    private String description;
    private LocalDate reportDate;
    private enum Status {Lost, Found}

    public Report() {
    }

    public Report(String reporterName, String phone, String email, String location, String description, LocalDate reportDate, Dog dog, List<Comment> comments) {
        this.reporterName = reporterName;
        this.phone = phone;
        this.email = email;
        this.location = location;
        this.description = description;
        this.reportDate = reportDate;
        this.dog = dog;
        this.comments = comments;
    }

    @ManyToOne
    @JoinColumn(name = "dog_id")
    private Dog dog;

    @OneToMany(mappedBy = "report")
    private List<Comment> comments = new ArrayList<>();

    public String getReporterName() {
        return reporterName;
    }

    public void setReporterName(String reporterName) {
        this.reporterName = reporterName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getReportDate() {
        return reportDate;
    }

    public void setReportDate(LocalDate reportDate) {
        this.reportDate = reportDate;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
}
