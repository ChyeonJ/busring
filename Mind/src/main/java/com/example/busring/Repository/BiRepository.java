package com.example.busring.Repository;

import com.example.busring.dto.MemberDTO;
import com.example.busring.dto.bus;
import com.example.busring.dto.businfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BiRepository extends JpaRepository<businfo, Long> {

    @Query("select bi from businfo bi where bi.num = :num")
    List<businfo> selectOne(@Param("num") long num);

}
