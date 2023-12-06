package com.example.busring.Service;

import com.example.busring.Repository.BiRepository;
import com.example.busring.dto.bus;
import com.example.busring.dto.businfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BusInfoSm implements BusInfoService{

    @Autowired
    private BiRepository biRepository;

    @Override
    public void insertOne(businfo info){
        info.setTime(LocalDateTime.now());
        biRepository.save(info);
    }

    @Override
    public List<businfo> selectOne(long num) {
        return biRepository.selectOne(num);
    }

    @Override
    public void updateOne(businfo info){ biRepository.save(info);}

}
