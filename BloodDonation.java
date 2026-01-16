package com.hospitalmanagement.HospitalManagement.model;

public class BloodDonation {
    private int bloodId;
    private String bloodGroup;
    private int quantity;
    private int donorId;
    private String collectionDate;

    public BloodDonation(int bloodId, String bloodGroup, int quantity, int donorId, String collectionDate) {
        this.bloodId = bloodId;
        this.bloodGroup = bloodGroup;
        this.quantity = quantity;
        this.donorId = donorId;
        this.collectionDate = collectionDate;
    }

    // Getters and Setters
    public int getBloodId() { return bloodId; }
    public void setBloodId(int bloodId) { this.bloodId = bloodId; }
    public String getBloodGroup() { return bloodGroup; }
    public void setBloodGroup(String bloodGroup) { this.bloodGroup = bloodGroup; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public int getDonorId() { return donorId; }
    public void setDonorId(int donorId) { this.donorId = donorId; }
    public String getCollectionDate() { return collectionDate; }
    public void setCollectionDate(String collectionDate) { this.collectionDate = collectionDate; }

    @Override
    public String toString() {
        return "BloodDonation{" +
                "bloodId=" + bloodId +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", quantity=" + quantity +
                ", donorId=" + donorId +
                ", collectionDate='" + collectionDate + '\'' +
                '}';
    }
}