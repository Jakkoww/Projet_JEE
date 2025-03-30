package projet.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import projet.core.entity.Comment;
import projet.core.entity.Dog;
import projet.core.entity.Report;
import projet.core.service.CommentService;
import projet.core.service.DogService;
import projet.core.service.ReportService;

import java.util.List;

@Controller
@RequestMapping("reports")
public class ReportsController {

    private final static Logger logger = LoggerFactory.getLogger(ReportsController.class);

    private final ReportService reportService;
    DogService dogService;
    CommentService commentService;

    public ReportsController(DogService dogService, CommentService commentService, ReportService reportService) {
        this.dogService = dogService;
        this.commentService = commentService;
        this.reportService = reportService;
    }

    @RequestMapping(value="/add", method = RequestMethod.GET)
    String addReportForm(){
        return "ReportForm";
    }

    @RequestMapping(value="/save", method = RequestMethod.POST)
    String saveReport(@ModelAttribute("report") Report report, @RequestParam("dog")long dogId){
        Dog dog = dogService.findOne(dogId);
        report.setDog(dog);
        logger.info("New report added");

        return "redirect:../reports/list";
    }

    @GetMapping("/list")
    String getListOfReports(ModelMap modelMap){
        List<Report> list = reportService.findAll();
        modelMap.addAttribute("reports", list);
        logger.info("List of reports...");

        return "ReportsList";
    }

    @RequestMapping(value="{id}/comment", method = RequestMethod.POST)
    String saveComment(@PathVariable("id") long reportId, Comment comment){
        Report report = reportService.findById(reportId);
        commentService.create(comment);
        comment.setReport(report);
        logger.info("Comment added to report");

        return "redirect:../reports/list";
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    String deleteReport(@PathVariable("id")long id){
        reportService.deleteById(id);
        logger.info("Report deleted");

        return "redirect:../../reports/list";
    }
}
