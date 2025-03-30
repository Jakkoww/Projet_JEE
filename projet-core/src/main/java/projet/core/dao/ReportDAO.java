package projet.core.dao;

import projet.core.entity.Report;

public interface ReportDAO extends GenericDAO<Report>{
    Report findReportById(long id);
}
