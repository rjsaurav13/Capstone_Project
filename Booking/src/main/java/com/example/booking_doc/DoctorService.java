package com.example.booking_doc;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Doctor findDoctorByFullName(String fullName) {
        return doctorRepository.findByFullName(fullName);
    }

    public List<Doctor> findDoctorsBySpecialization(String specialization) {
        return doctorRepository.findBySpecialization(specialization);
    }

    public Doctor findDoctorByContactNumber(String contactNumber) {
        return doctorRepository.findByContactNumber(contactNumber);
    }

    public Doctor findDoctorByEmail(String email) {
        return doctorRepository.findByEmail(email);
    }

    public List<Doctor> findDoctorsByClinicAddress(String clinicAddress) {
        return doctorRepository.findByClinicAddress(clinicAddress);
    }


    public void addDoctor(String fullName, String specialization, String contactNumber, String email, String clinicAddress) {
        // Create a new Doctor entity and save it in the database
        Doctor doctor = new Doctor(fullName, specialization, contactNumber, email, clinicAddress);
        doctorRepository.save(doctor);
    }

    public List<Doctor> getAllDoctors() {
        // Retrieve all doctors from the database
        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(Long id) {
        // Retrieve a doctor by its ID from the database
        return doctorRepository.findById(id).orElse(null);
    }

}
