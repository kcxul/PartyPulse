package com.group9.partypulse.Report;

import jakarta.persistence.*;

@Entity
@Table()
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int report_id;

    @Column(nullable = false)
    private String reportTitle;

    @Column(nullable = false)
    private String reportInfo;

    public Report(int report_id, String reportTitle, String reportInfo) {
        this.report_id = report_id;
        this.reportTitle = reportTitle;
        this.reportInfo = reportInfo;
    }

    public Report(String reportTitle, String reportInfo) {
        this.reportTitle = reportTitle;
        this.reportInfo = reportInfo;
    }

    public Report(){

    }

    public int getReport_id() {
        return report_id;
    }

    public void setReport_id(int report_id) {
        this.report_id = report_id;
    }

    public String getReportTitle() {
        return reportTitle;
    }

    public void setReportTitle(String reportTitle) {
        this.reportTitle = reportTitle;
    }

    public String getReportInfo() {
        return reportInfo;
    }

    public void setReportInfo(String reportInfo) {
        this.reportInfo = reportInfo;
    }

}
