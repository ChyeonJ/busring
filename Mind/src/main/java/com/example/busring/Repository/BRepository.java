package com.example.busring.Repository;

import com.example.busring.dto.bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BRepository extends JpaRepository<bus, String> {
}
