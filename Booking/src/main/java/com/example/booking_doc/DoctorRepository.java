package com.example.booking_doc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    // Custom method to find a doctor by full name
    Doctor findByFullName(String fullName);

    // Custom method to find doctors by specialization
    List<Doctor> findBySpecialization(String specialization);

    // Custom method to find doctors by contact number
    Doctor findByContactNumber(String contactNumber);

    // Custom method to find doctors by email
    Doctor findByEmail(String email);

    // Custom method to find doctors by clinic address
    List<Doctor> findByClinicAddress(String clinicAddress);
}
