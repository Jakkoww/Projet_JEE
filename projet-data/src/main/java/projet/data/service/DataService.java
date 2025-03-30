package projet.data.service;

import jakarta.annotation.PostConstruct;
import projet.core.entity.Comment;
import projet.core.entity.Dog;
import projet.core.entity.Report;
import projet.core.service.CommentService;
import projet.core.service.DogService;
import projet.core.service.ReportService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class DataService {

    private final CommentService commentService;
    private final DogService dogService;
    private final ReportService reportService;

    public DataService(CommentService commentService, DogService dogService, ReportService reportService) {
        this.commentService = commentService;
        this.dogService = dogService;
        this.reportService = reportService;
    }

    @PostConstruct
    public void initData() throws Exception {
        cleanDB();
        registerDogs();
        registerReports();
        registerComments();
    }

    private void cleanDB() {
        dogService.deleteAll();
        reportService.deleteAll();
        commentService.deleteAll();
    }

    private void registerReports() {
        Dog pepper = dogService.findByName("Pepper");
        Dog ninja = dogService.findByName("Ninja");
        Dog murphy = dogService.findByName("Murphy");
        Dog maya = dogService.findByName("Maya");
        Dog paco = dogService.findByName("Paco");
        Dog milo = dogService.findByName("Milo");

        createReport("Alice Dupont", "0612345678", "alice.dupont@email.com", "Paris", "Chien perdu dans le parc", LocalDate.of(2023, 10, 26), pepper, new ArrayList<>());
        createReport("Bob Martin", "0798765432", "bob.martin@email.com", "Lyon", "Chien errant près du marché", LocalDate.of(2023, 10, 27), ninja, new ArrayList<>());
        createReport("Charlie Durand", "0655555555", "charlie.durand@email.com", "Marseille", "Chien trouvé près de la gare", LocalDate.of(2023, 10, 28), murphy, new ArrayList<>());
        createReport("David Leroy", "0711223344", "david.leroy@email.com", "Lille", "Chien vu dans la rue", LocalDate.of(2023, 10, 29), maya, new ArrayList<>());
        createReport("Eve Moreau", "0699887766", "eve.moreau@email.com", "Toulouse", "Chien perdu dans un jardin", LocalDate.of(2023, 10, 30), paco, new ArrayList<>());
        createReport("Frank Richard", "0744332211", "frank.richard@email.com", "Bordeaux", "Chien trouvé dans un parc", LocalDate.of(2023, 10, 31), milo, new ArrayList<>());
    }

    private void createReport(String reporterName, String phone, String email, String location, String description, LocalDate reportDate, Dog dog, List<Comment> comments) {
        System.out.println("Registring report");
        Report report = new Report(reporterName,phone,email,location,description,reportDate,dog,comments);
        reportService.save(report);
    }

    private void registerDogs() {
        createDog("Pepper", "Cairn Terrier", "Blond", "Petit", "Jolie pupuce", "https://images.unsplash.com/photo-1518457243246-e1c5be5babb7?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");
        createDog("Ninja", "Cairn Terrier", "Noir", "Petit","Jolie pupuce", "https://images.unsplash.com/photo-1718206148115-f03ee8119b2b?q=80&w=2080&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");
        createDog("Murphy", "Beagle", "Noir/Blanc/marron", "Petit","Jolie pupuce", "https://images.unsplash.com/photo-1512546321483-c0468b7b8a95?q=80&w=1974&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");
        createDog("Maya", "Beagle", "Noir/Blanc/marron", "Petit","Jolie pupuce", "https://images.unsplash.com/photo-1586917138540-f1490b02f205?q=80&w=2136&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");
        createDog("Paco", "Golden Retriever", "Blond", "Gros","Gros toutou", "https://plus.unsplash.com/premium_photo-1694819488591-a43907d1c5cc?q=80&w=2028&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");
        createDog("Milo", "Malinois", "Noir/marron", "Gros","Gros toutou", "https://images.unsplash.com/photo-1579554600247-7dfe63989cac?q=80&w=2056&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");
    }

    private void createDog(String name, String breed, String color, String size, String description, String photoUrl) {
        System.out.println("Registring " + name);
        Dog dog = new Dog(name, breed, color, size, description, photoUrl);
        dogService.save(dog);
    }

    private void registerComments(){
        Report report1 = reportService.findById(1L);
        Report report2 = reportService.findById(2L);
        Report report3 = reportService.findById(3L);
        Report report4 = reportService.findById(4L);
        Report report5 = reportService.findById(5L);
        Report report6 = reportService.findById(6L);

        createComment("Sophie", "Je pense l'avoir vu hier", LocalDate.of(2023,10,27), report1);
        createComment("Marc", "Il est très mignon", LocalDate.of(2023,10,28), report2);
        createComment("Lucie", "Il a l'air perdu", LocalDate.of(2023,10,29), report3);
        createComment("Pierre", "Je l'ai vu avec un collier rouge", LocalDate.of(2023,10,30), report4);
        createComment("Julie", "Je peux peut-être le garder", LocalDate.of(2023,10,31), report5);
        createComment("Thomas", "il a été retrouvé ?", LocalDate.of(2023,11,01), report6);
    }

    private void createComment(String authorName, String description, LocalDate publishDate, Report report) {
        System.out.println("Registring comment");
        Comment comment = new Comment(authorName,description,publishDate,report);
        commentService.save(comment);
    }
}