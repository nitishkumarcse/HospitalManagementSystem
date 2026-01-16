package com.hospitalmanagement.HospitalManagement.model;

public class EmergencyService {
    private int incidentId;
    private String incidentType;
    private String location;
    private int responseTime;
    private String status;

    public EmergencyService(int incidentId, String incidentType, String location, int responseTime, String status) {
        this.incidentId = incidentId;
        this.incidentType = incidentType;
        this.location = location;
        this.responseTime = responseTime;
        this.status = status;
    }

    // Getters and Setters
    public int getIncidentId() { return incidentId; }
    public void setIncidentId(int incidentId) { this.incidentId = incidentId; }
    public String getIncidentType() { return incidentType; }
    public void setIncidentType(String incidentType) { this.incidentType = incidentType; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public int getResponseTime() { return responseTime; }
    public void setResponseTime(int responseTime) { this.responseTime = responseTime; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "EmergencyService{" +
                "incidentId=" + incidentId +
                ", incidentType='" + incidentType + '\'' +
                ", location='" + location + '\'' +
                ", responseTime=" + responseTime +
                ", status='" + status + '\'' +
                '}';
    }
}