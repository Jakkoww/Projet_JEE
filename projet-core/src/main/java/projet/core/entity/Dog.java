package projet.core.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Dog extends GenericEntity{
    private String name;
    private String breed;
    private String color;
    private String size;
    private String description;
    private String photoUrl;

    @OneToMany(mappedBy = "dog")
    private List<Report> reports = new ArrayList<>();

    protected Dog() {
    }

    public Dog(String name, String breed, String color, String size, String description, String photoUrl) {
        this.name = name;
        this.breed = breed;
        this.color = color;
        this.size = size;
        this.description = description;
        this.photoUrl = photoUrl;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }
}
