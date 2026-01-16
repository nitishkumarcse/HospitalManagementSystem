package com.hospitalmanagement.HospitalManagement.model;

public class Staff {
    private int staffId;
    private String name;
    private String role;
    private String phone;

    public Staff(int staffId, String name, String role, String phone) {
        this.staffId = staffId;
        this.name = name;
        this.role = role;
        this.phone = phone;
    }

    // Getters and Setters
    public int getStaffId() { return staffId; }
    public void setStaffId(int staffId) { this.staffId = staffId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    @Override
    public String toString() {
        return "Staff{" +
                "staffId=" + staffId +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}