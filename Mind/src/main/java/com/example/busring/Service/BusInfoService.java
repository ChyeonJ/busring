package com.example.busring.Service;

import com.example.busring.dto.bus;
import com.example.busring.dto.businfo;

import java.util.List;

public interface BusInfoService {

    void insertOne(businfo info);

    void updateOne(businfo info);

    public List<businfo> selectOne(long num);


}
