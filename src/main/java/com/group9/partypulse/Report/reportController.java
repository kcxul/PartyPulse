package com.group9.partypulse.Report;

import com.group9.partypulse.user.User;
import com.group9.partypulse.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@RestController
@RequestMapping("/PartyPulse/report")

public class reportController {

    @Autowired
    private reportService service;

    @GetMapping("/all/reports")
    public List<Report> getAllReports() {
        return service.getAllReports();
    }

    @GetMapping("/report/{report_id}")
    public Report findReportByID(@PathVariable int report_id) {
        return service.findReportByID(report_id);
    }

    @PutMapping("/edit/{report_id}")
    public Report editReport(@PathVariable int report_id, @RequestBody Report report) {
        service.editReport(report_id, report);
        return service.findReportByID(report_id);
    }
    @PostMapping("/new/report")
    public List<Report> addNewReport(@RequestBody Report report) {
        service.addNewReport(report);
        return service.getAllReports();
    }

    @DeleteMapping("/delete/{report_id}")
    public List<Report> deleteReportByID(@PathVariable int report_id) {
        service.deleteReportByID(report_id);
        return service.getAllReports();
    }

}
