package com.example.busring.Repository;

import com.example.busring.dto.MemberDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JRepository extends JpaRepository<MemberDTO, String> {
}

