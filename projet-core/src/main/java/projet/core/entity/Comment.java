package projet.core.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

@Entity
public class Comment extends GenericEntity{

    private String authorName;
    private String description;
    private LocalDate publishDate;

    protected Comment() {
    }

    public Comment(String authorName, String description, LocalDate publishDate, Report report) {
        this.authorName = authorName;
        this.description = description;
        this.publishDate = publishDate;
        this.report = report;
    }

    @ManyToOne
    @JoinColumn(name = "report_id")
    private Report report;

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }
}
