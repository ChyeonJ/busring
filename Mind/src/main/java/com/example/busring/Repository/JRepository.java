package com.example.busring.Repository;

import com.example.busring.dto.MemberDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JRepository extends JpaRepository<MemberDTO, Long> {

    @Query("select m from MemberDTO m where m.num = :num")
    List<MemberDTO> selectOne(@Param("num") long num);


}

