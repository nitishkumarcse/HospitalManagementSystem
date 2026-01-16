package com.hospitalmanagement.HospitalManagement;

import com.hospitalmanagement.HospitalManagement.util.DataBaseUtil;
import com.hospitalmanagement.HospitalManagement.controller.*;
import com.hospitalmanagement.HospitalManagement.model.*;
import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Connection establised");
        // Instantiate all controllers
        PatientController patientController = new PatientController();
        DoctorController doctorController = new DoctorController();
        AdminController adminController = new AdminController();
        AppointmentController appointmentController = new AppointmentController();
        BillingController billingController = new BillingController();
        StaffController staffController = new StaffController();
        LabReportController labReportController = new LabReportController();
        BloodDonationController bloodDonationController = new BloodDonationController();
        EmergencyServiceController emergencyServiceController = new EmergencyServiceController();

        while (true) {
            System.out.println("\n=== Hospital Management System ===");
            System.out.println("1. Patient Management");
            System.out.println("2. Doctor Management");
            System.out.println("3. Admin Management");
            System.out.println("4. Appointment Management");
            System.out.println("5. Billing Management");
            System.out.println("6. Staff Management");
            System.out.println("7. Lab Report Management");
            System.out.println("8. Blood Donation Management");
            System.out.println("9. Emergency Service Management");
            System.out.println("0. Exit");
            System.out.print("Choose a module: ");
            int moduleChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (moduleChoice == 0) {
                System.out.println("Exiting system...");
                break;
            }

            switch (moduleChoice) {
                case 1:
                    handlePatientOperations(scanner, patientController);
                    break;
                case 2:
                    handleDoctorOperations(scanner, doctorController);
                    break;
                case 3:
                    handleAdminOperations(scanner, adminController);
                    break;
                case 4:
                    handleAppointmentOperations(scanner, appointmentController);
                    break;
                case 5:
                    handleBillingOperations(scanner, billingController);
                    break;
                case 6:
                    handleStaffOperations(scanner, staffController);
                    break;
                case 7:
                    handleLabReportOperations(scanner, labReportController);
                    break;
                case 8:
                    handleBloodDonationOperations(scanner, bloodDonationController);
                    break;
                case 9:
                    handleEmergencyServiceOperations(scanner, emergencyServiceController);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }

    private static void handlePatientOperations(Scanner scanner, PatientController controller) {
        while (true) {
            System.out.println("\n--- Patient Management ---");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patient by ID");
            System.out.println("3. View All Patients");
            System.out.println("4. Update Patient");
            System.out.println("5. Delete Patient");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose an operation: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) break;

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter DOB (YYYY-MM-DD): ");
                    String dob = scanner.nextLine();
                    System.out.print("Enter gender: ");
                    String gender = scanner.nextLine();
                    System.out.print("Enter phone: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter diseases: ");
                    String diseases = scanner.nextLine();
                    Patient patient = new Patient(0, name, dob, gender, phone, diseases);
                    controller.savePatient(patient);
                    System.out.println("Patient added successfully!");
                    break;
                case 2:
                    System.out.print("Enter patient ID: ");
                    int id = scanner.nextInt();
                    Patient p = controller.getPatientById(id);
                    System.out.println(p != null ? p : "Patient not found.");
                    break;
                case 3:
                    controller.getAllPatients().forEach(System.out::println);
                    break;
                case 4:
                    System.out.print("Enter patient ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new DOB: ");
                    String newDob = scanner.nextLine();
                    System.out.print("Enter new gender: ");
                    String newGender = scanner.nextLine();
                    System.out.print("Enter new phone: ");
                    String newPhone = scanner.nextLine();
                    System.out.print("Enter new diseases: ");
                    String newDiseases = scanner.nextLine();
                    Patient updatedPatient = new Patient(updateId, newName, newDob, newGender, newPhone, newDiseases);
                    controller.updatePatient(updatedPatient);
                    System.out.println("Patient updated successfully!");
                    break;
                case 5:
                    System.out.print("Enter patient ID to delete: ");
                    int deleteId = scanner.nextInt();
                    controller.deletePatient(deleteId);
                    System.out.println("Patient deleted successfully!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void handleDoctorOperations(Scanner scanner, DoctorController controller) {
        while (true) {
            System.out.println("\n--- Doctor Management ---");
            System.out.println("1. Add Doctor");
            System.out.println("2. View Doctor by ID");
            System.out.println("3. View All Doctors");
            System.out.println("4. Update Doctor");
            System.out.println("5. Delete Doctor");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose an operation: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) break;

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter specialization: ");
                    String specialization = scanner.nextLine();
                    System.out.print("Enter phone: ");
                    String phone = scanner.nextLine();
                    Doctor doctor = new Doctor(0, name, specialization, phone);
                    controller.saveDoctor(doctor);
                    System.out.println("Doctor added successfully!");
                    break;
                case 2:
                    System.out.print("Enter doctor ID: ");
                    int id = scanner.nextInt();
                    Doctor d = controller.getDoctorById(id);
                    System.out.println(d != null ? d : "Doctor not found.");
                    break;
                case 3:
                    controller.getAllDoctors().forEach(System.out::println);
                    break;
                case 4:
                    System.out.print("Enter doctor ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new specialization: ");
                    String newSpecialization = scanner.nextLine();
                    System.out.print("Enter new phone: ");
                    String newPhone = scanner.nextLine();
                    Doctor updatedDoctor = new Doctor(updateId, newName, newSpecialization, newPhone);
                    controller.updateDoctor(updatedDoctor);
                    System.out.println("Doctor updated successfully!");
                    break;
                case 5:
                    System.out.print("Enter doctor ID to delete: ");
                    int deleteId = scanner.nextInt();
                    controller.deleteDoctor(deleteId);
                    System.out.println("Doctor deleted successfully!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void handleAdminOperations(Scanner scanner, AdminController controller) {
        while (true) {
            System.out.println("\n--- Admin Management ---");
            System.out.println("1. Add Admin");
            System.out.println("2. View Admin by ID");
            System.out.println("3. View All Admins");
            System.out.println("4. Update Admin");
            System.out.println("5. Delete Admin");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose an operation: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) break;

            switch (choice) {
                case 1:
                    System.out.print("Enter admin name: ");
                    String adminName = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    Admin admin = new Admin(0, adminName, email, password);
                    controller.saveAdmin(admin);
                    System.out.println("Admin added successfully!");
                    break;
                case 2:
                    System.out.print("Enter admin ID: ");
                    int id = scanner.nextInt();
                    Admin a = controller.getAdminById(id);
                    System.out.println(a != null ? a : "Admin not found.");
                    break;
                case 3:
                    controller.getAllAdmins().forEach(System.out::println);
                    break;
                case 4:
                    System.out.print("Enter admin ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new admin name: ");
                    String newAdminName = scanner.nextLine();
                    System.out.print("Enter new email: ");
                    String newEmail = scanner.nextLine();
                    System.out.print("Enter new password: ");
                    String newPassword = scanner.nextLine();
                    Admin updatedAdmin = new Admin(updateId, newAdminName, newEmail, newPassword);
                    controller.updateAdmin(updatedAdmin);
                    System.out.println("Admin updated successfully!");
                    break;
                case 5:
                    System.out.print("Enter admin ID to delete: ");
                    int deleteId = scanner.nextInt();
                    controller.deleteAdmin(deleteId);
                    System.out.println("Admin deleted successfully!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void handleAppointmentOperations(Scanner scanner, AppointmentController controller) {
        while (true) {
            System.out.println("\n--- Appointment Management ---");
            System.out.println("1. Add Appointment");
            System.out.println("2. View Appointment by ID");
            System.out.println("3. View All Appointments");
            System.out.println("4. Update Appointment");
            System.out.println("5. Delete Appointment");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose an operation: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) break;

            switch (choice) {
                case 1:
                    System.out.print("Enter patient ID: ");
                    int patientId = scanner.nextInt();
                    System.out.print("Enter doctor ID: ");
                    int doctorId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    System.out.print("Enter time (HH:MM): ");
                    String time = scanner.nextLine();
                    Appointment appointment = new Appointment(0, patientId, doctorId, date, time);
                    controller.saveAppointment(appointment);
                    System.out.println("Appointment added successfully!");
                    break;
                case 2:
                    System.out.print("Enter appointment ID: ");
                    int id = scanner.nextInt();
                    Appointment ap = controller.getAppointmentById(id);
                    System.out.println(ap != null ? ap : "Appointment not found.");
                    break;
                case 3:
                    controller.getAllAppointments().forEach(System.out::println);
                    break;
                case 4:
                    System.out.print("Enter appointment ID to update: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Enter new patient ID: ");
                    int newPatientId = scanner.nextInt();
                    System.out.print("Enter new doctor ID: ");
                    int newDoctorId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new date: ");
                    String newDate = scanner.nextLine();
                    System.out.print("Enter new time: ");
                    String newTime = scanner.nextLine();
                    Appointment updatedAppointment = new Appointment(updateId, newPatientId, newDoctorId, newDate, newTime);
                    controller.updateAppointment(updatedAppointment);
                    System.out.println("Appointment updated successfully!");
                    break;
                case 5:
                    System.out.print("Enter appointment ID to delete: ");
                    int deleteId = scanner.nextInt();
                    controller.deleteAppointment(deleteId);
                    System.out.println("Appointment deleted successfully!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void handleBillingOperations(Scanner scanner, BillingController controller) {
        while (true) {
            System.out.println("\n--- Billing Management ---");
            System.out.println("1. Add Billing");
            System.out.println("2. View Billing by ID");
            System.out.println("3. View All Billings");
            System.out.println("4. Update Billing");
            System.out.println("5. Delete Billing");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose an operation: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) break;

            switch (choice) {
                case 1:
                    System.out.print("Enter patient ID: ");
                    int patientId = scanner.nextInt();
                    System.out.print("Enter appointment ID: ");
                    int appointmentId = scanner.nextInt();
                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    Billing billing = new Billing(0, patientId, appointmentId, amount, date);
                    controller.saveBilling(billing);
                    System.out.println("Billing added successfully!");
                    break;
                case 2:
                    System.out.print("Enter bill ID: ");
                    int id = scanner.nextInt();
                    Billing b = controller.getBillingById(id);
                    System.out.println(b != null ? b : "Billing not found.");
                    break;
                case 3:
                    controller.getAllBillings().forEach(System.out::println);
                    break;
                case 4:
                    System.out.print("Enter bill ID to update: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Enter new patient ID: ");
                    int newPatientId = scanner.nextInt();
                    System.out.print("Enter new appointment ID: ");
                    int newAppointmentId = scanner.nextInt();
                    System.out.print("Enter new amount: ");
                    double newAmount = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter new date: ");
                    String newDate = scanner.nextLine();
                    Billing updatedBilling = new Billing(updateId, newPatientId, newAppointmentId, newAmount, newDate);
                    controller.updateBilling(updatedBilling);
                    System.out.println("Billing updated successfully!");
                    break;
                case 5:
                    System.out.print("Enter bill ID to delete: ");
                    int deleteId = scanner.nextInt();
                    controller.deleteBilling(deleteId);
                    System.out.println("Billing deleted successfully!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void handleStaffOperations(Scanner scanner, StaffController controller) {
        while (true) {
            System.out.println("\n--- Staff Management ---");
            System.out.println("1. Add Staff");
            System.out.println("2. View Staff by ID");
            System.out.println("3. View All Staff");
            System.out.println("4. Update Staff");
            System.out.println("5. Delete Staff");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose an operation: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) break;

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter role: ");
                    String role = scanner.nextLine();
                    System.out.print("Enter phone: ");
                    String phone = scanner.nextLine();
                    Staff staff = new Staff(0, name, role, phone);
                    controller.saveStaff(staff);
                    System.out.println("Staff added successfully!");
                    break;
                case 2:
                    System.out.print("Enter staff ID: ");
                    int id = scanner.nextInt();
                    Staff s = controller.getStaffById(id);
                    System.out.println(s != null ? s : "Staff not found.");
                    break;
                case 3:
                    controller.getAllStaff().forEach(System.out::println);
                    break;
                case 4:
                    System.out.print("Enter staff ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new role: ");
                    String newRole = scanner.nextLine();
                    System.out.print("Enter new phone: ");
                    String newPhone = scanner.nextLine();
                    Staff updatedStaff = new Staff(updateId, newName, newRole, newPhone);
                    controller.updateStaff(updatedStaff);
                    System.out.println("Staff updated successfully!");
                    break;
                case 5:
                    System.out.print("Enter staff ID to delete: ");
                    int deleteId = scanner.nextInt();
                    controller.deleteStaff(deleteId);
                    System.out.println("Staff deleted successfully!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void handleLabReportOperations(Scanner scanner, LabReportController controller) {
        while (true) {
            System.out.println("\n--- Lab Report Management ---");
            System.out.println("1. Add Lab Report");
            System.out.println("2. View Lab Report by ID");
            System.out.println("3. View All Lab Reports");
            System.out.println("4. Update Lab Report");
            System.out.println("5. Delete Lab Report");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose an operation: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) break;

            switch (choice) {
                case 1:
                    System.out.print("Enter patient ID: ");
                    int patientId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter test name: ");
                    String testName = scanner.nextLine();
                    System.out.print("Enter test result: ");
                    String testResult = scanner.nextLine();
                    LabReport labReport = new LabReport(0, patientId, testName, testResult);
                    controller.saveLabReport(labReport);
                    System.out.println("Lab Report added successfully!");
                    break;
                case 2:
                    System.out.print("Enter report ID: ");
                    int id = scanner.nextInt();
                    LabReport lr = controller.getLabReportById(id);
                    System.out.println(lr != null ? lr : "Lab Report not found.");
                    break;
                case 3:
                    controller.getAllLabReports().forEach(System.out::println);
                    break;
                case 4:
                    System.out.print("Enter report ID to update: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Enter new patient ID: ");
                    int newPatientId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new test name: ");
                    String newTestName = scanner.nextLine();
                    System.out.print("Enter new test result: ");
                    String newTestResult = scanner.nextLine();
                    LabReport updatedLabReport = new LabReport(updateId, newPatientId, newTestName, newTestResult);
                    controller.updateLabReport(updatedLabReport);
                    System.out.println("Lab Report updated successfully!");
                    break;
                case 5:
                    System.out.print("Enter report ID to delete: ");
                    int deleteId = scanner.nextInt();
                    controller.deleteLabReport(deleteId);
                    System.out.println("Lab Report deleted successfully!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void handleBloodDonationOperations(Scanner scanner, BloodDonationController controller) {
        while (true) {
            System.out.println("\n--- Blood Donation Management ---");
            System.out.println("1. Add Blood Donation");
            System.out.println("2. View Blood Donation by ID");
            System.out.println("3. View All Blood Donations");
            System.out.println("4. Update Blood Donation");
            System.out.println("5. Delete Blood Donation");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose an operation: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) break;

            switch (choice) {
                case 1:
                    System.out.print("Enter blood group: ");
                    String bloodGroup = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Enter donor ID (patient ID): ");
                    int donorId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter collection date (YYYY-MM-DD): ");
                    String collectionDate = scanner.nextLine();
                    BloodDonation bloodDonation = new BloodDonation(0, bloodGroup, quantity, donorId, collectionDate);
                    controller.saveBloodDonation(bloodDonation);
                    System.out.println("Blood Donation added successfully!");
                    break;
                case 2:
                    System.out.print("Enter blood ID: ");
                    int id = scanner.nextInt();
                    BloodDonation bd = controller.getBloodDonationById(id);
                    System.out.println(bd != null ? bd : "Blood Donation not found.");
                    break;
                case 3:
                    controller.getAllBloodDonations().forEach(System.out::println);
                    break;
                case 4:
                    System.out.print("Enter blood ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new blood group: ");
                    String newBloodGroup = scanner.nextLine();
                    System.out.print("Enter new quantity: ");
                    int newQuantity = scanner.nextInt();
                    System.out.print("Enter new donor ID: ");
                    int newDonorId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new collection date: ");
                    String newCollectionDate = scanner.nextLine();
                    BloodDonation updatedBloodDonation = new BloodDonation(updateId, newBloodGroup, newQuantity, newDonorId, newCollectionDate);
                    controller.updateBloodDonation(updatedBloodDonation);
                    System.out.println("Blood Donation updated successfully!");
                    break;
                case 5:
                    System.out.print("Enter blood ID to delete: ");
                    int deleteId = scanner.nextInt();
                    controller.deleteBloodDonation(deleteId);
                    System.out.println("Blood Donation deleted successfully!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void handleEmergencyServiceOperations(Scanner scanner, EmergencyServiceController controller) {
        while (true) {
            System.out.println("\n--- Emergency Service Management ---");
            System.out.println("1. Add Emergency Service");
            System.out.println("2. View Emergency Service by ID");
            System.out.println("3. View All Emergency Services");
            System.out.println("4. Update Emergency Service");
            System.out.println("5. Delete Emergency Service");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose an operation: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) break;

            switch (choice) {
                case 1:
                    System.out.print("Enter incident type: ");
                    String incidentType = scanner.nextLine();
                    System.out.print("Enter location: ");
                    String location = scanner.nextLine();
                    System.out.print("Enter response time (minutes): ");
                    int responseTime = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter status: ");
                    String status = scanner.nextLine();
                    EmergencyService emergencyService = new EmergencyService(0, incidentType, location, responseTime, status);
                    controller.saveEmergencyService(emergencyService);
                    System.out.println("Emergency Service added successfully!");
                    break;
                case 2:
                    System.out.print("Enter incident ID: ");
                    int id = scanner.nextInt();
                    EmergencyService es = controller.getEmergencyServiceById(id);
                    System.out.println(es != null ? es : "Emergency Service not found.");
                    break;
                case 3:
                    controller.getAllEmergencyServices().forEach(System.out::println);
                    break;
                case 4:
                    System.out.print("Enter incident ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new incident type: ");
                    String newIncidentType = scanner.nextLine();
                    System.out.print("Enter new location: ");
                    String newLocation = scanner.nextLine();
                    System.out.print("Enter new response time: ");
                    int newResponseTime = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new status: ");
                    String newStatus = scanner.nextLine();
                    EmergencyService updatedEmergencyService = new EmergencyService(updateId, newIncidentType, newLocation, newResponseTime, newStatus);
                    controller.updateEmergencyService(updatedEmergencyService);
                    System.out.println("Emergency Service updated successfully!");
                    break;
                case 5:
                    System.out.print("Enter incident ID to delete: ");
                    int deleteId = scanner.nextInt();
                    controller.deleteEmergencyService(deleteId);
                    System.out.println("Emergency Service deleted successfully!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
