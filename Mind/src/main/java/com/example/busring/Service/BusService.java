package com.example.busring.Service;

import com.example.busring.dto.MemberDTO;
import com.example.busring.dto.bus;

import java.util.List;

public interface BusService {

    public List<bus> getAll();

    public void insertOne(bus b);

    void deleteOne(long num);

    public List<bus> selectOne(long num);

    void updateOne(bus b);

}
