package com.group9.partypulse.Report;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class reportService {
    private reportRepo ReportRepository;

    public List<Report> getAllReports() {
        return ReportRepository.findAll();
    }

    public Report findReportByID(int report_id) {
        Optional<Report> report = ReportRepository.findById(report_id);
        return report.orElse(null);
    }

    public void addNewReport(Report report) {
        ReportRepository.save(report);
    }
    public void editReport(int report_id, Report report) {
        Report existing = findReportByID(report_id);
        if (existing != null) {
            existing.setReportTitle(report.getReportTitle());
            existing.setReportInfo(report.getReportInfo());
            ReportRepository.save(existing);
        }
    }

    public void deleteReportByID(int report_id) {
        ReportRepository.deleteById(report_id);
    }
}

