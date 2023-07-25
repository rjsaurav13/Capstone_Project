package com.example.booking_doc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    // Endpoint to get all doctors
    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        List<Doctor> doctors = doctorService.getAllDoctors();
        return ResponseEntity.ok(doctors);
    }

    // Endpoint to get a doctor by ID
    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id) {
        Doctor doctor = doctorService.getDoctorById(id);
        if (doctor != null) {
            return ResponseEntity.ok(doctor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint to add a new doctor
    @PostMapping
    public ResponseEntity<String> addDoctor(@RequestBody DoctorRequest request) {
        try {
            doctorService.addDoctor(request.getFullName(), request.getSpecialization(), request.getContactNumber(), request.getEmail(), request.getClinicAddress());
            return ResponseEntity.ok("Doctor added successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add doctor.");
        }
    }

    // Other endpoints for doctor-related functionalities can be added here

    // Request payload class for adding a new doctor
    static class DoctorRequest {
        private String fullName;
        private String specialization;
        private String contactNumber;
        private String email;
        private String clinicAddress;

        // Getters and Setters

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getSpecialization() {
            return specialization;
        }

        public void setSpecialization(String specialization) {
            this.specialization = specialization;
        }

        public String getContactNumber() {
            return contactNumber;
        }

        public void setContactNumber(String contactNumber) {
            this.contactNumber = contactNumber;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getClinicAddress() {
            return clinicAddress;
        }

        public void setClinicAddress(String clinicAddress) {
            this.clinicAddress = clinicAddress;
        }
    }
}

