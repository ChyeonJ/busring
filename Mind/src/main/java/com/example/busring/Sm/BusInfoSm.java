package com.example.busring.Sm;

import com.example.busring.Repository.BiRepository;
import com.example.busring.Service.BusInfoService;
import com.example.busring.dto.bus;
import com.example.busring.dto.businfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BusInfoSm implements BusInfoService {

    @Autowired
    private BiRepository biRepository;

    @Override
    public void insertOne(businfo info){
        // 현재 시간을 가져옴
        LocalDateTime currentDateTime = LocalDateTime.now();

        // 시간과 분만 추출하여 새로운 LocalDateTime 객체 생성
        LocalDateTime modifiedDateTime = LocalDateTime.of(
                currentDateTime.getYear(),
                currentDateTime.getMonth(),
                currentDateTime.getDayOfMonth(),
                currentDateTime.getHour(),
                currentDateTime.getMinute(),
                0,  // 초는 0으로 설정
                0   // 나노초는 0으로 설정
        );

        // info 객체에 설정
        info.setTime(modifiedDateTime);
        biRepository.save(info);
    }

    @Override
    public List<businfo> selectOne(long num) {
        return biRepository.selectOne(num);
    }

    @Override
    public void updateOne(businfo info){ biRepository.save(info);}

    @Override
    public List<businfo> getAll() {return biRepository.findAll();}

    @Override
    public void deleteOne(long num){biRepository.deleteById(num);}

}
