package com.hospitalmanagement.HospitalManagement.model;

public class LabReport {
    private int reportId;
    private int patientId;
    private String testName;
    private String testResult;

    public LabReport(int reportId, int patientId, String testName, String testResult) {
        this.reportId = reportId;
        this.patientId = patientId;
        this.testName = testName;
        this.testResult = testResult;
    }

    // Getters and Setters
    public int getReportId() { return reportId; }
    public void setReportId(int reportId) { this.reportId = reportId; }
    public int getPatientId() { return patientId; }
    public void setPatientId(int patientId) { this.patientId = patientId; }
    public String getTestName() { return testName; }
    public void setTestName(String testName) { this.testName = testName; }
    public String getTestResult() { return testResult; }
    public void setTestResult(String testResult) { this.testResult = testResult; }

    @Override
    public String toString() {
        return "LabReport{" +
                "reportId=" + reportId +
                ", patientId=" + patientId +
                ", testName='" + testName + '\'' +
                ", testResult='" + testResult + '\'' +
                '}';
    }
}