package projet.core.service;

import projet.core.dao.ReportDAO;
import projet.core.entity.Report;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ReportService extends GenericService<Report>  {

    private final ReportDAO reportDAO;

    protected ReportService(ReportDAO reportDAO) {
        super(reportDAO);
        this.reportDAO = reportDAO;
    }

    public List<Report> findAll() {
        return reportDAO.findAll();
    }

    public Report findById(long id) {
        return reportDAO.findReportById(id);
    }

    public Report create(Report report) {
        return reportDAO.save(report);
    }

    public void deleteReport(long reportId) {
        reportDAO.deleteById(reportId);
    }

}
