package com.example.busring.Repository;

import com.example.busring.dto.bus;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BusInfoRepository extends JpaRepository<bus, Long> {

//    @Query("select b from bus b where b.num = :num")
//    List<bus> selectOne(@Param("num") long num);

}
