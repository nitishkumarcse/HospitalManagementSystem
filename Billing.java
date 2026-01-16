package com.hospitalmanagement.HospitalManagement.model;

public class Billing {
    private int billId;
    private int patientId;
    private int appointmentId;
    private double amount;
    private String date;

    public Billing(int billId, int patientId, int appointmentId, double amount, String date) {
        this.billId = billId;
        this.patientId = patientId;
        this.appointmentId = appointmentId;
        this.amount = amount;
        this.date = date;
    }

    // Getters and Setters
    public int getBillId() { return billId; }
    public void setBillId(int billId) { this.billId = billId; }
    public int getPatientId() { return patientId; }
    public void setPatientId(int patientId) { this.patientId = patientId; }
    public int getAppointmentId() { return appointmentId; }
    public void setAppointmentId(int appointmentId) { this.appointmentId = appointmentId; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    @Override
    public String toString() {
        return "Billing{" +
                "billId=" + billId +
                ", patientId=" + patientId +
                ", appointmentId=" + appointmentId +
                ", amount=" + amount +
                ", date='" + date + '\'' +
                '}';
    }
}